package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.ChuangJianMode;
import gaoyang.baway.com.mvpdemo.view.ChuanJianview;

/**
 * Created by 15218 on 2017/10/22.
 */
public class CJpresenter implements ChuangJianMode.chuangj {

    private ChuangJianMode chuangJianMode ;
    private ChuanJianview chuanJianview ;

    public CJpresenter( ChuanJianview chuanJianview) {
        this.chuangJianMode = new ChuangJianMode();
        this.chuanJianview = chuanJianview;
        chuangJianMode.setChuangj(this);
    }

    public void getData(String uid,String price){

        chuangJianMode.getData(uid,price);

    }

    @Override
    public void Success(BaseBean baseBean) {
            chuanJianview.Success1(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
            chuanJianview.Error1(baseBean);
    }
}
