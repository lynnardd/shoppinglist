package com.lynnard.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.InputType
import android.util.Log
import android.widget.*
import com.lynnard.kotlinproject.adapter.KotlinRecyclerAdapter
import com.lynnard.kotlinproject.dataClasses.ShoppingItem
import com.lynnard.kotlinproject.helpers.DatabaseHandler
import com.lynnard.kotlinproject.helpers.SimpleItemTouchHelperCallback

open class MainActivity : AppCompatActivity() {

    private lateinit var addItem: FloatingActionButton
    private lateinit var shoppingRecycler: RecyclerView
    private lateinit var touchHelper: ItemTouchHelper
    //private val fragmentManager : android.support.v4.app.FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        addItem = findViewById(R.id.btnAddItem) as FloatingActionButton
        shoppingRecycler = findViewById(R.id.recyclerView) as RecyclerView
    }

    override fun onStop() {
        super.onStop()
    }


    override fun onStart() {
        super.onStart()

        val handler: DatabaseHandler = DatabaseHandler(this@MainActivity)
        val adapter = KotlinRecyclerAdapter(handler.allItems as ArrayList<ShoppingItem>, this@MainActivity)
        val callback:ItemTouchHelper.Callback = SimpleItemTouchHelperCallback(adapter)
        touchHelper = ItemTouchHelper(callback)
        shoppingRecycler.adapter = adapter
        shoppingRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        touchHelper.attachToRecyclerView(shoppingRecycler)

        addItem.setOnClickListener {
            val layout: LinearLayout = LinearLayout(this@MainActivity)
            layout.orientation = LinearLayout.VERTICAL

            val builder = android.app.AlertDialog.Builder(this)
            val itemInput: EditText = EditText(this@MainActivity)
            itemInput.hint = "Item name"
            itemInput.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            val quantityInput: EditText = EditText(this@MainActivity)
            quantityInput.hint = "Quantity"
            quantityInput.inputType = InputType.TYPE_CLASS_NUMBER
            val unit : Spinner = Spinner(this@MainActivity)
            val mAdapter = ArrayAdapter.createFromResource(this@MainActivity, R.array.labels, android.R.layout.simple_spinner_item)//ArrayAdapter<String>(this@MainActivity, R.array.labels, android.R.layout.simple_spinner_dropdown_item)
            mAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            unit.adapter = mAdapter

            layout.addView(itemInput)
            layout.addView(quantityInput)
            layout.addView(unit)
            val dialog = builder
                    .setTitle("Add an item")
                    .setView(layout)
                    .setPositiveButton("Add", { _, _ ->
                        handler.addItem(ShoppingItem(itemInput.text.toString(), quantityInput.text.toString(), unit.selectedItem.toString()))
                        (shoppingRecycler.adapter as KotlinRecyclerAdapter).add()
                        Log.d("added", itemInput.text.toString() + " " + quantityInput.text.toString() + " " + unit.selectedItem.toString())
                    })
                    .setNegativeButton("Cancel", { _, _ -> })
                    .show()
        }
    }

    override fun onResume() {
        super.onResume()
    }
}

