package com.mobile.test.simcardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private InternetUtil util;

    private SIMUtil simUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SubscriptionManager.from(this).getActiveSubscriptionInfoList();
        simUtil = new SIMUtil(this);
        Log.d("SIM", String.valueOf(simUtil.getSimSupportedCount()));

        for (SubscriptionInfo s : simUtil.getActiveSubscriptionInfo()) {
            Log.d("SIMinfo", s.getNumber());
        }
//        String state = util.getNetworkState(this);
//        Log.d("State", state);
    }


}
