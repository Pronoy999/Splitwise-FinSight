package com.pro.finsight.splitwise.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingleTonQueue {
    private static SingleTonQueue instance;
    private RequestQueue requestQueue;

    private SingleTonQueue(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static synchronized SingleTonQueue getInstance(Context context) {
        if (instance == null) {
            instance = new SingleTonQueue(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
