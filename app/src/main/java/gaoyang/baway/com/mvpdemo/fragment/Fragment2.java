package gaoyang.baway.com.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gaoyang.baway.com.mvpdemo.R;
import gaoyang.baway.com.mvpdemo.untils.ViewUnitls;

/**
 * Created by 15218 on 2017/10/12.
 */
public class Fragment2 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = ViewUnitls.setVeiw(getActivity(), R.layout.fragment2);



        return view;
    }
}
