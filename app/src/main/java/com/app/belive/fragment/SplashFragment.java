package com.app.belive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.app.parent.ParentSplashFragment;

import bl.app.com.be_live.R;

public class SplashFragment extends ParentSplashFragment {



    @Override
    public int resId() {
        return R.layout.splash_fragment_layout;
    }


    public static Fragment create(int... resSub){
        SplashFragment frag = new SplashFragment();
        Bundle b = new Bundle();
        b.putIntArray(SUB_KEY , resSub);
        frag.setArguments(b);
        return frag;
    }



    @Override
    public int resIdSub() {
        return R.id.sub;
    }

    @Override
    public int[] resSub(Bundle args) {
        return args.getIntArray(SUB_KEY);
    }

    @Override
    protected void doSomethingWithView(View v) {
        super.doSomethingWithView(v );

    }
}
