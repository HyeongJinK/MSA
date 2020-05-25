package com.illunex.invest.startup.service.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.illunex.invest.api.composite.startup.company.model.NiceCompanyInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KoscomOpenApiService {
    public static List<NiceCompanyInfo> companyOutlineIfo(String businessNumber) {
        List<NiceCompanyInfo> list = new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v1/nice/companyOutlineIfo/companyShortOutline");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            urlBuilder.append("?");
            urlBuilder.append(URLEncoder.encode("bizno","UTF-8") + "=" + URLEncoder.encode(businessNumber, "UTF-8") + "&");
            urlBuilder.append(URLEncoder.encode("apikey","UTF-8") + "=" + URLEncoder.encode("l7xx33d195cb26064d5fb636e979bf0b2f30", "UTF-8"));
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = null;
            StringBuilder sb = new StringBuilder();
            try{
                if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                } else {
                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
                }

                String line;
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }
                rd.close();
            }catch(Exception e){
                if(rd!=null){
                    rd.close();
                }
            }

            conn.disconnect();
            JsonElement rootObject = JsonParser.parseString(sb.toString()).getAsJsonObject().get("items").getAsJsonObject().get("item");
            NiceCompanyInfo[] array = gson.fromJson(rootObject, NiceCompanyInfo[].class);
            list = Arrays.asList(array);

        }catch(Exception e){
            e.printStackTrace();
        }


        return list;
    }
}
