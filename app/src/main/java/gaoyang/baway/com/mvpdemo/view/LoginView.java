package gaoyang.baway.com.mvpdemo.view;

import gaoyang.baway.com.mvpdemo.bean.LoginBean;

public interface LoginView {


    void nameError(String msg);

    void passError(String msg);

    void loginSuccess(LoginBean baseBean);

    void loginFail(LoginBean baseBean);





}