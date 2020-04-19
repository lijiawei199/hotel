package net.fly.order.core.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangchong
 * @description http请求处理
 * @create 2017-08-09 14:28
 */
public class HttpClientUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    private static CloseableHttpClient httpClient;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(20);
        cm.setDefaultMaxPerRoute(50);
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
    }

//    public static String get()

    public static String get(String url) {
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String result = "";
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout
                    (30000).build();
            httpGet.setConfig(requestConfig);
            httpGet.setConfig(requestConfig);
            httpGet.addHeader("Content-type", "application/json; charset=utf-8");
            httpGet.setHeader("Accept", "application/json");
            response = httpClient.execute(httpGet);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 模拟get请求
     *
     * @param url     请求URL地址
     * @param params  请求参数
     * @param charset 字符编码
     * @return get请求的响应字符串
     */
    public static String doGet(String url, String params, String charset) {
        HttpClient hc = new HttpClient();
        hc.getHttpConnectionManager().getParams().setConnectionTimeout(50000);
        GetMethod gm = new GetMethod(url);
        gm.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 50000);
        gm.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler());
//        gm.addRequestHeader("Content-Type","application/x-www-form-urlencoded; charset="+charset);
        String content = "";
        try {
            gm.setQueryString(URIUtil.encodeQuery(params, charset));
            if (hc.executeMethod(gm) == HttpStatus.SC_OK) {
                return CharacterEncodingUtils.aToB(gm.getResponseBodyAsString(), gm.getResponseCharSet(), charset);
            }
        } catch (Exception e) {
            log.info("调用api2获取openId异常", e);
        }
        return content;
    }

    /**
     * 模拟post请求
     *
     * @param url     请求URL地址
     * @param params  请求参数
     * @param charset 字符编码
     * @param isWrap  是否换行
     * @return post请求的响应字符串
     */
    public static String doPost(String url, Map<String, String> params,
                                String charset, boolean isWrap) {
        HttpClient hc = new HttpClient();
        PostMethod hm = new PostMethod(url);
        StringBuffer sb = new StringBuffer();
        if (params != null && params.size() != 0) {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                nameValuePairs.add(new NameValuePair(key, params.get(key)));
            }
            hm.setRequestBody(nameValuePairs.toArray(new NameValuePair[]{}));
        }
        try {
            hc.executeMethod(hm);
            if (hm.getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(hm
                        .getResponseBodyAsStream(), charset));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    if (isWrap) {
                        sb.append(System.getProperty("line.separator"));
                    }
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hm.releaseConnection();
        }
        return sb.toString();
    }

    /**
     * 模拟Post请求
     *
     * @param url     请求URL地址
     * @param body    请求内容
     * @param charset 字符编码
     * @param isWrap  是否换行
     * @return post请求的响应字符串
     */
    public static String doPost(String url, String body, String charset, boolean isWrap) {
        HttpClient hc = new HttpClient();
        PostMethod hm = new PostMethod(url);
        hm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        hm.addRequestHeader("Content-Type", "text/html;charset=UTF-8");
        hm.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
        StringBuffer sb = new StringBuffer();
        hm.setRequestBody(body);
        try {
            hc.executeMethod(hm);
            if (hm.getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(hm
                        .getResponseBodyAsStream(), charset));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    if (isWrap) {
                        sb.append(System.getProperty("line.separator"));
                    }
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hm.releaseConnection();
        }
        return sb.toString();
    }

    /**
     * 模拟Post请求
     *
     * @param url     请求URL地址
     * @param body    请求内容
     * @param charset 字符编码
     * @return post请求的响应字符串
     */
    public static String doPost(String url, String body, String charset) {
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.getParams().setContentCharset("UTF-8");
            PostMethod method = new PostMethod(url);

            RequestEntity entity = new StringRequestEntity(body, "application/json", charset);
            method.setRequestEntity(entity);
            httpClient.executeMethod(method);
            InputStream in = method.getResponseBodyAsStream();
            //下面将stream转换为String
            StringBuffer sb = new StringBuffer();
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            char[] b = new char[4096];
            for (int n; (n = isr.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 发送xml数据请求到server端
     *
     * @param url     xml请求数据地址
     * @param strXml  发送的xml数据流
     * @param charset 字符编码
     * @return null发送失败，否则返回响应内容
     */
    public static String doPostOfXml(String url, String strXml, String charset) {

        //创建httpclient工具对象
        HttpClient client = new HttpClient();
        //创建post请求方法
        PostMethod myPost = new PostMethod(url);

        String strResp = null;
        try {
            //设置请求头部类型
            myPost.setRequestHeader("Content-Type", "text/xml");
            myPost.setRequestHeader("charset", charset);

            //设置请求体，即xml文本内容，注：这里写了两种方式，一种是直接获取xml内容字符串，一种是读取xml文件以流的形式
//          myPost.setRequestBody(strXml);
            myPost.setRequestEntity(new StringRequestEntity(strXml, "text/xml", charset));

            int statusCode = client.executeMethod(myPost);
            if (statusCode == HttpStatus.SC_OK) {
                BufferedInputStream bis = new BufferedInputStream(myPost.getResponseBodyAsStream());
                byte[] bytes = new byte[1024];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int count = 0;
                while ((count = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, count);
                }
                byte[] strByte = bos.toByteArray();
                strResp = new String(strByte, 0, strByte.length, charset);
                bos.close();
                bis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        myPost.releaseConnection();
        return strResp;
    }

    /**
     * post请求
     *
     * @param url            url地址
     * @param jsonParam      参数
     * @param noNeedResponse 不需要返回结果
     * @return 请求结果
     */
    public static String httpPost(String url, String jsonParam, boolean noNeedResponse) {
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String strResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");

            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    strResult = str;
                    if (noNeedResponse) {
                        return null;
                    }
                } catch (Exception e) {
                    log.error("post请求提交失败:" + url + e.getMessage());
                }
            }
        } catch (IOException e) {
            log.error("post请求提交失败:" + url + e.getMessage());
        }
        return strResult;
    }

    /**
     * 模拟ssl请求
     *
     * @param urlRequest 请求URL
     * @return
     */
    public static String doGetForSSL(String urlRequest, String charset) {
        StringBuffer sb = new StringBuffer();
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
            InputStream reader = connection.getInputStream();
            byte[] bytes = new byte[512];
            int length = reader.read(bytes);
            do {
                sb.append(new String(bytes, 0, length, charset));
                length = reader.read(bytes);
            } while (length > 0);
            reader.close();
            connection.disconnect();
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return sb.toString();
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

    public static String sendPostByJson(String url, Map<String, String> map, Map<String, String> headers) {
        log.info("调用sendPost请求{}，入参： {}", url, JSON.toJSONString(map));
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(url);

        // do
        try {
            String entityStr = JSON.toJSONString(map);
            StringEntity stringEntity = new StringEntity(entityStr, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");

            // set headers
            setHeaders(post, headers);
            post.setEntity(stringEntity);
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            log.info("调用sendPost请求{}，出参： {}", url, result);
            return result;
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    private static void setHeaders(HttpPost httpPost, Map<String, String> header) {
        if (!CollectionUtils.isEmpty(header)) {
            Header[] headers = new Header[header.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : header.entrySet()) {
                headers[i] = new BasicHeader(entry.getKey(), entry.getValue());
                i++;
            }
            httpPost.setHeaders(headers);
        }
    }

    public static String sendPostByJson2(String url, Map<String, Object> map, Map<String, String> headers) {
        log.info("调用sendPost请求{}，入参： {}", url, JSON.toJSONString(map));
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(url);

        // do
        try {
            String entityStr = JSON.toJSONString(map);
            StringEntity stringEntity = new StringEntity(entityStr, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");

            // set headers
            setHeaders2(post, headers);
            post.setEntity(stringEntity);
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            log.info("调用sendPost请求{}，出参： {}", url, result);
            return result;
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    private static void setHeaders2(HttpPost httpPost, Map<String, String> header) {
        if (!CollectionUtils.isEmpty(header)) {
            Header[] headers = new Header[header.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : header.entrySet()) {
                headers[i] = new BasicHeader(entry.getKey(), entry.getValue());
                i++;
            }
            httpPost.setHeaders(headers);
        }
    }

    public static String sendPostByJson3(String url, String JSONStr, Map<String, String> headers) {
        log.info("调用sendPost请求{}，入参： {}", url, JSONStr);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(url);

        // do
        try {
            StringEntity stringEntity = new StringEntity(JSONStr, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");

            // set headers
            setHeaders(post, headers);
            post.setEntity(stringEntity);
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            log.info("调用sendPost请求{}，出参： {}", url, result);
            return result;
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

}
