//Thi Thanh Tra KIEU #261066512
package com.teaching.foods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment;
    ArrayList<Restaurant>myRestos;
    ArrayList<Fragment> pv_fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = ListFragment.getInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview, listFragment).commit();


        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    myRestos = new ArrayList<>();
    listFragment.setData(listFragment.myrestaurants);

        switch (item.getItemId()) {
            case R.id.lowprice:
                for(int i=0; i<listFragment.myrestaurants.size(); i++){
                    for(int j=i+1; j<listFragment.myrestaurants.size(); j++)
                    if(listFragment.myrestaurants.get(i).getMinPrice()>listFragment.myrestaurants.get(j).getMinPrice()){
                        Collections.swap(listFragment.myrestaurants, i, j);
                    }
                }
                listFragment.adapter.notifyDataSetChanged();

                return true;
            case R.id.highprice:
                for(int i=0; i<listFragment.myrestaurants.size(); i++){
                    for(int j=i+1; j<listFragment.myrestaurants.size(); j++)
                        if(listFragment.myrestaurants.get(i).getMinPrice()<listFragment.myrestaurants.get(j).getMinPrice()){
                            Collections.swap(listFragment.myrestaurants, i, j);
                        }
                }
                listFragment.adapter.notifyDataSetChanged();
                return true;
            case R.id.rating:
                for(int i=0; i<listFragment.myrestaurants.size(); i++){
                    for(int j=i+1; j<listFragment.myrestaurants.size(); j++)
                        if(listFragment.myrestaurants.get(i).getRating()<listFragment.myrestaurants.get(j).getRating()){
                            Collections.swap(listFragment.myrestaurants, i, j);
                        }
                }
                listFragment.adapter.notifyDataSetChanged();
                return true;
            case R.id.vegan:
                for(int i=0; i<listFragment.myrestaurants.size(); i++){

                    if(listFragment.myrestaurants.get(i).isVegetarian()){
                        myRestos.add(listFragment.myrestaurants.get(i));
                    }
                }
                listFragment.setData(myRestos);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}