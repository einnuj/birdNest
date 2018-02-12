package com.silkroad.authentication.preferences;

import com.silkroad.authentication.preferences.entity.JsonPreferences;
import com.silkroad.authentication.preferences.entity.JsonPreferencesBuilder;

public interface JsonPreferencesHandlerInterface<T extends JsonPreferences> {

    T getPreferences(Class<T> clazz, JsonPreferencesBuilder<T> jsonPreferencesBuilder);

    void setPreferences(T jsonPreferences);
}
