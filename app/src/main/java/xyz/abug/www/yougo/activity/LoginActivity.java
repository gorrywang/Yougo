package xyz.abug.www.yougo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.fragment.LoginFragment;
import xyz.abug.www.yougo.fragment.RegFragment;

public class LoginActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Fragment> mList = new ArrayList<>();
    private MyAdapter mMyAdapter;
    private TextView mTextLogin, mTextReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        initAdapter();
    }

    /**
     * 加载数据
     */
    private void initData() {
        Fragment f1 = new LoginFragment();
        Fragment f2 = new RegFragment();
        mList.add(f1);
        mList.add(f2);
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        mMyAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTextLogin.setTextColor(getResources().getColor(R.color.tip_font));
                mTextReg.setTextColor(getResources().getColor(R.color.tip_font));
                if (position == 0) {
                    mTextLogin.setTextColor(getResources().getColor(R.color.important_title));
                } else {
                    mTextReg.setTextColor(getResources().getColor(R.color.important_title));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化id
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.ac_login_pager_tab);
        mTextLogin = (TextView) findViewById(R.id.ac_login_text_login);
        mTextReg = (TextView) findViewById(R.id.ac_login_text_reg);
        mTextLogin.setTextColor(getResources().getColor(R.color.important_title));
        mTextReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });

        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });
    }

    /**
     * 适配器
     */
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
