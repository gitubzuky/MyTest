package com.example.administrator.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.administrator.test.annotation.Injection;
import com.example.administrator.test.annotation.ViewInject;
import com.example.administrator.test.presenter.TestPresenter;
import com.example.administrator.test.utils.ActivityUtils;
import com.example.administrator.test.view.TestFragment;

/**
 * Created by Administrator on 2016/10/14.
 */

public class TestActivity extends AppCompatActivity {

    private TestPresenter mTestPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Injection.inject(this);

        TestFragment tasksFragment =
                (TestFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = TestFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }

        mTestPresenter = new TestPresenter(tasksFragment);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
