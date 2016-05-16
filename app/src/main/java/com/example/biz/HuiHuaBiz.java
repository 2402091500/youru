package com.example.biz;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.huihua;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class HuiHuaBiz {
	private Context context;
	private String address;

	public HuiHuaBiz(Context context,String address) {
		this.context = context;
		this.address=address;
	}
	public List<huihua> loadmsg(){
		ContentResolver cr=context.getContentResolver(); 
		Uri uri=Uri.parse("content://sms/");
		 Cursor c=cr.query(uri, new String[]{"_id","address","body","status"}, "address=?", new String[]{address}, null);
	    List<huihua> list=new ArrayList<huihua>();
		 while(c.moveToNext()){
			huihua h=new huihua();
			h.setId(c.getInt(0));
			h.setAddress(c.getString(1));
			h.setBody(c.getString(2));
			h.setStatus(c.getInt(3));
			list.add(h);
		}
		 c.close();
		 return list;
		
	}
}
