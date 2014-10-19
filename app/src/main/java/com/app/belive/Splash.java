package com.app.belive;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.app.adapters.FragmentAdapter;
import com.app.belive.fragment.SplashFragment;
import com.app.parent.ParentActionBar;
import com.viewpagerindicator.CirclePageIndicator;

import bl.app.com.be_live.R;


public class Splash extends ParentActionBar {

    private static final String TAG = Splash.class.getSimpleName() ;
    private ViewPager mPager;
    private FragmentAdapter mAdapter;
    private CirclePageIndicator mindicator;

    private Handler mHandler = new Handler();

    private int currentIndex = 0;

    private PagerAnimation mAnimationNation = null;

    public static final long TIME_TO_SCROLL = 4000L;
    @Override
    public int getResId() {
        return R.layout.screen_slide_layout;
    }

    @Override
    public boolean hasActionBar() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPager = (ViewPager) findViewById(R.id.pager);

        mAdapter = new FragmentAdapter(getSupportFragmentManager());

        mAdapter.add(SplashFragment.create(R.string.app_sub1 , R.string.app_sub2 , R.string.app_sub3));
        mAdapter.add(SplashFragment.create(R.string.splash_1));
        mAdapter.add(SplashFragment.create(R.string.splash_2));
        mAdapter.add(SplashFragment.create(R.string.splash_3));
        mAdapter.add(SplashFragment.create(R.string.splash_4));

        mindicator = (CirclePageIndicator) findViewById(R.id.circles);
        mPager.setAdapter(mAdapter);

        mindicator.setViewPager(mPager , currentIndex);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentIndex = position;
                mindicator.setCurrentItem(position);
                Log.i(TAG , "currentIndex " + position);
            }
        });
        mAnimationNation = new PagerAnimation();
        mHandler.post(mAnimationNation);
    }

    private class PagerAnimation implements Runnable{

        @Override
        public void run() {
            mPager.setCurrentItem(currentIndex , true);
            currentIndex = (currentIndex + 1 ) % mAdapter.getCount() ;


            mHandler.postDelayed(this, TIME_TO_SCROLL);

        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mAnimationNation != null){
            mHandler.removeCallbacks(mAnimationNation);
        }
    }
}
