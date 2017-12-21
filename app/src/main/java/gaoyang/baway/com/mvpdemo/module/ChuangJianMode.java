package gaoyang.baway.com.mvpdemo.module;

import android.util.Log;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/22.
 */
public class ChuangJianMode {

    public void getData(String uid,String price){
        String url = Api.CHUANGJIAN + "?uid=" + uid+ "&price=" + price ;
        //log测试输出
                Log.d("liuhao","string: " + url);
        HttpOkUntils.getHttpUtils().OkGet(url, BaseBean.class, new NetClickListener() {
            @Override
            public void Suesses(BaseBean baseBean) {
                chuangj.Success(baseBean);
            }

            @Override
            public void Error(BaseBean baseBean) {
                chuangj.Error(baseBean);
            }
        });

    }
    chuangj chuangj ;

    public void setChuangj(ChuangJianMode.chuangj chuangj) {
        this.chuangj = chuangj;
    }

    public interface chuangj {

        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);

    }
}
