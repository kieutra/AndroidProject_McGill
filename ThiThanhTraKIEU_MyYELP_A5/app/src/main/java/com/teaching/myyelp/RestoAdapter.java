package com.teaching.myyelp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.ViewHolder>{
    ArrayList<Restaurant> myRestos;
    Context context;
    LinearLayout linearLayout;
    final String DB_NAME = "Favorite Restos";
    final String TABLE_NAME = "RESTAURANTS";

    public RestoAdapter(Context context, ArrayList<Restaurant> myRestos){
        this.myRestos = myRestos;
        this.context = context;

    }

    @NonNull
    @Override
    public RestoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resto, parent, false);
        //context = parent.getContext();
        linearLayout = view.findViewById(R.id.restos);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RestoAdapter.ViewHolder holder, int position) {

        holder.id.setText(myRestos.get(position).getId()+"");
        holder.nameofresto.setText(myRestos.get(position).getNameofresto());
        holder.rating.setRating(myRestos.get(position).getRating());
        holder.price.setText(myRestos.get(position).getPrice());
        holder.categorytype.setText(myRestos.get(position).getCategorytype());
        holder.phonenumber.setText(myRestos.get(position).getPhonenumber());
        holder.address.setText(myRestos.get(position).getAddress());

        Glide.with(holder.banner.getContext()).load(myRestos.get(position).getUrl()).into(holder.banner);

 //Click Yes and Add data into Database
        linearLayout.setOnClickListener(new View.OnClickListener() {
            DatabaseHelper db = new DatabaseHelper(context, DB_NAME, null, 1);
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Add to favorites?")
                        .setMessage("Do you want to add this item into your favorite?")
                        .setPositiveButton("YES", (dialogInterface, i) -> {
                            ContentValues restosfavor = new ContentValues();
                            restosfavor.put("NAME", myRestos.get(holder.getAdapterPosition()).nameofresto);
                            restosfavor.put("RATING", myRestos.get(holder.getAdapterPosition()).rating);
                            restosfavor.put("PRICE", myRestos.get(holder.getAdapterPosition()).price);
                            restosfavor.put("CATEGORY", myRestos.get(holder.getAdapterPosition()).categorytype);
                            restosfavor.put("PHONE", myRestos.get(holder.getAdapterPosition()).phonenumber);
                            restosfavor.put("ADDRESS", myRestos.get(holder.getAdapterPosition()).address);
                            restosfavor.put("IMAGE", myRestos.get(holder.getAdapterPosition()).url);

                            db.getWritableDatabase().insert(TABLE_NAME, null, restosfavor);
                            Toast.makeText(context, myRestos.get(holder.getAdapterPosition()).nameofresto +" has been added into Favorites", Toast.LENGTH_SHORT).show();
                        }).setNegativeButton("NO", (dialogInterface, i) -> {
                        });
                builder.create().show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return myRestos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView banner;
        TextView nameofresto;
        RatingBar rating;
        TextView price;
        TextView categorytype;
        TextView phonenumber;
        TextView address;
        TextView id;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            banner = itemView.findViewById(R.id.banner);
            nameofresto = itemView.findViewById(R.id.nameofresto);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);
            categorytype = itemView.findViewById(R.id.categorytype);
            phonenumber = itemView.findViewById(R.id.phonenumber);
            address = itemView.findViewById(R.id.address);
            id = itemView.findViewById(R.id.id);



        }

    }
}
