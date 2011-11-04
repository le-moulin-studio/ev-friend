package com.lemoulinstudio.evfriend.domain;

public class Spot {
  
  public static Spot create(String name, String address) {
    Spot spot = new Spot();
    spot.name = name;
    spot.address = address;
    return spot;
  }

  public static Spot create(String name, String address, GeoLocation geoLocation) {
    Spot spot = new Spot();
    spot.name = name;
    spot.address = address;
    spot.geoLocation = geoLocation;
    return spot;
  }

  public static Spot create(String name, String address, GeoLocation geoLocation, int nbPlaces) {
    Spot spot = new Spot();
    spot.name = name;
    spot.address = address;
    spot.geoLocation = geoLocation;
    spot.nbPlaces = nbPlaces;
    return spot;
  }

  public String name;
  public String address;
  public String phoneNumber;
  
  public GeoLocation geoLocation;
  public Integer nbPlaces;
}
