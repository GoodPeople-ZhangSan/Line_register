package org.android.line;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class HttpClientUtils {
    public static String sendPostWithJson(String url, Map<String, String> heardMap, String jsonStr) {
        // 返回的结果
        String jsonResult = "";
        try {
            HttpClient client = new HttpClient();
            // 连接超时
            client.getHttpConnectionManager().getParams().setConnectionTimeout(3 * 1000);
            // 读取数据超时
            client.getHttpConnectionManager().getParams().setSoTimeout(3 * 60 * 1000);
            client.getParams().setContentCharset("UTF-8");
            PostMethod postMethod = new PostMethod(url);

            // 遍历Map内容，增加请求头
            for (Map.Entry<String, String> stringObjectEntry : heardMap.entrySet()) {
                postMethod.setRequestHeader(stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }

            // 非空
            if (null != jsonStr && !"".equals(jsonStr)) {
                StringRequestEntity requestEntity = new StringRequestEntity(jsonStr, heardMap.get("content-type"), "UTF-8");
                postMethod.setRequestEntity(requestEntity);
            }
            int status = client.executeMethod(postMethod);
            if (status == HttpStatus.SC_OK) {
                jsonResult = postMethod.getResponseBodyAsString();

                System.out.println(postMethod.toString());
                System.out.println(postMethod.getResponseBodyAsString());
                System.out.println(Arrays.toString(postMethod.getResponseBody()));
                System.out.println(Arrays.toString(postMethod.getRequestHeaders()));

            } else {
                throw new RuntimeException("接口连接失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("接口连接失败！");
        }
        return jsonResult;
    }

}
