package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/17.
 */
public class AddCartMode {

    public void addData(String uid,String pid){
      String url =  Api.ADD_CART_API+"?uid=" + uid + "&pid="+pid;
        HttpOkUntils.getHttpUtils().OkGet(url, BaseBean.class, new NetClickListener() {
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

    public void setGetDataApi(AddCartMode.getDataApi getDataApi) {
        this.getDataApi = getDataApi;
    }

    public interface getDataApi{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    }


}
