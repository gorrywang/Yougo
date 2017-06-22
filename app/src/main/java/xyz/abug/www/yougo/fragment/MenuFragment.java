package xyz.abug.www.yougo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.activity.MainActivity;
import xyz.abug.www.yougo.activity.MenuContentActivity;

/**
 * Created by iswgr on 2017/6/20.
 */

public class MenuFragment extends Fragment implements View.OnClickListener {
    private View mView;
    private TextView mTxtShoucang, mTxtXiaoxi, mTxtYouhuiquan, mTxtShouhou, mTxtDizhi, mTxtSetting;
    private Button mFinishBtn;
    private LinearLayout mLinearDfk, mLinearDsh, mLinearQbdd, mLinearUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_menu, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    /**
     * 绑定控件
     */
    private void initView() {
        mTxtShoucang = mView.findViewById(R.id.frag_menu_shoucang);
        mTxtXiaoxi = mView.findViewById(R.id.frag_menu_xiaoxi);
        mTxtYouhuiquan = mView.findViewById(R.id.frag_menu_youhuiquan);
        mTxtShouhou = mView.findViewById(R.id.frag_menu_shouhou);
        mTxtDizhi = mView.findViewById(R.id.frag_menu_shouhuodizhi);
        mTxtSetting = mView.findViewById(R.id.frag_menu_setting);
        mFinishBtn = mView.findViewById(R.id.frag_menu_btn_finish);
        mLinearDfk = mView.findViewById(R.id.frag_menu_linear_daifukuan);
        mLinearDsh = mView.findViewById(R.id.frag_menu_linear_daishouhuo);
        mLinearQbdd = mView.findViewById(R.id.frag_menu_linear_quanbu);
        mLinearUser = mView.findViewById(R.id.frag_menu_linear_user);
        mLinearUser.setOnClickListener(this);
        mLinearDfk.setOnClickListener(this);
        mLinearDsh.setOnClickListener(this);
        mLinearQbdd.setOnClickListener(this);
        mTxtShoucang.setOnClickListener(this);
        mTxtXiaoxi.setOnClickListener(this);
        mTxtYouhuiquan.setOnClickListener(this);
        mTxtShouhou.setOnClickListener(this);
        mTxtDizhi.setOnClickListener(this);
        mTxtSetting.setOnClickListener(this);
        mFinishBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), MenuContentActivity.class);
        MainActivity.closeDrawer();
        switch (view.getId()) {
            case R.id.frag_menu_shoucang:
                //收藏
                intent.putExtra("data", 0);
                startActivity(intent);
                break;

            case R.id.frag_menu_xiaoxi:
                //消息
                intent.putExtra("data", 1);
                startActivity(intent);
                break;

            case R.id.frag_menu_youhuiquan:
                //优惠券
                intent.putExtra("data", 2);
                startActivity(intent);
                break;

            case R.id.frag_menu_shouhou:
                //售后
                intent.putExtra("data", 3);
                startActivity(intent);
                break;

            case R.id.frag_menu_shouhuodizhi:
                //收货地址
                intent.putExtra("data", 4);
                startActivity(intent);
                break;

            case R.id.frag_menu_setting:
                //设置
                intent.putExtra("data", 5);
                startActivity(intent);
                break;

            case R.id.frag_menu_btn_finish:
                //退出
                getActivity().finish();
                break;
            case R.id.frag_menu_linear_daifukuan:
                //待付款
                intent.putExtra("data", 6);
                startActivity(intent);
                break;
            case R.id.frag_menu_linear_daishouhuo:
                //待收货
                intent.putExtra("data", 7);
                startActivity(intent);
                break;
            case R.id.frag_menu_linear_quanbu:
                //全部订单
                intent.putExtra("data", 8);
                startActivity(intent);
                break;
            case R.id.frag_menu_linear_user:
                //用户设置
                intent.putExtra("data", 9);
                startActivity(intent);
                break;
        }
    }
}
