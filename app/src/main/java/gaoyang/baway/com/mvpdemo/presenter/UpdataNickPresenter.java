package gaoyang.baway.com.mvpdemo.presenter;

import java.lang.ref.WeakReference;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.UpdataNickName;
import gaoyang.baway.com.mvpdemo.view.UpdataNickNameView;

/**
 * Created by 15218 on 2017/11/16.
 */
public class UpdataNickPresenter implements UpdataNickName.GetData {

    private UpdataNickName nickName ;
    private WeakReference<UpdataNickNameView> weak ;

    public UpdataNickPresenter(UpdataNickNameView view) {
        this.nickName = new UpdataNickName();
        nickName.setGetData(this);
        weak = new WeakReference<UpdataNickNameView>(view);
    }

    public void updata(String uid,String name){
        nickName.updataName(uid,name);
    }

    @Override
    public void Success(BaseBean baseBean) {
        weak.get().UpdataSuccess(baseBean);
    }
    public void detach(){
        weak.clear();
    }
}
