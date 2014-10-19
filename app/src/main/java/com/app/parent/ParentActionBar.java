package com.app.parent;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.app.util.Settings;

import bl.app.com.be_live.R;


public abstract class ParentActionBar extends ActionBarActivity {


    protected ActionBar mActionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResId());

        mActionBar = getSupportActionBar();

        if(!hasActionBar()){

            mActionBar.hide();
        }

      /*  if(Settings.isFirstLaunched(this)){
            onStartLoad();
        }*/
        onStartLoad();

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  Protected Fields
    ////////////////////////////////////////////////////////////////////////////////////////////////
    protected void onStartLoad(){
        ProgressBar progress = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progress.setIndeterminate(true);

    }

    protected void onStopLoad(){

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  Abstract Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public abstract int getResId();

    public abstract boolean hasActionBar();


}
