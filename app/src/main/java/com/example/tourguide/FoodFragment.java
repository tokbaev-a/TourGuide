package com.example.tourguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.list_view, container, false);
        ArrayList<Location> locations = new ArrayList<Location>();

        String [] foodName = getResources().getStringArray(R.array.food);
        String [] foodAddress = getResources().getStringArray(R.array.foodAddress);
        String [] foodPhoneNumber = getResources().getStringArray(R.array.foodPhoneNumber);
        String [] description = getResources().getStringArray(R.array.description);
        String [] foodWorkingHours = getResources().getStringArray(R.array.foodWorkingHours);
        int [] images = {
                R.drawable.bali_sayan_house,
                R.drawable.bali_mamasan,
                R.drawable.bali_metis,
                R.drawable.bali_sarong,
                R.drawable.bali_republik,
                R.drawable.bali_slippery_stone,
                          };
        for (int i = 0; i < images.length ; i++) {

            locations.add(new Location(
                    foodName[i],
                    foodAddress[i],
                    foodPhoneNumber[i],
                    images[i],
                    "Info: " + description[i] + "\n",
                    "Working hours: " + foodWorkingHours[i]));
        }

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), locations);

        ListView listView = rootview.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        return rootview;
    }
}