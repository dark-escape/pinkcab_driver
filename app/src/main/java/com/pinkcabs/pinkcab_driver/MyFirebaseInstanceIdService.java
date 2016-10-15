package com.pinkcabs.pinkcab_driver;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Lenovo on 15-Oct-16.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    public static final String FCM_TOKEN_PREF_KEY="fcm_token";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token=FirebaseInstanceId.getInstance().getToken();
        saveToken(token);
    }

    private void saveToken(String token) {
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(FCM_TOKEN_PREF_KEY,token);
        editor.apply();
    }
}
