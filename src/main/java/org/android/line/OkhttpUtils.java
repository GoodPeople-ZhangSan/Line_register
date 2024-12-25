package org.android.line;

import okhttp3.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class OkhttpUtils {
    private static final OkHttpClient client = new OkHttpClient();

    // post请求
    public static void doPost(String url, Map<String, String> heardMap, RequestBody body) {
        // 创建Request请求
        Request.Builder requestbuilder = new Request.Builder().url(url).post(body);
        // 后续执行
        requestAll(requestbuilder, heardMap);
    }

    // Get请求
    public static void doGet(String url, Map<String, String> heardMap) {
        // 创建Request请求
        Request.Builder requestbuilder = new Request.Builder().url(url).get();
        // 后续执行
        requestAll(requestbuilder, heardMap);
    }

    public static void requestAll(Request.Builder requestbuilder, Map<String, String> heardMap) {
        // 遍历Map内容，增加请求头
        for (Map.Entry<String, String> stringObjectEntry : heardMap.entrySet()) {
            requestbuilder.addHeader(stringObjectEntry.getKey(), stringObjectEntry.getValue());
        }

        // 准备发送请求
        Request request = requestbuilder.build();
        // 用于存储 返回值body
        String resultBody;

        // 发送请求并获取响应
        try {
            Response resultResponse = client.newCall(request).execute();
            System.out.println(resultResponse.toString());
            System.out.println(resultResponse.headers().toString());
            System.out.println(resultResponse.body().toString());

            // 判断是否zip
            if (resultResponse.isSuccessful() && "gzip".equalsIgnoreCase(resultResponse.header("Content-Encoding"))) {
                // Gizp 解压
                resultBody = un_gzip(resultResponse);
                // 输出解压后的响应体
                System.out.println("请求Body内容 GZIP解压后：" + resultBody);
            } else {
                resultBody = resultResponse.body().string();
                // 如果响应不是GZIP压缩的，直接读取响应体
                System.out.println("no GZIP:" + resultBody);
            }
        } catch (IOException e) {
            System.out.println("异常：" + e);
        }
    }

    // 用于解压GZIP
    private static String un_gzip(Response response) {
        // 用于存储 返回值 body
        String result_un_Body = "";
        try {
            // 手动解压GZIP响应
            byte[] gzippedBody = response.body().bytes();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (GZIPInputStream gzipInputStream = new GZIPInputStream(gzippedBody.length > 0 ? new java.io.ByteArrayInputStream(gzippedBody) : null)) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = gzipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
            }
            result_un_Body = byteArrayOutputStream.toString("UTF-8");
        } catch (IOException e) {
            System.out.println("异常：" + e);
        }
        return result_un_Body;
    }
}
