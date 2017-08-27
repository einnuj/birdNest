package com.silkroad.model.service;

import java.io.IOException;
import java.util.Map;

public interface RestService {

    /**
     * Returns a String response from executing a GET request on target argument String url.
     *
     * @param url a string representing the URL from which to execute a GET request
     * @throws IOException
     * @return a String response from executing a GET request on the target argument String url.
     */
    String doGetRequest(String url) throws IOException;

    /**
     * Returns a String response from executing a POST request on target argument String url with a Map of parameters.
     *
     * @param url a string representing the URL from which to execute a GET request
     * @param parameters a map with String key, String value representing the parameters of a POST request
     * @throws IOException
     * @return a String response from executing a POST request on the target argument String url with the given parameters
     */
    String doPostRequest(String url, Map<String, String> parameters) throws IOException;
}
