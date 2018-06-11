package com.silkroad.authentication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class AuthenticationPreferences {

    private String oauthConsumerKey;
    private String oauthNonce;
    private String oauthSignature;
    private String oauthSignatureMethod;
    private String oauthTimestamp;
    private String oauthToken;
    private String oauthVersion;

    private AuthenticationPreferences(){}

    String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    String getOauthNonce() {
        return oauthNonce;
    }

    String getOauthSignature() {
        return oauthSignature;
    }

    String getOauthSignatureMethod() {
        return oauthSignatureMethod;
    }

    String getOauthTimestamp() {
        return oauthTimestamp;
    }

    String getOauthToken() {
        return oauthToken;
    }

    String getOauthVersion() {
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

    static class AuthenticationPreferencesBuilder {

        private String authPrefsRoot;
        private String authPrefsFileName;

        AuthenticationPreferencesBuilder preferencesRoot(String authPrefsRoot) {
            this.authPrefsRoot = authPrefsRoot;
            return this;
        }

        AuthenticationPreferencesBuilder preferencesFileName(String authPrefsFileName) {
            this.authPrefsFileName = authPrefsFileName;
            return this;
        }

        AuthenticationPreferences load() {
            try (FileReader fileReader = new FileReader(authPrefsRoot + File.separator + authPrefsFileName)) {
                Gson gson = new GsonBuilder().create();
                return gson.fromJson(fileReader, AuthenticationPreferences.class);
            }
            catch (IOException e) {
                getLogger().error("Could not get Preferences from file: ", e);
                throw new FailToLoadCredentialsException(e);
            }
        }

        private Logger getLogger() {
            return LoggerFactory.getLogger(getClass());
        }
    }


}
