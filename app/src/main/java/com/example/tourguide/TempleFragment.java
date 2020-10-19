package com.example.tourguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class TempleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] templePlaces = getResources().getStringArray(R.array.temple);
        String [] templeAddress = getResources().getStringArray(R.array.templeAddress);
        String [] info = getResources().getStringArray(R.array.templeInfo);
        String [] workingHours = getResources().getStringArray(R.array.templeWorkingHours);
        int [] images = {
                R.drawable.bali_tanah_lot_temple,
                R.drawable.bali_uluwatu_temple,
                R.drawable.bali_ulun_danu_beratan_temple,
                R.drawable.bali_besakih,
                R.drawable.bali_tirta_empul_temple,
                R.drawable.bali_underwater_temple,
                R.drawable.bali_goa_lawah_temple,
                 };

        View rootview = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();

        for (int i = 0; i < images.length ; i++) {

            locations.add(new Location(
                    templePlaces[i],
                    templeAddress[i],
                    images[i],
                     "Info: "+ info[i] ,
                    "Working hours: " + workingHours[i]));

        }

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), locations);

        ListView listView = rootview.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        return rootview;
    }
}