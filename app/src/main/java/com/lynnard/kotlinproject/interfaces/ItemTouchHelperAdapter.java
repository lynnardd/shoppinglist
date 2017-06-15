package com.lynnard.kotlinproject.interfaces;

import com.lynnard.kotlinproject.adapter.RecyclerAdapter;

/**
 * Created by gerard on 6/6/2017.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(RecyclerAdapter.ViewHolder viewHolder, int position);
}
