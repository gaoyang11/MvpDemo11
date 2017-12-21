package gaoyang.baway.com.mvpdemo.module;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.FenLeiChildBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import gaoyang.baway.com.mvpdemo.untils.HttpOkUntils;
import gaoyang.baway.com.mvpdemo.untils.NetClickListener;

/**
 * Created by 15218 on 2017/10/10.
 */
public class FenLeiMode {

    public void getData(int cid){

        HttpOkUntils.getHttpUtils()
                .OkGet(Api.FENLEI_CHILD_API+"?"+"cid="+cid, FenLeiChildBean.class, new NetClickListener() {
                    @Override
                    public void Suesses(BaseBean baseBean) {
                        fenLeiapi.Success(baseBean);
                    }

                    @Override
                    public void Error(BaseBean baseBean) {
                        fenLeiapi.Error(baseBean);
                    }
                });

    }

    private FenLeiapi fenLeiapi ;

    public void setFenLeiapi(FenLeiapi fenLeiapi) {
        this.fenLeiapi = fenLeiapi;
    }

    public interface FenLeiapi{

        void Success(BaseBean baseBean);
        void Error(BaseBean baseBean);

    }


}
