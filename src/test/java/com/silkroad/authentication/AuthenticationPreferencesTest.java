package com.silkroad.authentication;

import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

class AuthenticationPreferencesTest {

    @Nested
    class Load {

        @Test
        void Load_WhenRootAndFileName_ReturnsConfigurationData() {
            String testAuthRoot = "src" + File.separator + "test" + File.separator + "resources";
            String testAuthFileName = "auth.prefs.json";

            AuthenticationPreferences authenticationPreferences = new AuthenticationPreferences.AuthenticationPreferencesBuilder()
                    .preferencesRoot(testAuthRoot)
                    .preferencesFileName(testAuthFileName)
                    .load();

            Assert.assertNotNull(authenticationPreferences.getOauthConsumerKey());
            Assert.assertNotNull(authenticationPreferences.getOauthNonce());
            Assert.assertNotNull(authenticationPreferences.getOauthSignature());
            Assert.assertNotNull(authenticationPreferences.getOauthSignatureMethod());
            Assert.assertNotNull(authenticationPreferences.getOauthTimestamp());
            Assert.assertNotNull(authenticationPreferences.getOauthToken());
            Assert.assertNotNull(authenticationPreferences.getOauthVersion());
        }
    }
}
