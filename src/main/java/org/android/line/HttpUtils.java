package org.android.line;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.Map;

public class HttpUtils {
    public static void doPost(String targetUrl, Map<String, String> heardMap, String body) {
        // 创建HttpClient实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建HttpPost请求
            HttpPost httpPost = new HttpPost(targetUrl);

            // 遍历Map内容，增加请求头
            for (Map.Entry<String, String> stringObjectEntry : heardMap.entrySet()) {
                // 设置请求头
                httpPost.setHeader(stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }
//            httpPost.setHeader("Content-Type", "application/json");

            // 设置请求体
            StringEntity entity = new StringEntity(body);
            httpPost.setEntity(entity);

            // 发送请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {

                // 获取响应状态码
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Response Code: " + statusCode);

                // 获取响应体内容（这里以字符串形式展示）
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response Body: " + responseBody);
                System.out.println(Arrays.toString(httpPost.getAllHeaders()));

                // 注意：在实际应用中，你应该根据响应状态码来决定是否读取响应体
                // 例如，对于2xx的成功状态码，你可以读取响应体
                // 对于4xx或5xx的错误状态码，你可能需要处理错误或记录日志

            } catch (Exception e) {
                e.printStackTrace();
                // 在实际应用中，你可能需要更复杂的错误处理
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 在实际应用中，你可能需要更复杂的错误处理，包括关闭资源等
        }
    }
}
