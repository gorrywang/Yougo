package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.fragment.DfkFragment;
import xyz.abug.www.yougo.fragment.DshFragment;
import xyz.abug.www.yougo.fragment.QbddFragment;
import xyz.abug.www.yougo.fragment.ScFragment;
import xyz.abug.www.yougo.fragment.SetFragment;
import xyz.abug.www.yougo.fragment.ShFragment;
import xyz.abug.www.yougo.fragment.ShdzFragment;
import xyz.abug.www.yougo.fragment.UserFragment;
import xyz.abug.www.yougo.fragment.XxFragment;
import xyz.abug.www.yougo.fragment.YhqFragment;

/**
 * 菜单单机后的界面
 */

public class MenuContentActivity extends AppCompatActivity {

    private int mPositionNum;
    private FragmentManager mManager;
    private FragmentTransaction mTran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_content);
        initData();
        getPosition();
        loadFrag();
    }

    private void initData() {
        mManager = getSupportFragmentManager();
    }

    /**
     * 记载fragment
     */
    private void loadFrag() {
        mTran = mManager.beginTransaction();
        Fragment fragment = null;
        switch (mPositionNum) {
            case 0:
                //收藏
                fragment = new ScFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 1:
                //消息
                fragment = new XxFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 2:
                //优惠券
                fragment = new YhqFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 3:
                //售后
                fragment = new ShFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 4:
                //收货地址
                fragment = new ShdzFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 5:
                //设置
                fragment = new SetFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 6:
                //待付款
                fragment = new DfkFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 7:
                //待收货
                fragment = new DshFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 8:
                //全部订单
                fragment = new QbddFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
            case 9:
                //用户设置
                fragment = new UserFragment();
                mTran.replace(R.id.ac_menucontent_frame, fragment);
                break;
        }
        mTran.commit();
    }

    /**
     * 获取第几个
     */
    private void getPosition() {
        Intent intent = getIntent();
        int data = intent.getIntExtra("data", -1);
        mPositionNum = data;
    }
}
