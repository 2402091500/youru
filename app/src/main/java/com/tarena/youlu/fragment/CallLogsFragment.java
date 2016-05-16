package com.tarena.youlu.fragment;


import java.util.List;

import com.example.biz.CallLogsBiz;
import com.example.entity.CallLogs;
import com.example.youlu.R;
import com.tarena.youlu.adapter.CallLogsListViewAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class CallLogsFragment extends Fragment{
	
	private ListView lvCallLogs;
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_calllog, null);
		//��ȡ����
		List<CallLogs> logs=new CallLogsBiz(getActivity()).loadCallLogs();
		
//		System.out.println("--------"+logs);
		CallLogsListViewAdapter adapter=
				new CallLogsListViewAdapter(getActivity(), logs);
		lvCallLogs=(ListView)view.findViewById(R.id.lvCallLogs);
		lvCallLogs.setAdapter(adapter);
		return view;
	}
}
