package com.teaching.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetailActivity extends AppCompatActivity {
    String[] foodsName;
    int[] foodsLayout;
    EditText bbtea_taro, bbtea_choco, bbtea_matcha, bm_chicken, bm_pork, bm_vege, nem_chicken, nem_pork, nem_vege, mochi_taro, mochi_sakura, mochi_matcha;
    Button addItem1;
    double totalItem=0;
    static int nemPork =0;
    static int nemChicken =0;
    static int nemVege=0;
    static int bmPork=0;
    static int bmChicken=0;
    static int bmVege=0;
    static int bbtTaro=0;
    static int bbtMatcha=0;
    static int bbtChoco=0;
    static int mochiTaro=0;
    static int mochiSakura=0;
    static int mochiMatcha=0;
    static double totalMoneyDA =0;
    static CartList nemporkCA, nemchickenCA,nemvegeCA, bmiporkCA, bmchickenCA, bmvegeCA, bbttaroCA, bbtchocoCA, bbtmachaCA, mochitaroCA, mochimatchaCA, mochisakuraCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        foodsName = new String[]{"pork Nem", "chicken Nem", "vegetarian Nem",
                "pork Banh Mi", "chicken Banh Mi", "vegetarien Banh Mi",
                "taro Bubble Tea", "matcha Bubble Tea", "chocolate Bubble Tea",
                "matcha Mochi", "sakura Mochi", "taro Mochi"};
        foodsLayout = new int[]{R.layout.nem_pork, R.layout.nem_chicken, R.layout.nem_vege,
                R.layout.bm_pork, R.layout.bm_chicken, R.layout.bm_vege,
                R.layout.bbt_taro, R.layout.bbt_matcha, R.layout.bbt_chocolate,
                R.layout.mochi_matcha, R.layout.mochi_sakura, R.layout.mochi_taro,};

        getLayout();

        addItem1 =(Button) findViewById(R.id.button);

        bbtea_choco = findViewById(R.id.quantity_bbtea_choco);
        bbtea_matcha = findViewById(R.id.quantity_bbtea_matcha);
        bbtea_taro = findViewById(R.id.quantity_bbtea_taro);
        bm_chicken = findViewById(R.id.quantity_bm_chicken);
        bm_pork = findViewById(R.id.quantity_bm_pork);
        bm_vege = findViewById(R.id.quantity_bm_vege);
        nem_chicken = findViewById(R.id.quantity_nem_chicken);
        nem_pork = (EditText) findViewById(R.id.quantity_nem_pork);
        nem_vege = findViewById(R.id.quantity_nem_vege);
        mochi_taro = findViewById(R.id.quantity_mochi_taro);
        mochi_matcha = findViewById(R.id.quantity_mochi_matcha);
        mochi_sakura = findViewById(R.id.quantity_mochi_sakura);

        calculate();
    }

    public void getLayout() {
        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra("storedLayout") != null) {
            String s = intent.getStringExtra("storedLayout");
            for (int i = 0; i < foodsName.length; i++) {
                if (foodsName[i].equals(s)) {
                    setContentView(foodsLayout[i]);
                    break;
                }
            }
        }
    }


    public void calculate(){

        addItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalUpdated=0;
                String foodName="";
                String foodQuantity="";
                String foodPrice="";
//NEM PORK
                try {

                    nemPork += Integer.parseInt(nem_pork.getText().toString());
                    foodName="Pork NEM";
                    foodQuantity= ""+nemPork;
                    foodPrice = "$ 1.5";
                    totalItem = Integer.parseInt(nem_pork.getText().toString())*1.5;
                    totalUpdated= nemPork*1.5;

                    nemporkCA = new CartList(foodName, foodQuantity, foodPrice, ""+totalUpdated);

                }catch (Exception e){}
//NEM CHICKEN
                try{
                    nemChicken += Integer.parseInt(nem_chicken.getText().toString());
                    foodName="Chicken NEM";
                    foodQuantity = ""+nemChicken;
                    foodPrice = "$ 1.5";
                    totalItem = Integer.parseInt(nem_chicken.getText().toString())*1.5;
                    totalUpdated = nemChicken*1.5;

                    nemchickenCA = new CartList(foodName, foodQuantity, foodPrice, ""+totalUpdated);

                }catch (Exception e){}
//NEM VEGE
                try{
                    nemVege += Integer.parseInt(nem_vege.getText().toString());
                    foodName="Vege NEM";
                    foodQuantity = ""+nemVege;
                    foodPrice = "$ 1.5";
                    totalItem = Integer.parseInt(nem_vege.getText().toString())*1.5;
                    totalUpdated = nemVege*1.5;

                    nemvegeCA = new CartList(foodName, foodQuantity, foodPrice, ""+totalUpdated);

                }catch (Exception e){}
//BANH MI PORK
                try{
                    bmPork += Integer.parseInt(bm_pork.getText().toString());
                    foodName="Pork BANHMI";
                    foodQuantity = ""+bmPork;
                    foodPrice = "$ 6.5";
                    totalItem = Integer.parseInt(bm_pork.getText().toString())*6.5;
                    totalUpdated = bmPork*6.5;

                    bmiporkCA = new CartList(foodName, foodQuantity, foodPrice, ""+totalUpdated);

                }catch (Exception e){}
//BANH MI CHICKEN
                try {
                    bmChicken += Integer.parseInt(bm_chicken.getText().toString());
                    foodName = "Chicken BANHMI";
                    foodQuantity = "" + bmChicken;
                    foodPrice = "$ 6.5";
                    totalItem = Integer.parseInt(bm_chicken.getText().toString()) * 6.5;
                    totalUpdated = bmChicken * 6.5;

                    bmchickenCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);
                }catch (Exception e){}

//BANH MI VEGE
                try {
                    bmVege += Integer.parseInt(bm_vege.getText().toString());
                    foodName = "Vege BANHMI";
                    foodQuantity = "" + bmVege;
                    foodPrice = "$ 6.5";
                    totalItem = Integer.parseInt(bm_vege.getText().toString()) * 6.5;
                    totalUpdated = bmVege * 6.5;

                    bmvegeCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);

                } catch (Exception e) {
                }
//BBTEA matcha
                try {
                    bbtMatcha += Integer.parseInt(bbtea_matcha.getText().toString());
                    foodName = "Matcha BBTEA";
                    foodQuantity = "" + bbtMatcha;
                    foodPrice = "$ 5.0";
                    totalItem = Integer.parseInt(bbtea_matcha.getText().toString()) * 5;
                    totalUpdated = bbtMatcha * 5;

                    bbtmachaCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);

                } catch (Exception e) {
                }
//BBTEA TARO
                try {
                    bbtTaro += Integer.parseInt(bbtea_taro.getText().toString());
                    foodName = "Taro BBTEA";
                    foodQuantity = "" + bbtTaro;
                    foodPrice = "$ 5.0";
                    totalItem = Integer.parseInt(bbtea_taro.getText().toString()) * 5;
                    totalUpdated = bbtTaro * 5;

                    bbttaroCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);

                } catch (Exception e) {
                }
//BBTEA CHOCO
                try {
                    bbtChoco += Integer.parseInt(bbtea_choco.getText().toString());
                    foodName = "Choco BBTEA";
                    foodQuantity = "" + bbtChoco;
                    foodPrice = "$ 5.0";
                    totalItem = Integer.parseInt(bbtea_choco.getText().toString()) * 5;
                    totalUpdated = bbtChoco * 5;

                    bbtchocoCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);
                } catch (Exception e) {
                }
//MOCHI MATCHA
                try {
                    mochiMatcha += Integer.parseInt(mochi_matcha.getText().toString());
                    foodName = "Matcha MOCHI";
                    foodQuantity = "" + mochiMatcha;
                    foodPrice = "$ 3.5";
                    totalItem = Integer.parseInt(mochi_matcha.getText().toString()) * 3.5;
                    totalUpdated = mochiMatcha * 3.5;

                    mochimatchaCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);
                } catch (Exception e) {
                }
//MOCHI SAKURA
                try {
                    mochiSakura += Integer.parseInt(mochi_sakura.getText().toString());
                    foodName = "Sakura MOCHI";
                    foodQuantity = "" + mochiSakura;
                    foodPrice = "$ 3.5";
                    totalItem = Integer.parseInt(mochi_sakura.getText().toString()) * 3.5;
                    totalUpdated = mochiSakura * 3.5;

                    mochisakuraCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);

                } catch (Exception e) {  }
//MOCHI TARO
                try {
                    mochiTaro += Integer.parseInt(mochi_taro.getText().toString());
                    foodName = "Taro MOCHI";
                    foodQuantity = "" + mochiTaro;
                    foodPrice = "$3.5";
                    totalItem = Integer.parseInt(mochi_taro.getText().toString()) * 3.5;
                    totalUpdated = mochiTaro * 3.5;

                    mochitaroCA = new CartList(foodName, foodQuantity, foodPrice, "" + totalUpdated);

                } catch (Exception e) {}

                    totalMoneyDA += totalItem;

                    if (totalItem != 0) {
                        Toast.makeText(DetailActivity.this, "The item is added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailActivity.this, FoodListActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(totalItem==0) {
            Intent intent = new Intent(DetailActivity.this, FoodListActivity.class);
            startActivity(intent);
            finish();
        }
    }
}








