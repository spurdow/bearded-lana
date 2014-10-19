package com.app.belive;

import android.app.Application;
import android.content.res.Resources;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

import bl.app.com.be_live.R;


public class BLApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Resources res = getResources();
        Parse.initialize(this , res.getString(R.string.parse_app_id) , res.getString(R.string.parse_client_id));
        ParseFacebookUtils.initialize(res.getString(R.string.facebook_app_id_test));
    }
}
