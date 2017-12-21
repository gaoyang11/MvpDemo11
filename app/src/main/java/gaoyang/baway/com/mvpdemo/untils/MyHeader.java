package gaoyang.baway.com.mvpdemo.untils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liaoinstan.springview.container.BaseHeader;

import gaoyang.baway.com.mvpdemo.R;

/**
 * Created by 佘鑫海 on 2017/12/11.
 */

public class MyHeader extends BaseHeader {
    //获取Header
    private TextView textView;
    private int i = 0;
    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.springview_item, viewGroup, true);
        textView = view.findViewById(R.id.textView);
        return view;
    }

    //拖拽开始前回调
    @Override
    public void onPreDrag(View rootView) {}

    //手指拖拽过程中不断回调，dy为拖拽的距离，可以根据拖动的距离添加拖动过程动画
    @Override
    public void onDropAnim(View rootView, int dy) {}

    //手指拖拽过程中每次经过临界点时回调，upORdown是向上经过还是向下经过
    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
        i++;
        textView.setText("X "+i);
    }

    //拉动超过临界点后松开时回调
    @Override
    public void onStartAnim() {}

    //头部已经全部弹回时回调
    @Override
    public void onFinishAnim() {
    }
}
