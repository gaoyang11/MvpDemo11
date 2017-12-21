package gaoyang.baway.com.mvpdemo.module;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;

import gaoyang.baway.com.mvpdemo.bean.LoginBean;
import gaoyang.baway.com.mvpdemo.common.Api;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 15218 on 2017/9/27.
 */
public class LoginModle {

   private Handler handler = new Handler();

    public void Login(final String mobile, final String pwd){
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",pwd);
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .post(build)
                .url(Api.LOGIN_API)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response!=null&&response.isSuccessful()){
                    final String result = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //走解析逻辑，解析完成走如下逻辑
                            Gson g = new Gson();
                            LoginBean baseBean = g.fromJson(result, LoginBean.class);
                            if (baseBean.getCode().equals("0")){
                                logini.loginSuccess(baseBean);
                            }else{
                                logini.loginFail(baseBean);
                            }
                        }
                    });
                }
            }
        });

    }


    private LoginI logini ;




    public void setLogini(LoginI logini) {
        this.logini = logini;
    }

    public interface LoginI{
        void loginSuccess(LoginBean baseBean);
        void loginFail(LoginBean baseBean);
    }

}
