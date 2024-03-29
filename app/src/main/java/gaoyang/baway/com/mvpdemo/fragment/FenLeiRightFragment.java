package gaoyang.baway.com.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.adapter.MyExpandAdapter;
import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.FenLeiChildBean;
import gaoyang.baway.com.mvpdemo.presenter.FenLeiPresenter;
import gaoyang.baway.com.mvpdemo.untils.ViewUnitls;
import gaoyang.baway.com.mvpdemo.view.FenLeiView;

/**
 * Created by 15218 on 2017/10/10.
 */
public class FenLeiRightFragment extends BaseFragment implements FenLeiView{

    private FenLeiPresenter presenter ;
    private List<List<FenLeiChildBean.DataBean.ListBean>> lsit = new ArrayList<>();
    private ExpandableListView expand;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = ViewUnitls.setVeiw(getActivity(), R.layout.fenlei_right_layout);
        Bundle arguments = getArguments();
        int cid = arguments.getInt("cid");
        //log测试输出
                Log.d("qq","获取的cid " + cid);
        initView(view);
        loadData(cid);
        return view;
    }

    private void loadData(int cid) {
        presenter.getData(cid);
    }
    private void initView(View v) {
        expand = (ExpandableListView) v.findViewById(R.id.expand);
        presenter = new FenLeiPresenter(this);
    }


    @Override
    public void Success(BaseBean baseBean) {
        FenLeiChildBean fenleibean = (FenLeiChildBean) baseBean;
        List<FenLeiChildBean.DataBean> data = fenleibean.getData();
        for (FenLeiChildBean.DataBean dataBean : data){
            List<FenLeiChildBean.DataBean.ListBean> list = dataBean.getList();
            lsit.add(list);
        }
        MyExpandAdapter myexpanadapter = new MyExpandAdapter(data,lsit,getActivity());
        expand.setAdapter(myexpanadapter);
        for (int i = 0 ;i < data.size();i++){

            expand.expandGroup(i);

        }
    }

    @Override
    public void Error(BaseBean baseBean) {

    }

    @Override
    protected void onVisible() {

    }

    @Override
    protected void onInvisible() {

    }
}
