package com.example.profiles;

import java.util.Objects;

/**
 * Service now builds immutable UserProfiles
 */
public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createWithDisplayName(String id, String email, String displayName) {
        if (displayName != null && displayName.length() > 100) {
            displayName = displayName.substring(0, 100); // keep validation consistent
        }
        return new UserProfile.Builder(id, email)
                .displayName(displayName)
                .build();
    }
}
