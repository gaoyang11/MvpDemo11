package gaoyang.baway.com.mvpdemo.untils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 15218 on 2017/10/8.
 */
public class ToastUntils {

    public static  void setToast(Context context,String s){
         //吐司事件
          Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }

}
