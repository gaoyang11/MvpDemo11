package gaoyang.baway.com.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gaoyang.baway.com.mvpdemo.R;


/**
 * Created by 15218 on 2017/11/14.
 */
public class ThreeFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.threefragment,null);
        initViw(view);


        return view;
    }

    private void initViw(View v) {



    }
}
