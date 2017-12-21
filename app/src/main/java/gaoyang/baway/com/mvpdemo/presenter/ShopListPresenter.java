package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.ShopListMode;
import gaoyang.baway.com.mvpdemo.view.ShopListView;

/**
 * Created by 15218 on 2017/10/11.
 */
public class ShopListPresenter implements ShopListMode.shopListapi{

    private ShopListView shopListView ;
    private ShopListMode shopListMode ;

    public ShopListPresenter(ShopListView shopListView) {
        this.shopListView = shopListView;
        this.shopListMode = new ShopListMode();
        shopListMode.setShopListapi(this);
    }

    public void getData(int pscid,int page){
            shopListMode.getData(pscid,page);
    }

    @Override
    public void Success(BaseBean baseBean) {
            shopListView.Success(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
            shopListView.Error(baseBean);
    }
}
