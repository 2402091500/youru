package com.example.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		String number=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
		Log.i("00000000000",number);
		String number2=getResultData();
		
		if(number2.equals("111")){
			setResultData(null);
		}
	}

}
