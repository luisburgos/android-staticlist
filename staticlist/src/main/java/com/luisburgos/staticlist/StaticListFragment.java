package com.luisburgos.staticlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisburgos.staticlist.adapter.StaticListRecyclerViewAdapter;

import java.util.List;

/**
 * Created by luisburgos on 10/27/16.
 */

public abstract class StaticListFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected StaticListRecyclerViewAdapter mAdapter;
    protected StaticListRecyclerViewAdapter.OnStaticListItemClickListener optionsListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new StaticListRecyclerViewAdapter(getContext(), setupStaticListItems(), optionsListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getMainLayoutResource(), container, false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        setupRecyclerView();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    protected int getMainLayoutResource() {
        return R.layout.static_list_fragment;
    }

    protected void setupRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)
        );

        bindDataToAdapter();
    }

    private void bindDataToAdapter() {
        mRecyclerView.setAdapter(mAdapter);
    }

    protected abstract List<StaticListItem> setupStaticListItems();

    public void setOptionsListener(StaticListRecyclerViewAdapter.OnStaticListItemClickListener optionsListener) {
        this.optionsListener = optionsListener;
    }

}
