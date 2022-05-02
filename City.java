package de.materna.candyLord;

import de.materna.candyLord.Enums.CandyEnum;
import de.materna.candyLord.Enums.CityEnum;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class City {
    String name;
    Point2D location;
    ArrayList<Candy> candies;

    public City(String name, Point2D location, ArrayList<Candy> candies) {
        this.name = name;
        this.location = location;
        this.candies = candies;
    }


    public static int calcTravelCost(City fromCity, City toCity) {
        return (int) (GameManager.PRICE_PER_DISTANCE * Math.abs(fromCity.getLocation().distance(toCity.getLocation())));
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", candies=" + candies +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }

    public void setCandies(ArrayList<Candy> candies) {
        this.candies = candies;
    }


    public static ArrayList<City> createCities() {
        ArrayList<City> cities = new ArrayList<City>();

        for (CityEnum city : CityEnum.values()) {
            ArrayList<Candy> citieCandy = new ArrayList<Candy>();
            for (CandyEnum candy : CandyEnum.values()) {
                citieCandy.add(new Candy(candy.name(), candy.getBasePrice() * city.getPriceFactor(), candy.getBaseAmount()));
            }
            cities.add((new City(city.name(), city.getPointOnMap(), citieCandy)));
        }


        return cities;
    }


}
