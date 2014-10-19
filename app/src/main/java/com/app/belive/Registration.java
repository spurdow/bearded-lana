package com.app.belive;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.parent.ParentActionBar;
import com.facebook.widget.LoginButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import bl.app.com.be_live.R;


public class Registration extends ParentActionBar {

    private static final String TAG = Registration.class.getSimpleName();
    private TextView mSub = null;
    private Button facebook_login;
    @Override
    public int getResId() {
        return R.layout.register_layout;
    }

    @Override
    public boolean hasActionBar() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSub = (TextView) findViewById(R.id.sub_app_name);
        mSub.setText(R.string.registration);

        facebook_login = (Button) findViewById(R.id.facebook_button);
        facebook_login.setOnClickListener(new FacebookLogin());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
    }


    class FacebookLogin implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            ParseFacebookUtils.logIn(Registration.this , new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if(parseUser != null)
                    Log.w(TAG , parseUser.toString());
                }
            });
        }
    }
}
