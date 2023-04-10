package com.carzen.server.controller;

import com.carzen.server.dto.PaymentResHandleDto;
import com.carzen.server.service.TossPaymentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TossPaymentsController {
    @Autowired
    private TossPaymentsService tossPaymentsService;

    /**
     * 결제요청 성공 redirect > 결제승인
     * @return
     */
    @GetMapping(value = "/toss/card/reqSuccess")
    public ResponseEntity<?> cardSuccess(@RequestParam String paymentKey,
                                      @RequestParam String orderId,
                                      @RequestParam Long amount) {
        System.out.println("결제요청 성공 redirect > 결제승인");

        if ( "".equals(paymentKey) ) {
            System.out.println("필수 파라미터 누락으로 진행 불가 - paymentKey");
            return new ResponseEntity<>("필수 파라미터 누락으로 진행 불가 - paymentKey", HttpStatus.BAD_REQUEST);
        }
        if ( "".equals(orderId) ) {
            System.out.println("필수 파라미터 누락으로 진행 불가 - orderId");
            return new ResponseEntity<>("필수 파라미터 누락으로 진행 불가 - orderId", HttpStatus.BAD_REQUEST);
        }
        if ( "".equals(amount) ) {
            System.out.println("필수 파라미터 누락으로 진행 불가 - amount");
            return new ResponseEntity<>("필수 파라미터 누락으로 진행 불가 - amount", HttpStatus.BAD_REQUEST);
        }
        // 결제 검증 후 페이먼트 키 페이먼트객체에 추가
        if( !tossPaymentsService.validatePayment(paymentKey, orderId, amount) ) {
            System.out.println("결제 검증 실패");
            return new ResponseEntity<>("결제 검증 실패", HttpStatus.BAD_REQUEST);
        }

        // 결제승인
        PaymentResHandleDto result = tossPaymentsService.requestPaymentConfirm(paymentKey, orderId, amount);
        return new ResponseEntity<>(result, HttpStatus.OK);
//        model.addAttribute("paymentsInfo", paymentsMap);
//
//        int responseCode = (int) paymentsMap.get("responseCode");
//
//        if ( responseCode == 200 ) {
//            // 일시 표현 (yyyy년mm월dd일 hh:mm)
//            String rsvDateTimeAmPm = "";
//            String reservationDate = paymentsMap.get("reservationDate").toString();
//            String reservationTime = paymentsMap.get("reservationTime").toString();
//
//            String[] reservationDateArr = reservationDate.split("-");
//
//            rsvDateTimeAmPm += reservationDateArr[0] + "년" + Integer.parseInt(reservationDateArr[1]) + "월" + Integer.parseInt(reservationDateArr[2]) + "일";
//
//            if ( "08:30".equals(reservationTime) || "10:00".equals(reservationTime) ) {
//                rsvDateTimeAmPm += " 오전 " + reservationTime;
//            } else {
//                rsvDateTimeAmPm += " 오후 " + reservationTime;
//            }
//
//            // 금액 콤마
//            DecimalFormat df = new DecimalFormat("###,###");
//
//            int totalAmount = Integer.parseInt(paymentsMap.get("totalAmount").toString());
//            String totalAmountDf = df.format(totalAmount);
//
//            try {
//                // 알림톡 전송
//                // 본인인증 휴대폰 번호 조회
//                Map<String, Object> niceCertInfo = certService.selectNiceCertInfo(paymentsMap);
//                String decName = "";
//                String decMobileNo = "";
//
//                if ( niceCertInfo != null ) {
//                    String encName = niceCertInfo.get("name").toString();
//                    String encMobileNo = niceCertInfo.get("mobile_no").toString();
//
//                    decName = Base64Util.decodingBase64(AES256Util.AES_Decode(encName));
//                    decMobileNo = Base64Util.decodingBase64(AES256Util.AES_Decode(encMobileNo));
//
//                    // 알림톡 전송
//                    Map<String, Object> biztalk = new HashMap<String, Object>();
//                    biztalk.put("tmpltCode", "rsvSuccess");
//                    biztalk.put("title", "결제완료");
//                    biztalk.put("name", decName);
//                    biztalk.put("recipient", decMobileNo);
//                    biztalk.put("rsvDateTime", paymentsMap.get("reservationDate") + " " + paymentsMap.get("reservationTime"));
//                    biztalk.put("rsvComp", paymentsMap.get("repairShopName"));
//                    biztalk.put("rsvCompAddr", paymentsMap.get("repairShopAddr"));
//                    biztalk.put("rsvGrade", paymentsMap.get("grade"));
//                    biztalk.put("rsvCarname", paymentsMap.get("carname"));
//                    biztalk.put("rsvAmt", totalAmountDf);
//                    biztalk.put("id", paymentsMap.get("carId"));
//                    biztalk.put("order_id", paymentsMap.get("orderId"));
//
//                    String message = biztalkService.setMessage(biztalk);
//                    biztalk.put("message", message);
//
//                    String token = biztalkService.getToken();
//                    String resultStr = "";
//
//                    if ( !"".equals(token) ) {
//                        biztalk.put("token", token);
//                        System.out.println(biztalk);
//                        resultStr = biztalkService.sendKakaoNotice(biztalk);
//                        System.out.println(resultStr);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                // 점검점 휴대폰 번호 조회
//                Map<String, Object> compInfo = appService.selectCompInfo(paymentsMap);
//
//                if ( compInfo != null ) {
//                    // 알림톡 전송
//                    Map<String, Object> biztalk = new HashMap<String, Object>();
//                    biztalk.put("tmpltCode", "insRsvStatus");
//                    biztalk.put("title", "예약현황");
//                    biztalk.put("rsvDateTimeAmPm", rsvDateTimeAmPm);
//                    biztalk.put("rsvComp", paymentsMap.get("repairShopName"));
//                    biztalk.put("rsvDateTime", paymentsMap.get("reservationDate") + " " + paymentsMap.get("reservationTime"));
////					biztalk.put("rsvUserGubun", paymentsMap.get("userGubun"));
//                    if ( "G".equals(paymentsMap.get("userGubun")) ) {
//                        biztalk.put("userGubun", "개인");
//                    } else if ( "D".equals(paymentsMap.get("userGubun")) ) {
//                        biztalk.put("userGubun", "딜러");
//                    }
//                    biztalk.put("rsvCarname", paymentsMap.get("carname") + "(" + paymentsMap.get("grade") + ")");
//                    biztalk.put("rsvCarno", paymentsMap.get("carno"));
//                    // TODO 휴대폰번호 변경
////					biztalk.put("recipient", compInfo.get("comp_mphone"));
////					biztalk.put("recipient", "01023327292");
//                    biztalk.put("recipient", "01029121564");
//                    biztalk.put("id", paymentsMap.get("carId"));
//                    biztalk.put("order_id", paymentsMap.get("orderId"));
//
//                    String message = biztalkService.setMessage(biztalk);
//                    biztalk.put("message", message);
//
//                    String token = biztalkService.getToken();
//                    String resultStr = "";
//
//                    if ( !"".equals(token) ) {
//                        biztalk.put("token", token);
//                        System.out.println(biztalk);
//                        resultStr = biztalkService.sendKakaoNotice(biztalk);
//                        System.out.println(resultStr);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            // 결제완료 후 user_info.car_id update
//            Map<String, Object> userMap = new HashMap<String, Object>();
//            userMap.put("appLoginId", appLoginId);
//            userMap.put("appLoginKind", appLoginKind);
//            userMap.put("userGubun", userGubun);
//            userMap.put("carId", paymentsMap.get("carId"));
//            userMap.put("distance", paymentsMap.get("distance"));
//            appLoginService.updateUserCarId(userMap);
//
//            Map<String, Object> userInfo = new HashMap<String, Object>();
//
//            if ( "G".equals(userGubun) ) {
//                userInfo = appLoginService.selectUserInfo(userMap);
//                session.setAttribute("USER_INFO", userInfo);
//            } else {
//                userMap.put("regNum", appLoginId);
//                userInfo = appService.selectDealerInfo(userMap);
//                session.setAttribute("USER_INFO", userInfo);
//            }
//        } else {
//            model.addAttribute("code", paymentsMap.get("code"));
//            model.addAttribute("message", paymentsMap.get("message"));
////			returnStr = "app/paymentFail";
//        }
//
//        model.addAttribute("type", "CARD");
//        model.addAttribute("reqType", "APRV");

//        return "app/paymentResult";
    }

    /**
     * 결제요청 실패 redirect uri
     * @return
     */
    @GetMapping(value = "/toss/card/reqFail")
    public ResponseEntity<?> cardFail(@RequestParam String code,
                                         @RequestParam String orderId,
                                         @RequestParam String message) {
        /**
         * 에러 목록
         * PAY_PROCESS_CANCELED	사용자에 의해 결제가 취소되었습니다.
         * PAY_PROCESS_ABORTED	결제 진행 중 승인에 실패하여 결제가 중단되었습니다.
         * REJECT_CARD_COMPANY	결제 승인이 거절되었습니다.
         */
        if("".equals(code) || "".equals(orderId) || "".equals(message)) {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }

        // 결제요청 실패
        System.out.println("결제요청 실패");
        System.out.println("code : " + code);
        Object ret = tossPaymentsService.requestPaymentFail(code, orderId, message);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
