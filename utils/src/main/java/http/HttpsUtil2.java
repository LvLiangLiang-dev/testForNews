package http;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.ws.rs.HttpMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-03-29 下午1:37
 */
public class HttpsUtil2 {

    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) throws Exception {
        System.out.println("send https requestUrl:"+requestUrl);
        System.out.println("send https requestMethod:"+requestMethod);
        System.out.println("send https param:"+outputStr);
        JSONObject jsonObject = new JSONObject();
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            /*允许输出*/
            httpUrlConn.setDoOutput(true);
            /*允许输入*/
            httpUrlConn.setDoInput(true);
            /*不允许缓存*/
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);
            /*如果是get请求，明文连接*/
            if (HttpMethod.GET.toString().equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (!StringUtils.isEmpty(outputStr)) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 将请求返回的输入流转换成字json对象
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            httpUrlConn.disconnect();
            jsonObject=GsonUtil.fromJson(buffer.toString(),JSONObject.class);
            System.out.println("response jsonObject:"+jsonObject);
        } catch (ConnectException ce) {
            System.out.println("Weixin server connection timed out.");
            throw new Exception("Weixin server connection timed out.");
        } catch (Exception e) {
            System.out.println("https request error:" + e);
            throw new Exception("https request error:" + e);
        } finally {
            try {
                // 释放资源
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}

