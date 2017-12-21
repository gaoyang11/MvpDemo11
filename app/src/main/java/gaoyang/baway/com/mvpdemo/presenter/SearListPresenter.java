package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.SearchListmode;
import gaoyang.baway.com.mvpdemo.view.SearListView;

/**
 * Created by 15218 on 2017/10/12.
 */
public class SearListPresenter implements SearchListmode.searListapi {

    private SearchListmode searchListmode ;
    private SearListView searListView ;

    public SearListPresenter(SearListView searListView) {
        this.searchListmode = new SearchListmode();
        this.searListView = searListView;
        searchListmode.setSearListapi(this);
    }

    public void getData(String ketwords){
        searchListmode.getData(ketwords);
    }

    @Override
    public void Success(BaseBean baseBean) {
        searListView.Success(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
        searListView.Error(baseBean);
    }

}
