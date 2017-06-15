package com.lynnard.kotlinproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lynnard.kotlinproject.R;
import com.lynnard.kotlinproject.dataClasses.ShoppingItem;
import com.lynnard.kotlinproject.helpers.Boast;
import com.lynnard.kotlinproject.helpers.DatabaseHandler;
import com.lynnard.kotlinproject.interfaces.ItemTouchHelperAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 6/6/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements ItemTouchHelperAdapter {

    public List<ShoppingItem> shoppingItemList = new ArrayList<>();
    private Context context;

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(ViewHolder viewHolder, int position) {
        delete(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName;
        TextView tvItemQuantity;
        TextView tvLabel;

        ViewHolder(View v) {
            super(v);
            tvItemName = (TextView) v.findViewById(R.id.tvItemName);
            tvItemQuantity = (TextView) v.findViewById(R.id.tvQuantity);
            tvLabel = (TextView) v.findViewById(R.id.lblPcs);
        }
    }

    public RecyclerAdapter(List<ShoppingItem> list, Context context) {
        this.shoppingItemList = list;
        this.context = context;
    }

    //public List<ShoppingItem> getShoppingItemList() { return shoppingItemList; }

    @Override
    public int getItemCount() {
        return shoppingItemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShoppingItem item = shoppingItemList.get(position);
        holder.tvItemName.setText(item.getName());
        holder.tvItemQuantity.setText(item.getQuantity());
        holder.tvLabel.setText(item.getLabel());

        /*try{
            Integer quantity = Integer.valueOf(item.getQuantity());
            switch(quantity){
                case 0 : holder.tvLabel.setText("");
                    break;
                case 1 : holder.tvLabel.setText(R.string.pc);
                    break;
                default: holder.tvLabel.setText(R.string.pcs);
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
            holder.tvLabel.setText("");
        }*/

    }


    public void add() {
        shoppingItemList.clear();
        shoppingItemList = new DatabaseHandler(context).getAllItems();
        notifyDataSetChanged();
        Boast.showText(context, "Added");
    }


    public void delete(int position) {
        new DatabaseHandler(context).deleteItem(shoppingItemList.get(position));

        shoppingItemList.clear();
        shoppingItemList = new DatabaseHandler(context).getAllItems();
        notifyDataSetChanged();

        Boast.showText(context, "Item removed!");
    }


}
