package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import xyz.abug.www.yougo.R;

public class CarActivity extends AppCompatActivity implements View.OnClickListener  {
    private ImageView mImgBack;
    private TextView mTextPay , mTextMoney;
    private ToggleButton button1 ;
    private ToggleButton button2 , buttonQ;
    private boolean mBtn1Bool1 =false;
    private boolean mBtn1Bool2 =false;
    private ImageView mImgDel ;
    private TextView mTextCancel;

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
        mImgDel = (ImageView) findViewById(R.id.ac_item_img_del);
        mTextPay = (TextView) findViewById(R.id.ac_car_text_pay);
        mTextMoney = (TextView) findViewById(R.id.ac_car_text_money);
        buttonQ = (ToggleButton) findViewById(R.id.ac_car_toggle_q);
        mTextCancel = (TextView) findViewById(R.id.ac_item_text_cancel);
        mTextCancel.setOnClickListener(this);
        mImgBack.setOnClickListener(this);
        mImgDel.setOnClickListener(this);
        mTextPay.setOnClickListener(this);
        //include
        View view1 = findViewById(R.id.ac_car_include_1);
        View view2 = findViewById(R.id.ac_car_include_2);
        button1 = view1.findViewById(R.id.item_car_rad_success);
        button2 = view2.findViewById(R.id.item_car_rad_success);
        button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mBtn1Bool1 = b;
                check();
            }
        });
        button2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mBtn1Bool2 = b;
                check();
            }
        });
        buttonQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    button1.setChecked(true);
                    button2.setChecked(true);
                } else {
                    button1.setChecked(false);
                    button2.setChecked(false);
                }
            }
        });
    }

    /**
     * 检查是否显示删除按钮
     */
    private void check() {
        if (mBtn1Bool1 || mBtn1Bool2) {

        }
    }

    private boolean mDelBool = true;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_shop_img_back:
                //返回
                finish();
                break;
            case R.id.ac_car_text_pay:
                //支付
                if (mDelBool) {
                    Intent intent = new Intent(CarActivity.this, PayActivity.class);
                    startActivity(intent);
                } else {
                    //删除
                    Toast.makeText(CarActivity.this,"删除",Toast.LENGTH_SHORT).show();
                }
            case R.id.ac_item_img_del:
                //删除按钮
                //隐藏删除，显示取消
                mImgDel.setVisibility(View.GONE);
                mTextCancel.setVisibility(View.VISIBLE);
                //隐藏金额, 修改到删除
                mTextMoney.setVisibility(View.GONE);
                mTextPay.setText("删除");
                mDelBool = false;
                break;
            case R.id.ac_item_text_cancel:
                //是删除，取消
                //显示删除，隐藏取消
                mImgDel.setVisibility(View.VISIBLE);
                mTextCancel.setVisibility(View.GONE);
                //显示金额, 修改到支付
                mTextMoney.setVisibility(View.VISIBLE);
                mTextPay.setText("结算(2)");
                mDelBool = true;
                break;
        }
    }

}
