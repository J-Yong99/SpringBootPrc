package com.carzen.server.service;

import com.carzen.server.utils.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    @Autowired
    Environment env;

    public Map<String, Object> getSpecInfo(String carno, String owner) {
        HttpURLConnection conn = null;
        OutputStream stream = null;
        BufferedReader bufferedReader = null;

        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            String urlString = "http://api.cartory.net/api/kcarinfo";
            String body = "params={\"carno\": \"" + carno + "\", \"owner\": \"" + owner + "\"}&resulttype=FVIN&istire=YES&isbattery=YES&ispriceinfo=YES";

            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);

//			conn.setRequestProperty("APPLICATION-KEY", "q4PffbQErx"); // 로컬용
//			conn.setRequestProperty("APPLICATION-KEY", "seU/+Qe93ki65AA91sjwhw=="); // 개발서버용
            conn.setRequestProperty("APPLICATION-KEY", "DV3wvLFFsEOJpRzCYwwpmw=="); // 20220429
            conn.setRequestProperty("TYPE", "C");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8;");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            stream = conn.getOutputStream();
            stream.write(body.getBytes(StandardCharsets.UTF_8));
            stream.flush();

            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

            String temp, response = "";
            temp = response = "";
            while ((temp = bufferedReader.readLine()) != null) {
                response += temp;
            }
            Map<String, Object> cartoryInfo = CommonUtil.convertJSONstringToMap(response);

            cartoryInfo.put("carurl", env.getProperty("cartory.image.url") + cartoryInfo.get("carurl").toString());
            cartoryInfo.put("owner", owner);

            // 차량이미지 변환
            Map<String, Object> h = convertImage(cartoryInfo);
            cartoryInfo.put("convert_carurl", h.get("convert_carurl"));

            returnMap.putAll(cartoryInfo);

        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put("status", "internalError");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception e) {
                }
            }
            if (conn != null)
                conn.disconnect();
        }
        return returnMap;
    }
    public Map<String, Object> convertImage(Map<String, Object> commandMap) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        String IMAGE_URL = (String) commandMap.get("carurl") == null ? "" : (String) commandMap.get("carurl");
        BufferedImage image = null;

        try {
            //버퍼이미지에 경로에 이미지를 읽어서 넣음
            image = ImageIO.read(new URL(IMAGE_URL));

            //이미지주소의 맨끝부분에 파일이름을 자름
            String fileNm = IMAGE_URL.substring(IMAGE_URL.lastIndexOf("/") + 1);
            fileNm = fileNm.replace(".png", ".webp");

            //저장할 디렉터리와파일명 생성
            String filePath = env.getProperty("spring.servlet.multipart.location");
            filePath = filePath + "/CAR_IMG/";

            File file = new File(filePath+fileNm);
            //해당경로로 gif형식의 이미지파일을 저장
            ImageIO.write(image, "webp", file);
            returnMap.put("convert_carurl", "https://tagotago.kr/upload/CAR_IMG/" + fileNm);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnMap;
    }

    public List<Map<String, Object>> searchRecall(String vinNum) {
        HttpURLConnection conn = null;
        OutputStream stream = null;
        BufferedReader bufferedReader = null;

        try {
            String apiKey = env.getProperty("recall.apiKey");
            String urlString = "https://www.car.go.kr/api/searchRecall.jsp";
            String body = "apiKey=" + apiKey + "&vinNum=" + vinNum;
            System.out.println("apiKey: >>> " + apiKey);
            System.out.println("vinNum: >>> " + vinNum);

            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10500);

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            stream = conn.getOutputStream();
            stream.write(body.getBytes(StandardCharsets.UTF_8));
            stream.flush();

            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "EUC-KR"));

            String temp, response = "";
            temp = response = "";
            while ((temp = bufferedReader.readLine()) != null) {
                response += temp;
            }
            System.out.println("data read : " + response);
            Map<String, Object> resultMap = CommonUtil.convertJSONstringToMap(response);
            System.out.println("resultMap: >>> " + resultMap);
            List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

            if (resultMap.get("resultList") != null) {
                resultList = (List<Map<String, Object>>) resultMap.get("resultList");
            }

            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception e) {
                }
            }
            if (conn != null)
                conn.disconnect();
        }
    }

}
