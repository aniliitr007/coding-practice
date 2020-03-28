package com.akgcloud.java.application;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSSender {

    private static final int    TIMEOUT_IN_MILLI = 1000 * 45;
    private static final String ENCODING         = "UTF-8";

    public static boolean sendSingleMessage(String recep) throws Exception {
        if (recep == null || "null".equalsIgnoreCase(recep)) {
            return false;
        }

        String pushURL = "test.sms.com";

        StringBuilder urlBuf = new StringBuilder();
        urlBuf.append(pushURL);
        urlBuf.append(URLEncoder.encode("recepientURLParam", ENCODING)).append("=")
                .append(URLEncoder.encode(recep, ENCODING));
        urlBuf.append("&").append(URLEncoder.encode("messageURLParam", ENCODING)).append("=")
                .append(URLEncoder.encode("sms content here", ENCODING));

        URL url = new URL(urlBuf.toString());
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(TIMEOUT_IN_MILLI);
        urlCon.setReadTimeout(TIMEOUT_IN_MILLI);
        urlCon.setRequestMethod("GET");
        urlCon.setDoOutput(true);
        urlCon.setDoInput(true);
        urlCon.setUseCaches(false);
        urlCon.connect();

        InputStream is = urlCon.getInputStream();
        StringBuilder ret = new StringBuilder();
        byte[] buffer = new byte[500];
        int len = 0;
        while ((len = is.read(buffer)) > 0) {
            ret.append(new String(buffer, 0, len));
        }
        try {
            is.close();
        } catch (Exception e) {
        }
        try {
            urlCon.disconnect();
        } catch (Exception e) {
        }

        if (ret.indexOf("successResponseSubstring") != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
