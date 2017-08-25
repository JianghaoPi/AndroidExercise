package com.mobile.test.testmonitor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobile.test.testmonitor.R;

/**
 * Created by Administrator on 2017/8/16.
 */

public class FragmentHome extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_main, container,false);
        TextView config = (TextView) view.findViewById(R.id.configure);
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.mobile.test.testmonitor.ACTION_START");
                intent.addCategory("com.mobile.test.testmonitor.MY_CATEGORY");
                startActivity(intent);
            }
        });
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
