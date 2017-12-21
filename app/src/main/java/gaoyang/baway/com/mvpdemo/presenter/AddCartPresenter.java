package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.AddCartMode;
import gaoyang.baway.com.mvpdemo.view.AddCartView;

/**
 * Created by 15218 on 2017/10/17.
 */
public class AddCartPresenter implements AddCartMode.getDataApi{

    private AddCartMode addCartMode ;
    private AddCartView addCartView ;

    public AddCartPresenter(AddCartView addCartView) {
        this.addCartMode = new AddCartMode();
        this.addCartView = addCartView;
        addCartMode.setGetDataApi(this);
    }

    public void addData(String uid,String pid){
        addCartMode.addData(uid,pid);
    }

    @Override
    public void Success(BaseBean baseBean) {
        addCartView.addSuccess(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
        addCartView.addError(baseBean);
    }
}
