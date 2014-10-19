package com.app.parent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public abstract class ParentSplashFragment extends ParentFragment {

    public static final String SUB_KEY = "sub_key";

    protected TextView mSub = null;

    public abstract int resIdSub();

    public abstract int[] resSub(Bundle args);


    @Override
    public void setUp(View v) {
        mSub = (TextView) v.findViewById(resIdSub());

        Bundle args = getArguments();
        String sub = "";
        int[] res = resSub(args);
        for(int i = 0 ; i < res.length ; i++){
            sub+= getResources().getString(res[i]) +"\n";
        }
        mSub.setText(sub);
    }

}
