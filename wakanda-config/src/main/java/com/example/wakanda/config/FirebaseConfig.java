/*
package com.example.wakanda.config;

import com.google.auth.oauth2.GoogleCredentials; // Ensure the Google Auth Library for Java (google-auth-library-oauth2-http) is added to your dependencies
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {
    public static void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase-service-account.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://<your-database-name>.firebaseio.com") // Realtime Database
                //.setDatabaseUrl("https://<your-database-name>.firestore.firestoregoogleapis.com") // Firestore
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}
*/