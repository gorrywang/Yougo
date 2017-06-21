package xyz.abug.www.yougo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.abug.www.yougo.R;

public class MoneyActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private Integer[] mList = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        initView();
        initAdapter();
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        //创建LinearLayoutManager
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //设置为横向滑动
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置
        mRecycler.setLayoutManager(manager);
        //实例化适配器
        MyAdapter myAdapter = new MyAdapter();
        //设置适配器
        mRecycler.setAdapter(myAdapter);
    }

    /**
     * 初始化id
     */
    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.ac_money_recycler);
    }

    /**
     * 内部适配器
     */

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(MoneyActivity.this).inflate(R.layout.item_money, null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return mList.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
