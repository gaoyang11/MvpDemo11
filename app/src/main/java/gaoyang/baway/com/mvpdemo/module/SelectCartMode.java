package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.SelectBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/17.
 */
public class SelectCartMode {

    public void SelectData(String uid){
        String url = Api.SELECT_CART_API + "?uid=" + uid;
        HttpOkUntils.getHttpUtils().OkGet(url, SelectBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                selectDataApi.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                selectDataApi.Error(baseBean);
            }
        });

    }

    public selectDataApi selectDataApi ;

    public void setSelectDataApi(SelectCartMode.selectDataApi selectDataApi) {
        this.selectDataApi = selectDataApi;
    }

    public interface selectDataApi{

        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);

    }


}
