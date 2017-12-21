package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/11/17.
 */
public class UpdateStaOne  {

    public void getData(String uid,String status,String orderid){

        HttpOkUntils.getHttpUtils().OkGet(Api.UPDATE_ORDER_STATUS + "?uid=" + uid + "&status=" + status + "&orderid=" + orderid, BaseBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                loadData.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
loadData.Error(baseBean);
            }
        });

    }

    LoadData loadData ;

    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }

    public interface LoadData{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    }


}
