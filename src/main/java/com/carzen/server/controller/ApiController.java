package com.carzen.server.controller;

import com.carzen.server.service.ApiService;
import com.carzen.server.service.BizTalkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;
    @Autowired
    private BizTalkService bizTalkService;

    @PostMapping("/api/car")
    public ResponseEntity<Map<String, Object>> getSpecInfo(
           @RequestBody Map<String, Object> commandMap
            ) {
        String carNo = commandMap.get("carNo") == null ? "" : (String) commandMap.get("carNo");
        String ownerNm = commandMap.get("ownerNm") == null ? "" : (String) commandMap.get("ownerNm");

        Map<String, Object> carInfo = new HashMap<String, Object>();
        try {
            carInfo = apiService.getSpecInfo(carNo, ownerNm);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(carInfo);
    }

    @PostMapping("/api/recall")
    public ResponseEntity<List<Map<String, Object>>> searchRecall(@RequestBody Map<String, Object> mapParam) {
        try {
            List<Map<String, Object>> recallResult = apiService.searchRecall(mapParam.get("vinNum").toString());
            return ResponseEntity.ok(recallResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/biztalk/token")
    public ResponseEntity<String> getBizTalkToken() {
        try {
            String token = bizTalkService.getToken();
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping(value = "/api",params = {"api1", "api2, api3"}) public void testApi3()
    {

    }
    @GetMapping(value = "/api",params = {"api1", "api2"}) public void testApi2()

    {

    }
}
