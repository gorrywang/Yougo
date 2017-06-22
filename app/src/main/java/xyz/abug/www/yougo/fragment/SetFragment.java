package xyz.abug.www.yougo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import xyz.abug.www.yougo.R;
import xyz.abug.www.yougo.activity.LoginActivity;

/**
 * Created by iswgr on 2017/6/21.
 * 设置
 */

public class SetFragment extends Fragment {
    private View mView;
    private ImageView mImgBack;
    private LinearLayout mLinearUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_setting, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    /**
     * 绑定
     */
    private void initView() {
        mLinearUser = mView.findViewById(R.id.frag_set_linear_login);
        mImgBack = mView.findViewById(R.id.frag_set_img_back);
        mLinearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}
