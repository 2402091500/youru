package com.example.biz;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.CallLogs;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import android.util.Log;

public class CallLogsBiz {
	private Context context;

	public CallLogsBiz(Context context) {
		this.context = context;
	}
////dsfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	//编写业务方法  获取通话记录
	public List<CallLogs> loadCallLogs(){
		//访问ContentProvider  获取通话记录
		//Calls.CONTENT_URI
		ContentResolver r=context.getContentResolver();
		Cursor c=r.query(Calls.CONTENT_URI, 
				new String[]{
				Calls.DATE, 
				Calls.DURATION, 
				Calls.NUMBER, 
				Calls.TYPE, 
				"name", 
				Calls._ID,
				"photo_id"}, null , null, Calls.DEFAULT_SORT_ORDER);
		ArrayList<CallLogs> logs=new ArrayList<CallLogs>();
		while(c.moveToNext()){
			CallLogs l=new CallLogs(c.getInt(5), c.getInt(6), c.getString(4), c.getString(2), c.getLong(0), c.getInt(3),c.getLong(1));
			logs.add(l);
		}
		c.close();
		return logs;
	}

}
