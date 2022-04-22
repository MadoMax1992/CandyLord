package de.materna.candyLord.event;

import de.materna.candyLord.Candy;
import de.materna.candyLord.Enums.CandyEnum;
import de.materna.candyLord.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Mugging extends Event {

    @Override
    public void process(Player player) {
        Candy candyOfPlayer = player.pickRandomCandy();
        candyOfPlayer.setAmount(0);
        System.err.println("You Lost all of your " + candyOfPlayer.getName()+"!");
    }

}
