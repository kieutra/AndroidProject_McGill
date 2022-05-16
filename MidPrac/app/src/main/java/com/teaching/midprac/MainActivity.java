package com.teaching.midprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText e_milk, e_egg, e_beef, e_soda, e_biscuit, e_fruit, e_veges;
    CheckBox check_milk, check_eggs, check_beef, check_soda, check_biscuit, check_fruit, check_veges;
    TextView sum;
    Button check_out;
    ArrayList<CheckBox> checkBoxes;
    ArrayList<Integer> quantities;
    ArrayList<Double> prices;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateTotal();
    }

    private void shoppingCart() {

        e_milk = findViewById(R.id.E_milk);
        e_egg = findViewById(R.id.E_egg);
        e_beef = findViewById(R.id.E_beef);
        e_soda = findViewById(R.id.E_soda);
        e_biscuit = findViewById(R.id.E_biscuit);
        e_fruit = findViewById(R.id.E_fruit);
        e_veges = findViewById(R.id.E_veges);
        check_milk = findViewById(R.id.checkMilk);
        check_eggs = findViewById(R.id.checkEgg);
        check_beef = findViewById(R.id.checkBeef);
        check_soda = findViewById(R.id.checkSoda);
        check_biscuit = findViewById(R.id.checkBiscuit);
        check_fruit = findViewById(R.id.checkFruit);
        check_veges = findViewById(R.id.checkVeges);

        checkBoxes = new ArrayList<CheckBox>();
        checkBoxes.add(check_milk);
        checkBoxes.add(check_eggs);
        checkBoxes.add(check_beef);
        checkBoxes.add(check_soda);
        checkBoxes.add(check_biscuit);
        checkBoxes.add(check_fruit);
        checkBoxes.add(check_veges);

        quantities = new ArrayList<Integer>();
        for (int i = 0; i < checkBoxes.size(); i++) {
            quantities.add(0);
        }
        try {
            quantities.set(0, Integer.parseInt(e_milk.getText().toString()));
        } catch (Exception e) {
        }
        try {
            quantities.set(1, Integer.parseInt(e_egg.getText().toString()));
        } catch (Exception e) {
        }
        try {
            quantities.set(2, Integer.parseInt(e_beef.getText().toString()));
        } catch (Exception e) {
        }
        try {
            quantities.set(3, Integer.parseInt(e_soda.getText().toString()));
        } catch (Exception e) {
        }
        try {
            quantities.set(4, Integer.parseInt(e_biscuit.getText().toString()));
        } catch (Exception e) {
        }
        try {
            quantities.set(5, Integer.parseInt(e_fruit.getText().toString()));
        } catch (Exception e) {
        }
        try {
            quantities.set(6, Integer.parseInt(e_veges.getText().toString()));
        } catch (Exception e) {
        }

            prices = new ArrayList<Double>();

            double milk_price = 3;
            double eggs_price = 2;
            double beef_price = 23;
            double soda_price = 1;
            double biscuit_price = 2.5;
            double fruit_price = 6.5;
            double veges_price = 4;
            prices.add(milk_price);
            prices.add(eggs_price);
            prices.add(beef_price);
            prices.add(soda_price);
            prices.add(biscuit_price);
            prices.add(fruit_price);
            prices.add(veges_price);

            total = 0;
            for (int i = 0; i < checkBoxes.size(); i++) {
                if (checkBoxes.get(i).isChecked() && quantities.get(i) != 0) {
                    total = total + quantities.get(i) * prices.get(i);
                }
            }
    }

    private void calculateTotal(){
        sum = findViewById(R.id.sum);
        check_out = findViewById(R.id.check_out);
        check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCart();
                sum.setText("$"+total);
            }
        });
        //        check_out.setOnClickListener(view -> {
//            shoppingCart();
//            sum.setText(String.valueOf(total));
//        });
    }

}