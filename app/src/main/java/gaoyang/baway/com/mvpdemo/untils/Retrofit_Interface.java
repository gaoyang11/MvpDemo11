package gaoyang.baway.com.mvpdemo.untils;

import gaoyang.baway.com.mvpdemo.bean.OrderBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Retrofit_Interface {
    @GET("product/getOrders")//在这里我们用到了Retrofit的get请求
    Observable<OrderBean> getBean(@Query("uid") String uid);
}