package com.luisburgos.androidstaticlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.luisburgos.staticlist.StaticListFragment;
import com.luisburgos.staticlist.StaticListItem;
import com.luisburgos.staticlist.adapter.StaticListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luisburgos on 2/4/17.
 */

public class MyStaticListFragment extends StaticListFragment implements StaticListRecyclerViewAdapter.OnStaticListItemClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setOptionsListener(this);
    }

    @Override
    protected List<StaticListItem> setupStaticListItems() {
        List<StaticListItem> items = new ArrayList<>();

        items.add(new StaticListItem("Option 1", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));
        items.add(new StaticListItem("Option 2", StaticListItem.TYPES.BASIC));
        items.add(new StaticListItem("Option 3", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));

        return items;
    }

    public static MyStaticListFragment newInstance() {
        Bundle arguments = new Bundle();
        MyStaticListFragment fragment = new MyStaticListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onItemClick(StaticListItem item) {
        Toast.makeText(getContext(), "Click item " + String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
    }
}

