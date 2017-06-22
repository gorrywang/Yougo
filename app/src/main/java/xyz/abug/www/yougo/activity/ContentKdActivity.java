package xyz.abug.www.yougo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.bean.TraceBean;

/**
 * 快递详情
 */


public class ContentKdActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<TraceBean> mList = new ArrayList<>();
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_kd);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        mMyAdapter = new MyAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMyAdapter);
    }

    /**
     * 获取数据
     */
    private void initData() {
        TraceBean bean;
        for (int i = 1 ; i<6 ;i++ ){
            bean = new TraceBean("2017.07.07 18:18","哈哈哈哈您好,您的快递到达了"+i);
            mList.add(bean);
        }
    }

    /**
     * 绑定id
     */
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_contentkd_recycler_show);
    }

    /**
     * 适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(ContentKdActivity.this).inflate(R.layout.item_kd, null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if (position == 0) {
                //第一个
                holder.top.setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams layoutParams = holder.yuan.getLayoutParams();
                layoutParams.height = 30;
                layoutParams.width = 30;
                holder.yuan.setLayoutParams(layoutParams);
                holder.yuan.setBackgroundResource(R.drawable.yuandian_first);
                holder.data.setTextColor(getResources().getColor(R.color.important_title));
                holder.data.setTextSize(18);
            }

//            if (position == mList.size()){
//                ViewGroup.LayoutParams layoutParams = holder.bottom.getLayoutParams();
//                layoutParams.height = 500;
//                holder.bottom.setLayoutParams(layoutParams);
//            }
            holder.data.setText(mList.get(position).getData());
            holder.time.setText(mList.get(position).getTime());

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            View top , bottom ,yuan;
            TextView data ,time;

            public ViewHolder(View itemView) {
                super(itemView);
                top = itemView.findViewById(R.id.item_kd_lint_top);
                bottom = itemView.findViewById(R.id.item_kd_bottom);
                yuan = itemView.findViewById(R.id.item_kd_dian);
                data = itemView.findViewById(R.id.item_kd_txt_data);
                time = itemView.findViewById(R.id.item_kd_txt_time);
            }
        }
    }

}
