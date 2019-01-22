package com.example.chai1.androidapp;

import android.util.Log;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class SessionLogin {


        // LogCat tag
        private static String TAG = SessionLogin.class.getSimpleName();

        Context context;

        // Shared Preferences
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        // Shared pref mode
        int PRIVATE_MODE = 0;

        // Shared preferences file name
        private static final String PREF_NAME = "TEST";

        private static final String KEY_IS_LOGGED_IN = "IS_LOGGED_IN";


        public SessionLogin(Context context) {
            this.context = context;
            sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = sharedPreferences.edit();
        }

        public void setLogin(boolean isLoggedIn) {

            editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);

            // commit changes
            editor.commit();

            Log.d(TAG, "User login session modified!");
        }

        public boolean isLoggedIn() {
            return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
        }


}
