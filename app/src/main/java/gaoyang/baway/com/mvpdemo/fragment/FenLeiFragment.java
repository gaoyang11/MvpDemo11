package gaoyang.baway.com.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.adapter.MyFenLeiLftAdapter;
import gaoyang.baway.com.mvpdemo.bean.BaseBean;
import gaoyang.baway.com.mvpdemo.bean.FenLeiBean;
import gaoyang.baway.com.mvpdemo.presenter.HomePresenter;
import gaoyang.baway.com.mvpdemo.untils.NoScrollViewPager;
import gaoyang.baway.com.mvpdemo.untils.ViewUnitls;
import gaoyang.baway.com.mvpdemo.view.HomeView;

/**
 * Created by 15218 on 2017/10/8.
 */
public class FenLeiFragment extends Fragment implements HomeView{


    private RecyclerView recy_left;
    private HomePresenter presenter;
    private NoScrollViewPager vip;
    private List<FenLeiRightFragment> fragments ;
    private MyFenLeiLftAdapter myFenLeiLftAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = ViewUnitls.setVeiw(getActivity(), R.layout.fenlei_layout);

        initView(view);
        loadData();

        return view;

    }

    private void loadData() {
        presenter.LoadData1();
    }

    private void initView(View v) {
        presenter = new HomePresenter(this);
        recy_left =  v.findViewById(R.id.recythree);
        vip =  v.findViewById(R.id.vip1);
        vip.setNoScroll(true);
        fragments = new ArrayList<>();
    }

//hasjhdvahsd

    @Override
    public void Success(BaseBean baseBean) {

    }

    @Override
    public void Erroe(BaseBean baseBean) {

    }

    @Override
    public void Success1(BaseBean baseBean) {
        FenLeiBean fenlei = (FenLeiBean) baseBean;
        List<FenLeiBean.DataBean> data = fenlei.getData();
        recy_left.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        myFenLeiLftAdapter = new MyFenLeiLftAdapter(getActivity(), data);

        recy_left.setAdapter(myFenLeiLftAdapter);
        newFragment(data);
    }

    private void newFragment(List<FenLeiBean.DataBean> data) {

        for (int i = 0 ; i< data.size() ; i++){
            FenLeiRightFragment fragment = new FenLeiRightFragment();
            int cid = data.get(i).getCid();
            Bundle bun = new Bundle();
            bun.putInt("cid",cid);
            fragment.setArguments(bun);
            fragments.add(fragment);
        }

        vip.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        myFenLeiLftAdapter.setOnItemclickListener(new MyFenLeiLftAdapter.OnclickListener() {
            @Override
            public void setOnClickListener(int position) {
               vip.setCurrentItem(position);
            }
        });
    }

    @Override
    public void Erroe1(BaseBean baseBean) {

    }
}
