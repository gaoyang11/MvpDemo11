package gaoyang.baway.com.mvpdemo.untils;

import android.content.Context;
import android.view.View;

/**
 * Created by 15218 on 2017/10/8.
 */
public class ViewUnitls {

    public static View setVeiw(Context context,int layout){

        View view = View.inflate(context,layout,null);
        return view ;
    }

}
