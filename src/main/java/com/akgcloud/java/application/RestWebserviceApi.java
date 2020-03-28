package com.akgcloud.java.application;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class RestWebserviceApi {

    public static final int CONNECT_TIMEOUT_IN_MILLI = (1000 * 60 * 5);

    public static boolean executeApi() throws Exception {
        HttpURLConnection urlCon = null;
        String reqData = null;
        String resJson = null;
        boolean isSucess = true;

        try {
            reqData = getPostParameters();
            URL url = new URL("https//test.com");
            Proxy proxy = getProxyServer();
            if (proxy != null) {
                urlCon = (HttpURLConnection) url.openConnection(proxy);
            } else {
                urlCon = (HttpURLConnection) url.openConnection();
            }
            urlCon.setConnectTimeout(CONNECT_TIMEOUT_IN_MILLI);
            urlCon.setReadTimeout(CONNECT_TIMEOUT_IN_MILLI);
            urlCon.setRequestProperty("Content-Type", "application/json");
            urlCon.setRequestMethod("POST");
            urlCon.setDoInput(true);
            urlCon.setDoOutput(true);
            urlCon.setUseCaches(false);
            urlCon.setRequestProperty("Accept",
                    "application/json, text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2");

            // if req is gzip
            urlCon.setRequestProperty("Content-Encoding", "gzip");
            urlCon.setRequestProperty("Accept-Encoding", "gzip");

            DataOutputStream out = new DataOutputStream(urlCon.getOutputStream());
            out.writeBytes(reqData);
            out.flush();
            out.close();

            resJson = convertInputStreamToString(getInputStream(urlCon));
            parseResponseJSON(resJson);
            try {
                urlCon.disconnect();
            } catch (Exception e) {
                isSucess = false;
            }

        } catch (Exception e) {
            isSucess = false;
        }
        return isSucess;
    }

    public static String getPostParameters() {
        // create json and return
        return null;
    }

    public static Proxy getProxyServer() {
        String m_proxyIP = "192:168:0:1";
        int m_proxyPort = 25;
        if (m_proxyIP != null && m_proxyPort > 0) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(m_proxyIP, m_proxyPort));
        }
        return null;
    }

    public static String convertInputStreamToString(InputStream inpStrm) throws Exception {
        StringBuilder b = new StringBuilder();
        byte[] buffer = new byte[2048];
        int len = -1;
        while ((len = inpStrm.read(buffer)) != -1) {
            b.append(new String(buffer, 0, len));
        }
        return b.toString();
    }

    public static InputStream getInputStream(HttpURLConnection urlCon) throws Exception {
        InputStream inp = urlCon.getInputStream();
        String enc = urlCon.getContentEncoding();
        InputStream inpStrm = null;
        if (enc != null && enc.equalsIgnoreCase("gzip")) {
            inpStrm = new GZIPInputStream(new BufferedInputStream(inp));
        } else {
            inpStrm = new BufferedInputStream(inp);
        }
        return inpStrm;
    }

    public static void parseResponseJSON(String resJson) throws Exception {
        JSONObject searchJson = new JSONObject(resJson);
        JSONArray results = null;
        JSONObject option = null;
        results = searchJson.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            option = results.getJSONObject(i);
            int id = option.getInt("id");
            String name = option.getString("name");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
