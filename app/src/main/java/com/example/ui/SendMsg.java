package com.example.ui;

import java.util.List;
import java.util.zip.Inflater;

import com.example.biz.HuiHuaBiz;
import com.example.entity.huihua;
import com.example.youlu.R;
import com.example.youlu.R.layout;
import com.example.youlu.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SendMsg extends Activity {

	private LayoutInflater inflater;
	List<huihua> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_msg);
		
		String n = getIntent().getStringExtra("number");
		ListView listView=(ListView)findViewById(R.id.listView1);
		HuiHuaBiz  H=new HuiHuaBiz(this, n);
		 list=H.loadmsg();
		SendmsglistAdapter  adapter=new  SendmsglistAdapter();
		listView.setAdapter(adapter);
		
	}
	
     
	
	class SendmsglistAdapter extends BaseAdapter{

		private huihua huihua;
		private TextView tv1;

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return list.get(position).hashCode();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			huihua=list.get(position);
			ViewHolder  viewHolder=null;
			if(convertView==null){
				viewHolder=new ViewHolder();
				if(huihua.getStatus()==32||huihua.getStatus()==0){
					
					convertView=inflater.inflate(R.layout.me_msg_item,null);
					viewHolder.tv1=(TextView)findViewById(R.id.textView1);
					convertView.setTag(viewHolder);
				}
				if(huihua.getStatus()==-1){
					convertView=inflater.inflate(R.layout.you_msg_item,null);
					viewHolder.tv1=(TextView)findViewById(R.id.textView1);
					convertView.setTag(viewHolder);
				}
			}else{
				viewHolder=(ViewHolder) convertView.getTag();
			}
			
			viewHolder.tv1.setText(huihua.getBody());
			
			return convertView;
		}
		class ViewHolder {
			TextView tv1;
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_msg, menu);
		return true;
	}

}
