package com.teaching.foods;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.teaching.foods.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    public ArrayList<Restaurant> myrestaurants;
    private static ListFragment listFragment;
    RestoAdapter adapter;
    ListView listview;
    Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);



        myrestaurants = new ArrayList<>();
        myrestaurants.add(new Restaurant("Bol De Vie", "Rue Masson", 15, "33-43 minutes", R.drawable.boldevie, 9.8));
        myrestaurants.add(new Restaurant("Restaurant chez Lien", "Rue Sherbrook", 15, "27-37 minutes", R.drawable.restochezlien, 9.4));
        myrestaurants.add(new Restaurant("Fusion Express", "Av. Pierre-De Coubertin", 35, "30-40 minutes", R.drawable.fusionexpress, 9.7));
        myrestaurants.add(new Restaurant("Homa Pizzeria", "Rue Hochelaga", 20, "34-44 minutes", R.drawable.homapizzeria, 9.2));
        myrestaurants.add(new Restaurant("La Belle Province", "Boul Langelier", 25, "27-37 minutes", R.drawable.labelleprovince, 9.7));
        myrestaurants.add(new Restaurant("Pizza Lafontaine", "Rue Hochellaga", 20, "27-37 minutes", R.drawable.pizzalafontaine, 9.4));
        myrestaurants.add(new Restaurant("Resto Indian", "Saint-Jean-Baptiste", 30, "37-47 minutes", R.drawable.restoindian, 10.0));
        myrestaurants.add(new Restaurant("Sake Sushi", "Rue Sherbrook", 45, "35-45 minutes", R.drawable.sakesushi, 9.1));
        myrestaurants.add(new Restaurant("Salut Asie", "Rue Sherbrook", 25, "28-38 minutes", R.drawable.salutasie, 9.6));
        myrestaurants.add(new Restaurant("Sandwiches Cao Lanh", "Rue Ontario", 35, "35-45 minutes", R.drawable.sandwichcaolanh, 9.8));
        myrestaurants.add(new Restaurant("Sandwich Par Ici", "Rue Sherbrook", 25, "44-54 minutes", R.drawable.sandwichparici, 9.8));
        myrestaurants.add(new Restaurant("Soupe & Roll", "Rue Hochelaga", 20, "24-34 minutes", R.drawable.souproll, 9.5));

        myrestaurants.get(0).setVegetarian(true);
        myrestaurants.get(3).setVegetarian(true);
        myrestaurants.get(5).setVegetarian(true);
        myrestaurants.get(6).setVegetarian(true);
        myrestaurants.get(10).setVegetarian(true);

        myrestaurants.get(2).setFeatured(true);
        myrestaurants.get(3).setFeatured(true);
        myrestaurants.get(7).setFeatured(true);
        myrestaurants.get(9).setFeatured(true);

        context = inflater.getContext();
        listview = v.findViewById(R.id.listview_fl);
        adapter = new RestoAdapter(context, myrestaurants);
        listview.setAdapter(adapter);

        return v;
    }
    public static ListFragment getInstance(){
        if(listFragment ==null)
            listFragment = new ListFragment();
        return listFragment;
    }
    public ListFragment(){}
    public ArrayList<Restaurant> getMyrestaurants() {
        return myrestaurants;
    }

    public void setMyrestaurants(ArrayList<Restaurant> myrestaurants) {
        this.myrestaurants = myrestaurants;
    }

    public void setData(ArrayList<Restaurant> data){
        adapter = new RestoAdapter(context, data);
        listview.setAdapter(adapter);

    }
}