package gaoyang.baway.com.mvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.adapter.MyTakeAdapter;
import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.TakeGoodsBean;
import gaoyang.baway.com.mvpdemo.presenter.TakePresenter;
import gaoyang.baway.com.mvpdemo.untils.IntentUntils;
import gaoyang.baway.com.mvpdemo.untils.SpUtils;
import gaoyang.baway.com.mvpdemo.view.TakeView;

public class TakeGoodsActivity extends AppCompatActivity implements TakeView{

    private ImageView i;
    private RecyclerView recy;
    private Button btn_build;
    private TakePresenter takepresnter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_goods);
        getSupportActionBar().hide();
        initView();
        exit();
        news();
    }
    /**
     * 退出
     */
    public void exit (){

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.leftone, R.anim.rightone);
            }
        });

    }

    /**
     * 新建收货地址
     */
    public void news(){

        btn_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUntils.setIntent(TakeGoodsActivity.this,NewAddressActivity.class);
            }
        });

    }

    private void initView() {

        i = (ImageView) findViewById(R.id.image_left);
        recy = (RecyclerView) findViewById(R.id.recy);
        btn_build = (Button) findViewById(R.id.build);
        takepresnter = new TakePresenter(this);

    }


    @Override
    public void Success(BaseBean baseBean) {

          TakeGoodsBean taebean  = (TakeGoodsBean) baseBean;
        List<TakeGoodsBean.DataBean> data = taebean.getData();

        recy.setLayoutManager(new LinearLayoutManager(TakeGoodsActivity.this,LinearLayoutManager.VERTICAL,false));
        recy.addItemDecoration(new DividerItemDecoration(TakeGoodsActivity.this,DividerItemDecoration.VERTICAL));
        MyTakeAdapter takeAdapter = new MyTakeAdapter(data,TakeGoodsActivity.this);
        recy.setAdapter(takeAdapter);
    }

    @Override
    public void Error(BaseBean baseBean) {
         //吐司事件
          Toast.makeText(TakeGoodsActivity.this, baseBean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        takepresnter.getData(SpUtils.getSpUid(TakeGoodsActivity.this)+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        takepresnter.deatch();
    }
}
