package com.fengyunweather.app.util;

/**
 * Created by Kevin on 2015/10/26.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
