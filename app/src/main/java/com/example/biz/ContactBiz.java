package com.example.biz;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;

import com.example.entity.Contact;


public class ContactBiz {
	private Context context;
	public ContactBiz(Context context) {
		this.context=context;
	}
	
	/** 查询所有的联系人 */
	public List<Contact> loadContacts(){
		ContentResolver r=context.getContentResolver();
		//查询联系人数据  并且封装对象 
		//  content://com.android.contacts/contacts
		Cursor c=r.query(Contacts.CONTENT_URI, new String[]{Contacts._ID,  Contacts.PHOTO_ID}, null, null, null);
		ArrayList<Contact> cs=new ArrayList<Contact>();
		while(c.moveToNext()){
			Contact contact=new Contact();
			//获取当前联系人的id 和 photoid
			int _id=c.getInt(0);
			int photoId=c.getInt(1);
			contact.setId(_id);
			contact.setPhotoId(photoId);
			// content://com.android.contacts/data
			Cursor c2=r.query(Data.CONTENT_URI, new String[]{Data.MIMETYPE, Data.DATA1}, Data.RAW_CONTACT_ID+"=?", new String[]{_id+""}, null);
			while(c2.moveToNext()){
				//Log.i("info", c2.getString(0)+","+c2.getString(1));
				String mimetype=c2.getString(0);
				//"vnd.android.cursor.item/phone_v2"
				if(mimetype.equals(Phone.CONTENT_ITEM_TYPE)){
					contact.setPhone(c2.getString(1));
				}else if(mimetype.equals(Email.CONTENT_ITEM_TYPE)){
					contact.setEmail(c2.getString(1));
				}else if(mimetype.equals("vnd.android.cursor.item/postal-address_v2")){

				}else if(mimetype.equals("vnd.android.cursor.item/name")){
					contact.setName(c2.getString(1));
				}
			
			}
			cs.add(contact);
			c2.close();
		}
		c.close();
		System.out.println(cs);
		return cs;
	}


}
