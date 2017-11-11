package com.silkroad.model.service;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class RestServiceTest {

    private MockWebServer webServer;

    private RestService restService;

    @Before
    public void setup() throws IOException {
        webServer = new MockWebServer();
        webServer.start();

        restService = new RestServiceImpl();
    }

    @Test
    public void testDoGetRequest() throws IOException, InterruptedException {
        final String expectedGetResponseMessage = "Yay, success for GET! Probably.";
        final String getUrlPath = "/get";

        setupResponse(expectedGetResponseMessage);
        HttpUrl httpUrl = setupUrl(getUrlPath);

        final String response = restService.doGetRequest(httpUrl.url().toString());
        testRequestResponse(expectedGetResponseMessage, response);

        RecordedRequest recordedRequest = webServer.takeRequest();
        testRequestUrl(httpUrl, recordedRequest.getRequestUrl());
        testRequestPath(getUrlPath, recordedRequest.getPath());
        testRequestMethod("GET", recordedRequest.getMethod());
    }

    private void setupResponse(String expectedResponseMessage) {
        final int expectedResponseCode = 200;

        MockResponse getResponse = buildResponseWithResponseCodeAndBodyMessage(expectedResponseCode, expectedResponseMessage);
        enqueueResponse(getResponse);
    }

    private MockResponse buildResponseWithResponseCodeAndBodyMessage(int responseCode, String bodyMessage) {
        MockResponse response = new MockResponse();
        response.setResponseCode(responseCode);
        response.setBody(bodyMessage);

        return response;
    }

    private void enqueueResponse(MockResponse response) {
        webServer.enqueue(response);
    }

    private HttpUrl setupUrl(String urlPath) {
        return webServer.url(urlPath);
    }

    private void testRequestResponse(String expectedResponseMessage, String actualResponse) {
        Assert.assertEquals(expectedResponseMessage, actualResponse);
    }

    private void testRequestUrl(HttpUrl expectedHttpUrl, HttpUrl actualRequestUrl) {
        Assert.assertEquals(expectedHttpUrl, actualRequestUrl);
    }

    private void testRequestPath(String expectedUrlPath, String actualRequestPath) {
        Assert.assertEquals(expectedUrlPath, actualRequestPath);
    }

    private void testRequestMethod(String expectedRequestMethod, String actualRequestMethod) {
        Assert.assertEquals(expectedRequestMethod, actualRequestMethod);
    }

    @Test
    public void testDoPostRequest() throws IOException, InterruptedException {
        final String expectedPostResponseMessage = "Yay, success for POST! Probably.";
        final String postUrlPath = "/post";

        setupResponse(expectedPostResponseMessage);
        HttpUrl httpUrl = setupUrl(postUrlPath);

        final String response = restService.doPostRequest(httpUrl.url().toString(), null);
        testRequestResponse(expectedPostResponseMessage, response);

        RecordedRequest recordedRequest = webServer.takeRequest();
        testRequestUrl(httpUrl, recordedRequest.getRequestUrl());
        testRequestPath(postUrlPath, recordedRequest.getPath());
        testRequestMethod("POST", recordedRequest.getMethod());
    }
}
