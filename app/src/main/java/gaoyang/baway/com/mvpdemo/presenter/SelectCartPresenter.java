package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.SelectCartMode;
import gaoyang.baway.com.mvpdemo.view.SelectCartView;

/**
 * Created by 15218 on 2017/10/17.
 */
public class SelectCartPresenter implements SelectCartMode.selectDataApi {


    private SelectCartView selectCartView ;
    private SelectCartMode selectCartMode ;

    public SelectCartPresenter(SelectCartView selectCartView) {
        this.selectCartView = selectCartView;
        this.selectCartMode = new SelectCartMode();
        selectCartMode.setSelectDataApi(this);
    }

    public void selectData(String uid){
        selectCartMode.SelectData(uid);
    }

    @Override
    public void Success(BaseBean baseBean) {
        selectCartView.Success(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
        selectCartView.Error(baseBean);
    }
}
