package com.example.base;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.youlu.R;

/**
 *
 */
public class BaseActivity extends FragmentActivity  implements View.OnClickListener {

    private TextView left;
    private TextView midlle;
    private TextView right;
    private FrameLayout context_framlayout;
    private RelativeLayout title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * @param parentid
     */
    protected  void setActiviyContextView(int parentid){
        initView(parentid);
    }

    /**
     *
     * @param parentid
     */
    private void initView(int parentid) {
        setContentView(R.layout.activity_base);
        left=(TextView)findViewById(R.id.tv_left);
        midlle=(TextView)findViewById(R.id.tv_midlle);
        right=(TextView)findViewById(R.id.tv_right);

        title=(RelativeLayout)findViewById(R.id.title);
        context_framlayout=(FrameLayout)findViewById(R.id.content_layout);
        LayoutInflater.from(this).inflate(parentid,context_framlayout);
    }


    /**
     * @param lefttxt 左边文字
     * @param midlletxt 中间文字
     * @param righttxt 右边文字
     * @param rightcolor 右边文字color
     * @param bgcolor 背景color
     * @param isShowleft 是否显示左边图标
     * @param rightDrawble 右边图标
     */
    public void setTitle (String lefttxt,String midlletxt,String righttxt,int rightcolor,int bgcolor,Boolean isShowleft,int rightDrawble){
        if(lefttxt!=null){
            left.setText(lefttxt);
        }else {
            left.setText("");
        }
        if(righttxt!=null){
            right.setText(righttxt);
        }else{
            right.setText("");
        }
        if(midlletxt!=null){
            midlle.setText(midlletxt);
        }else{
            midlle.setText("");
        }
        if(bgcolor>0){
           title.setBackgroundColor(getResources().getColor(bgcolor));
        } if(rightcolor>0){
           right.setTextColor(getResources().getColor(bgcolor));
        }
        if(!isShowleft){
            left.setVisibility(View.GONE);
        }
        if(rightDrawble>0){
           Drawable drawable=getResources().getDrawable(rightDrawble);
            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
            right.setCompoundDrawables(null,null,drawable,null);
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_left:
                this.finish();
            case R.id.tv_right:
                onRightOnclic();
        }
    }

    /**
     * 标题右边被点击
     */
    private void onRightOnclic() {
    }
}
