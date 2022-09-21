package com.example.wishlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemRecyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        var items : MutableList<WishlistItem> = mutableListOf();
        var nameVal:String;
        var priceVal:String;
        var urlVal:String;

        val submitBtn = findViewById<Button>(R.id.submitBtn);

        val nameEntry = findViewById<EditText>(R.id.nameEntry);
        val priceEntry = findViewById<EditText>(R.id.priceEntry);
        val urlEntry = findViewById<EditText>(R.id.urlEntry);

        submitBtn.setOnClickListener{
            nameVal = nameEntry.text.toString().trim();
            priceVal = priceEntry.text.toString().trim();
            urlVal = urlEntry.text.toString().trim();


            if(nameVal == "" || priceVal == "" || urlVal == "")
            {
                return@setOnClickListener;
            }

            var newItem = WishlistItem(nameVal, urlVal, priceVal);

            items.add(newItem);

            val adapter = ItemAdapter(items);

            itemRecyclerView.adapter = adapter;
            itemRecyclerView.layoutManager = LinearLayoutManager(this);
            setContentView(R.layout.activity_main)
        }



    }

}