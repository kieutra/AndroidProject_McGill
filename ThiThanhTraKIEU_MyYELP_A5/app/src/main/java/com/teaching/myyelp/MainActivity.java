//Thi Thanh Tra KIEU #261066512

package com.teaching.myyelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;


import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    SearchView searchView;
    RecyclerView recview;
    ArrayList<Restaurant> myAllResto;
    Spinner spinner;
    YelpAPI yelpapi;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FavoriteFragment favoriteFragment;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        createSearchview();
        createResto("chinese food");
        createNavigationview();
    }

//Navigation View from Start (left)
    public void createNavigationview(){
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if(id==R.id.search){
                setContentView(R.layout.activity_main);
                createSearchview();
                createResto("chinese food");
                createNavigationview();
            }else if(id==R.id.favorite){
                frameLayout = findViewById(R.id.frame);
                frameLayout.setBackgroundColor(0xffffffff);
                favoriteFragment = new FavoriteFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, favoriteFragment).addToBackStack("tag").commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });
    }


//Use query to call each restaurant
    public void createSearchview() {
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.equalsIgnoreCase("sushi")){
                    createResto("sushi");
                }else if(query.equalsIgnoreCase("steak")){
                    createResto("steak");
                }else if(query.equalsIgnoreCase("bbq")){
                    createResto("bbq");
                }else if(query.equalsIgnoreCase("dessert")){
                    createResto("dessert");
                }else{
                    createResto("chinese food");
                }
                searchView.clearFocus();

                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

//Create Common Restaurants
    public void createResto(String s){
        yelpapi = new YelpClient().build();
        yelpapi.getUser(s, "montreal").enqueue(new Callback<YelpResponse>() {
            @Override
            public void onResponse(@NonNull Call<YelpResponse> call, @NonNull Response<YelpResponse> response) {
                YelpResponse res = response.body();
                myAllResto = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    assert res != null;
                    myAllResto.add(new Restaurant(i+1,
                            res.businesses.get(i).name,
                            res.businesses.get(i).rating,
                            res.businesses.get(i).price,
                            res.businesses.get(i).categories.get(0).title,
                            res.businesses.get(i).phone,
                            res.businesses.get(i).location.address1 + ", " +
                                    res.businesses.get(i).location.city + ", " +
                                    res.businesses.get(i).location.state,
                            res.businesses.get(i).url
                    ));
                }
                recycleview(myAllResto);
                chooseFromSpinner(myAllResto);
            }
            @Override
            public void onFailure(@NonNull Call<YelpResponse> call, @NonNull Throwable t) {
            }
        });
    }

//Create Recycle View
    public void recycleview(ArrayList<Restaurant> myResto){
        RestoAdapter adapter = new RestoAdapter(this, myResto);
        recview = findViewById(R.id.recview);
        recview.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recview.setLayoutManager(layoutManager);
    }

//Create Spinner for sorting
    public void chooseFromSpinner(ArrayList<Restaurant> myarr) {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapterView.getSelectedItem().toString();
                if (s.equals("Rating")) {
                    for (int j = 0; j < myarr.size(); j++) {
                        for (int k = j + 1; k < myarr.size(); k++) {
                            if (myarr.get(j).rating < myarr.get(k).rating) {
                                Collections.swap(myarr, j, k);
                            }
                        }
                    }
                    recycleview(myarr);
                } else if(s.equals("Price")){
                    for (int j = 0; j < myarr.size(); j++) {
                        for (int k = j + 1; k < myarr.size(); k++) {

                            if(myarr.get(j).price_pos > myarr.get(k).price_pos){

                                Collections.swap(myarr, j, k);
                            }
                        }
                    }

                }
                recycleview(myarr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

//Use Back Button to exit.
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
