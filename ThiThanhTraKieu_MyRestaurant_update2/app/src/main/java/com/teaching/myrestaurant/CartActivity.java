package com.teaching.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CartActivity extends AppCompatActivity {
    ArrayList<CartList> myArrayCart;
    ListView myListView;
    TextView total;
    Button clear;
    static String clearStr="";
    CartListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_cart);

        myArrayCart = new ArrayList<CartList>();
        myListView = (ListView) findViewById(R.id.listViewCart);
        total = findViewById(R.id.totalCA);
        clear=  findViewById(R.id.clear);

        newCart();
        clickClear();

        clearStr="";

    }

    public void newCart(){
        if(DetailActivity.nemPork !=0) {
           myArrayCart.add(DetailActivity.nemporkCA);
        }
        if(DetailActivity.nemChicken !=0) {
            myArrayCart.add(DetailActivity.nemchickenCA);
        }
        if(DetailActivity.nemVege !=0) {
            myArrayCart.add(DetailActivity.nemvegeCA);
        }

        if(DetailActivity.bmPork !=0) {
            myArrayCart.add(DetailActivity.bmiporkCA);
        }
        if(DetailActivity.bmChicken !=0) {
            myArrayCart.add(DetailActivity.bmchickenCA);
        }
        if(DetailActivity.bmVege !=0) {
            myArrayCart.add(DetailActivity.bmchickenCA);

        }
        if(DetailActivity.bbtChoco !=0) {
            myArrayCart.add(DetailActivity.bbtchocoCA);
        }
        if(DetailActivity.bbtTaro !=0) {
            myArrayCart.add(DetailActivity.bbttaroCA);
        }
        if(DetailActivity.bbtMatcha !=0) {
            myArrayCart.add(DetailActivity.bbtmachaCA);
        }

        if(DetailActivity.mochiMatcha !=0) {
            myArrayCart.add(DetailActivity.mochimatchaCA);
        }
        if(DetailActivity.mochiSakura !=0) {
            myArrayCart.add(DetailActivity.mochisakuraCA);
        }
        if(DetailActivity.mochiTaro !=0) {
            myArrayCart.add(DetailActivity.mochitaroCA);
        }

//food items List View
            adapter = new CartListAdapter(this, myArrayCart);
            myListView.setAdapter(adapter);

//Total Shopping Cart
            total.setText("TOTAL: $ "+DetailActivity.totalMoneyDA);
        }

    public void clickClear(){
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myArrayCart.removeAll(myArrayCart);
                adapter.notifyDataSetChanged();

//Set up all static variables =0;
                DetailActivity.nemChicken=0;
                DetailActivity.nemPork=0;
                DetailActivity.nemVege=0;
                DetailActivity.bmVege=0;
                DetailActivity.bmChicken=0;
                DetailActivity.bmPork=0;
                DetailActivity.bbtTaro=0;
                DetailActivity.bbtMatcha=0;
                DetailActivity.bbtChoco=0;
                DetailActivity.mochiTaro=0;
                DetailActivity.mochiSakura=0;
                DetailActivity.mochiMatcha=0;
                DetailActivity.totalMoneyDA=0;

                total.setText("TOTAL: $ 0.0");

                clearStr="clear";
            }
        });
    }
}


