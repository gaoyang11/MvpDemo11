package gaoyang.baway.com.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.adapter.MyTwoAdapter;
import gaoyang.baway.com.mvpdemo.bean.OrderBean;
import gaoyang.baway.com.mvpdemo.presenter.OrderPresenter;
import gaoyang.baway.com.mvpdemo.untils.SpUtils;
import gaoyang.baway.com.mvpdemo.view.OrderView;

/**
 * Created by 15218 on 2017/11/14.
 */
public class TwoFragment extends Fragment implements OrderView{

    private RelativeLayout relv;
    private RecyclerView recy;
    private OrderPresenter orderPresenter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.twofragment,null);
        initViw(view);
        loadData();

        return view;
    }

    private void loadData() {
            orderPresenter.getData(getActivity(), SpUtils.getSpUid(getActivity())+"");
    }

    private void initViw(View view) {

        relv = view.findViewById(R.id.linear1);
        recy = view.findViewById(R.id.recy1);
        orderPresenter = new OrderPresenter(this);

    }

    @Override
    public void Success(OrderBean baseBean) {

        List<OrderBean.DataBean> data = baseBean.getData();

        for (int j = 0; j < data.size(); j++){
            if(data.get(j).getStatus()!=0){
                data.remove(data.get(j));
            }
        }
        //log测试输出
        Log.d("qq","待支付的长度：" + data.size());
        if(data!=null&&data.size()!=0){
            recy.setVisibility(View.VISIBLE);
            recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            recy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
            recy.setAdapter(new MyTwoAdapter(getActivity(),data));
        }else {
            relv.setVisibility(View.VISIBLE);
        }
    }
}
