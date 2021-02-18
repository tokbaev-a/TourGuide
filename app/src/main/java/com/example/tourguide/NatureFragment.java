package com.example.tourguide;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class NatureFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.place_list, container, false);

        String[] natureName = getResources().getStringArray(R.array.natureName);
        String[] natureAddress = getResources().getStringArray(R.array.natureAddress);

        int[] images = {R.drawable.bali_jatiluwih_rice_terraces, R.drawable.bali_angels_billabong, R.drawable.bali_leke_leke, R.drawable.bali_beji_guwang, R.drawable.bali_desa_temukus, R.drawable.bali_kanto_lampo, R.drawable.bali_suluban_cave, R.drawable.bali_yeh_leh, R.drawable.bali_pasih_uug,};
        String [] sightDescription = getResources().getStringArray(R.array.natureDescription);

         ArrayList<Place> places = new ArrayList<>();

        for (int i = 0; i < images.length ; i++) {
            places.add(new Place(natureName[i], natureAddress[i], sightDescription[i], images[i] ));
        }

        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootview.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);

        return rootview;
    }

}



