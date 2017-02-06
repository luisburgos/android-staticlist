package com.luisburgos.staticlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.luisburgos.staticlist.R;
import com.luisburgos.staticlist.StaticListItem;
import com.luisburgos.staticlist.holders.BaseStaticListItemViewHolder;
import com.luisburgos.staticlist.holders.BasicItemViewHolder;
import com.luisburgos.staticlist.holders.BasicRightDetailItemViewHolder;
import com.luisburgos.staticlist.holders.SwitchItemViewHolder;

import java.util.List;

import static com.luisburgos.staticlist.StaticListUtils.checkNotNull;

public class StaticListRecyclerViewAdapter extends RecyclerView.Adapter<BaseStaticListItemViewHolder> {

    private Context mContext;
    private List<StaticListItem> mItems;
    private OnStaticListItemClickListener mListener;


    public StaticListRecyclerViewAdapter(Context context, List<StaticListItem> items) {
        mContext = checkNotNull(context);
        setItems(items);
    }

    public StaticListRecyclerViewAdapter(Context context, List<StaticListItem> items, OnStaticListItemClickListener listener) {
        this(context, items);
        addOnItemClickListener(listener);
    }

    public void addOnItemClickListener(OnStaticListItemClickListener listener) {
        mListener = checkNotNull(listener);
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getRowType().ordinal();
    }

    /**
     * This method creates different RecyclerView.ViewHolder objects based on the item view type.\
     *
     * @param viewGroup ViewGroup container for the item
     * @param viewType type of view to be inflated
     * @return viewHolder to be inflated
     */
    @Override
    public BaseStaticListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        BaseStaticListItemViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        StaticListItem.TYPES rowType = StaticListItem.TYPES.values()[viewType];

        switch (rowType) {
            case SWITCH:
                View viewSwitch = inflater.inflate(R.layout.static_list_item_switch, viewGroup, false);
                viewHolder = new SwitchItemViewHolder(viewSwitch);
                break;
            case BASIC_RIGHT_DETAIL:
                View viewDetail = inflater.inflate(R.layout.static_list_item_basic_right_detail, viewGroup, false);
                viewHolder = new BasicRightDetailItemViewHolder(viewDetail);
                break;
            default:
                View viewBasic = inflater.inflate(R.layout.static_list_item_basic, viewGroup, false);
                viewHolder = new BasicItemViewHolder(viewBasic);
                break;
        }
        return viewHolder;
    }

    /**
     * This method internally calls onBindViewHolder(ViewHolder, int) to update the
     * RecyclerView.ViewHolder contents with the item at the given position
     * and also sets up some private fields to be used by RecyclerView.
     *
     * @param viewHolder The type of RecyclerView.ViewHolder to populate
     * @param position Item position in the viewgroup.
     */
    @Override
    public void onBindViewHolder(BaseStaticListItemViewHolder viewHolder, int position) {
        viewHolder.bind(mItems.get(position), mListener);

        StaticListItem.TYPES rowType = StaticListItem.TYPES.values()[viewHolder.getItemViewType()];

        switch (rowType) {
            case SWITCH:
                SwitchItemViewHolder switchViewHolder = (SwitchItemViewHolder) viewHolder;
                configureSwitchItemViewHolder(switchViewHolder, position);
                break;
            case BASIC_RIGHT_DETAIL:
                BasicRightDetailItemViewHolder basicDetailViewHolder = (BasicRightDetailItemViewHolder) viewHolder;
                configureBasicDetailItemViewHolder(basicDetailViewHolder, position);
                break;
            default:
                BasicItemViewHolder basicViewHolder = (BasicItemViewHolder) viewHolder;
                configureBasicItemViewHolder(basicViewHolder, position);
                break;
        }
    }

    private void configureBasicItemViewHolder(BasicItemViewHolder basicViewHolder, int position) {
        basicViewHolder.staticItemTitleTextView.setText(mItems.get(position).getTitle());
    }

    private void configureBasicDetailItemViewHolder(BasicRightDetailItemViewHolder basicDetailViewHolder, int position) {
        basicDetailViewHolder.staticItemTitleTextView.setText(mItems.get(position).getTitle());
    }

    private void configureSwitchItemViewHolder(SwitchItemViewHolder switchViewHolder, final int position) {
        final StaticListItem item = mItems.get(position);
        switchViewHolder.staticItemTitleTextView.setText(item.getTitle());
        switchViewHolder.notificationSwitch.setChecked((Boolean) item.getValue());
        switchViewHolder.notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //TODO: Verify warnings.
                StaticListItem.SwitchListener listener = (StaticListItem.SwitchListener) item.getListener();
                if(listener != null){
                    listener.onSwitchChange(isChecked);
                }
            }
        });
    }

    private void setItems(List<StaticListItem> items) {
        mItems = checkNotNull(items);
    }

    public interface OnStaticListItemClickListener {
        void onItemClick(StaticListItem item);
    }
}