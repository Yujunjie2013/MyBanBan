package com.example.yune.mybanban.base;

import android.util.Log;

import com.example.yune.mybanban.mvp.model.CommonParam;
import com.example.yune.mybanban.retrofit.RetrofitUtils;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Yune on 2016/11/8.
 * Presenter是负责View和Model交互的纽带，所以这里我们定义一个泛型表示需要传入一个View
 */
public class BasePresenter<V> {

    public V mView;
    private CompositeSubscription mCompositeSubscription;
    public Retrofit mRetrofit;

    public void addachView(V view) {
        this.mView = view;
        mRetrofit = RetrofitUtils.getmRetrofit();
    }

    public void detachView() {
        this.mView = null;
        onUnSubscription();
    }

    /**
     * 添加订阅
     *
     * @param observable
     * @param subscriber
     */
    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    /**
     * 移除订阅
     */
    public void onUnSubscription() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    private TreeMap<String, Object> treeMap = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    public CommonParam setParams() {

        CommonParam commonParams = new CommonParam();
        commonParams.setAppVersion("1.0.1");
        commonParams.setToken("");
        commonParams.setOriginatorId(1l);//TODO 管理员
        commonParams.setOrgId("0");//TODO 组织
        commonParams.setPage(0);
        commonParams.setPagesize(5);
        commonParams.setAppKey("bbl40c2n1uq5zcvcvz");
        treeMap.put("commonParam", commonParams);

        return commonParams;
    }

    private String key = "8e6c0b64cd2bc372bda41d76aca49318";

    public CommonParam setData(Object object) {
        CommonParam commonParam = setParams();

        treeMap.put("object", object);

        Gson gson = new Gson();
        String params = signJson(treeMap, gson);
        if (!isEmpty(key)) {
            params = params + "&key=" + key;
        }

        params = params.replace("\\", "\\\\");
        Log.d("yujj--->", "md5:" + params);
        String sign = getMD5(params);
        commonParam.setSign(sign.toUpperCase());
        Log.d("yujj---->", "入参打印" + gson.toJson(treeMap));

        return commonParam;
    }

    private String signJson(TreeMap<String, Object> jsonObject, Gson gson) {

        for (String paramName : jsonObject.keySet()) {
            String s = gson.toJson(jsonObject.get(paramName));
            jsonObject.put(paramName, s);
        }
        return formatParams(jsonObject);
    }

    private String formatParams(Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                sb.append("&")
                        .append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        //它包含此字符序列当前所包含的字符子序列。该子字符串始于指定索引处的字符，一直到此字符串末尾。
        return sb.substring(1);
    }

    private boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    private String getMD5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));
            byte[] encryption = md5.digest();

            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
