package com.yu.moveevnet.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/17.
 */
public class BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(MainActivity.Action)){
            String message = intent.getStringExtra(MainActivity.MSG);
            Log.e("skyline",message);
        }
    }
}
