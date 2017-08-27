package com.silkroad.model.service;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class RestServiceDefaultImpl implements RestService {

    private static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";

    public String doGetRequest(String url) throws IOException{
        final OkHttpClient httpClient = new OkHttpClient();

        Request getRequest = new Request.Builder()
                .url(url)
                .build();
        Response response = httpClient.newCall(getRequest).execute();

        return response.body().string();
    }

    public String doPostRequest(String url, Map<String, String> parameters) throws IOException {
        final OkHttpClient httpClient = new OkHttpClient();

        Gson gson = new Gson();
        String jsonParameters = gson.toJson(parameters);

        MediaType mediaTypeJSON = MediaType.parse(CONTENT_TYPE_JSON);
        RequestBody requestBody = RequestBody.create(mediaTypeJSON, jsonParameters);

        Request postRequest = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = httpClient.newCall(postRequest).execute();

        return response.body().string();
    }
}
