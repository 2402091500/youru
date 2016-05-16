package com.example.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.listener.MyPhoneListener;
import com.example.youlu.R;
import com.tarena.youlu.adapter.MyPagerAdapter;
import com.tarena.youlu.fragment.Bohao_Fragment3;
import com.tarena.youlu.fragment.CallLogsFragment;
import com.tarena.youlu.fragment.ContactFragment1;
import com.tarena.youlu.fragment.Msg_Fragment2;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {
    @Bind(R.id.viewPager1)
    ViewPager viewPager1;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.tv3)
    TextView tv3;
    @Bind(R.id.tv4)
    TextView tv4;
    @Bind(R.id.caidan)
    LinearLayout caidan;
    private GridView gridview;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);


        List<Fragment> fs = new ArrayList<Fragment>();
        fs.add(new CallLogsFragment());
        fs.add(new ContactFragment1());
        fs.add(new Msg_Fragment2());
        fs.add(new Bohao_Fragment3());
        PagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),
                fs);
        viewPager1.setAdapter(adapter);
        viewPager1.setCurrentItem(0);
        ChangeCaidan(0);


    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        this.unregisterReceiver(MyPhoneListener.receiver);
    }


    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4})
    public void onClick(View view) {
        Drawable drawable;
        switch (view.getId()) {
            case R.id.tv1:
                ChangeCaidan(0);
                viewPager1.setCurrentItem(0);
//                /img02_14
//                    img01g_12
                break;
            case R.id.tv2:
                ChangeCaidan(1);
                viewPager1.setCurrentItem(1);
//                /img02_11">
//                e/img01g_15
                break;
            case R.id.tv3:
                ChangeCaidan(2);
                viewPager1.setCurrentItem(2);
//                img05_11">
//                    /img01g_18
                break;
            case R.id.tv4:
                ChangeCaidan(3);
                viewPager1.setCurrentItem(3);
//                img07_19">
//                    /img01g_21
                break;
        }
    }

    private void ChangeCaidan(int d) {
//        /img02_14
//                img01g_12
//
//        /img02_11">
//        e/img01g_15
//
//        img05_11">
//                /img01g_18
//
//        img07_19">
//                /img01g_21
        Drawable drawable=null;

        viewPager1.setCurrentItem(d);
        switch (d) {
            case 0:
                drawable = getResources().getDrawable(R.drawable.img01g_12);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv1.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_15);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv2.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_18);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv3.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_21);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv4.setCompoundDrawables(null, drawable, null, null);
                break;
            case 1:
                drawable = getResources().getDrawable(R.drawable.img02_14);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv1.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img02_11);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv2.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_18);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv3.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_21);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv4.setCompoundDrawables(null, drawable, null, null);
                break;
            case 2:
                drawable = getResources().getDrawable(R.drawable.img02_14);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv1.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_15);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv2.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img05_11);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv3.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_21);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv4.setCompoundDrawables(null, drawable, null, null);
                break;
            case 3:
                drawable = getResources().getDrawable(R.drawable.img02_14);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv1.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_15);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv2.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img01g_18);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv3.setCompoundDrawables(null, drawable, null, null);
                drawable = getResources().getDrawable(R.drawable.img07_19);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv4.setCompoundDrawables(null, drawable, null, null);
                break;


        }
    }
}
