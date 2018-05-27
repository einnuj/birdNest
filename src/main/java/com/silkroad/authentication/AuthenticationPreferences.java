package com.silkroad.authentication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class AuthenticationPreferences {

    private static final String AUTH_PREFS_ROOT = "src" + File.separator + "main" + File.separator + "resources";
    private static final String AUTH_PREFS_FILE_NAME = "auth.pref.json";

    private String oauthConsumerKey;
    private String oauthNonce;
    private String oauthSignature;
    private String oauthSignatureMethod;
    private String oauthTimestamp;
    private String oauthToken;
    private String oauthVersion;

    AuthenticationPreferences() {
        load();
    }

    private static AuthenticationPreferences load() {
        try (FileReader fileReader = new FileReader(AUTH_PREFS_ROOT + File.separator + AUTH_PREFS_FILE_NAME)) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(fileReader, AuthenticationPreferences.class);
        }
        catch (IOException e) {
            getLogger().error("Could not get Preferences from file: ", e);
            throw new FailToLoadCredentialsException(e);
        }
    }

    private static Logger getLogger() {
        return LoggerFactory.getLogger(AuthenticationPreferences.class);
    }

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

}
