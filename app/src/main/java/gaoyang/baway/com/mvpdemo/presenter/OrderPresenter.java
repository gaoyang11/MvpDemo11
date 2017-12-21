package gaoyang.baway.com.mvpdemo.presenter;

import android.content.Context;

import java.lang.ref.WeakReference;

import gaoyang.baway.com.mvpdemo.bean.OrderBean;
import gaoyang.baway.com.mvpdemo.module.OrderModle;
import gaoyang.baway.com.mvpdemo.view.OrderView;

/**
 * Created by 15218 on 2017/11/15.
 */
public class OrderPresenter implements OrderModle.loadData {

    private OrderModle orderModle ;
    private WeakReference<OrderView> weak ;

    public OrderPresenter(OrderView orderView) {
        this.orderModle = new OrderModle();
        orderModle.setLoadData(this);
        this.weak = new WeakReference<OrderView>(orderView);
    }

    public void deatch(){
        weak.clear();
    }
    public void getData(Context context,String uid){
        orderModle.getData(context,uid);
    }
    @Override
    public void Success(OrderBean basebean) {
    weak.get().Success(basebean);
    }

}
