package com.example.tourguide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity context, ArrayList<Location> locations) {

        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.location_list, parent, false);
        }


        final Location currentLocation = getItem(position);

        TextView nameOfLocation = listItemView.findViewById(R.id.locations_name);
        nameOfLocation.setText(currentLocation.getNameOfLocation());


        TextView address = listItemView.findViewById(R.id.location_address);
        address.setText(currentLocation.getAddress());
        address.getPaint().setUnderlineText(true);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent addressIntent = new Intent(Intent.ACTION_VIEW);
            String title = "  Open with";
            Intent chooser = Intent.createChooser(addressIntent.setData(Uri.parse("geo:0,0?q=" + currentLocation.getAddress())), title);
            getContext().startActivity(chooser);
        }
    });

        final TextView number = listItemView.findViewById(R.id.phone_number);
        number.setVisibility(View.GONE);

        ImageView imageLocation = listItemView.findViewById(R.id.image);
        ViewTarget<ImageView, Drawable> into = Glide
                .with(getContext())
                .load(currentLocation.getImageResourceId())
                .into(imageLocation);

        final ImageView phoneIcon = listItemView.findViewById(R.id.phone_number_icon);
        phoneIcon.setVisibility(View.GONE);

        final TextView wHours = listItemView.findViewById(R.id.w_hours);
        wHours.setVisibility(View.GONE);

        final ImageView wHoursIcon = listItemView.findViewById(R.id.w_hours_icon);
        wHoursIcon.setVisibility(View.GONE);

        final ImageView shortText = listItemView.findViewById(R.id.description_icon);
        shortText.setVisibility(View.GONE);

        final TextView description = listItemView.findViewById(R.id.description);
        description.setVisibility(View.GONE);

        final ImageView show = listItemView.findViewById(R.id.show_more_button);
        show.setVisibility(View.VISIBLE);

        final ImageView hide = listItemView.findViewById(R.id.hide_button);
        hide.setVisibility(View.GONE);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    hide.setVisibility(View.VISIBLE);
                    show.setVisibility(View.GONE);
                    shortText.setVisibility(View.VISIBLE);
                    description.setText(currentLocation.getDescription());
                    description.setVisibility(View.VISIBLE);

                if (currentLocation.hasNumber()) {
                    wHoursIcon.setVisibility(View.VISIBLE);
                    phoneIcon.setVisibility(View.VISIBLE);
                    number.setText(currentLocation.getPhoneNumber());
                    number.getPaint().setUnderlineText(true);
                    number.setVisibility(View.VISIBLE);

                    number.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent numberIntent = new Intent(Intent.ACTION_DIAL);
                            getContext().startActivity(numberIntent.setData(Uri.parse("tel:" + currentLocation.getPhoneNumber())));
                        }
                    });
                }
                    if(currentLocation.hasWorkingHours()){
                    wHours.setText(currentLocation.getWorkingHours());
                    wHours.setVisibility(View.VISIBLE);
                    wHoursIcon.setVisibility(View.VISIBLE);
                }
            }
        });

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setVisibility(View.VISIBLE);
                hide.setVisibility(View.GONE);
                if (currentLocation.hasNumber()) {
                    phoneIcon.setVisibility(View.GONE);
                    number.setVisibility(View.GONE);

                }
                    wHoursIcon.setVisibility(View.GONE);
                    wHours.setVisibility(View.GONE);
                    shortText.setVisibility(View.GONE);
                    description.setVisibility(View.GONE);

                }
        });

        return listItemView;

    }
}











