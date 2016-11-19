package com.example.yune.mybanban.mvp.model;

/**
 * Created by Yune on 2016/11/9.
 */

public class BaseModel<D> {
    private String status;
    private String message;
    private D data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
