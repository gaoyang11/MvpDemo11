package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/11/16.
 */
public class UpdataNickName {

    public void updataName(String uid,String nickname){

        HttpOkUntils.getHttpUtils().OkGet(Api.UPDATA_NICKNAME+"?uid="+uid+"&nickname="+nickname, BaseBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                getData.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {

            }
        });

    }

    GetData getData ;

    public void setGetData(GetData getData) {
        this.getData = getData;
    }

    public interface GetData{
        void Success(BaseBean baseBean);
    }

}
