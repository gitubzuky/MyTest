package com.example.administrator.test.presenter;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.administrator.test.model.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class TestPresenter implements TestContract.IPresenter {

    private final TestContract.IView mTestView;

    public TestPresenter(@NonNull TestContract.IView mTestView) {
        this.mTestView = mTestView;
        mTestView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getData() {
        List<TestBean> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestBean testBean = new TestBean();
            testBean.setText("item" + i);
            dataList.add(testBean);
        }
        mTestView.showList(dataList);
    }
}
