package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import xyz.abug.www.yougo.R;

public class PayActivity extends AppCompatActivity {

    private TextView mTextPay;
    private ImageView mImgOpen;
    private LinearLayout mLinearContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
    }

    /**
     * 绑定
     */
    private void initView() {
        mLinearContent = (LinearLayout) findViewById(R.id.ac_pay_linear_content);
        mImgOpen = (ImageView) findViewById(R.id.ac_pay_img_open);
        mTextPay = (TextView) findViewById(R.id.ac_pay_text_pay);
        mTextPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
