package com.huangyu.library.http;

import java.io.Serializable;

/**
 * Created by huangyu on 2017-4-10.
 */
public class BaseResponse<T> implements Serializable {

    public boolean mState;
    public String mMessage;
    public T mData;

    public boolean getState() {
        return mState;
    }

    public void setState(boolean state) {
        this.mState = state;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public T getData() {
        return mData;
    }

    public void setData(T body) {
        this.mData = body;
    }

}
