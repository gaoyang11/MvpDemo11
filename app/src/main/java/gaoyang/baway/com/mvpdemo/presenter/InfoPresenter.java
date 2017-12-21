package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.InfoMode;
import gaoyang.baway.com.mvpdemo.view.InfoView;


/**
 * Created by 15218 on 2017/10/14.
 */
public class InfoPresenter implements InfoMode.getinfoapi {
    private InfoMode infoMode ;
    private InfoView infoView ;

    public InfoPresenter(InfoView infoView) {
        this.infoMode = new InfoMode();
        this.infoView = infoView;
        infoMode.setGetinfoapi(this);
    }
    public void getInfo(int uid){
        infoMode.getInfo(uid);
    }
    @Override
    public void Success(BaseBean baseBean) {
            infoView.Success(baseBean);
    }


    @Override
    public void Error(String msg) {
            infoView.Error(msg);
    }
}
