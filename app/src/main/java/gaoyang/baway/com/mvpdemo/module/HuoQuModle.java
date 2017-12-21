package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.HuoQuBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/11/17.
 */
public class HuoQuModle {

    public void getData(String uid){

        HttpOkUntils.getHttpUtils().OkGet(Api.GET_MOREN_ADDRESS+"?uid="+uid, HuoQuBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                getDataApi.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                getDataApi.Error(baseBean);
            }
        });

    }

    public getDataApi getDataApi ;

    public void setGetDataApi(HuoQuModle.getDataApi getDataApi) {
        this.getDataApi = getDataApi;
    }

    public interface getDataApi{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    }

}
