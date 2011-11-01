package com.lemoulinstudio.evfriend.domain;

import java.util.List;

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

  public String name;
  public String address;
  public String phoneNumber;
  
  public GeoLocation geoLocation;
  public Integer nbPlaces;
}
