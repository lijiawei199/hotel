package net.fly.order.core.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @description 字符编码转换工具类
 * @author wangchong
 * @create 2017-08-09 14:36
 */
public class CharacterEncodingUtils {
    /**
     * iso8859-1转utf-8编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String isoToUtf8(String str) {
        return aToB(str, "iso8859-1", "utf-8");
    }

    /**
     * iso8859-1转gbk编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String isoToGBK(String str) {
        return aToB(str, "iso8859-1", "gbk");
    }

    /**
     * iso8859-1转gb2312编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String isoToGB2312(String str) {
        return aToB(str, "iso8859-1", "gb2312");
    }

    /**
     * gbk转iso8859-1编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String GBKToIso(String str) {
        return aToB(str, "gbk", "iso8859-1");
    }

    /**
     * gbk转utf-8编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String gbkToUtf8(String str) {
        return aToB(str, "gbk", "utf-8");
    }

    /**
     * gbk转gb2312编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String gbkToGb2312(String str) {
        return aToB(str, "gbk", "gb2312");
    }

    /**
     * utf-8转iso8859-1编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String utf8ToIso(String str) {
        return aToB(str, "utf-8", "iso8859-1");
    }

    /**
     * utf-8转gbk编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String utf8ToGbk(String str) {
        return aToB(str, "utf-8", "gbk");
    }

    /**
     * utf-8转gb2312编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String utf8ToGb2312(String str) {
        return aToB(str, "utf-8", "gb2312");
    }

    /**
     * gb2312转iso8859-1编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String gb2312ToIso(String str) {
        return aToB(str, "gb2312", "iso8859-1");
    }

    /**
     * gb2312转gbk编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String gb2312ToGbk(String str) {
        return aToB(str, "gb2312", "gbk");
    }

    /**
     * gb2312转utf-8编码
     *
     * @param str 需要转码字符串
     * @return 转码后字符串
     */
    public static String gb2312ToUtf8(String str) {
        return aToB(str, "gb2312", "utf-8");
    }

    /**
     * 将字符串由A编码转换成B编码
     *
     * @param str 需要转码的字符串
     * @param a   字符编码
     * @param b   字符编码
     * @return 转码后字符串
     */
    public static String aToB(String str, String a, String b) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = new String(str.getBytes(a), b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * URL编码
     *
     * @param url
     * @param coding
     * @return
     */
    public static String urlEncode(String url, String coding) {
        try {
            return URLEncoder.encode(url, coding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * URL按照UTF-8编码
     *
     * @param url
     * @return
     */
    public static String urlEncode(String url) {
        return urlEncode(url, "UTF-8");
    }

    /**
     * URL解码
     *
     * @param url
     * @param coding
     * @return
     */
    public static String urlDecode(String url, String coding) {
        try {
            return URLDecoder.decode(url, coding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * URL按照UTF-8解码
     *
     * @param url
     * @return
     */
    public static String urlDecode(String url) {
        return urlDecode(url, "UTF-8");
    }


}
