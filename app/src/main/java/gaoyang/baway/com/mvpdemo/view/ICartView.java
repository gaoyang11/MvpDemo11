package gaoyang.baway.com.mvpdemo.view;

/**
 * Created by XP on 2017/10/19.
 */
public interface ICartView {
    //修改购物车中全选按钮的状态
    void changeCheckBtn(boolean flag);
    //计算总价的方法
    void addPrice();
    void addCount();

    void delete(String uid, String pid);
}
