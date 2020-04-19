package net.fly.order.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.net.ssl.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author zchjeff on 2017/11/1.
 */
public class HttpKit {
    private static final Logger log = LoggerFactory.getLogger(HttpKit.class);

    private static final String SUFFIX_XLS = ".xls";
    private static final String SUFFIX_XLSX = ".xlsx";

    public static String getIp() {
        return getRequest().getRemoteAddr();
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return new WafRequestWrapper(request);
    }

    public static String getCookie(String name) {
        Cookie[] cookies = getRequest().getCookies();
        if (null == cookies) {
            return StringUtils.EMPTY;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return StringUtils.EMPTY;
    }

    public static void saveToken(String token) {
        HttpServletResponse response = getResponse();
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(3600 * 24 * 7);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * 是否是微信请求
     *
     * @return
     */
    public static boolean isWx() {
        String userAgent = getRequest().getHeader("user-agent");
        if (StringUtils.isBlank(userAgent)) {
            return false;
        }
        userAgent = userAgent.toLowerCase();
        return StringUtils.isNotEmpty(userAgent) && userAgent.indexOf("micromessenger") > -1;
    }

    /**
     * 获取头内信息
     *
     * @param key
     * @return
     */
    public static String getHeader(String key) {
        HttpServletRequest request = getRequest();
        return request.getHeader(key);
    }

    public static boolean isPost() {
        HttpServletRequest request = getRequest();
        return "post".equalsIgnoreCase(request.getMethod());
    }


    /**
     * 取上次请求来源地址
     *
     * @return
     */
    public static String getReferer() {
        HttpServletRequest request = getRequest();
        String refer = request.getHeader("referer");
        if (refer == null) {
            StringBuilder referUrl = new StringBuilder(request.getScheme());

            referUrl.append("://");
            referUrl.append(request.getServerName());
            if (request.getServerPort() != 80) {
                referUrl.append(":").append(request.getServerPort());
            }
            referUrl.append(request.getRequestURI());
//            String referUrl = "%s://%s%s";
//            refer = String.format(referUrl,
//                    request.getScheme(), request.getServerName(), request.getRequestURI());
            if (StringUtils.isNotEmpty(request.getQueryString())) {
                referUrl.append("?").append(request.getQueryString());
            }
            refer = referUrl.toString();
        }
        return refer;
    }

    public static boolean isAjax() {
        HttpServletRequest request = getRequest();
        boolean isAjax = false;
        isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        return isAjax;
    }

    public static void response(String content) throws Exception {
        HttpServletResponse response = getResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(content);
        out.flush();
        out.close();
    }

    /**
     * 推送到微信
     *
     * @param urlRequest URL
     * @param content    参数
     * @param charset    字符格式
     * @return 返回字符串
     */
    public static String doPostForSSL(String urlRequest, String content, String charset) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(512);
        try {
            URL url = new URL(urlRequest);
            // use ignore host name verifier
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            // Prepare SSL Context
            TrustManager[] tm = {ignoreCertificationTrustManger};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            connection.setSSLSocketFactory(ssf);
            connection.setDoOutput(true);
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content.getBytes(charset));
            out.flush();
            out.close();
            InputStream reader = connection.getInputStream();
            byte[] bytes = new byte[512];
            int length = reader.read(bytes);
            do {
                buffer.write(bytes, 0, length);
                length = reader.read(bytes);
            } while (length > 0);
            reader.close();
            connection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        String repString = new String(buffer.toByteArray());
        return repString;
    }

    /**
     * 忽视证书HostName
     */
    private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String s, SSLSession sslsession) {
            return true;
        }
    };

    /**
     * 忽略证书
     */
    private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {
        private X509Certificate[] certificates;

        @Override
        public void checkClientTrusted(X509Certificate certificates[],
                                       String authType) throws CertificateException {
            if (this.certificates == null) {
                this.certificates = certificates;
            }
        }

        @Override
        public void checkServerTrusted(X509Certificate[] ax509certificate,
                                       String s) throws CertificateException {
            if (this.certificates == null) {
                this.certificates = ax509certificate;
            }
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    public static String getRequestRefer() {
        String refer;
        HttpSession httpSession = HttpKit.getRequest().getSession();
        log.info("getRequestRefer->当前session id is {}", httpSession.getId());
        if (httpSession.getAttribute("refer") != null) {
            refer = httpSession.getAttribute("refer").toString();
            if (refer.equals(HttpKit.getRequest().getScheme() + "://" + HttpKit.getRequest().getServerName() + "/login")) {
                log.info("getRequestRefer->用户从登录页面过来，跳首页");
                refer = "/";
            }
            log.info("getRequestRefer->当前session id is {}, refer地址{}", httpSession.getId(), refer);
        } else {
            log.info("getRequestRefer->没有对应的refer，设置refer为： /");
            refer = "/";
        }
        return refer;
    }

    public static String getUri() {
        try {
            return HttpKit.getRequest().getRequestURI();
        } catch (Exception e) {
            log.error("获取uri失败:{}", e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * 导出excel文件
     *
     * @param workbook excel
     * @param filename 文件名 不包含后缀
     */
    @SuppressWarnings("all")
    public static void downloadExcel(Workbook workbook, String filename) {
        HttpServletResponse response = HttpKit.getResponse();
        try (OutputStream ouputStream = response.getOutputStream()) {
            if (workbook instanceof XSSFWorkbook) {
                filename = filename + SUFFIX_XLSX;
            } else {
                filename = filename + SUFFIX_XLS;
            }
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "filename=" + new String(filename.getBytes(Charset.forName("gb2312")), StandardCharsets.ISO_8859_1));
            workbook.write(ouputStream);
            ouputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ResponseEntity<byte[]> prepareWorkbook(Workbook workbook, String fileName) {
        try (ByteArrayOutputStream outByteStream = new ByteArrayOutputStream()) {
            fileName = fileName + ((workbook instanceof XSSFWorkbook) ? SUFFIX_XLSX : SUFFIX_XLS);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(outByteStream);
            return new ResponseEntity<>(outByteStream.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            log.error("导出文件失败", e);
            return null;
        }
    }

    public static ResponseEntity<byte[]> prepareFile(byte[] data, String fileName) {
        try (ByteArrayOutputStream outByteStream = new ByteArrayOutputStream()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        } catch (Exception e) {
            log.error("导出文件失败", e);
            return null;
        }
    }
}
