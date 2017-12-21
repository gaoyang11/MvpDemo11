package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/11/17.
 */
public class MorenAddressMode {

    public void getData(String uid,String addrid,String status){

        HttpOkUntils.getHttpUtils().OkGet(Api.MOREN_ADDRESS + "?uid=" + uid + "&addrid=" + addrid + "&status=" + status, BaseBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                    loaddata.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                    loaddata.Error(baseBean);
            }
        });

    }

    loaddata loaddata ;

    public void setLoaddata(MorenAddressMode.loaddata loaddata) {
        this.loaddata = loaddata;
    }

    public  interface loaddata{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    };

}
