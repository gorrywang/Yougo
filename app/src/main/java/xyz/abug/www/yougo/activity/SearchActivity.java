package xyz.abug.www.yougo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import xyz.abug.www.yougo.R;

public class SearchActivity extends AppCompatActivity {
    private ImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        mImgBack = (ImageView) findViewById(R.id.ac_search_img_back);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
