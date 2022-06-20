package com.teaching.myyelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RestoFragmentAdapter extends RecyclerView.Adapter<RestoFragmentAdapter.ViewHolder>{
    ArrayList<Restaurant> myRestos;
    Context context;


    public RestoFragmentAdapter(Context context, ArrayList<Restaurant> myRestos){
        this.myRestos = myRestos;
        this.context = context;

    }

    @NonNull
    @Override
    public RestoFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resto, parent, false);
        //context = parent.getContext();


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestoFragmentAdapter.ViewHolder holder, int position) {
        holder.id.setText("");
        holder.nameofresto.setText(myRestos.get(position).getNameofresto());
        holder.rating.setRating(myRestos.get(position).getRating());
        holder.price.setText(myRestos.get(position).getPrice());
        holder.categorytype.setText(myRestos.get(position).getCategorytype());
        holder.phonenumber.setText(myRestos.get(position).getPhonenumber());
        holder.address.setText(myRestos.get(position).getAddress());

        Glide.with(holder.banner.getContext()).load(myRestos.get(position).getUrl()).into(holder.banner);

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

