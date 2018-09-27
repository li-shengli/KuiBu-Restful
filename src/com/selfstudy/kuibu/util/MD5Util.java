package com.selfstudy.kuibu.util;

import org.apache.log4j.Logger;

import java.security.MessageDigest;

public class MD5Util {

    private static Logger logger = Logger.getLogger(MD5Util.class);

    public static String md5Encode(String inStr) {
        if (inStr == null) return null;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            byte[] byteArray = inStr.getBytes("UTF-8");
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuilder hexValue = new StringBuilder();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            logger.error("Something wrong when generate MD5 String", e);
        }

        return null;
    }
}
