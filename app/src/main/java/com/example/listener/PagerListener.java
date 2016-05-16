package com.example.listener;


import com.example.ui.MainActivity;
import com.example.youlu.R;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;

public class PagerListener implements OnPageChangeListener {
	private Context Context;
	private RadioButton r1;
	private RadioButton r2;
	private RadioButton r3;
	private RadioButton r4;
	private RadioGroup group;
	private TableLayout tableLayout;
	private Animation ani;
	private LayoutAnimationController ani2;
	
	


	public PagerListener(android.content.Context context, RadioButton r1,
			RadioButton r2, RadioButton r3, RadioButton r4, RadioGroup group,
			TableLayout tableLayout) {
		this.Context = context;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.group = group;
		this.tableLayout = tableLayout;
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		switch (arg0) {
		case 0:
			r1.setChecked(true);
			break;
		case 1:
			r2.setChecked(true);
			break;
		case 2:
			r3.setChecked(true);
			break;
		case 3:
			r4.setChecked(true);
			break;

		}
	}
}
