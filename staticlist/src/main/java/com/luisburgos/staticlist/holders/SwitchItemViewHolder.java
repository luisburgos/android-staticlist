package com.luisburgos.staticlist.holders;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;

import com.luisburgos.staticlist.R;


/**
 * Created by luisburgos on 10/27/16.
 */
public class SwitchItemViewHolder extends BaseStaticListItemViewHolder {

    public TextView staticItemTitleTextView;
    public SwitchCompat notificationSwitch;

    public SwitchItemViewHolder(View itemView) {
        super(itemView);
        staticItemTitleTextView = (TextView) itemView.findViewById(R.id.staticItemTitleTextView);
        notificationSwitch = (SwitchCompat) itemView.findViewById(R.id.staticListItemSwitch);
    }

    public interface OnSwitchChanged {
        void onChanged(boolean isChecked);
    }

}
