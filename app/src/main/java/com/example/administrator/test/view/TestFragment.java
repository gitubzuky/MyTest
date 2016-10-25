package com.example.administrator.test.view;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.test.R;
import com.example.administrator.test.adapter.TestRvAdapter;
import com.example.administrator.test.annotation.Injection;
import com.example.administrator.test.annotation.ViewInject;
import com.example.administrator.test.model.TestBean;
import com.example.administrator.test.presenter.TestContract;
import com.example.administrator.test.presenter.TestPresenter;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class TestFragment extends Fragment implements TestContract.IView {

    //    @ViewInject(R.id.rv_test)
    private RecyclerView rvTest;

    //    @ViewInject(R.id.tv_test_title)
    private TextView tvTitle;

    private TestContract.IPresenter mPresenter;
    private View mNoTestView;

    private TestRvAdapter mRvAdapter;

    public TestFragment() {
        // Requires empty public constructor
    }

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull TestContract.IPresenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_test, container, false);
//        Injection.inject(root);
        tvTitle = (TextView) root.findViewById(R.id.tv_test_title);
//        rvTest.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTest = (RecyclerView) root.findViewById(R.id.rv_test);
        rvTest.setLayoutManager(new LinearLayoutManager(this.getContext()));//必须加。。。不然显示不出数据
        // Set up test view
        mRvAdapter = new TestRvAdapter(getContext());
        rvTest.setAdapter(mRvAdapter);

        mPresenter.getData();

        return root;
    }

    @Override
    public void setTitle(String text) {
        if (TextUtils.isEmpty(text)) {
            tvTitle.setText(text);
        }
    }

    @Override
    public void setTitleTextColor(@ColorRes int color) {
        tvTitle.setTextColor(getResources().getColor(color));
    }

    @Override
    public void showToast(String toast, int duration) {
        Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<TestBean> dataList) {
        mRvAdapter.addData(dataList);
    }
}
