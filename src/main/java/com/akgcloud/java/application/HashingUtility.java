package com.akgcloud.java.application;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.Adler32;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class HashingUtility {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[]                buffer       = new byte[8 * 1024];

    public static String getMD5HashString(String str) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());

        byte byteData[] = md.digest();

        // convert the byte to hex format method 1
        // StringBuffer sb = new StringBuffer();
        // for (int i = 0; i < byteData.length; i++) {
        // sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,
        // 16).substring(1));
        // }
        //
        // System.out.println("Digest(in hex format):: " + sb.toString());

        // convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String getMD5Hash(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((str).getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        byte raw[] = md.digest();
        for (int i = 0; i < raw.length; i++) {
            sb.append(Character.forDigit((raw[i] >>> 4) & 0xf, 16));
            sb.append(Character.forDigit(raw[i] & 0xf, 16));
        }
        return sb.toString();

    }

    public static void hashTokenAuthenticationString() throws Exception {
        String m_algoMethod = "SHA-512";
        String m_encodingStd = "UTF-8";
        String m_encodingMethod = "Base64";
        String m_config = "transNoKey|foreignUserKey|secretKey";

        // input param
        String m_txnNo = "";
        String m_foreignUKey = "965300";
        String m_secretkey = "bPr1fGoofHw6EFgi2C9G0TgfqRjfe";
        String m_timeStampFormat = "ddMMyyyyhh";
        String timeStampVal = null;
        if (m_timeStampFormat != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(m_timeStampFormat);
            timeStampVal = sdf.format(new Date());
            System.out.println("timeStampVal : " + timeStampVal);
        }

        String authKey = null;

        MessageDigest md = MessageDigest.getInstance(m_algoMethod);
        if (m_config != null) {
            String[] order = m_config.split("[|]", -1);
            if (order != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < order.length; i++) {
                    String temp = order[i];
                    if (temp.equalsIgnoreCase("foreignUserKey")) {
                        sb.append(m_foreignUKey);
                    } else if (temp.equalsIgnoreCase("secretKey")) {
                        sb.append(m_secretkey);
                    } else if (temp.equalsIgnoreCase("transNoKey")) {
                        sb.append(m_txnNo);
                    }
                }
                md.update((sb.toString()).getBytes(m_encodingStd));
            }

        }
        byte raw[] = md.digest();
        if (m_encodingMethod.equalsIgnoreCase("Base64")) {
            authKey = new String(Base64.encodeBase64(raw));
        } else if (m_encodingMethod.equalsIgnoreCase("ByteToHex")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < raw.length; i++) {
                sb.append(Character.forDigit((raw[i] >>> 4) & 0xf, 16));
                sb.append(Character.forDigit(raw[i] & 0xf, 16));
            }
            authKey = sb.toString();
        }
        System.out.println("authKey : " + authKey);
        System.out.println("encoded authKey : " + URLEncoder.encode(authKey));
    }

    public static void calculateAdler32Checksum() {
        String origString = "Test";
        byte bytes[] = origString.getBytes();
        Checksum checksum = new Adler32();
        checksum.update(bytes, 0, bytes.length);
        String strChecksum = Long.toString(checksum.getValue());
        System.out.println("Adler32Checksum : " + strChecksum);
    }

    public static void scrambleForHashToken() {
        String word = "ZILLIOUSFCMONLINE";
        String newword = "";
        int rndnum;
        Random randGen = new Random();
        boolean letter[] = new boolean[word.length()];
        do {
            rndnum = randGen.nextInt(word.length());
            if (letter[rndnum] == false) {
                newword = newword + word.charAt(rndnum);
                letter[rndnum] = true;
            }
        } while (newword.length() < word.length());
        System.out.println("scrambled word : " + newword);
    }

    public void test() {

        int[] Num1 = { 5, 3, 6, 2, 8, 2, 0, 2, 8 };
        int[] Num2 = { 3, 5, 2, 3, 2, 1, 3, 4 };
        int sum = 0, carry;
        int k = Num1.length + Num2.length;
        int[] Num = new int[k];
        for (int i = Num1.length - 1; i >= 0; i--) {
            carry = 0;
            for (int j = Num2.length - 1; j >= 0; j--) {
                sum = Num2[j] * Num1[i] + carry + Num[k - 1];
                carry = sum / 10;
                Num[--k] = sum % 10;

            }
            Num[--k] = carry;
            k += Num2.length;
        }

        for (int j = 0; j < Num.length; j++) {
            System.out.println(j + "= " + Num[j]);
        }

    }

    public static void testException() {
        try {
            throw new RuntimeException("My Exception");
        } catch (Exception e) {
            e.printStackTrace();
            String s = null;
            try {
                System.out.println(Integer.parseInt(s));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }

        } finally {
            System.out.println("In finally");
        }
        System.out.println("End");
    }

    public static void testScanner() {
        System.out.println("Enter input integer");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            if (n < 100) {
                System.out.println("input : " + n);
            } else {
                System.exit(200);
            }
        }
    }

    public byte[] compress(InputStream stream) throws IOException {
        DeflaterInputStream deflateStream = null;
        try {
            deflateStream = new DeflaterInputStream(stream, new Deflater(Deflater.BEST_COMPRESSION, true));
            int length = 0;
            outputStream.reset();
            while ((length = deflateStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            return outputStream.toByteArray();
        } finally {
            if (deflateStream != null) {
                try {
                    deflateStream.close();
                } catch (Exception e) {
                }
                deflateStream = null;
            }
        }
    }

    public static void testCompression() throws Exception {

        FileInputStream fis = new FileInputStream("C:\\Users\\anil\\Desktop\\original.txt");
        FileOutputStream fos = new FileOutputStream("deflated.txt");
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);

        doCopy(fis, dos); // copy original.txt to deflated.txt and compress it

        FileInputStream fis2 = new FileInputStream("deflated.txt");
        InflaterInputStream iis = new InflaterInputStream(fis2);
        FileOutputStream fos2 = new FileOutputStream("inflated.txt");

        doCopy(iis, fos2); // copy deflated.txt to inflated.txt and uncompress
                           // it

    }

    public static void doCopy(InputStream is, OutputStream os) throws Exception {
        int oneByte;
        while ((oneByte = is.read()) != -1) {
            os.write(oneByte);
        }
        os.close();
        is.close();
    }

    public static void sha1() {
        String m_foreignUKey = "qtechagent";
        String m_secretkey = "atlas_travel_99";
        String m_timeStampFormat = "ddMMyyyyhhmm";
        String timeStampVal = null;
        if (m_timeStampFormat != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(m_timeStampFormat);
            timeStampVal = sdf.format(new Date());
            System.out.println("timeStampVal : " + timeStampVal);
        }
        System.out.println("SHA1 : " + DigestUtils.sha1Hex(m_foreignUKey + m_secretkey + "290620170250"));
    }

    public static long getDifferenceInDatesWithoutSwap(Calendar cal1, Calendar cal2, int differenceUnit,
            List<Integer> skipTimes) {
        long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long skipTime = 0;
        switch (differenceUnit) {
        case Calendar.SECOND:
            return diff / 1000;
        case Calendar.MINUTE:
            return diff / (60 * 1000);
        case Calendar.HOUR:
            diff = diff / (60 * 60 * 1000);
            // restrict skip check for 1 week due to performance issue
            if (diff < 168 && skipTimes != null) {
                skipTime = getSkipTimeBetweenTwoDates(cal1, cal2, skipTimes, Calendar.HOUR_OF_DAY);
                if (diff > skipTime) {
                    diff = diff - skipTime;
                }
            }
            return diff;
        case Calendar.DATE:
            diff = diff / (24 * 60 * 60 * 1000);
            // restrict skip check for 1 month due to performance issue
            if (diff < 31 && skipTimes != null) {
                skipTime = getSkipTimeBetweenTwoDates(cal1, cal2, skipTimes, Calendar.DAY_OF_WEEK);
                if (diff > skipTime) {
                    diff = diff - skipTime;
                }
            }
            return diff;
        }
        throw new RuntimeException("Invalid Difference Unit Value: " + differenceUnit);
    }

    public static long getSkipTimeBetweenTwoDates(Calendar cal1, Calendar cal2, List<Integer> skipTimes, int skipUnit) {
        long skipTime = 0;
        if (skipTimes != null && skipTimes.size() > 0 && cal1.before(cal2)) {
            while (cal1.before(cal2)) {
                if (skipTimes.contains(cal1.get(skipUnit))) {
                    skipTime++;
                }
                switch (skipUnit) {
                case Calendar.HOUR_OF_DAY:
                    cal1.add(Calendar.HOUR, 1);
                    break;
                case Calendar.DAY_OF_WEEK:
                    cal1.add(Calendar.DATE, 1);
                    break;
                default:
                    throw new RuntimeException("Invalid Skip Unit Value: " + skipUnit);
                }
            }
        }
        return skipTime;
    }

    public static void main(String[] args) throws Exception {
        // testStringBufferCapacity();
        hashTokenAuthenticationString();
        // sha1();
        // calculateAdler32Checksum();
        // scrambleForHashToken();

        // Class cls = Class.forName("com.example.java.TestExample");//
        // TestExample.class;
        //
        // for (Method m : cls.getMethods()) {
        // System.out.println(m.getName());
        // }
        String r1 = "{\"username\": \"Agent/Company Name\"\"username\": \"Agent/Company Name\"\"username\": \"Agent/Company Name\"\"username\": \"Agent/Company Name\"\"username\": \"Agent/Company Name\"\"username\": \"Agent/Company Name\"}";
        System.out.println(new String(Base64.encodeBase64(r1.getBytes())));
        System.out.println(URLEncoder.encode(new String(Base64.encodeBase64(r1.getBytes()))));

    }
}
