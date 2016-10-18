package com.example.administrator.test.view;

import android.support.annotation.ColorRes;

/**
 * Created by Administrator on 2016/9/13.
 */
public interface IView {
    void setTitle(String text);
    void setTitleTextColor(@ColorRes int color);
    void showToast(String toast, int duration);
}
