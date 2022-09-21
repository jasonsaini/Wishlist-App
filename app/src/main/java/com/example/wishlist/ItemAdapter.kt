package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class ItemAdapter(private val items: List<WishlistItem>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Create member variables for any view that will set row renders.
        val nameTextView : TextView;
        val priceTextView : TextView;
        val urlTextView : TextView;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Store each of the layout's views into the public final member variables created above
            nameTextView = itemView.findViewById(R.id.nameText);
            priceTextView = itemView.findViewById(R.id.priceText);
            urlTextView = itemView.findViewById(R.id.itemURLText);

        }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val context = parent.context;
         val inflater = LayoutInflater.from(context);
         val itemView = inflater.inflate(R.layout.item_layout, parent, false);
         return ViewHolder(itemView);
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val curItem = items.get(position)

         holder.nameTextView.text = curItem.itemName;
         holder.urlTextView.text = curItem.itemURL;
         holder.priceTextView.text = "$ " + curItem.price;

     }

     override fun getItemCount(): Int {
         return items.size;
     }
 }