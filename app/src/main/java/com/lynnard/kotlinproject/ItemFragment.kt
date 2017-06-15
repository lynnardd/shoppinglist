package com.lynnard.kotlinproject

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.lynnard.kotlinproject.adapter.RecyclerAdapter
import com.lynnard.kotlinproject.dataClasses.ShoppingItem
import com.lynnard.kotlinproject.helpers.DatabaseHandler
import com.lynnard.kotlinproject.helpers.SimpleItemTouchHelperCallback

/**
 * Created by gerard on 6/15/2017.
 */
class ItemFragment : DialogFragment() {

    private lateinit var itemName : EditText
    private lateinit var itemQuantity : EditText
    private lateinit var itemType : Spinner
    private lateinit var itemAdd : Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.item_fragment, container, false)

        itemName = view.findViewById(R.id.edtItemName) as EditText
        itemQuantity = view.findViewById(R.id.edtitemQuantity) as EditText
        itemType = view.findViewById(R.id.drpLabel) as Spinner
        itemAdd = view.findViewById(R.id.btnAddItem) as Button



        itemAdd.setOnClickListener {
            val handler: DatabaseHandler = DatabaseHandler(activity)
            val adapter = RecyclerAdapter(handler.allItems, activity)

            //handler.addItem(ShoppingItem(itemName.text.toString(), itemQuantity.text.toString()))
        }


        return view
    }

}