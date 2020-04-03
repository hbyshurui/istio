package post.tool;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class OkHttpPost {
    public static final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    public static String PostJson(JSONObject json, String url) throws IOException {
        return postMethod(json.toString(), url);
    }

    public static String PostString(String s, String url) throws IOException {
        return postMethod(s, url);
    }

    private static String postMethod(String s, String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, s);
        Request request = new Request.Builder().url(url).post(body).build();
        return getString(client, request);
    }

    public static String getMethod(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        return getString(client, request);
    }

    private static String getString(OkHttpClient client, Request request) throws IOException {
        Response response = client.newCall(request).execute();
        if (response.body() != null) {
            return response.body().string();
        } else {
            return "接口返回为空";
        }
    }
}