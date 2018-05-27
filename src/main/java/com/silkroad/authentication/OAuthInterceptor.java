package com.silkroad.authentication;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OAuthInterceptor implements Interceptor {

    private final AuthenticationPreferences authenticationPreferences;

    private OAuthInterceptor(AuthenticationPreferences authenticationPreferences) {
        this.authenticationPreferences = authenticationPreferences;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", authPrefsToOauthString()).build();
        return chain.proceed(authenticatedRequest);
    }

    private String authPrefsToOauthString() {
        return "Oauth " +
                "oauth_consumer_key: \"" + authenticationPreferences.getOauthConsumerKey() + "\"," +
                "oauth_nonce: \"" + authenticationPreferences.getOauthNonce() + "\"," +
                "oauth_signature: \"" + authenticationPreferences.getOauthSignature() + "\"," +
                "oauth_signature_method: \"" + authenticationPreferences.getOauthSignatureMethod() + "\"," +
                "oauth_timestamp: \"" + authenticationPreferences.getOauthTimestamp() + "\"," +
                "oauth_token: \"" + authenticationPreferences.getOauthToken() + "\"," +
                "oauth_version: \"" + authenticationPreferences.getOauthVersion() + "\""
                ;
    }
}
