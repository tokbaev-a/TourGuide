package com.example.tourguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    boolean isVisible = false;

    public PlaceAdapter(Activity context, ArrayList<Place> places) {

        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.places, parent, false);
        }


        final Place currentPlace = getItem(position);

        TextView nameOfLocation = listItemView.findViewById(R.id.place_name);
        assert currentPlace != null;
        nameOfLocation.setText(currentPlace.getPlaceName());


        TextView address = listItemView.findViewById(R.id.place_address);
        address.setText(currentPlace.getAddress());
        address.getPaint().setUnderlineText(true);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent addressIntent = new Intent(Intent.ACTION_VIEW);
            String title = "  Open with";
            Intent chooser = Intent.createChooser(addressIntent.setData(Uri.parse("geo:0,0?q=" + currentPlace.getAddress())), title);
            getContext().startActivity(chooser);
        }
    });

        final TextView number = listItemView.findViewById(R.id.phone_number);
        number.setVisibility(View.GONE);

        final ImageView phoneIcon = listItemView.findViewById(R.id.phone_number_icon);
        phoneIcon.setVisibility(View.GONE);

        final TextView wHours = listItemView.findViewById(R.id.w_hours);
        wHours.setVisibility(View.GONE);

        final ImageView wHoursIcon = listItemView.findViewById(R.id.working_hours_icon);
        wHoursIcon.setVisibility(View.GONE);

        final ImageView shortText = listItemView.findViewById(R.id.description_icon);
        shortText.setVisibility(View.GONE);

        final TextView description = listItemView.findViewById(R.id.description);
        description.setVisibility(View.GONE);

        final CardView show = listItemView.findViewById(R.id.card);
        show.setVisibility(View.VISIBLE);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isVisible) {
                    isVisible = true;
                    shortText.setVisibility(View.VISIBLE);
                    description.setText(currentPlace.getDescription());
                    description.setVisibility(View.VISIBLE);

                    if (currentPlace.hasNumber()) {
                        wHoursIcon.setVisibility(View.VISIBLE);
                        phoneIcon.setVisibility(View.VISIBLE);
                        number.setText(currentPlace.getPhoneNumber());
                        number.getPaint().setUnderlineText(true);
                        number.setVisibility(View.VISIBLE);

                        number.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent numberIntent = new Intent(Intent.ACTION_DIAL);
                                getContext().startActivity(numberIntent.setData(Uri.parse("tel:" + currentPlace.getPhoneNumber())));
                            }
                        });
                    }
                    if (currentPlace.hasWorkingHours()) {
                        wHours.setText(currentPlace.getWorkingHours());
                        wHours.setVisibility(View.VISIBLE);
                        wHoursIcon.setVisibility(View.VISIBLE);
                    }
                } else {
                    isVisible=false;
                    show.setVisibility(View.VISIBLE);
                    if (currentPlace.hasNumber()) {
                        phoneIcon.setVisibility(View.GONE);
                        number.setVisibility(View.GONE);
                    }
                    wHoursIcon.setVisibility(View.GONE);
                    wHours.setVisibility(View.GONE);
                    shortText.setVisibility(View.GONE);
                    description.setVisibility(View.GONE);
                }
            }
        });

        return listItemView;

    }
}











