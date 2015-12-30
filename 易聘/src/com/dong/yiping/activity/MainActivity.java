package com.dong.yiping.activity;

import java.util.ArrayList;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dong.yiping.R;
import com.dong.yiping.adapter.MainFragmentPagerAdapter;
import com.dong.yiping.fragment.ForeFragment;
import com.dong.yiping.fragment.OneFragment;
import com.dong.yiping.fragment.ThreeFragment;
import com.dong.yiping.fragment.TwoFragment;
import com.dong.yiping.ui.ControlScrollViewPager;

public class MainActivity extends RoboFragmentActivity {

	@InjectView(R.id.main_viewpager) ControlScrollViewPager main_viewpager;
	@InjectView(R.id.main_tabs_layout) LinearLayout main_tabs_layout;
	private boolean exiting = false;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		setListener();
	}
	private void initView(){
		main_viewpager = (ControlScrollViewPager)findViewById(R.id.main_viewpager);
        ArrayList fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());
        fragmentList.add(new ForeFragment());
        MainFragmentPagerAdapter pagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        main_viewpager.setOffscreenPageLimit(3);
        main_viewpager.setAdapter(pagerAdapter);
        main_viewpager.setScrollable(false);//设置ViewPage不可滚动
        changeTabs(0);
    }
	private void changeTabs(int index){
        for (int i = 0;i<main_tabs_layout.getChildCount();i++){
            TextView textView = (TextView)main_tabs_layout.getChildAt(i);
            if (i==index){
                textView.setSelected(true);
            }else {
                textView.setSelected(false);
            }
        }
    }
	private void setListener(){
		main_viewpager.setOnPageChangeListener(new MainOnPageChangeListener());
        for (int i = 0;i<main_tabs_layout.getChildCount();i++){
            final int finalI = i;
            main_tabs_layout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	main_viewpager.setCurrentItem(finalI,false);
                }
            });
        }
    }
	private class MainOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int i, float v, int i2) {

        }

        @Override
        public void onPageSelected(int i) {
            changeTabs(i);
//            if (i == 1){
//                mViewPager.setScrollable(false);
//            }else {
//                mViewPager.setScrollable(true);
//            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
	 public void onBackPressed() {
	        if (exiting) {
	            finish();
	        } else {
	            Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
	            exiting = true;
	            new Handler().postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                    exiting = false;
	                }
	            }, 2000);
	        }
	    }
	
}
