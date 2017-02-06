package com.luisburgos.androidstaticlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luisburgos.staticlist.StaticListItem;
import com.luisburgos.staticlist.adapter.StaticListRecyclerViewAdapter;


/**
 * Created by luisburgos on 2/4/17.
 */

public class MyContainerFragment extends Fragment implements StaticListRecyclerViewAdapter.OnStaticListItemClickListener{

    private MyInnerStaticListFragment staticListFragment;

    public MyContainerFragment() {

    }

    public static MyContainerFragment newInstance() {
        Bundle arguments = new Bundle();
        MyContainerFragment fragment = new MyContainerFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        staticListFragment = (MyInnerStaticListFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.staticListContainer);
        if (staticListFragment == null) {
            staticListFragment = MyInnerStaticListFragment.newInstance();
            fm.beginTransaction().replace(R.id.staticListContainer, staticListFragment).commit();
        }

        staticListFragment.setOptionsListener(this);
    }

    @Override
    public void onItemClick(StaticListItem item) {
        Toast.makeText(getContext(), "Click item " + String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
    }
}

