package com.tarena.youlu.fragment;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.example.biz.ContactBiz;
import com.example.biz.MsgBiz;
import com.example.entity.Contact;
import com.example.entity.Msg;
import com.example.ui.SendMsg;
import com.example.youlu.R;
import com.tarena.youlu.adapter.MsgListviewAdapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Msg_Fragment2 extends Fragment{

	private ListView msg_lv_listview;
	public List<Msg> list;
	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_contact2, null);
		MsgBiz mbBiz=new MsgBiz(getActivity());
		 list=mbBiz.loadMsgs();
		ContactBiz cb=new ContactBiz(getActivity());
		List<Contact> cons=cb.loadContacts();
	    
//	    		 list.get(i).setName (cons.get(i).getName());
	    		
//	    		System.out.println(cons.get(i).getName()+"---------------------------------"+list.toArray());
	    				
		
		MsgListviewAdapter msgaAdapter=new MsgListviewAdapter(getActivity(), list);
		msg_lv_listview=(ListView)view.findViewById(R.id.listView1);
		msg_lv_listview.setAdapter(msgaAdapter);
		msg_lv_listview.setOnItemClickListener(new OnItemClickListener() {

			private OnClickListener onListener;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
//				RelativeLayout layout = (RelativeLayout)msg_lv_listview.getChildAt(position);// 获得子item的layout
//				TextView et = (TextView) layout.findViewById(R.id.msg_name);
//				
				String test = list.get(position).getName();
				
				  Intent intent=new Intent(getActivity(),SendMsg.class);
				  intent.putExtra("position", position);
				  intent.putExtra("number", test);
				  startActivity(intent);
			}});
		
		
		return view;
	}
	
}
