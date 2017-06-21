package xyz.abug.www.yougo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.bean.ShopVO;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {
    private int mClassNum;
    private ImageView mImgBack;
    private TextView mTxtTitle;
    private List<ShopVO> mShopList = new ArrayList<>();
    private MyAdapter mMyAdapter;
    private RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        getClassNum();
        loadData();
        initAdapter();
    }

    /**
     * 适配器
     */
    private void initAdapter() {
        mMyAdapter = new MyAdapter();
        //参数意思：分为几列；方向。
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //设置
        mRecycler.setLayoutManager(manager);
        //设置适配器
        mRecycler.setAdapter(mMyAdapter);
    }

    /**
     * 加载商场数据
     */
    private void loadData() {
        switch (mClassNum) {
            case 0:
                //女装
                mTxtTitle.setText("女装");
                getWOmanData();
                break;
            case 1:
                //男装
                mTxtTitle.setText("男装");
                getManData();
                break;
            case 2:
                //童装
                mTxtTitle.setText("童装");
                getChildData();
                break;
        }
    }

    /**
     * 获取童装
     */
    private void getChildData() {
        for (int i = 0; i < 30; i++) {
            ShopVO shopVO = new ShopVO("童装", 100 + i + "", getRandomStr("童装童装"), 2000 + i, R.drawable.tongzhuang);
            mShopList.add(shopVO);
        }
    }

    /**
     * 获取男装
     */
    private void getManData() {
        for (int i = 0; i < 30; i++) {
            ShopVO shopVO = new ShopVO("男装", 100 + i + "", getRandomStr("男装男装"), 2000 + i, R.drawable.nanzhuang);
            mShopList.add(shopVO);
        }
    }

    /**
     * 获取女装
     */
    private void getWOmanData() {
        for (int i = 0; i < 30; i++) {
            ShopVO shopVO = new ShopVO("女装", 100 + i + "", getRandomStr("女装女装"), 2000 + i, R.drawable.nvzhuang);
            mShopList.add(shopVO);
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
        mImgBack = (ImageView) findViewById(R.id.item_title_img_left);
        mTxtTitle = (TextView) findViewById(R.id.item_title_txt_title);
        mRecycler = (RecyclerView) findViewById(R.id.ac_shop_recycler_show);
        mImgBack.setImageResource(R.drawable.back);
        mImgBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_title_img_left:
                //返回
                finish();
                break;
        }
    }


    /**
     * 适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //绑定行布局
            View view = View.inflate(parent.getContext(), R.layout.item_show, null);
            //实例化ViewHolder
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        //设置数据
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //获取当前实体类对象
            ShopVO vo = mShopList.get(position);
            //设置
            holder.img.setImageResource(vo.getImg());
            holder.textName.setText(vo.getName());
            holder.textMoney.setText("￥:" + vo.getMoney());
            holder.textSc.setText("已售出:" + vo.getShouchu());
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ShopActivity.this, MoneyActivity.class);
                    startActivity(intent);
                }
            });
        }

        //数量
        @Override
        public int getItemCount() {
            return mShopList.size();
        }

        //内部类
        class ViewHolder extends RecyclerView.ViewHolder {
            //行布局中的控件
            ImageView img;
            TextView textName, textMoney, textSc;
            LinearLayout linearLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                //绑定控件
                linearLayout = itemView.findViewById(R.id.item_show_linear);
                img = itemView.findViewById(R.id.item_show_img);
                textName = itemView.findViewById(R.id.item_show_txt_name);
                textMoney = itemView.findViewById(R.id.item_show_txt_money);
                textSc = itemView.findViewById(R.id.item_show_txt_yishou);
            }
        }
    }


    //将文本长度改变
    private String getRandomStr(String str) {
        Random random = new Random();
        int num = random.nextInt(10) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(str + "");
        }
        return builder.toString();
    }


}
