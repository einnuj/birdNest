package com.silkroad.authentication.preferences.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public class AuthenticationPreferences extends JsonPreferences {

    private String oauthConsumerKey;
    private String oauthNonce;
    private String oauthSignature;
    private String oauthSignatureMethod;
    private String oauthTimestamp;
    private String oauthToken;
    private String oauthVersion;

    private AuthenticationPreferences() {}

    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    public String getOauthNonce() {
        return oauthNonce;
    }

    public String getOauthSignature() {
        return oauthSignature;
    }

    public String getOauthSignatureMethod() {
        return oauthSignatureMethod;
    }

    public String getOauthTimestamp() {
        return oauthTimestamp;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public String getOauthVersion() {
        return oauthVersion;
    }

    @Override
    public String toString() {
        return "AuthenticationPreferences{" +
                "oauthConsumerKey='" + oauthConsumerKey + '\'' +
                ", oauthNonce='" + oauthNonce + '\'' +
                ", oauthSignature='" + oauthSignature + '\'' +
                ", oauthSignatureMethod='" + oauthSignatureMethod + '\'' +
                ", oauthTimestamp='" + oauthTimestamp + '\'' +
                ", oauthToken='" + oauthToken + '\'' +
                ", oauthVersion='" + oauthVersion + '\'' +
                '}';
    }

    public static class AuthenticationPreferencesBuilder extends JsonPreferencesBuilder<AuthenticationPreferences> {
        private static final String DEFAULT_OAUTH_SIGNATURE_METHOD = "HMAC-SHA1";
        private static final String DEFAULT_OAUTH_VERSION = "1.0";

        public AuthenticationPreferencesBuilder() {
            super.t = new AuthenticationPreferences();
            t.oauthSignatureMethod = DEFAULT_OAUTH_SIGNATURE_METHOD;
            t.oauthVersion = DEFAULT_OAUTH_VERSION;
        }

        public AuthenticationPreferencesBuilder oauthConsumerKey(String oauthConsumerKey) {
            t.oauthConsumerKey = oauthConsumerKey;
            return this;
        }

        public AuthenticationPreferencesBuilder oauthNonce(String oauthNonce) {
            t.oauthNonce = oauthNonce;
            return this;
        }

        public AuthenticationPreferencesBuilder oauthSignature(String oauthSignature) {
            t.oauthSignature = oauthSignature;
            return this;
        }

        public AuthenticationPreferencesBuilder oauthSignatureMethod(String oauthSignatureMethod) {
            t.oauthSignatureMethod = oauthSignatureMethod;
            return this;
        }

        public AuthenticationPreferencesBuilder oauthTimestamp(String oauthTimestamp) {
            t.oauthTimestamp = oauthTimestamp;
            return this;
        }

        public AuthenticationPreferencesBuilder oauthToken(String oauthToken) {
            t.oauthToken = oauthToken;
            return this;
        }

        public AuthenticationPreferencesBuilder oauthVersion(String oauthVersion) {
            t.oauthVersion = oauthVersion;
            return this;
        }

        @Override
        public AuthenticationPreferences build() {
            AuthenticationPreferences authenticationPreferences = super.build();

            if (Stream.of(t.oauthConsumerKey, t.oauthNonce, t.oauthSignature, t.oauthSignatureMethod, t.oauthTimestamp, t.oauthToken, t.oauthVersion)
                    .anyMatch(StringUtils::isBlank)) {
                throw new AuthenticationPreferencesBuildException(authenticationPreferences);
            }

            return authenticationPreferences;
        }

    }
}
