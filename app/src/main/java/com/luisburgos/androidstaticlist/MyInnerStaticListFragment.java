package com.luisburgos.androidstaticlist;

import android.os.Bundle;

import com.luisburgos.staticlist.StaticListFragment;
import com.luisburgos.staticlist.StaticListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luisburgos on 2/6/17.
 */

public class MyInnerStaticListFragment extends StaticListFragment {

    @Override
    protected List<StaticListItem> setupStaticListItems() {
        List<StaticListItem> items = new ArrayList<>();

        items.add(new StaticListItem("Option 1", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));
        items.add(new StaticListItem("Option 2", StaticListItem.TYPES.BASIC));
        items.add(new StaticListItem("Option 3", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));

        return items;
    }

    public static MyInnerStaticListFragment newInstance() {
        Bundle arguments = new Bundle();
        MyInnerStaticListFragment fragment = new MyInnerStaticListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
}

