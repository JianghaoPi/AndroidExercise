package com.mobile.test.simcardmanager;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * Created by Administrator on 2017/8/19.
 */

public class SIMUtil {


    //private static final String TAG = makeLogTag(SIMUtil.class);
    public static SubscriptionManager subscriptionManager = null;
    private Context context;

    public SIMUtil(Context context) {
        this.context = context;
        if (subscriptionManager == null) {
            subscriptionManager = SubscriptionManager.from(this.context);
        }
    }

    public int getSimSupportedCount() {
        return subscriptionManager.getActiveSubscriptionInfoCountMax();
    }

    public List<SubscriptionInfo> getActiveSubscriptionInfo() {
        return subscriptionManager.getActiveSubscriptionInfoList();
    }
}
