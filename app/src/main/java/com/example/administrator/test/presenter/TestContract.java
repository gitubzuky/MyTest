package com.example.administrator.test.presenter;

import android.support.annotation.ColorRes;
import android.view.View;

import com.example.administrator.test.model.TestBean;
import com.example.administrator.test.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public interface TestContract {
    interface IView extends BaseView<IPresenter> {
        void setTitle(String text);

        void setTitleTextColor(@ColorRes int color);

        void showToast(String toast, int duration);

        void showList(List<TestBean> dataList);
    }

    interface IPresenter extends BasePresenter {
        void getData();
    }
}
