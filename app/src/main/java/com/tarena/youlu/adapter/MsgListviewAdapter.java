package com.tarena.youlu.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.example.entity.Msg;
import com.example.youlu.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MsgListviewAdapter extends BaseAdapter{
	
	private Context context;
	private List<Msg> list;
	private LayoutInflater inflater;
	private ImageView msg_img;
	private TextView msg_name;
	private TextView tv_snippet;
	private TextView tvtime;
	private String      date; 
	
	

	public MsgListviewAdapter(Context context, List<Msg> list
			) {
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

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
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			
			convertView=inflater.inflate(R.layout.lv_msg_item, null);
			msg_img=(ImageView)convertView.findViewById(R.id.msg_img);
			msg_name=(TextView)convertView.findViewById(R.id.msg_name);
			tv_snippet=(TextView)convertView.findViewById(R.id.tv_snippet);
			tvtime=(TextView)convertView.findViewById(R.id.tvTime);
			convertView.setTag(holder);
			
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
			Msg msg=list.get(position);
			msg_img.setImageResource(R.drawable.qq);
			msg_name.setText(msg.getName());
			tv_snippet.setText(msg.getSnippet());
			tvtime.setText(msg.getDate());
		
		return convertView;
	}
	class ViewHolder{
		ImageView msg_img;
		TextView msg_name;
		TextView tv_snippet;
		TextView tvtime;
	}

}
