package com.hc.library.bluesocket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.hc.library.bluesocket.message.IMessage;

/**
 *
 * 用来监听消息到达。
 * Created by jack.yan on 2017/10/30.
 */
public abstract class BlueMessageReceiver extends BroadcastReceiver {


    public void register(Context context){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BlueService.ACTION_MESSAGE_REVEIVER);
        context.registerReceiver(this,intentFilter);
    }

    public void unregister(Context context){
        context.unregisterReceiver(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (BlueService.ACTION_MESSAGE_REVEIVER.equals(intent.getAction())){
            IMessage message = intent.getParcelableExtra("message");
            if (message != null){
                onMessageReceiver(message);
            }
        }
    }


    public abstract void onMessageReceiver(IMessage message);


}
