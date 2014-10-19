package com.app.util;

import android.content.Context;
import android.content.SharedPreferences;


public class Settings {

    public final static String TAG  = "com.app.belive";

    public final static String FIRST_LAUNCH =  TAG + ".first_launch";

    public static boolean isFirstLaunched(Context context){
        SharedPreferences shared = context.getSharedPreferences(TAG , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        boolean result = shared.getBoolean(FIRST_LAUNCH , false);

        editor.putBoolean(FIRST_LAUNCH , true);

        return result;
    }
}
