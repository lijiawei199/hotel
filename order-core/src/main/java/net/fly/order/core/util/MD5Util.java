package net.fly.order.core.util;

import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class MD5Util {

    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(byteToHexString(b));
        }
        return sb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    public static String MD5Encode(String origin, Charset charset) {
        Assert.notNull(origin, "源字符串不能为空");
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(origin.getBytes(charset)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

}
