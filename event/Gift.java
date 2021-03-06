package de.materna.candyLord.event;

import de.materna.candyLord.Candy;
import de.materna.candyLord.GameManager;
import de.materna.candyLord.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Gift extends Event {

    @Override
    public void process(Player player) {
        Candy candyOfPlayer = player.pickRandomCandy();
        int randomAmount = ThreadLocalRandom.current().nextInt(1, GameManager.RANDOM_GIFT_MAX_AMMMOUNT);
        candyOfPlayer.setAmount(candyOfPlayer.getAmount() + randomAmount);
        player.setCapacity(player.getCapacity() + randomAmount);
        System.err.println("You Found "+ randomAmount + " " + candyOfPlayer.getName() +"!");

        //TODO Check Carrying Capacity

    }

}
