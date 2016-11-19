package com.example.yune.mybanban.mvp.Login;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.yune.mybanban.App;
import com.example.yune.mybanban.R;
import com.example.yune.mybanban.mvp.model.bean.LoginBean;

/**
 * Created by Yune on 2016/11/9.
 */

public class ILoginModelImpl implements ILoginModel {

    @Override
    public boolean setData(LoginBean loginBean) {
        String phone = loginBean.getPhone();
        String code = loginBean.getCode();
        if (phone != null && !TextUtils.isEmpty(phone) && code != null && !TextUtils.isEmpty(code)) {
            Log.d("yujj", "入参正常!");
        } else {
            Toast.makeText(App.getInstance(), App.getInstance().getString(R.string.params_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }
}
