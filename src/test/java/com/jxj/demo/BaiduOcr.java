package com.jxj.demo;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduOcr {
    private static final String APP_ID = "19755251";
    private static final String API_KEY = "wzdcXqFvzIiEkMmniUqS9OVh";
    private static final String SECRET_KEY = "SEGVlXnXKwMUHVrIWxD4rPAnk4MGUbcY";
    private static AipOcr client;

    public static String imgOcr(byte[] img) throws JSONException {
        getClient();
        JSONObject jsonObject = client.webImage(img, null);
        JSONArray jSONArray=jsonObject.getJSONArray("words_result");
        String j= (String) jSONArray.get(0);
        return j;
    }

    private static void getClient() {
        if (client == null) {
            client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        }
    }
}
