package com.tarena.youlu.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter{

	private List<Fragment> fs;
	
	public MyPagerAdapter(FragmentManager fm, List<Fragment> fs) {
		super(fm);
	this.fs=fs;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fs.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fs.size();
	}
	

}
