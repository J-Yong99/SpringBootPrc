package com.carzen.server.service;

import com.carzen.server.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class BizTalkService {
    @Autowired
    Environment env;
    public String getToken() {
        HttpURLConnection conn = null;
        OutputStream stream = null;
        BufferedReader bufferedReader = null;
        String resultStr = "";
        String passwd = env.getProperty("biztalk.passwd");
        try {
            String urlString = "https://www.biztalk-api.com/v2/auth/getToken";
            String body = "{\"bsid\": \"carzen\", \"passwd\": \""+ passwd +"\"}";

            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            String outPutStr = "";
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("###### [TODO delete] Token :" + response.toString());
                outPutStr = response.toString();
            }
            Map<String, Object> resultMap = CommonUtil.convertJSONstringToMap(outPutStr);
            if("1000".equals(resultMap.get("responseCode").toString())) {	// 정상토큰 get
                resultStr = resultMap.get("token").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e){}
            }
            if(stream != null) {
                try {
                    stream.close();
                } catch (Exception e){}
            }
            if(conn != null)
                conn.disconnect();
        }
        return resultStr;
    }
}
