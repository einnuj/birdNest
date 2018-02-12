package com.silkroad.authentication.preferences.entity;

class AuthenticationPreferencesBuildException extends RuntimeException {
    private static final String DEFAULT_ERROR_MESSAGE = "Invalid Authentication Preferences while building: ";
    private static final String DEFAULT_BLANK_FIELD_MESSAGE = "some fields were null or blank: ";

    AuthenticationPreferencesBuildException(AuthenticationPreferences authenticationPreferences) {
        super(DEFAULT_ERROR_MESSAGE + DEFAULT_BLANK_FIELD_MESSAGE + authenticationPreferences);
    }
}
