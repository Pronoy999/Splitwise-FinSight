package com.pro.finsight.splitwise.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class HttpRequestHelper {
    /**
     * Makes a POST request to the specified URL with the given parameters.
     *
     * @param context  The context from which the request is made.
     * @param url      The URL to which the request is sent.
     * @param params   The parameters to be included in the POST request.
     * @param callback The callback to handle the response or error.
     */
    public static void makePostRequest(Context context, String url, Map<String, String> params, final RequestCallBack callback) {
        StringRequest postRequest = new StringRequest(
                Request.Method.POST,
                url,
                callback::onSuccess,
                error -> callback.onError(error.toString())
        ) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        SingleTonQueue.getInstance(context).getRequestQueue().add(postRequest);
    }

    /**
     * Makes a GET request to the specified URL.
     *
     * @param context  The context from which the request is made.
     * @param url      The URL to which the request is sent.
     * @param callback The callback to handle the response or error.
     */
    public static void makeGetRequest(Context context, String url, final RequestCallBack callback) {
        StringRequest getRequest = new StringRequest(
                Request.Method.GET,
                url,
                callback::onSuccess,
                error -> callback.onError(error.toString())
        );

        SingleTonQueue.getInstance(context).getRequestQueue().add(getRequest);
    }
}
