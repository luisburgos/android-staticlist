package com.luisburgos.staticlist;

/**
 * Created by luisburgos on 10/27/16.
 */

public class StaticListItem<Value> {

    private String title;
    private Value value;
    private TYPES rowType;
    private StaticListItemListener listener;

    public StaticListItem(String title, TYPES rowType) {
        this.title = title;
        this.rowType = rowType;
    }

    public StaticListItem(String title, TYPES rowType, StaticListItemListener listener) {
        this.title = title;
        this.rowType = rowType;
        this.listener = listener;
    }

    public TYPES getRowType() {
        return rowType;
    }

    public String getTitle() {
        return title;
    }

    public StaticListItemListener getListener() {
        return listener;
    }

    public static enum TYPES {
        BASIC(0),
        BASIC_RIGHT_DETAIL(1),
        SWITCH(2);

        private final int value;

        TYPES(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }

    //TODO: Verify and evaluate refactor.
    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    //TODO: Evaluate listeners definition extraction.
    public interface StaticListItemListener {

    }

    public interface SwitchListener extends StaticListItemListener {
        void onSwitchChange(boolean isChecked);
    }

}
