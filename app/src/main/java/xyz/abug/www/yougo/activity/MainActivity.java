package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.adapter.MyPagerAdapter;
import xyz.abug.www.yougo.utils.Utils;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, OnClickListener {
    //图片轮播
    private ViewPager mViewPager;
    private List<ImageView> mImageViewList = new ArrayList<>();
    private int[] mPicGroup = new int[]{R.drawable.ad_1, R.drawable.ad_2, R.drawable.ad_1, R.drawable.ad_2};
    private MyPagerAdapter mPagerAdapter;
    private LinearLayout mLinearPosition;
    private int mPositionNum = 0;
    //男装女装童装
    private RelativeLayout mRelaWoman, mRelaMan, mRelaChild;
    private static DrawerLayout mDrawerLayout;
    private ImageView mImgMenu;
    private FloatingActionButton mFloatBtn;
    //搜索
    private ImageView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
        startPicThread();
    }

    /**
     * 图片轮播线程
     */
    private void startPicThread() {
        new Thread() {
            public void run() {
                Utils.LBT_STATUS = true;
                while (Utils.LBT_STATUS) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                        }
                    });
                }
            }
        }.start();
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        mPagerAdapter = new MyPagerAdapter(mImageViewList);
        mViewPager.setAdapter(mPagerAdapter);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        ImageView imageView;
        //指示器
        View pointView;
        LinearLayout.LayoutParams layoutParams;
        for (int i : mPicGroup) {
            imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(i);
            mImageViewList.add(imageView);
            imageView = null;
            //添加小白点指示器
            pointView = new View(this);
            pointView.setBackgroundResource(R.drawable.selector_bg_point);
            layoutParams = new LinearLayout.LayoutParams(25, 25);
            if (i != 0)
                layoutParams.leftMargin = 10;

            // 设置默认所有都不可用
            pointView.setEnabled(false);
            mLinearPosition.addView(pointView, layoutParams);
        }
        mLinearPosition.getChildAt(0).setEnabled(true);
    }

    /**
     * 初始化控件
     */

    private void initView() {
        mSearchView = (ImageView) findViewById(R.id.item_title_img_search);
        mViewPager = (ViewPager) findViewById(R.id.ac_main_pager_show);
        mLinearPosition = (LinearLayout) findViewById(R.id.ac_main_linear_position);
        mRelaWoman = (RelativeLayout) findViewById(R.id.ac_main_rela_woman);
        mRelaMan = (RelativeLayout) findViewById(R.id.ac_main_rela_man);
        mRelaChild = (RelativeLayout) findViewById(R.id.ac_main_rela_child);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.ac_main_drawer_show);
        mImgMenu = (ImageView) findViewById(R.id.item_title_img_left);
        mFloatBtn = (FloatingActionButton) findViewById(R.id.ac_main_float);
        mSearchView.setOnClickListener(this);
        mFloatBtn.setOnClickListener(this);
        mImgMenu.setOnClickListener(this);
        mViewPager.addOnPageChangeListener(this);
        mRelaWoman.setOnClickListener(this);
        mRelaMan.setOnClickListener(this);
        mRelaChild.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int pos = position % mImageViewList.size();
        mLinearPosition.getChildAt(mPositionNum).setEnabled(false);
        //设置小圆点
        mLinearPosition.getChildAt(pos).setEnabled(true);
        mPositionNum = pos;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 按钮监听事件
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ShopActivity.class);
        switch (view.getId()) {
            case R.id.ac_main_rela_woman:
                //女装
                Toast.makeText(MainActivity.this, "女装", Toast.LENGTH_SHORT).show();
                intent.putExtra("data", 0);
                startActivity(intent);
                break;

            case R.id.ac_main_rela_man:
                //男装
                Toast.makeText(MainActivity.this, "男装", Toast.LENGTH_SHORT).show();
                intent.putExtra("data", 1);
                startActivity(intent);
                break;

            case R.id.ac_main_rela_child:
                //童装
                Toast.makeText(MainActivity.this, "童装", Toast.LENGTH_SHORT).show();
                intent.putExtra("data", 2);
                startActivity(intent);
                break;
            case R.id.item_title_img_left:
                //打开菜单
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.ac_main_float:
                //浮动菜单
                intent = null;
                intent = new Intent(MainActivity.this, CarActivity.class);
                startActivity(intent);
                break;

            case R.id.item_title_img_search:
                //搜索
                intent = null;
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    public static void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}
