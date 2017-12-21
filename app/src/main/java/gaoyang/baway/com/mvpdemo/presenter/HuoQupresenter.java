package gaoyang.baway.com.mvpdemo.presenter;

import java.lang.ref.WeakReference;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.HuoQuModle;
import gaoyang.baway.com.mvpdemo.view.HuoQuView;

/**
 * Created by 15218 on 2017/10/22.
 */
public class HuoQupresenter implements HuoQuModle.getDataApi {

    private HuoQuModle chuangJianMode ;
    private WeakReference<HuoQuView> weak ;

    public HuoQupresenter(HuoQuView chuanJianview) {
        this.chuangJianMode = new HuoQuModle();
        this.weak = new WeakReference<HuoQuView>(chuanJianview);
        chuangJianMode.setGetDataApi(this);
    }

    public void getData(String uid){

        chuangJianMode.getData(uid);

    }

    public void detaach (){
        weak.clear();
    }

    @Override
    public void Success(BaseBean baseBean) {
            weak.get().Success(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
        weak.get().Error(baseBean);
    }
}
