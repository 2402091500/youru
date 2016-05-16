package com.example.listener;

import com.example.youlu.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MyPhoneListener extends PhoneStateListener {
	private Context context;

	NotificationManager manager;

	public static brodReceiver receiver;
	public MyPhoneListener(Context context) {
		this.context = context;
		manager=(NotificationManager)this.context.getSystemService(Context.NOTIFICATION_SERVICE);
	
		receiver=new brodReceiver();
		IntentFilter filter=new IntentFilter();
		filter.addAction("tonhuazon");
		filter.addAction("com.menghao.work5");
		filter.addAction("com.menghao.work6");
		this.context.registerReceiver(receiver, filter);
	}

	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		// TODO Auto-generated method stub
		if(state==TelephonyManager.CALL_STATE_IDLE){
			Toast.makeText(context, "ŒﬁªÓ∂Ø", Toast.LENGTH_LONG);
		}else if(state==TelephonyManager.CALL_STATE_OFFHOOK){
			Intent intent=new Intent();
			intent.setAction("tonhuazon");
			context.sendBroadcast(intent);
		}else if(state==TelephonyManager.CALL_STATE_RINGING){
			Toast.makeText(context, "œÏ¡Â", Toast.LENGTH_LONG);
		}
		super.onCallStateChanged(state, incomingNumber);
	}
	
	
	class brodReceiver extends BroadcastReceiver{
		@SuppressLint("NewApi")
		@Override
		public void onReceive(Context context, Intent intent) {
		  if(intent.getAction()=="tonhuazon"){
			 Builder builer=new Builder(context).setContentTitle("cep").
					 setSmallIcon(R.drawable.a).
					 setLargeIcon(BitmapFactory.decodeResource
							 (context.getResources(), R.drawable.a)).setTicker("dddddddddddd");
			 manager.notify(1, builer.build());
		  }
		  
			
		}
		
	}
}
