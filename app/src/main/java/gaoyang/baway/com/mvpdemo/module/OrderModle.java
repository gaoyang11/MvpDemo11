package gaoyang.baway.com.mvpdemo.module;

import android.content.Context;

import gaoyang.baway.com.mvpdemo.bean.OrderBean;
import gaoyang.baway.com.mvpdemo.untils.RetrofitUntils;
import gaoyang.baway.com.mvpdemo.view.NetClickListener1;

/**
 * Created by 15218 on 2017/11/15.
 */
public class OrderModle {

    public void getData(Context context, String uid){

        RetrofitUntils.getRetrofitUntils(context).get(uid, new NetClickListener1() {
            @Override
            public void Suesses(OrderBean baseBean) {
               loadData.Success(baseBean);
            }
        });

    }

    loadData loadData ;

    public void setLoadData(OrderModle.loadData loadData) {
        this.loadData = loadData;
    }

    public interface loadData{

        void Success(OrderBean basebean);

    }

}
