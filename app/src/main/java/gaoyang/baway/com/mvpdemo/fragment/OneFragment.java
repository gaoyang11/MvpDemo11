package gaoyang.baway.com.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.adapter.MyOneAdapter;
import gaoyang.baway.com.mvpdemo.bean.OrderBean;
import gaoyang.baway.com.mvpdemo.presenter.OrderPresenter;
import gaoyang.baway.com.mvpdemo.untils.SpUtils;
import gaoyang.baway.com.mvpdemo.view.OrderView;

/**
 * Created by 15218 on 2017/11/14.
 */
public class OneFragment extends Fragment implements OrderView{

    private OrderPresenter orderPresenter ;
    MyOneAdapter oneadapter ;
    private RecyclerView recy;
    private RelativeLayout lin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.onefragment,null);
        //查找控件
        initViw(view);
        //加载数据
        loadData();

        return view;
    }

    private void loadData() {
        //请求网络
        orderPresenter.getData(getActivity(),SpUtils.getSpUid(getActivity())+"");
    }

    private void initViw(View v) {
        orderPresenter = new OrderPresenter(this);
        recy = v.findViewById(R.id.recy1);
        lin = v.findViewById(R.id.linear1);
    }

    @Override
    public void Success(OrderBean baseBean) {
        OrderBean orderbean =  baseBean;
        List<OrderBean.DataBean> data = orderbean.getData();
        if(data!=null&&data.size()!=0){
            recy.setVisibility(View.VISIBLE);
            lin.setVisibility(View.GONE);
            oneadapter = new MyOneAdapter(getActivity(),data);
            recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            recy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
            recy.setAdapter(oneadapter);
        }else {
            recy.setVisibility(View.GONE);
            lin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        orderPresenter.deatch();
    }
}
