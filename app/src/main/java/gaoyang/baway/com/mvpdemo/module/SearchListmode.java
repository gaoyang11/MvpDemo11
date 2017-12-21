package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.SearListBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/12.
 */
public class SearchListmode {

    public void getData(String keywords){

        HttpOkUntils.getHttpUtils().OkGet(Api.SEARCH_API + "?keywords=" + keywords + "&source=android", SearListBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                searListapi.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                searListapi.Error(baseBean);
            }
        });

    }

    private searListapi searListapi ;

    public void setSearListapi(SearchListmode.searListapi searListapi) {
        this.searListapi = searListapi;
    }

    public interface searListapi{
        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);
    }

}
