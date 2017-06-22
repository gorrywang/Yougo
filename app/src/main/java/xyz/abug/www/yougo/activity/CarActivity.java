package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.abug.www.yougo.R;

public class CarActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImgBack;
    private TextView mTextPay;

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
        mTextPay = (TextView) findViewById(R.id.ac_car_text_pay);
        mImgBack.setOnClickListener(this);
        mTextPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_shop_img_back:
                //返回
                finish();
                break;
            case R.id.ac_car_text_pay:
                //支付
                Intent intent = new Intent(CarActivity.this, PayActivity.class);
                startActivity(intent);
                break;
        }
    }
}
