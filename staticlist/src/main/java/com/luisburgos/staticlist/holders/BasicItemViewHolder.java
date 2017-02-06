package com.luisburgos.staticlist.holders;

import android.view.View;
import android.widget.TextView;

import com.luisburgos.staticlist.R;

/**
 * Created by luisburgos on 10/27/16.
 */
public class BasicItemViewHolder extends BaseStaticListItemViewHolder {

    public TextView staticItemTitleTextView;

    public BasicItemViewHolder(View itemView) {
        super(itemView);
        staticItemTitleTextView = (TextView) itemView.findViewById(R.id.staticItemTitleTextView);
    }

}
