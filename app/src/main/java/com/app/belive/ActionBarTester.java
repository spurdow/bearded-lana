package com.app.belive;

import android.content.Context;
import android.os.AsyncTask;
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
public class ActionBarTester extends ParentActionBarPullToRefresh implements OnRefreshListener {

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
        // Now find the PullToRefreshLayout to setup
        mPullRefresh = (PullToRefreshLayout) findViewById(R.id.ptr_layout);

        // Now setup the PullToRefreshLayout
        ActionBarPullToRefresh.from(this)
                // Mark All Children as pullable
                .allChildrenArePullable()
                        // Set a OnRefreshListener
                .listener(this)
        // Finally commit the setup to our PullToRefreshLayout
        .setup(mPullRefresh);

    }


    @Override
    public void onRefreshStarted(View view) {
        new AsyncTask<Void , Void , Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

                for(int i =0 ; i < 5; i++){
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mPullRefresh.setRefreshComplete();
            }
        }.execute(null,null,null);
    }
}
