package com.teaching.myyelp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {
    final String DB_NAME = "Favorite Restos";
    ArrayList<Restaurant>myFavorRestos;
    ArrayList<Restaurant>myFilteredRestos;
    RecyclerView recview_fr;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);
        myFavorRestos = new ArrayList<>();
        myFilteredRestos = new ArrayList<>();
        button = v.findViewById(R.id.button);

        DatabaseHelper db = new DatabaseHelper(v.getContext(), DB_NAME, null, 1);

//CREATE CURSOR TO READ ALL DATA IN RESTAURANTS
        Cursor cursor = db.getReadableDatabase().rawQuery("SELECT * FROM RESTAURANTS", null);
 //       Cursor cursor = db.getReadableDatabase().query(TABLE_NAME, null,null, null, null, null, null, null);

 //CURSOR READS EACH ROW
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
                float rating = cursor.getFloat(cursor.getColumnIndexOrThrow("RATING"));
                String price = cursor.getString(cursor.getColumnIndexOrThrow("PRICE"));
                String category = cursor.getString(cursor.getColumnIndexOrThrow("CATEGORY"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("PHONE"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("ADDRESS"));
                String url = cursor.getString(cursor.getColumnIndexOrThrow("IMAGE"));
                myFavorRestos.add(new Restaurant(name, rating, price, category, phone, address, url));

            }while(cursor.moveToNext());
        }


        cursor.close();
        db.close();

//DELETE DUPLICATE DATA
        for(int i=0; i<myFavorRestos.size(); i++){
            int count =0;
            for(int j=i+1; j<myFavorRestos.size(); j++){
                if(myFavorRestos.get(i).nameofresto.equals(myFavorRestos.get(j).nameofresto) &&
                myFavorRestos.get(i).address.equals(myFavorRestos.get(j).address)){
                    count++;
                }
            }
            if(count==0) myFilteredRestos.add(myFavorRestos.get(i));
        }

//ADD POSITION FOR RESTAURANT TO ITS NAME
        for(int i=0; i<myFilteredRestos.size(); i++){
            myFilteredRestos.get(i).nameofresto = i + 1 + " " + myFilteredRestos.get(i).nameofresto;
        }

//RECYCLE VIEW
        RestoFragmentAdapter adapter = new RestoFragmentAdapter(v.getContext(), myFilteredRestos);
        recview_fr = v.findViewById(R.id.recView_fr);
        recview_fr.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);
        recview_fr.setLayoutManager(layoutManager);

//CLEAR BUTTON
        button.setOnClickListener(view -> {
            //db.getWritableDatabase().delete(TABLE_NAME, null,null);
            v.getContext().deleteDatabase(DB_NAME);
            myFavorRestos.removeAll(myFavorRestos);
           myFilteredRestos.removeAll(myFilteredRestos);
           adapter.notifyDataSetChanged();
        });

        return v;
    }

//USE BACK BUTTON TO GO TO MAIN ACTIVITY
@Override
public void onDetach() {
    super.onDetach();
    if(isRemoving()){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
}