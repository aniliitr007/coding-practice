package com.akgcloud.java.application;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class SoapWebserviceApi {

    public static final int CONNECT_TIMEOUT_IN_MILLI = (1000 * 60 * 5);

    public static void executeApi() throws Exception {
        String reqXML = getRequestXMLWithSOAP();
        String resXML = null;
        try {
            URL url = new URL("https://test.com");
            HttpURLConnection urlCon = null;
            Proxy proxy = getProxyServer();
            if (proxy != null) {
                urlCon = (HttpURLConnection) url.openConnection(proxy);
            } else {
                urlCon = (HttpURLConnection) url.openConnection();
            }
            urlCon.setConnectTimeout(CONNECT_TIMEOUT_IN_MILLI);
            urlCon.setReadTimeout(CONNECT_TIMEOUT_IN_MILLI);
            urlCon.setRequestMethod("POST");
            urlCon.setDoInput(true);
            urlCon.setDoOutput(true);
            urlCon.setUseCaches(false);
            urlCon.setRequestProperty("Content-type", "text/xml; charset=utf-8");
            urlCon.setRequestProperty("Accept", "application/soap+xml, application/dime, multipart/related, text/*");
            urlCon.setRequestProperty("SOAPAction", "TESTAction");

            // if (req.isUsingGZip()) {
            // urlCon.setRequestProperty("Content-Encoding", "gzip");
            // urlCon.setRequestProperty("Accept-Encoding", "gzip");
            // }

            DataOutputStream out = null;
            // if (req.isUsingGZip()) {
            // out = new DataOutputStream(new
            // GZIPOutputStream(urlCon.getOutputStream()));
            // } else {
            out = new DataOutputStream(urlCon.getOutputStream());
            // }
            out.writeBytes(reqXML);
            out.flush();
            out.close();

            InputStream inp = null;
            try {
                inp = urlCon.getInputStream();
            } catch (IOException e) {
                inp = urlCon.getErrorStream();
            }

            String enc = urlCon.getContentEncoding();
            InputStream inpStrm = null;
            if (enc != null && enc.equalsIgnoreCase("gzip")) {
                inpStrm = new GZIPInputStream(new BufferedInputStream(inp));
            } else {
                inpStrm = new BufferedInputStream(inp);
            }

            // res.parseResponseXML(new
            // ByteArrayInputStream(resXML.getBytes()));
            // res.parseResponseXML(inpStrm);

            try {
                inpStrm.close();
            } catch (Exception e) {
            }
            try {
                urlCon.disconnect();
            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
    }

    public static String getRequestXMLWithSOAP() throws Exception {
        StringBuilder buf = new StringBuilder(40960);
        appendSoapTop(buf);
        appendRequestXML(buf);
        appendSoapBottom(buf);
        return buf.toString();
    }

    public static void appendSoapTop(StringBuilder buf) {
        buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        buf.append(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns=\"http://webservice.zillious.com/ns/V1\"><soapenv:Header>");
        buf.append(
                "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" soapenv:mustUnderstand=\"1\"><wsse:UsernameToken xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"UsernameToken-25616143\"><wsse:Username>");
        buf.append("user name");
        buf.append(
                "</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">");
        buf.append("password");
        buf.append("</wsse:Password></wsse:UsernameToken></wsse:Security>");
        buf.append("</soapenv:Header><soapenv:Body>");
    }

    public static void appendRequestXML(StringBuilder buf) {
        buf.append("<Request>").append("</Request>");
    }

    public static void appendSoapBottom(StringBuilder buf) {
        buf.append("</soapenv:Body></soapenv:Envelope>");
    }

    public static Proxy getProxyServer() {
        String m_proxyIP = "192:168:0:1";
        int m_proxyPort = 25;
        if (m_proxyIP != null && m_proxyPort > 0) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(m_proxyIP, m_proxyPort));
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
