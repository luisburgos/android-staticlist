package com.luisburgos.androidstaticlist;

import android.os.Bundle;

import com.luisburgos.staticlist.StaticListFragment;
import com.luisburgos.staticlist.StaticListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luisburgos on 2/4/17.
 */

public class DemoStaticListFragment extends StaticListFragment {

    @Override
    protected List<StaticListItem> setupStaticListItems() {
        List<StaticListItem> items = new ArrayList<>();

        items.add(new StaticListItem("Configuración 1", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));
        items.add(new StaticListItem("Configuración 2", StaticListItem.TYPES.BASIC));
        items.add(new StaticListItem("Configuración 3", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));

        return items;
    }

    public static DemoStaticListFragment newInstance() {
        Bundle arguments = new Bundle();
        DemoStaticListFragment fragment = new DemoStaticListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
}

