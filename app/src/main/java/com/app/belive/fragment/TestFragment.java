package com.app.belive.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.parent.ParentFragment;

import java.util.ArrayList;

import bl.app.com.be_live.R;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * Created by David Montecillo on 10/20/2014.
 */
public class TestFragment extends ParentFragment implements OnRefreshListener {

    protected PullToRefreshLayout mPullRefresh = null;
    private ListView mList = null;
    private ArrayList<String> list=null;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        list=new ArrayList<String>();
        int no=1;
        for(int i=0;i<5;i++)
        {
            list.add("Item No :"+no++);
        }

        ViewGroup viewGroup = (ViewGroup) view;

        // As we're using a ListFragment we create a PullToRefreshLayout manually
        mPullRefresh = new PullToRefreshLayout(viewGroup.getContext());

        // We can now setup the PullToRefreshLayout
        ActionBarPullToRefresh.from(this.getActivity())
                // We need to insert the PullToRefreshLayout into the Fragment's ViewGroup
                .insertLayoutInto(viewGroup)
                        // Here we mark just the ListView and it's Empty View as pullable
                .theseChildrenArePullable(android.R.id.list, android.R.id.empty)
                .listener(this)
                .setup(mPullRefresh);

    }

    @Override
    public void onRefreshStarted(View view) {

    }

    @Override
    public int resId() {
        return R.layout.pull_to_refresh_template;
    }

    @Override
    public void setUp(View v) {

    }
}
