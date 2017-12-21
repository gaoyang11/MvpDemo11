package gaoyang.baway.com.mvpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import gaoyang.baway.com.mvpdemo.R;

/**
 *
 */

public class FristActivity extends BaseActivity {
    private ImageView iv_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_item);
        getSupportActionBar().hide();
        //Api.init(getApplicationContext());
        initView();
    }
    /**
     * 获取资源组件
     */
    private void initView() {
        iv_index = (ImageView) findViewById(R.id.iv_index);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(new Intent(FristActivity.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
