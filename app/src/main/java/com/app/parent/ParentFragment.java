package com.app.parent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class ParentFragment extends Fragment{

    public static final String RES_KEY = "res_key";

    //


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(resId() , container , false);
        setUp(v);
        doSomethingWithView(v);
        return v;
    }

    protected void doSomethingWithView(View v){

    }

    public abstract int resId();

    public abstract void setUp(View v);

}
