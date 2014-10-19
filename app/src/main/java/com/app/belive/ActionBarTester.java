package com.app.belive;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.parent.ParentActionBarPullToRefresh;

import java.util.ArrayList;

import bl.app.com.be_live.R;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * Created by David Montecillo on 10/20/2014.
 */
public class ActionBarTester extends ParentActionBarPullToRefresh {

    private ListView mList = null;
    private ArrayList<String> list=null;
    @Override
    public int getResId() {
        return R.layout.pull_to_refresh_template;
    }

    @Override
    public boolean hasActionBar() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



}
