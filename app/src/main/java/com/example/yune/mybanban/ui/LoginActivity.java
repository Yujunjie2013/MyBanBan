package com.example.yune.mybanban.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.yune.mybanban.MainActivity;
import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BaseActivity;
import com.example.yune.mybanban.mvp.model.BaseModel;
import com.example.yune.mybanban.mvp.model.bean.LoginBean;
import com.example.yune.mybanban.mvp.presenter.LoginPresenter;
import com.example.yune.mybanban.mvp.view.LoginView;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView, View.OnClickListener {


    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        findViewById(R.id.email_sign_in_button).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //初始化数据
    }

    @Override
    public void getDataSuccess(BaseModel data) {
        //TODO 登录成功后返回的数据
        Log.d("yujj", data.getMessage() + "==" + data.getStatus());
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void getDataFail(String msg) {
        //TODO 登录失败的回调
        Log.d("yujj", "失败:" + msg);
    }

    @Override
    public LoginBean getData() {
        //登录入参
        LoginBean lb = new LoginBean();
        lb.setPhone(mEmailView.getText().toString().trim());
        lb.setCode(mPasswordView.getText().toString().trim());
        lb.setState("1");
        lb.setChannelId("000000000");
        lb.setChannelType("2");
        return lb;
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                //执行登录操作
                mPresenter.login();
                break;
        }
    }
}

