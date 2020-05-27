import org.apache.commons.lang3.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static PoolingHttpClientConnectionManager poolingConnManager;
    private static final Integer timeout;
    private static final String CHARSET = "UTF-8";
    private static final String HTTP_HEAD_PARAMETER_TIMEOUT = "timeout";

    static {
        timeout = 120 * 1000;
        poolingConnManager = new PoolingHttpClientConnectionManager();
    }

    /**
     * 发送post请求，未指定参数的编码方式，在指定cookie、domain、path不为空前提下，可向request中设置cookie
     *
     * @param url     url地址
     * @param params  请求参数
     * @param cookies cookie值
     * @param domain  cookie的所属domain
     * @param path    cookie的path
     *
     * @return result string
     */
    public static String sendPost(String url, Map<String, String> params, Map<String, String> cookies,
                                  String domain, String path) {
        CloseableHttpClient httpclient = getClient(cookies, domain, path);

        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (null != params) {
            for (Iterator<String> i = params.keySet().iterator(); i.hasNext(); ) {
                String key = i.next();
                nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        HttpResponse response;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            logger.error("send post error:", e);
        }
        return "ERROR";
    }

    /**
     * 发送request，可以填写cookie，request body使用utf8编码
     *
     * @param url         目标地址
     * @param requestBody 使用utf8编码的request body
     * @param cookies     cookie
     * @param domain      domain
     * @param path        path
     *
     * @return result
     */
    public static String sendPost(String url, String requestBody, Map<String, String> cookies, String domain,
                                  String path) {
        CloseableHttpClient httpclient = getClient(cookies, domain, path);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(requestBody, CHARSET));
        HttpResponse response;
        String result = null;
        try {
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
        } catch (IOException e) {
            logger.error(String.format("send post fail, url is %s, detail is:", url), e);
        }
        return result;
    }

    /**
     * 发送post请求，未指定编码方式，中文有乱码可能
     *
     * @param url    post地址
     * @param params 参数
     *
     * @return result string
     */
    public static String sendPost(String url, Map<String, String> params) {
        return sendPost(url, params, null, null, null);
    }

    /**
     * 发送post请求
     *
     * @param url         post地址
     * @param requestBody 参数
     *
     * @return result string
     */
    public static String sendPost(String url, String requestBody) {
        return sendPost(url, requestBody, null, null, null);
    }

    public static String appendUrlByParams(String url, Map<String, String> params) throws Exception {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (null != params) {
            for (Iterator<String> i = params.keySet().iterator(); i.hasNext(); ) {
                String key = i.next();
                nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        return url + (StringUtils.contains(url, "?") ? "&" : "?")
                + EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
    }

    public static String sendGet(String url, Map<String, String> params, Cookie[] cookies) throws Exception {
        CloseableHttpClient httpclient = null;
        if (null == cookies || cookies.length == 0) {
            httpclient = getClient();
        } else {
            String domain = "";
            String path = "";
            Map<String, String> maps = new HashMap<>();
            for (Cookie cookie : cookies) {
                maps.put(cookie.getName(), cookie.getValue());
                domain = cookie.getDomain();
                path = cookie.getPath();
            }
            httpclient = getClient(maps, domain, path);
        }
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (null != params) {
            for (Iterator<String> i = params.keySet().iterator(); i.hasNext(); ) {
                String key = i.next();
                nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        String param = url + (StringUtils.contains(url, "?") ? "&" : "?")
                + EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
        logger.info("param: " + param);
        HttpGet httpget = new HttpGet(param);
        String str = getCookieStr(cookies);
        if (!StringUtils.isEmpty(str)) {
            httpget.addHeader("Cookie", str);
        }
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            logger.error("sent get error:" + e + " url is:" + url);
            throw e;
        }
    }

    public static String sendGet(String url) throws Exception {
        CloseableHttpClient httpclient = getClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response;
        try {
            logger.info("SEND GET REQUEST, URL:" + url);
            response = httpclient.execute(httpget);
            logger.info("SEND GET REQUEST SUC, URL:" + url);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
            logger.info("READY TO RETURN");
            return result;
        } catch (Exception e) {
            logger.error("sent get error:" + e + " url is:" + url);
            throw e;
        }
    }

    public static String sendGetByHeader(String url, Map<String, String> params, Map<String, String> header) {
        CloseableHttpClient httpclient = getClient();
        String result = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (null != params) {
                for (Iterator<String> i = params.keySet().iterator(); i.hasNext(); ) {
                    String key = i.next();
                    nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
                }
            }
            HttpGet httpget = new HttpGet(url + (StringUtils.contains(url, "?") ? "&" : "?")
                    + EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs, CHARSET)));

            if (null == header || header.size() == 0) {
                header = getJsonHeader();
            }
            for (String key : header.keySet()) {
                httpget.setHeader(key, header.get(key));
            }
            HttpResponse response;
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
        } catch (Exception e) {
            logger.error("sent get error:" + e + " url is:" + url);
        }
        return result;
    }

    public static String sendGetByHeader(String url, Map<String, String> header) throws Exception {
        CloseableHttpClient httpclient = getClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response;
        try {
            if (null != header && header.size() > 0) {
                for (String key : header.keySet()) {
                    httpget.setHeader(key, header.get(key));
                }
            }
            logger.info("SEND GET REQUEST, URL:" + url);
            response = httpclient.execute(httpget);
            logger.info("SEND GET REQUEST SUC, URL:" + url);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
            logger.info("READY TO RETURN");
            return result;
        } catch (Exception e) {
            logger.error("sent get error:" + e + " url is:" + url);
            throw e;
        }
    }



    public static Map<String, String> getJsonHeader() {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("Content-Type", "application/json");
        ret.put("Accept", "application/json");
        return ret;
    }

    public static HttpEntityEnclosingRequestBase fillJson(HttpEntityEnclosingRequestBase entityRequest,
                                                          String jsonStr, Map<String, String> header) {
        if (null != header) {
            for (String key : header.keySet()) {
                entityRequest.setHeader(key, header.get(key));
            }
        }
        entityRequest.setEntity(new StringEntity(jsonStr, CHARSET));
        return entityRequest;
    }

    /**
     * 注意：一定要将response读出来，不然这个请求一直不能释放！！！
     *
     * @param entityRequest The request
     *
     * @return The response entity
     */
    public static HttpResponse sendPostEntity(HttpEntityEnclosingRequestBase entityRequest) {
        CloseableHttpClient httpclient = getClient();
        try {
            return httpclient.execute(entityRequest);
        } catch (Exception e) {
            logger.error("send post error:" + e);
            throw new RuntimeException("提交post失败", e);
        }
    }

    public static String sendPostJson(String url, String json, Map<String, String> header) {
        HttpEntityEnclosingRequestBase httpPost = fillJson(new HttpPost(url), json, header);
        return readResponse(sendPostEntity(httpPost));
    }

    public static String sendPostJson(String url, String json, Cookie[] cookies) {
        HttpEntityEnclosingRequestBase httpPost = fillJson(new HttpPost(url), json, getJsonHeader());
        String str = getCookieStr(cookies);
        if (!StringUtils.isEmpty(str)) {
            httpPost.addHeader("Cookie", str);
        }
        return readResponse(sendPostEntity(httpPost));
    }

    public static String readResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        try {
            String result = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e) {
            logger.error("send post error:", e);
            throw new RuntimeException("提交post失败", e);
        }
    }

    public static String sendPostByHeader(String url, Map<String, String> params, String requestBody,
                                          Map<String, String> header, boolean isAppendUrlByParams) {
        CloseableHttpClient httpclient = getClient();
        try {
            ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
            if (null != params) {
                for (String e : params.keySet()) {
                    nameValuePairs.add(new BasicNameValuePair(e, params.get(e)));
                }
            }
            if (isAppendUrlByParams) {
                url = url + (StringUtils.contains(url, "?") ? "&" : "?")
                        + EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
            }
            HttpPost httpPost = new HttpPost(url);
            if (!isAppendUrlByParams) {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
            }

            if (StringUtils.isNotEmpty(requestBody)) {
                httpPost.setEntity(new StringEntity(requestBody, CHARSET));
            }
            httpPost.setHeader("Keep-Alive", String.valueOf(timeout / 1000));
            if (null == header || header.size() == 0) {
                header = getJsonHeader();
            }
            for (String key : header.keySet()) {
                httpPost.setHeader(key, header.get(key));
            }
            HttpResponse response1 = httpclient.execute(httpPost);
            HttpEntity e1 = response1.getEntity();
            String result = EntityUtils.toString(e1, CHARSET);
            EntityUtils.consume(e1);
            return result;
        } catch (Exception e) {
            logger.error("send post error:" + e);
            throw new RuntimeException("提交post失败", e);
        }
    }

    /**
     * Content-Type  : application/x-www-form-urlencoded
     */
    public static String sendPostUtf8(String url, Map<String, String> params) {
        CloseableHttpClient httpclient = getClient();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
        if (null != params) {
            for (String e : params.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(e, params.get(e)));
            }
        }
        httpPost.setHeader("Keep-Alive", String.valueOf(timeout / 1000));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
            HttpResponse response1 = httpclient.execute(httpPost);
            HttpEntity e1 = response1.getEntity();
            String result = EntityUtils.toString(e1, CHARSET);
            EntityUtils.consume(e1);
            return result;
        } catch (Exception e) {
            logger.error("send post error:" + e);
            throw new RuntimeException("提交post失败", e);
        }
    }

    private static CloseableHttpClient getClient() {
        return getClient(null, null, null);
    }

    private static CloseableHttpClient getClient(Map<String, String> cookies, String domain, String path) {
        ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                HeaderElementIterator it =
                        new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase(HTTP_HEAD_PARAMETER_TIMEOUT)) {
                        return timeout;
                    }
                }
                return timeout;
            }
        };
        BasicCookieStore cookieStore = new BasicCookieStore();
        if (null != cookies) {
            if (null == path) {
                path = "";
            }
            if (null == domain) {
                domain = "";
            }
            for (String key : cookies.keySet()) {
                BasicClientCookie cookie = new BasicClientCookie(key, cookies.get(key));
                cookie.setDomain(domain);
                cookie.setPath(path);
                cookieStore.addCookie(cookie);
            }
        }
        return HttpClients.custom().disableContentCompression()
                .setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(10 * 1000).build())
                .setKeepAliveStrategy(keepAliveStrategy).setDefaultCookieStore(cookieStore)
                .setConnectionManager(poolingConnManager).build();
    }

    public static String getCookieStr(Cookie[] cookies) {
        StringBuffer sb = new StringBuffer();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                sb.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
            }
        }
        return sb.toString();
    }

}

