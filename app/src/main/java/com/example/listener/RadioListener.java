package com.example.listener;

import android.support.v4.view.ViewPager;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;




public class RadioListener implements OnCheckedChangeListener{
	private RadioGroup group;
	private int r1;
	private int r2;
	private int r3;
	private int r4;
	
	private ViewPager pager;
	
	

	public RadioListener(RadioGroup group, int r1, int r2, int r3, int r4,
			ViewPager pager) {
		super();
		this.group = group;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.pager = pager;
	}


	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId==r1) {
			 pager.setCurrentItem(0);
		}else if (checkedId==r2) {
			 pager.setCurrentItem(1);
		}else if (checkedId==r3) {
			 pager.setCurrentItem(2);
		}else if (checkedId==r4) {
			 pager.setCurrentItem(3);
		}
		
	}



}
