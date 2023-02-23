package com.teaching.myrestaurant;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FoodListActivity extends AppCompatActivity {
    ListView mylist;
    String[] nems = new String[]{"pork Nem", "chicken Nem", "vegetarian Nem"};
    String[] banhmis = new String[]{"pork Banh Mi", "chicken Banh Mi", "vegetarien Banh Mi"};
    String[] bbteas = new String[]{"taro Bubble Tea", "matcha Bubble Tea", "chocolate Bubble Tea"};
    String[] mochis = new String[]{"matcha Mochi", "sakura Mochi", "taro Mochi"};

    TextView total;
    Button seeCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_food_list);

        total = findViewById(R.id.totalFL);
        seeCart = findViewById(R.id.seeCart);

      //  updateTotal();
        total.setText("TOTAL: " + DetailActivity.totalMoneyDA);

        reloadListView();
        getFrameLayout();
        seeCartAct();

        Log.d("FL", "create");
    }

//Create Listview and Click items in Listview
    public void createListView(String[] str) {
        mylist = findViewById(R.id.mylist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview2, str);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = mylist.getItemAtPosition(i).toString();
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("storedLayout", s);
                startActivity(intent);
                //finish();
            }
        });
    }

//Display Listview based on user's choice
    public void getFrameLayout() {
        Intent intent = getIntent();
        String input;
        if (intent != null && intent.getStringExtra("framelayout") != null) {
            input = intent.getStringExtra("framelayout");
            if (input.equals("nem")) createListView(nems);
            else if (input.equals("banhmi")) createListView(banhmis);
            else if (input.equals("bbtea")) createListView(bbteas);
            else createListView(mochis);

            SharedPreferences sf = getSharedPreferences("storedInput", MODE_PRIVATE);
            SharedPreferences.Editor edit = sf.edit();
            edit.putString("storedInputvalue", input);
            edit.apply();
        }
    }

//Reload listview
    public void reloadListView() {
        SharedPreferences sf = getSharedPreferences("storedInput", MODE_PRIVATE);
        String input = sf.getString("storedInputvalue", "");
        if (input.equals("nem")) createListView(nems);
        else if (input.equals("banhmi")) createListView(banhmis);
        else if (input.equals("bbtea")) createListView(bbteas);
        else createListView(mochis);

    }

//Go to CartActivity
    public void seeCartAct(){
        seeCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodListActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("FL", "start");
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(CartActivity.clearStr.equals("clear")){
            //totalMoney =0;
            total.setText("TOTAL: 0.0");
        }
        Log.d("FL", "restart");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.startActivity(new Intent(FoodListActivity.this, MainActivity.class));
        return;
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Log.d("FL", "resume");
//    }
//
//    @Override
//    protected void onPause() {
//
//        super.onPause();
//        Log.d("FL", "pause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//            Log.d("FL", "stop");
//    }
}