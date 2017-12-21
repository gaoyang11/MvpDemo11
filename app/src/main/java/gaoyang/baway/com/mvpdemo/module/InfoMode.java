package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.InfoBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;


/**
 * Created by 15218 on 2017/10/14.
 */
public class InfoMode {

    public  void getInfo(int uid){
        if(uid==0){
            getinfoapi.Error("uid==0");
        }else {
            HttpOkUntils.getHttpUtils().OkGet(Api.USER_INFO_API + "?uid=" + uid, InfoBean.class, new NetClickListener() {
                @Override
                public void Suesses(BaseBean baseBean) {
                        getinfoapi.Success(baseBean);
                }

                @Override
                public void Error(BaseBean baseBean) {
                        getinfoapi.Error(baseBean.getMsg());
                }
            });
        }
        }


    private getinfoapi getinfoapi ;

    public void setGetinfoapi(InfoMode.getinfoapi getinfoapi) {
        this.getinfoapi = getinfoapi;
    }

    public interface getinfoapi{
        void Success(BaseBean baseBean);
        void Error(String msg);
    }

}
