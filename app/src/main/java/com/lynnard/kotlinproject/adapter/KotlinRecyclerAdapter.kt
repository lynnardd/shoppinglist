package com.lynnard.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lynnard.kotlinproject.R
import com.lynnard.kotlinproject.dataClasses.ShoppingItem
import com.lynnard.kotlinproject.helpers.Boast
import com.lynnard.kotlinproject.helpers.DatabaseHandler
import com.lynnard.kotlinproject.interfaces.ItemTouchHelperAdapter

/**
 * Created by gerard on 6/15/2017.
 */

class KotlinRecyclerAdapter(private var items: ArrayList<ShoppingItem>, private val context: Context) : RecyclerView.Adapter<KotlinRecyclerAdapter.ViewHolder>(), ItemTouchHelperAdapter {

    class ViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v) {
        internal var tvItemName: TextView = v.findViewById(R.id.tvItemName) as TextView
        internal var tvItemQuantity: TextView = v.findViewById(R.id.tvQuantity) as TextView
        internal var tvLabel: TextView = v.findViewById(R.id.lblPcs) as TextView
    }

    /**
     *
     * RecyclerView Adapter Functions
     *
     * */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): KotlinRecyclerAdapter.ViewHolder =
            KotlinRecyclerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.card, parent, false))


    override fun onBindViewHolder(holder: KotlinRecyclerAdapter.ViewHolder?, position: Int) {
        holder!!.tvItemName.text = items[position].name
        holder.tvItemQuantity.text = items[position].quantity
        holder.tvLabel.text = items[position].label
    }

    override fun getItemCount(): Int = items.size

    /*************************************/

    /**
     *
     * Item Touch Helper Adapter Functions
     *
     * */
    override fun onItemDismiss(viewHolder: KotlinRecyclerAdapter.ViewHolder?, position: Int) = delete(position)

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean = false

    /*************************************/

    /**
     *
     * Database Functions
     *
     * */
    fun add(){
        items.clear()
        items = DatabaseHandler(context).allItems as ArrayList<ShoppingItem>
        notifyDataSetChanged()

        Boast.showText(context, "Item Added!")
    }

    fun delete(position: Int){
        DatabaseHandler(context).deleteItem(items[position])
        items.clear()
        items = DatabaseHandler(context).allItems as ArrayList<ShoppingItem>
        notifyDataSetChanged()

        Boast.showText(context, "Item bought!")
    }
}