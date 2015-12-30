package com.dong.yiping.fragment;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

import com.dong.yiping.R;
import com.dong.yiping.adapter.TwoFragmentAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TwoFragment extends RoboFragment{
	
	@InjectView(R.id.lv_listview) ListView lv_listview; 
	
	private TwoFragmentAdapter adapter;
	private Context mContext;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_two, null);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
		init();
		
	}

	private void init() {
		adapter = new TwoFragmentAdapter(mContext);
		lv_listview.setAdapter(adapter);
	}
}
