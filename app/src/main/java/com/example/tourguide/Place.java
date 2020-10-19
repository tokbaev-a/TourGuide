package com.example.tourguide;

public class Place {
    private int imageId;
    private String placeName;
    private String address;
    private String description;
    private String phoneNumber = notGiven;
    private String wHours = notGiven;
    private static String notGiven = null;



    public Place(String placeName, String address, String phoneNumber, int imageId, String description, String wHours){
        this.placeName = placeName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
        this.imageId = imageId;
        this.wHours = wHours;
    }

    public Place(String placeName, String address, int imageId, String description, String wHours){
        this.placeName = placeName;
        this.address = address;
        this.description = description;
        this.imageId = imageId;
        this.wHours = wHours;
    }
    public Place(String placeName, String address, String description, int imageId){
        this.placeName = placeName;
        this.address = address;
        this.description = description;
        this.imageId = imageId;
    }

    public String getWorkingHours() {
        return wHours;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean hasNumber() {
        return getPhoneNumber() != notGiven;
    }
    public boolean hasWorkingHours() {
        return getWorkingHours() != notGiven;
    }
}
