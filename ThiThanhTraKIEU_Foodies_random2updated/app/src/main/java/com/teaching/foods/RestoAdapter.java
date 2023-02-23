package com.teaching.foods;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestoAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Restaurant> myrestaurants;
 public  RestoAdapter(Context context, ArrayList<Restaurant> myrestos){
        mContext=context;
        myrestaurants = myrestos;
    }
    @Override
    public int getCount() {
        return myrestaurants.size();
    }

    @Override
    public Object getItem(int i) {
        return myrestaurants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.listview_resto, null);
        TextView name_addr = v.findViewById(R.id.name_addr);
        TextView rating = v.findViewById(R.id.rating);
        TextView vegan = v.findViewById(R.id.vegan);
        TextView minPrice = v.findViewById(R.id.minPrice);
        TextView time_delivery = v.findViewById(R.id.time_delivery);
        ImageView banner = v.findViewById(R.id.banner);

        if(myrestaurants.get(i).isVegetarian()==true){
           vegan.setText("     ");
            vegan.setBackgroundResource(R.drawable.square_shape);
        }
        name_addr.setText(myrestaurants.get(i).getName() + ", "+ myrestaurants.get(i).getAddress1());
        rating.setText(myrestaurants.get(i).getRating()+"");
        minPrice.setText("$"+myrestaurants.get(i).getMinPrice());
        time_delivery.setText(myrestaurants.get(i).getDeliveryTime());
        banner.setImageResource(myrestaurants.get(i).getBannerImage());
        return v;
    }
}
