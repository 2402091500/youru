package com.zbq.deleteslide;

import java.util.LinkedList;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

import com.example.youlu.R;
import com.zbq.deleteslide.ActionSheet.OnActionSheetSelected;
import com.zbq.widget.DelSlideListView;
import com.zbq.widget.ListViewonSingleTapUpListenner;
import com.zbq.widget.OnDeleteListioner;

public class MainActivity extends Activity implements OnDeleteListioner, ListViewonSingleTapUpListenner,OnActionSheetSelected, OnCancelListener{
	
	LinkedList<String> mlist = new LinkedList<String>();
	MyAdapter mMyAdapter;
	DelSlideListView mDelSlideListView;
	int delID = 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		this.mDelSlideListView = (DelSlideListView) this.findViewById(R.id.listv);
		mMyAdapter = new MyAdapter(this, mlist);
		mDelSlideListView.setAdapter(mMyAdapter);
		mDelSlideListView.setDeleteListioner(this);
		mDelSlideListView.setSingleTapUpListenner(this);
		mMyAdapter.setOnDeleteListioner(this);
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		for(int i=0;i<50;i++){
			mlist.add("»¬¶¯É¾³ý->"+i);
		}
		mMyAdapter.notifyDataSetChanged();
	}


	@Override
	public void onSingleTapUp() {
		
	}


	@Override
	public boolean isCandelete(int position) {
		return true;
	}


	@Override
	public void onDelete(int ID) {
		delID = ID;
		ActionSheet.showSheet(this, this, this);
	}


	@Override
	public void onBack() {
		
	}

	@Override
	public void onCancel(DialogInterface arg0) {
		
	}

	@Override
	public void onClick(int whichButton) {
		switch (whichButton) {
		case 0:
			mlist.remove(delID);
			mDelSlideListView.deleteItem();
			mMyAdapter.notifyDataSetChanged();
			
			break;
		case 1:
			
			break;
		default:
			break;
	}
	}


}
