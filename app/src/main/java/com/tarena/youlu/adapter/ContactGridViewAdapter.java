package com.tarena.youlu.adapter;

import java.util.List;

import com.example.entity.Contact;
import com.example.youlu.R;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.provider.ContactsContract.Data;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ContactGridViewAdapter extends BaseAdapter{
	private Context context;
	private List<Contact> cs;
	private LayoutInflater inflater;
	
	public ContactGridViewAdapter(Context context, List<Contact> cs) {
		this.context=context;
		this.cs=cs;
		cs.add(0, new Contact(0, "添加联系人",
				0, null, null, null));
		inflater=LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		System.out.println(cs.size());
		return cs.size();
		
	}

	@Override
	public Object getItem(int position) {
		return cs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return cs.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.gridview_item, null);
			holder.photo=(ImageView)convertView.findViewById(R.id.photo);
			holder.tvName=(TextView)convertView.findViewById(R.id.tvName);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		Contact contact=cs.get(position);
		holder.tvName.setText(contact.getName());
		if(position==0){
			holder.photo.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.img02_07));
			return convertView;
		}
		Bitmap bitmap=getPhoto(contact.getId());
		if(bitmap!=null){
			holder.photo.setImageBitmap(bitmap);
		}
		return convertView;
	}
	
	private Bitmap getPhoto(int id){
		ContentResolver r=context.getContentResolver();
		Cursor c=r.query(Data.CONTENT_URI, new String[]{Data.MIMETYPE ,Data.DATA15}, Data.RAW_CONTACT_ID+"=?", new String[]{id+""}, null);
		while(c.moveToNext()){
			if(c.getString(0).equals(Photo.CONTENT_ITEM_TYPE)){
				//发现头像数据  
				byte[] bytes=c.getBlob(1);
				Bitmap b=BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
				return b;
			}
		}
		return null;
	}
	
	class ViewHolder {
		ImageView photo;
		TextView tvName;
	}
	
}



