package com.tarena.youlu.fragment;


import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.provider.ContactsContract.Data;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biz.ContactBiz;
import com.example.entity.Contact;
import com.example.youlu.R;
import com.tarena.youlu.adapter.ContactGridViewAdapter;

public class ContactFragment1 extends BaseFragment{

	private GridView gv;
	private List<Contact> cs;
	private AlertDialog dialog;
	private ContactGridViewAdapter adapter;
//	@Override
//	public View onCreateView(LayoutInflater inflater,
//			ViewGroup container,
//			Bundle savedInstanceState) {
//
//
//		View view=inflater.inflate(R.layout.fragment_contact1, null);
//
//		gv=(GridView)view.findViewById(R.id.gv_contacts);
//
//		//��ȡList<Contact>
//		cs=new ContactBiz(getActivity()).loadContacts();
//
//
//		ContactGridViewAdapter adapter=
//				new ContactGridViewAdapter(getActivity(), cs);
//
//		gv.setAdapter(adapter);
//
//		setListener();
//		return view;
//	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_contact1;
	}

	@Override
	protected void initView() {
		gv= findView(R.id.gv_contacts);
	}

	@Override
	protected void initData() {
		cs=new ContactBiz(getActivity()).loadContacts();


		 adapter=
				new ContactGridViewAdapter(getActivity(), cs);

		gv.setAdapter(adapter);

		setListener();
	}

	@Override
	protected void showDate() {
		adapter=
				new ContactGridViewAdapter(getActivity(), cs);

		gv.setAdapter(adapter);
	}

	private Bitmap getPhoto(int id){
		ContentResolver r=getActivity().getContentResolver();
		System.out.println("---");
		Cursor c=r.query(Data.CONTENT_URI, new String[]{Data.MIMETYPE ,Data.DATA15}, Data.RAW_CONTACT_ID+"=?", new String[]{id+""}, null);
		while(c.moveToNext()){
			if(c.getString(0).equals(Photo.CONTENT_ITEM_TYPE)){
				//����ͷ������  
				byte[] bytes=c.getBlob(1);
				Bitmap b=BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
				return b;
			}
		}
		return null;
	}
	private void setListener(){
		
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			private ImageView ximg;

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				 dialog=new Builder(getActivity()).create();
				dialog.show();
				Window window=dialog.getWindow();
				LayoutInflater inflater=LayoutInflater.from(getActivity());
				View v=inflater.inflate(R.layout.contact_detail, null);

				ximg=(ImageView)v.findViewById(R.id.imageView2);
				ximg.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
				
				
				ContactBiz cBiz=new ContactBiz(getActivity());
				List<Contact> contacts =cBiz.loadContacts();
				
			  Contact contact= contacts.get(position-1);
			   
			ImageView photo=(ImageView)v.findViewById(R.id.photo);
			TextView textView1=(TextView) v.findViewById(R.id.textView1);
			TextView textView2=(TextView) v.findViewById(R.id.textView2);
			TextView textView3=(TextView) v.findViewById(R.id.textView3);
			TextView textView4=(TextView) v.findViewById(R.id.textView4);
			Bitmap bitmap=getPhoto(contact.getId());
			
//			if(bitmap==null){
				photo.setImageResource(R.drawable.moren);
//			}else {
//				photo.setImageBitmap(bitmap);
				
//			}
			System.out.println("========================");
			textView1.setText(contact.getName());
		    textView2.setText(contact.getEmail());
		    
		    textView3.setText(String.valueOf(contact.getPhoto()));
		    textView4.setText(contact.getPhone());
				window.setContentView(v);
				
				//��alertDialog��������ü���
				//v.findViewById(R.id.imageView1).set.....
				
			}
		});
	}
	
}
