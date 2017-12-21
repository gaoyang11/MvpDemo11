package gaoyang.baway.com.mvpdemo.view;

/**
 * Created by 15218 on 2017/9/27.
 */
public interface RegisterView {

    void nameError(String msg);

    void passError(String msg);

    void registerSuccess(String code,String msg);

    void registerFail(String code,String msg);

}
