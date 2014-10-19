package com.app.parent;


import android.os.Bundle;

import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;

public class ParentActionBarPullToRefresh extends ParentActionBar {

    protected ActionBarPullToRefresh mPullRefresh = null;

    @Override
    public int getResId() {
        return 0;
    }

    @Override
    public boolean hasActionBar() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPullRefresh = new ActionBarPullToRefresh();
    }
}
