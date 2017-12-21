package gaoyang.baway.com.mvpdemo.presenter;

import java.lang.ref.WeakReference;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.UpdateStaOne;
import gaoyang.baway.com.mvpdemo.view.UpdateStaOneView;

/**
 * Created by 15218 on 2017/11/17.
 */
public class UpdateStaOnePresenter implements UpdateStaOne.LoadData {

    private UpdateStaOne updateStaOne ;
    private WeakReference<UpdateStaOneView> weak ;

    public UpdateStaOnePresenter(UpdateStaOneView updateStaOneView) {
        this.updateStaOne = new UpdateStaOne();
        updateStaOne.setLoadData(this);
        weak = new WeakReference<UpdateStaOneView>(updateStaOneView);
    }

    public void getData(String uid,String status,String orderid){
        updateStaOne.getData(uid,status,orderid);
    }

    public void deatch(){
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
