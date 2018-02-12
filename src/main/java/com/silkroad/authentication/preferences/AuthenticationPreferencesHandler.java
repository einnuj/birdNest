package com.silkroad.authentication.preferences;

import com.silkroad.authentication.preferences.entity.AuthenticationPreferences;

import java.io.File;

public class AuthenticationPreferencesHandler extends AbstractJsonPreferencesHandler<AuthenticationPreferences> {

    private static final String DEFAULT_PREFERENCES_ROOT = "src" + File.separator + "main" + File.separator + "resources";
    private static final String DEFAULT_PREFERENCES_FILE_NAME = "auth.pref.json";

    public AuthenticationPreferencesHandler() {
        super.preferencesRoot = DEFAULT_PREFERENCES_ROOT;
        super.preferencesFileName = DEFAULT_PREFERENCES_FILE_NAME;
    }

    public AuthenticationPreferencesHandler(String preferencesRoot, String preferencesFileName) {
        super.preferencesRoot = preferencesRoot;
        super.preferencesFileName = preferencesFileName;
    }

}
