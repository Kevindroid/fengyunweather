package com.fengyunweather.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.fengyunweather.app.service.AutoupdateService;

/**
 * Created by Kevin on 2015/10/27.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context, AutoupdateService.class);
        context.startService(i);
    }
}
