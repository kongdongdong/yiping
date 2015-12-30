package com.dong.yiping.fragment;

import java.util.ArrayList;
import java.util.List;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

import com.dong.yiping.R;
import com.dong.yiping.adapter.OneFragmentAdapter;
import com.dong.yiping.bean.OneFragmentJobBean;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class OneFragment extends RoboFragment{

	@InjectView(R.id.lv_listview) ListView lv_listview;
	
	private OneFragmentAdapter adapter;
	private List<OneFragmentJobBean> listJob;
	private List<OneFragmentJobBean> listZhaoPin;
	private List<OneFragmentJobBean> listGroup;
	private List<OneFragmentJobBean> listStudent;
	private Context mContext;
	
	
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_one, null);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
		initData();
		init();
	}

	private void initData() {
		listJob = new ArrayList<OneFragmentJobBean>();
		for(int i=0;i<5;i++){
			OneFragmentJobBean bean = new OneFragmentJobBean("医院代表--实习生","中日友好医院","2000-3000/月","朝阳区");
			listJob.add(bean);
		}
		listZhaoPin = new ArrayList<OneFragmentJobBean>();
		for(int i=0;i<5;i++){
			OneFragmentJobBean bean = new OneFragmentJobBean("医院代表--实习生","中日友好医院","2000-3000/月","朝阳区");
			listZhaoPin.add(bean);
		}
		listGroup = new ArrayList<OneFragmentJobBean>();
		for(int i=0;i<5;i++){
			OneFragmentJobBean bean = new OneFragmentJobBean("医院代表--实习生","中日友好医院","2000-3000/月","朝阳区");
			listGroup.add(bean);
		}
		listStudent = new ArrayList<OneFragmentJobBean>();
		for(int i=0;i<5;i++){
			OneFragmentJobBean bean = new OneFragmentJobBean("医院代表--实习生","中日友好医院","2000-3000/月","朝阳区");
			listStudent.add(bean);
		}
	}

	private void init() {
		adapter = new OneFragmentAdapter(mContext,listJob,listZhaoPin,listGroup,listStudent);
		lv_listview.setAdapter(adapter);
	}
	
}
