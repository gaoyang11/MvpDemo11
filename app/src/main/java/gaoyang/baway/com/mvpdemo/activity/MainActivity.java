package gaoyang.baway.com.mvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.hjm.bottomtabbar.BottomTabBar;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.fragment.BaseFragment;
import gaoyang.baway.com.mvpdemo.fragment.FenLeiFragment;
import gaoyang.baway.com.mvpdemo.fragment.Home;
import gaoyang.baway.com.mvpdemo.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar tabbar;
private GridView gr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        getSupportActionBar().hide();

        initView();

        initData();


    }

    private void initData() {
        tabbar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(15)
                .setTabPadding(4,6,10)
                .addTabItem("首页", R.mipmap.ic_nav_home,Home.class)
                .addTabItem("分类",R.mipmap.ic_nav_class,FenLeiFragment.class)
                .addTabItem("购物车",R.mipmap.gou_wu_che, BaseFragment.CartFragment.class)
                .addTabItem("我的",R.mipmap.ic_nav_user,UserFragment.class)
                .isShowDivider(true);
    }


    private void initView() {

        tabbar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);

    }
}
