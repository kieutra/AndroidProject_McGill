package com.teaching.foods;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> pv_fragments;
    ArrayList<Restaurant>myRestos;
    ArrayList<Fragment> setFeatured_fragments;


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        setFeatured_fragments = new ArrayList<>();
        pv_fragments = new ArrayList<>();
        pv_fragments.add(new Boldevie_fragment());
        pv_fragments.add(new Chezlien_fragment());
        pv_fragments.add(new Fusionexpress_fragment());
        pv_fragments.add(new HomaPizzeria_fragment());
        pv_fragments.add(new BelleProvince_fragment());
        pv_fragments.add(new PizzaLafontaine_fragment());
        pv_fragments.add(new Restoindian_fragment());
        pv_fragments.add(new Sakesushi_fragment());
        pv_fragments.add(new Salutasie_fragment());
        pv_fragments.add(new Sandwichcaolanh_fragment());
        pv_fragments.add(new Sandwichparici_fragment());
        pv_fragments.add(new Souproll_fragment());

        myRestos = ListFragment.getInstance().getMyrestaurants();
        for(int i=0; i<myRestos.size(); i++){
            if(myRestos.get(i).isFeatured()){
                setFeatured_fragments.add(pv_fragments.get(i));
            }
        }
        if(position%3==0)
            return setFeatured_fragments.get(0);
        else if(position%3==1)
            return setFeatured_fragments.get(1);
        else{
            return setFeatured_fragments.get(2);
        }
    }

    @Override
    public int getCount() {
        return 30;
    }
}
