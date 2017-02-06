package com.luisburgos.staticlist.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luisburgos.staticlist.StaticListItem;
import com.luisburgos.staticlist.adapter.StaticListRecyclerViewAdapter;

/**
 * Created by luisburgos on 2/5/17.
 */

public class BaseStaticListItemViewHolder extends RecyclerView.ViewHolder {

    public BaseStaticListItemViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(final StaticListItem item, final StaticListRecyclerViewAdapter.OnStaticListItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }
}
