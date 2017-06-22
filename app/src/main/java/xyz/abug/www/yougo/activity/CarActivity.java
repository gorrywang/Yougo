package xyz.abug.www.yougo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import xyz.abug.www.yougo.R;

public class CarActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        mImgBack = (ImageView) findViewById(R.id.ac_shop_img_back);
        mImgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_shop_img_back:
                //返回
                finish();
                break;
        }
    }
}
