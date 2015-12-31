package com.dong.yiping.activity;

import com.dong.yiping.R;
import com.dong.yiping.utils.LoadingUtil;
import com.google.inject.Inject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectView;

public class LoginActivity extends BaseActivity implements OnClickListener{

	@InjectView(R.id.tv_login_regist) TextView tv_login_regist;
	@InjectView(R.id.tv_login_login) TextView tv_login_login;
	@Inject Context mContext;
	@InjectExtra(value="url",optional=true) String url; 
	
	private Intent mIntent;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		
	}

	private void initView() {
		tv_login_regist.setOnClickListener(this);
		tv_login_login.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.tv_login_regist:
			LoadingUtil util = new LoadingUtil(mContext);
			util.showDialog();
			/*mIntent = new Intent(mContext,RegistActivity.class);
			startActivity(mIntent);*/
			break;

		case R.id.tv_login_login:
			mIntent = new Intent(mContext,MainActivity.class);
			startActivity(mIntent);
			finish();
			break;
		}
		
	}
}
