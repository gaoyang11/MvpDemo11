package gaoyang.baway.com.mvpdemo.view;


import gaoyang.baway.com.mvpdemo.bean.BaseBean;

/**
 * Created by 15218 on 2017/10/14.
 */
public interface InfoView {

    void Success(BaseBean baseBean);
    void Error(String msg);

}
