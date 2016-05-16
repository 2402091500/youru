package com.example.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.entity.Contact;
import com.example.entity.Msg;

import android.R.string;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.format.DateFormat;

public class MsgBiz {
	private List<Contact> contacts;
	private Context context;

	public MsgBiz(Context context) {
		this.context = context;
	}
 
	 public List<Msg> loadMsgs(){
		 Cursor c2 = null;
		 ContentResolver r=context.getContentResolver();
		 //canonical-addressesµÄUri
		 Uri uri1=Uri.parse("content://mms-sms/canonical-addresses");
		 //threadsµÄuri
		 Uri uri=Uri.parse("content://mms-sms/conversations?simple=true");
		 
		 Cursor c=r.query(uri, new String[]{"_id","date","message_count","snippet","unread_count,recipient_ids"}, null, null, null);
		List<Msg> list=new ArrayList<Msg>();
		 while(c.moveToNext()){
			 Msg msg=new Msg();
			
			  SimpleDateFormat formatter = new SimpleDateFormat("MM-dd hh:mm");
		        long now = Long.parseLong(c.getString(1));
		        Calendar calendar = Calendar.getInstance();
		        calendar.setTimeInMillis(now);
		       String s = formatter.format(calendar.getTime());
//		        System.out.println(now + " ============ " + formatter.format(calendar.getTime()));
				msg.setDate(s);
			
			
			
			msg.setMessage_count(c.getInt(2));
//			if(c.getString(3).length()>10){
//				
//				msg.setSnippet(c.getString(3).substring(0, 9)+"...");
//			}else{
				msg.setSnippet(c.getString(3));
//			}
			msg.setUnread_count(c.getInt(4));
//			System.out.println(c.getString(1)+""+c.getString(2)+""+c.getString(3)+""+c.getInt(4)+"^^^^"+c.getInt(5));
			int ids=c.getInt(5);
			 c2=r.query(uri1, new String[]{"address"}," _id=?", new String[]{""+ids}, null);
			
		    while(c2.moveToNext()){
		    	msg.setName(c2.getString(1));
//		    	System.out.println("--------"+c2.getString(0));
		    }
			
			list.add(msg);
				}
			
      
		 c2.close();
		 c.close();
		return list;
		 
	 }


	 public static int getTimesmorning(){
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.HOUR_OF_DAY, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.MILLISECOND, 0);
		 return (int) (cal.getTimeInMillis());
		 }
	
}
