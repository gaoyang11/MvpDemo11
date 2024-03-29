package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.HomeMode;
import gaoyang.baway.com.mvpdemo.view.HomeView;

/**
 * Created by 15218 on 2017/10/8.
 */
public class HomePresenter implements HomeMode.HomeData,HomeMode.HomeData1{

    private HomeView homeView ;
    private HomeMode homeMode ;

    public  HomePresenter (HomeView homeView){
        this.homeView = homeView;
        homeMode = new HomeMode();
        homeMode.setHomedata(this);
        homeMode.setHomedata1(this);
    }
    public void LoadData(){
        homeMode.HomeLoadData();
    }
    public void LoadData1(){
        homeMode.HomeLoadData1();
    }
    @Override
    public void Success(BaseBean baseBean) {
        homeView.Success(baseBean);
    }
    @Override
    public void Erroe(BaseBean baseBean) {
        homeView.Erroe(baseBean);
    }

    @Override
    public void Success1(BaseBean baseBean) {
        homeView.Success1(baseBean);
    }

    @Override
    public void Erroe1(BaseBean baseBean) {
            homeView.Erroe1(baseBean);
    }
}
