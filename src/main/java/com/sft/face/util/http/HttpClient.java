package com.sft.face.util.http;

import com.sft.face.util.Get4Code;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;

public class HttpClient {
    private static CloseableHttpClient httpClient;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(20);
        cm.setDefaultMaxPerRoute(50);
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
    }

    /**
     * 获得响应HTTP实体内容
     * @param response
     * @return
     * @throws java.io.IOException
     * @throws java.io.UnsupportedEncodingException
     */
    private static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
        //通过HttpResponse 的getEntity()方法获取返回信息
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }
            br.close();
            is.close();
            return sb.toString();
        }
        return "";
    }

    public static String doGet(String url) throws ClientProtocolException, IOException {
        //首先需要先创建一个DefaultHttpClient的实例
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //先创建一个HttpGet对象,传入目标的网络地址,然后调用HttpClient的execute()方法即可:
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(URI.create(url));
        HttpResponse response = httpClient.execute(httpGet);
        String httpEntityContent = getHttpEntityContent(response);
        httpGet.abort();
        return httpEntityContent;
    }

    public static String doPost(String url, String jsonString) {
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String result = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
            httpPost.setConfig(requestConfig);
            httpPost.setConfig(requestConfig);
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(new StringEntity(jsonString, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
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

    public static void main(String[] args) throws Exception {

    }
}