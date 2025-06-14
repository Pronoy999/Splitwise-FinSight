package com.pro.finsight.splitwise.utils;

public interface RequestCallBack {
    void onSuccess(String response);

    void onError(String error);
}
