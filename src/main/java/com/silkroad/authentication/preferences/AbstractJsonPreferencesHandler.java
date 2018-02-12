package com.silkroad.authentication.preferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.silkroad.authentication.preferences.entity.JsonPreferences;
import com.silkroad.authentication.preferences.entity.JsonPreferencesBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public abstract class AbstractJsonPreferencesHandler<T extends JsonPreferences> implements JsonPreferencesHandlerInterface<T> {

    String preferencesRoot;
    String preferencesFileName;

    private Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    private String getPreferencesFullFilePath() {
        return preferencesRoot + File.separator + preferencesFileName;
    }

    @Override
    public T getPreferences(Class<T> clazz, JsonPreferencesBuilder<T> jsonPreferencesBuilder) {
        try (FileReader fileReader = new FileReader(getPreferencesFullFilePath())) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(fileReader, clazz);
        }
        catch (FileNotFoundException e) {
            getLogger().error("File was not found while getting preferences: ", e);
        }
        catch (IOException e) {
            getLogger().error("Could not get Preferences from file: ", e);
        }

        getLogger().warn("Failed to get Preferences; returning default, unset Class: {} via Builder: {}", clazz.getName(), jsonPreferencesBuilder.getClass().getName());
        return jsonPreferencesBuilder.build();
    }

    @Override
    public void setPreferences(T jsonPreferences) {
        try (FileWriter fileWriter = new FileWriter(getPreferencesFullFilePath())) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(jsonPreferences, fileWriter);
        } catch (IOException e) {
            getLogger().error("Could not write Preferences to file: ", e);
        }
    }
}
