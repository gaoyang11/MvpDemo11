package gaoyang.baway.com.mvpdemo.presenter;

import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.module.FenLeiMode;
import gaoyang.baway.com.mvpdemo.view.FenLeiView;

/**
 * Created by 15218 on 2017/10/10.
 */
public class FenLeiPresenter implements FenLeiMode.FenLeiapi {

    private FenLeiMode fenLeiMode ;
    public FenLeiView fenLeiView ;

    public FenLeiPresenter(FenLeiView fenLeiView) {
        this.fenLeiMode = new FenLeiMode();
        this.fenLeiView = fenLeiView;
        fenLeiMode.setFenLeiapi(this);
    }

    public void getData(int cid){

        fenLeiMode.getData(cid);

    }


    @Override
    public void Success(BaseBean baseBean) {
            fenLeiView.Success(baseBean);
    }

    @Override
    public void Error(BaseBean baseBean) {
            fenLeiView.Error(baseBean);
    }
}
