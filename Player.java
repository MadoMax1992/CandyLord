package de.materna.candyLord;

import de.materna.candyLord.Enums.CandyEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    int money;
    int health;
    List<Candy> candyList;
    City city;
    int capacity;

    public Player(int money, int health, List<Candy> candyList, City city, int capacity) {
        this.money = money;
        this.health = health;
        this.candyList = candyList;
        this.city = city;
        this.capacity = capacity;
    }



    public static Player createPlayer(City startCity) {
        ArrayList<Candy> playerCandy = new ArrayList<>();

        for (CandyEnum candy : CandyEnum.values()) {
            playerCandy.add(new Candy(candy.name(), candy.getBasePrice(), 0));
        }
        return new Player(GameManager.PLAYER_MONEY, GameManager.PLAYER_HEALTH, playerCandy, startCity, 0);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Candy> getCandyList() {
        return candyList;
    }

    public void setCandyList(List<Candy> candyList) {
        this.candyList = candyList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isSellPossible(Candy choosenCandy, int amount) {

        for (Candy candy : candyList) {
            if (choosenCandy.getName().equals(candy.getName())) {
                if (amount > candy.getAmount()) {
                    return false;
                }
                candy.setAmount(candy.getAmount() - amount);
                this.setCapacity(this.getCapacity() - amount);
                this.setMoney(this.getMoney() + choosenCandy.getPrice() * amount);

            }
        }
        return true;

    }


    public boolean isBuyPossible(Candy choosenCandy, int amount) {
        int transactionCost = choosenCandy.getPrice() * amount;

        if (GameManager.PLAYER_MAX_CAPACITY < (amount + this.getCapacity()))
            return false;
        if (transactionCost > this.getMoney())
            return false;

        for (Candy candy : candyList) {
            if (choosenCandy.getName().equals(candy.getName())) {
                candy.setAmount(candy.getAmount() + amount);
                this.setCapacity(this.getCapacity() + amount);
                this.setMoney(this.getMoney() - transactionCost);
            }

        }
        return true;
    }


    public boolean isTravelPossible(City toCity) {
        ;
        int travelPrice = this.city.calcTravelCostTo(toCity);

        if (travelPrice <= this.getMoney()) {
            this.city = toCity;
            for (Candy candy : this.city.getCandies()) {
                candy.shuffelprice();
            }
            this.setMoney(this.getMoney() - travelPrice);
            return true;
        }

        return false;

    }

    public Candy pickRandomCandy () {
        return this.getCandyList().get(ThreadLocalRandom.current().nextInt( 0, CandyEnum.values().length));

    }


}
