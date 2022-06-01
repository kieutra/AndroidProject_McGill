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
    ArrayList<String>arr_nempork, arr_nemchicken, arr_nemvege, arr_bmpork, arr_bmchicken, arr_bmvege, arr_bbtchoco, arr_bbtmatcha, arr_bbttaro, arr_mochitaro, arr_mochisakura, arr_mochimatcha;
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
        arr_nempork = new ArrayList<String>();
        arr_nemchicken = new ArrayList<String>();
        arr_nemvege = new ArrayList<String>();
        arr_bmpork = new ArrayList<String>();
        arr_bmchicken = new ArrayList<String>();
        arr_bmvege = new ArrayList<String>();
        arr_bbtchoco = new ArrayList<String>();
        arr_bbtmatcha = new ArrayList<String>();
        arr_bbttaro = new ArrayList<String>();
        arr_mochimatcha = new ArrayList<String>();
        arr_mochisakura = new ArrayList<String>();
        arr_mochitaro = new ArrayList<String>();

        myListView = (ListView) findViewById(R.id.listViewCart);

        total = findViewById(R.id.totalCA);
        clear=  findViewById(R.id.clear);
        myCart();
        clickClear();
//        Log.d("CA", "create");
        clearStr="";
    }

    public void myCart() {
        //int size = sf.getInt("_size", 0);
//NEM shopping cart
        if(DetailActivity.nemPork !=0) {
            SharedPreferences sf = getSharedPreferences("storednemPork", MODE_PRIVATE);
            for (int i = 0; i < 4; i++)
                arr_nempork.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_nempork.get(0), arr_nempork.get(1), arr_nempork.get(2), arr_nempork.get(3)));
        }
        if(DetailActivity.nemChicken !=0){
        SharedPreferences sf = getSharedPreferences("storednemChicken", MODE_PRIVATE);
        for (int i = 0; i < 4; i++)
            arr_nemchicken.add(sf.getString("_" + i, null));
        myArrayCart.add(new CartList(arr_nemchicken.get(0), arr_nemchicken.get(1), arr_nemchicken.get(2), arr_nemchicken.get(3)));
        }
        if(DetailActivity.nemVege !=0){
        SharedPreferences sf = getSharedPreferences("storednemVege", MODE_PRIVATE);
        for(int i = 0; i < 4; i++)
            arr_nemvege.add(sf.getString("_" + i, null));
        myArrayCart.add(new CartList(arr_nemvege.get(0), arr_nemvege.get(1), arr_nemvege.get(2), arr_nemvege.get(3)));
        }

//BANH MI shopping cart
        if(DetailActivity.bmPork !=0){
            SharedPreferences sf = getSharedPreferences("storedbmPork", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_bmpork.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_bmpork.get(0), arr_bmpork.get(1), arr_bmpork.get(2), arr_bmpork.get(3)));
        }
        if(DetailActivity.bmChicken !=0){
            SharedPreferences sf = getSharedPreferences("storedbmChicken", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_bmchicken.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_bmchicken.get(0), arr_bmchicken.get(1), arr_bmchicken.get(2), arr_bmchicken.get(3)));
        }
        if(DetailActivity.bmVege !=0){
            SharedPreferences sf = getSharedPreferences("storedbmVege", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_bmvege.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_bmvege.get(0), arr_bmvege.get(1), arr_bmvege.get(2), arr_bmvege.get(3)));
        }

//BBTEA shopping cart
        if(DetailActivity.bbtChoco !=0){
            SharedPreferences sf = getSharedPreferences("storedbbtChoco", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_bbtchoco.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_bbtchoco.get(0), arr_bbtchoco.get(1), arr_bbtchoco.get(2), arr_bbtchoco.get(3)));
        }
        if(DetailActivity.bbtMatcha !=0){
            SharedPreferences sf = getSharedPreferences("storedbbtMatcha", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_bbtmatcha.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_bbtmatcha.get(0), arr_bbtmatcha.get(1), arr_bbtmatcha.get(2), arr_bbtmatcha.get(3)));
        }
        if(DetailActivity.bbtTaro !=0){
            SharedPreferences sf = getSharedPreferences("storedbbtTaro", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_bbttaro.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_bbttaro.get(0), arr_bbttaro.get(1), arr_bbttaro.get(2), arr_bbttaro.get(3)));
        }

//MOCHI shopping cart
        if(DetailActivity.mochiMatcha !=0){
            SharedPreferences sf = getSharedPreferences("storedmochiMatcha", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_mochimatcha.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_mochimatcha.get(0), arr_mochimatcha.get(1), arr_mochimatcha.get(2), arr_mochimatcha.get(3)));
        }
        if(DetailActivity.mochiSakura !=0){
            SharedPreferences sf = getSharedPreferences("storedmochiSakura", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_mochisakura.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_mochisakura.get(0), arr_mochisakura.get(1), arr_mochisakura.get(2), arr_mochisakura.get(3)));
        }
        if(DetailActivity.mochiTaro !=0){
            SharedPreferences sf = getSharedPreferences("storedmochiTaro", MODE_PRIVATE);
            for(int i = 0; i < 4; i++)
                arr_mochitaro.add(sf.getString("_" + i, null));
            myArrayCart.add(new CartList(arr_mochitaro.get(0), arr_mochitaro.get(1), arr_mochitaro.get(2), arr_mochitaro.get(3)));
        }

//food items List View
        adapter = new CartListAdapter(this, myArrayCart);
        myListView.setAdapter(adapter);

//calculate Total Shopping Cart
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
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("CA", "start");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("CA", "restart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("CA", "resume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("CA", "pause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("CA", "stop");
//    }
}


