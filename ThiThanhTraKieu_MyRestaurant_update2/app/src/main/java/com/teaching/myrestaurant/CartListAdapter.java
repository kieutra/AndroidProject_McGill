package com.teaching.myrestaurant;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CartListAdapter extends BaseAdapter{
Context mContext;
ArrayList<CartList> myArrayCart;

CartListAdapter(Context context, ArrayList<CartList> arrayCart){
    mContext = context;
    myArrayCart = arrayCart;
}

    @Override
    public int getCount() {
        return myArrayCart.size();
    }

    @Override
    public Object getItem(int i) {
        return myArrayCart.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    View v = View.inflate(mContext, R.layout.cartactivity_listview, null);
        TextView foodName = v.findViewById(R.id.foodName3);
        TextView quantity = v.findViewById(R.id.quantity3);
        TextView price= v.findViewById(R.id.price3);
        TextView totalItem = v.findViewById(R.id.totalItem3);

        foodName.setText(myArrayCart.get(i).getFoodName());
        quantity.setText(myArrayCart.get(i).getQuantity());
        price.setText(myArrayCart.get(i).getPrice());
        totalItem.setText(myArrayCart.get(i).getTotal3());
        return v;
    }
}