package com.teaching.foods;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> pv_fragments;
    ArrayList<Fragment> setFeatured_fragments;
    ListFragment listFragment;
    int random1, random2, random3;


    public ViewPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);

        pv_fragments = new ArrayList<>();
        setFeatured_fragments = new ArrayList<>();
        listFragment = ListFragment.getInstance();

        pv_fragments.add(new Boldevie_fragment());
        pv_fragments.add(new Chezlien_fragment());
        pv_fragments.add( new Fusionexpress_fragment());
        pv_fragments.add(new HomaPizzeria_fragment());
        pv_fragments.add(new BelleProvince_fragment());
        pv_fragments.add(new PizzaLafontaine_fragment());
        pv_fragments.add(new Restoindian_fragment());
        pv_fragments.add(new Sakesushi_fragment());
        pv_fragments.add(new Salutasie_fragment());
        pv_fragments.add(new Sandwichcaolanh_fragment());
        pv_fragments.add(new Sandwichparici_fragment());
        pv_fragments.add(new Souproll_fragment());

        random1 = (int)(Math.random()*4);
        random2 = (int)(Math.random()*4);
        random3 = (int)(Math.random()*4);
        while(random1 == random2) {
              random2 = (int) (Math.random()*4);
        }
        while(random1 == random3 || random2 == random3) {
            random3 = (int) (Math.random()*4);
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        for(int i=0; i<listFragment.myrestaurants.size(); i++){
            if(listFragment.myrestaurants.get(i).isFeatured()){
                setFeatured_fragments.add(pv_fragments.get(i));
            }
        }

        if(position%3==0)
            return setFeatured_fragments.get(random1);
        else if(position%3==1)
            return setFeatured_fragments.get(random2);
        else{
            return setFeatured_fragments.get(random3);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
