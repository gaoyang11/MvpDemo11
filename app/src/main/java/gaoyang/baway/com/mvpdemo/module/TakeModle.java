package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.TakeGoodsBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/11/17.
 */
public class TakeModle {

    public void getDaa(String uid){

        HttpOkUntils.getHttpUtils().OkGet(Api.SELECT_ADDRESS + "?uid=" + uid, TakeGoodsBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                loaddate.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                loaddate.Error(baseBean);
            }
        });

    }

    loaddate loaddate ;

    public void setLoaddate(TakeModle.loaddate loaddate) {
        this.loaddate = loaddate;
    }

    public interface loaddate{

        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);

    };

}
