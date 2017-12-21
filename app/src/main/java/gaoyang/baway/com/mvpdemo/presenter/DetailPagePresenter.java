package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.DetailPageMode;
import gaoyang.baway.com.mvpdemo.view.DetailPageView;

/**
 * Created by 15218 on 2017/10/12.
 */
public class DetailPagePresenter implements DetailPageMode.detailPageApi {

    private DetailPageMode detailPageMode ;
    private DetailPageView detailPageView ;

    public DetailPagePresenter(DetailPageView detailPageView) {
        this.detailPageMode = new DetailPageMode();
        this.detailPageView = detailPageView;
        detailPageMode.setDetailPageApi(this);
    }

    public void getData(int pid){
        detailPageMode.geteData(pid);
    }

    @Override
    public void Success(BaseBean baseBean) {
        detailPageView.Success(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
        detailPageView.Error(baseBean);
    }
}
