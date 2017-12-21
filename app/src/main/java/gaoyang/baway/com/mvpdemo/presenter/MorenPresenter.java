package gaoyang.baway.com.mvpdemo.presenter;

import java.lang.ref.WeakReference;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.MorenAddressMode;
import gaoyang.baway.com.mvpdemo.view.MorenView;

/**
 * Created by 15218 on 2017/11/17.
 */
public class MorenPresenter implements MorenAddressMode.loaddata {

    private MorenAddressMode morenAddressMode ;
    private WeakReference<MorenView> weak ;

    public MorenPresenter(MorenView morenView) {
        this.morenAddressMode = new MorenAddressMode();
        morenAddressMode.setLoaddata(this);
        this.weak = new WeakReference<MorenView>(morenView);
    }



    public  void getData(String uid,String addrid,String status){

        morenAddressMode.getData(uid,addrid,status);

    }

    @Override
    public void Success(BaseBean baseBean) {
            weak.get().Suceess(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
        weak.get().Error(baseBean);
    }
    public void deatch(){
        weak.clear();
    }
}
