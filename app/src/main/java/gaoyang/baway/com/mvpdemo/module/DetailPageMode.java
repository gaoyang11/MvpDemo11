package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.DetailPageBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/12.
 */
public class DetailPageMode {

    public void geteData(int pid){

        HttpOkUntils.getHttpUtils().OkGet(Api.SHOP_XINXI_API + "?pid=" + pid, DetailPageBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                detailPageApi.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                detailPageApi.Error(baseBean);
            }
        });

    }

    private detailPageApi detailPageApi ;

    public void setDetailPageApi(DetailPageMode.detailPageApi detailPageApi) {
        this.detailPageApi = detailPageApi;
    }

    public interface detailPageApi{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    }


}
