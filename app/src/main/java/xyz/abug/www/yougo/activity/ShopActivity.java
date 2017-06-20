package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xyz.abug.www.yougo.R;

public class ShopActivity extends AppCompatActivity {
    private int mClassNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        getClassNum();
        loadData();
    }

    /**
     * 加载商场数据
     */
    private void loadData() {
        switch (mClassNum) {
            case 0:
                //女装

                break;
            case 1:
                //男装
                break;
            case 2:
                //童装
                break;
        }
    }

    /**
     * 获取类别
     */
    private void getClassNum() {
        Intent intent = getIntent();
        mClassNum = intent.getIntExtra("data", -1);
    }

    /**
     * 初始化view
     */
    private void initView() {

    }
}
