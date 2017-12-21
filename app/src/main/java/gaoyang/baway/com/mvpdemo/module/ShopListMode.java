package gaoyang.baway.com.mvpdemo.module;

import android.util.Log;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.ShopListBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/11.
 */
public class ShopListMode {

    private shopListapi shopListapi ;

    public void setShopListapi(ShopListMode.shopListapi shopListapi) {
        this.shopListapi = shopListapi;
    }

    public void getData(int pscid, int page){
            String url = Api.SHOP_LISTVIEW+"?"+"pscid="+pscid+"&"+"page="+page;
        //log测试输出
                Log.d("qq","url:" + url);
        HttpOkUntils.getHttpUtils().OkGet(url, ShopListBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                shopListapi.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                shopListapi.Error(baseBean);
            }
        });

    }

    public interface shopListapi{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    }
}
