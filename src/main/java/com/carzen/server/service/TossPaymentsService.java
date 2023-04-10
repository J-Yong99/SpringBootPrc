package com.carzen.server.service;

import com.carzen.server.domain.PaymentInfo;
import com.carzen.server.dto.PaymentResHandleCancelDto;
import com.carzen.server.dto.PaymentResHandleCardDto;
import com.carzen.server.dto.PaymentResHandleDto;
import com.carzen.server.dto.PaymentResHandleEasyPay;
import com.carzen.server.repository.PaymentInfoRepository;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Service

public class TossPaymentsService {
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private Environment env;

    @Transactional
    public boolean validatePayment(String paymentKey, String orderId, Long amount) {
        // amount와 orderId로 조회한 paymentInfo의 가격이 동일한지 검증
        // 동일하지 않으면 throw new Exception
        PaymentInfo paymentInfo = paymentInfoRepository.findByOrderId(orderId);
        if (paymentInfo == null) {
            throw new RuntimeException("결제 정보가 존재하지 않습니다.");
        }
        if (!paymentInfo.getCost().equals(amount)) {
            throw new RuntimeException("결제 금액이 일치하지 않습니다.");
        }
        // 결제 정보가 존재하고, 금액이 일치하면 true paymentinfo에 paymentkey 추가
        paymentInfo.setPaymentKey(paymentKey);
        return true;
    }

    @Transactional
    public PaymentResHandleDto requestPaymentConfirm(String paymentKey, String orderId, Long amount) {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        String encodedAuth = new String(Base64.getEncoder().encode((env.getProperty("toss.secretKey.test")+":").getBytes(StandardCharsets.UTF_8)));
        headers.setBasicAuth(encodedAuth);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        JSONObject param = new JSONObject();
        param.put("orderId", orderId);
        param.put("amount", amount);

        try {
            PaymentResHandleDto resBody = rest.postForEntity(
                    env.getProperty("toss.requestUri") + paymentKey,
                    new HttpEntity<>(param, headers),
                    PaymentResHandleDto.class
            ).getBody();
            PaymentInfo paymentInfo = paymentInfoRepository.findByOrderId(orderId);
            if(paymentInfo == null) {
                throw new RuntimeException("결제 정보가 존재하지 않습니다.");
            }

            PaymentResHandleCardDto card = resBody.getCard();
            PaymentResHandleEasyPay easyPay = resBody.getEasyPay();
            if(card != null) {
                paymentInfo.setCardCompany(card.getCompany() != null ? card.getCompany() : null);
                paymentInfo.setCardNum(card.getNumber() != null ? card.getNumber() : null);
            }
            if(easyPay != null) {
                paymentInfo.setEasyPayProvider(easyPay.getProvider() != null ? easyPay.getProvider() : null);
                paymentInfo.setEasyPayAmount(easyPay.getAmount() != null ? easyPay.getAmount() : null);
            }
            paymentInfo.setType(resBody.getMethod());
            paymentInfo.setRequestedAt(resBody.getRequestedAt());
            paymentInfo.setApprovedAt(resBody.getApprovedAt());
            paymentInfo.setStatus(resBody.getStatus());
            return resBody;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // 오류에 대한 처리 및 로깅
            System.out.println(e.getResponseBodyAsString());
        } catch (RestClientException e) {
            // 기타 RestTemplate 관련 오류 처리 및 로깅
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Transactional
    public Map<String, String> requestPaymentFail(String code, String orderId, String message) {
        PaymentInfo paymentInfo = paymentInfoRepository.findByOrderId(orderId);
        if(paymentInfo == null) {
            throw new RuntimeException("결제 정보가 존재하지 않습니다.");
        }
        paymentInfo.setStatus(code);
        return Map.of("code", code, "message", message, "orderId", orderId);
    }

    @Transactional
    public PaymentResHandleCancelDto requestPaymentCancel(String paymentKey, String cancelReason) {
        RestTemplate rest = new RestTemplate();

        URI uri = URI.create(Objects.requireNonNull(env.getProperty("toss.requestUri")) + paymentKey + "/cancel");

        HttpHeaders headers = new HttpHeaders();
        byte[] secretKeyByte = ((env.getProperty("toss.secretKey.test")+":").getBytes(StandardCharsets.UTF_8));
        headers.setBasicAuth(new String(Base64.getEncoder().encode(secretKeyByte)));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        JSONObject param = new JSONObject();
        param.put("cancelReason", cancelReason);

        PaymentResHandleDto paymentResHandleDto;

        try {
            paymentResHandleDto = rest.postForObject(
                    uri,
                    new HttpEntity<>(param, headers),
                    PaymentResHandleDto.class
            );
            if(paymentResHandleDto == null) {
                throw new RuntimeException("결제 취소에 대한 응답 정보가 존재하지 않습니다.");
            }
            paymentInfoRepository.findByOrderId(paymentResHandleDto.getOrderId()).setStatus(paymentResHandleDto.getStatus());
            return paymentResHandleDto.getCancels();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // 오류에 대한 처리 및 로깅
            System.out.println(e.getResponseBodyAsString());
        } catch (RestClientException e) {
            // 기타 RestTemplate 관련 오류 처리 및 로깅
            System.out.println(e.getMessage());
        }
        return null;
    }
}
