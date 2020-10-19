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

        View rootview = inflater.inflate(R.layout.place_list, container, false);
        String [] templePlaces = getResources().getStringArray(R.array.temple);
        String [] templeAddress = getResources().getStringArray(R.array.templeAddress);
        String [] info = getResources().getStringArray(R.array.templeInfo);
        String [] workingHours = getResources().getStringArray(R.array.templeWorkingHours);
        int [] images = {R.drawable.bali_tanah_lot_temple, R.drawable.bali_uluwatu_temple, R.drawable.bali_ulun_danu_beratan_temple, R.drawable.bali_besakih, R.drawable.bali_tirta_empul_temple, R.drawable.bali_underwater_temple, R.drawable.bali_goa_lawah_temple,};
        final ArrayList<Place> places = new ArrayList<Place>();

        for (int i = 0; i < images.length ; i++) {
            places.add(new Place(templePlaces[i], templeAddress[i], images[i],
                     "Info: "+ info[i] ,
                    "Working hours: " + workingHours[i]));
        }

        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootview.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);

        return rootview;
    }
}