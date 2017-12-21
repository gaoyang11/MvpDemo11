package gaoyang.baway.com.mvpdemo.presenter;

import java.lang.ref.WeakReference;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.TakeModle;
import gaoyang.baway.com.mvpdemo.view.TakeView;

/**
 * Created by 15218 on 2017/11/17.
 */
public class TakePresenter implements TakeModle.loaddate{

    private TakeModle takeModle ;
    private WeakReference<TakeView> weak ;

    public TakePresenter(TakeView takeView) {
        this.takeModle = new TakeModle();
        takeModle.setLoaddate(this);
        weak = new WeakReference<TakeView>(takeView);
    }

    public void getData(String uid){
         takeModle.getDaa(uid);
    }

    @Override
    public void Success(BaseBean baseBean) {
        if(baseBean!=null){
            weak.get().Success(baseBean);
        }
    }

    @Override
    public void Error(BaseBean baseBean) {
        weak.get().Error(baseBean);
    }
    public void deatch(){
        weak.clear();
    }

}
