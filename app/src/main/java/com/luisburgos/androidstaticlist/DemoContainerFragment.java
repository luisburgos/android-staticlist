package com.luisburgos.androidstaticlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luisburgos.staticlist.StaticListFragment;
import com.luisburgos.staticlist.StaticListItem;
import com.luisburgos.staticlist.adapter.StaticListRecyclerViewAdapter;


/**
 * Created by luisburgos on 2/4/17.
 */

public class DemoContainerFragment extends Fragment implements StaticListRecyclerViewAdapter.OnStaticListItemClickListener{

    private DemoStaticListFragment staticListFragment;

    public DemoContainerFragment() {

    }

    public static DemoContainerFragment newInstance() {
        Bundle arguments = new Bundle();
        DemoContainerFragment fragment = new DemoContainerFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.demo_container_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        staticListFragment = (DemoStaticListFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.staticListContainer);
        if (staticListFragment == null) {
            staticListFragment = DemoStaticListFragment.newInstance();
            fm.beginTransaction().replace(R.id.staticListContainer, staticListFragment).commit();
        }

        staticListFragment.setOptionsListener(this);
    }

    @Override
    public void onItemClick(StaticListItem item) {
        Log.d("DEMO", "Click item " + String.valueOf(item.getTitle()));
        Toast.makeText(getContext(), "Click item " + String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
    }
}

