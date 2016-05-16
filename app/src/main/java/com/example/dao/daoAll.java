package com.example.dao;

import com.example.youlu.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class daoAll implements OnClickListener{
	
	private Button bt;
     private TextView tv_title;
	
public daoAll(Button bt, TextView tv_title) {
		this.bt = bt;
		this.tv_title = tv_title;
	}




public void onClick(View bt) {
	switch (bt.getId()) {
	case R.id.bt1:
		tv_title.append("1");
		break;
	case R.id.bt2:
		tv_title.append("2");
		break;
	case R.id.bt3:
		tv_title.append("3");
		break;
	case R.id.bt4:
		tv_title.append("4");
		break;
	case R.id.bt5:
		tv_title.append("5");
		break;
	case R.id.bt6:
		tv_title.append("6");
		break;
	case R.id.bt7:
		tv_title.append("7");
		break;
	case R.id.bt8:
		tv_title.append("8");
		break;
	case R.id.bt9:
		tv_title.append("9");
		break;
	case R.id.bt10:
		tv_title.append("*");
		break;
	case R.id.bt11:
		tv_title.append("0");
		break;
	case R.id.bt12:
		tv_title.append("#");
		break;
	}
	
	

}
  
	   
   
}
