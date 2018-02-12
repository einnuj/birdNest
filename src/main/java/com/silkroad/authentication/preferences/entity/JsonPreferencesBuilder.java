package com.silkroad.authentication.preferences.entity;

public abstract class JsonPreferencesBuilder<T extends JsonPreferences> {

    T t;

    public T build() {
        return t;
    }
}
