package de.materna.candyLord;

import de.materna.candyLord.Enums.CityEnum;
import de.materna.candyLord.event.Event;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    static boolean isOver = false;
    static int round = 0;
    static final int MAX_ROUNDS = 30;
    static final int PRICE_PER_DISTANCE = 2;
    static final int PLAYER_MAX_CAPACITY = 10;
    static final int PLAYER_MONEY = 100;
    static final int PLAYER_HEALTH = 100;
    static final double PRICE_SHUFFEL_FACTOR = 0.1;
    static final CityEnum startCity = CityEnum.BREMEN;

    public static final int RANDOM_GIFT_MAX_AMMMOUNT = 5;
    public static final double EVENT_GIFT_PROBABILITY = 0.5;
    public static final double EVENT_MUG_PROBABILITY = 0.1;
    public static final double EVENT_NOOP_PROBABILITY = 0.2;


    public static void main(String[] args) {
        ArrayList<City> cities = City.createCities();
        Player player = Player.createPlayer(cities.get(startCity.ordinal()));

        //TODO Stringbuilder Klasse nutzen


        while (!isOver) {

            if (round != 0) {
                new Event().process(player);
            }


            printGameState(player);

            askPlayer(player, cities);


            round++;
            if (round == MAX_ROUNDS) {
                isOver = true;
                System.out.println("Das Spiel ist vorbei!\nDu hast" + player.getMoney() + "€ verdient.");
            }
        }


    }

    private static void askPlayer(Player player, ArrayList<City> cities) {
        System.out.println("What do you wanna do?");
        switch (getUserInputAsChar()) {
            case 'T' -> printTravelOptions(player, cities);
            case 'B' -> printBuyingOptions(player);
            case 'S' -> printSellingOptions(player);
            default -> {
                System.out.println("Input not reconized, Try Again!");
                askPlayer(player, cities);
            }

        }
    }

    private static void printSellingOptions(Player player) {
        System.out.println("What do you wanna sell ?");

        int inputNumber = 0;

        for (Candy candy : player.getCandyList()) {
            System.out.println("[" + inputNumber + "]: " + candy.getAmount() + "\t" + candy.getName());
            inputNumber++;
        }
        Candy chossenCandy = player.getCity().getCandies().get(getUserInputAsInt());

        System.out.println("How much do you wanna sell ?");

        transactSell(player, chossenCandy, getUserInputAsInt());

    }

    private static void printGameState(Player player) {

        System.out.println("\n\nRound: " + round + "/" + MAX_ROUNDS);
        System.out.println("Location: " + player.getCity().getName());
        System.out.println("Money: " + player.getMoney() + " €");
        System.out.println("Capactity: " + player.getCapacity() + "/" + GameManager.PLAYER_MAX_CAPACITY + "\n");
        System.out.println("Candies on Hand :" + toStringForPlayer(player.candyList));
        System.out.println("Candies in City :" + toStringForCity(player.getCity().getCandies()));

        System.out.println("(B)uy Candy\n(S)ell Candy\n(T)ravel to another City");

    }


    private static void printBuyingOptions(Player player) {
        System.out.println("What do you wanna buy ?");

        int inputNumber = 0;

        for (Candy candy : player.getCity().getCandies()) {
            System.out.println("[" + inputNumber + "]: " + "€" + candy.getPrice() + "\t" + candy.getName());
            inputNumber++;
        }
        Candy chossenCandy = player.getCity().getCandies().get(getUserInputAsInt());

        System.out.println("How much do you wanna have ?");

        transactPurchase(player, chossenCandy, getUserInputAsInt());


    }


    private static void transactSell(Player player, Candy choosenCandy, int amount) {
        if (player.isSellPossible(choosenCandy, amount)) {
            System.out.println("You sould " + amount + " " + choosenCandy.getName());
            return;
        }
        System.out.println("You cannot sell this");

    }

    private static void transactPurchase(Player player, Candy candy, int amount) {
        if (player.isBuyPossible(candy, amount)) {
            System.out.println("You bought " + amount + " " + candy.getName());
            return;
        }
        System.out.println("You cannot buy this");

    }

    private static void printTravelOptions(Player player, ArrayList<City> cities) {
        int inputNumber = 0;

        System.out.println("Where do you wanna go ?");
        for (City city : cities) {
            System.out.println("[" + inputNumber + "]: " + "€" + player.getCity().calcTravelCostTo(city) + " \t" + city.getName());
            inputNumber++;
        }
        travelPlayerToCity(player, cities.get(getUserInputAsInt()));
    }

    private static int getUserInputAsInt() {
        Scanner intScannner = new Scanner(System.in);
        try {
            return intScannner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input is not valid!\nTry again");
            return getUserInputAsInt();
        }


    }

    //TODO Tabs beim Output gehen manchaml kaputt

    private static char getUserInputAsChar() {
        Scanner charScannner = new Scanner(System.in);
        try {
            return charScannner.next().trim().toUpperCase().charAt(0);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Input is not valid!\nTry again");
            return getUserInputAsChar();
        }

    }

    private static void travelPlayerToCity(Player player, City toCity) {
        if (player.isTravelPossible(toCity)) {
            System.out.println("You Traveled to: " + toCity.getName());
            return;
        }
        System.out.println("You don't have enough money to travel to " + toCity.getName());
    }

    private static String toStringForCity(List<Candy> candies) {
        String output = "\n";
        for (Candy candy : candies) {
            output = output + candy.getPrice() + "€ \t" + candy.getName() + "\n";
        }
        return output;
    }

    private static String toStringForPlayer(List<Candy> candies) {
        String output = "\n";
        for (Candy candy : candies) {
            output = output + candy.getAmount() + " \t" + candy.getName() + "\n";
        }
        return output;
    }


}
