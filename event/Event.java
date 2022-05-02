package de.materna.candyLord.event;

import de.materna.candyLord.GameManager;
import de.materna.candyLord.Player;

public class Event {

    public void process(Player player){

        if (Math.random() < GameManager.EVENT_GIFT_PROBABILITY) {
            new Gift().process(player);
            return;
        }
        if (Math.random() < GameManager.EVENT_MUG_PROBABILITY) {
            new Mugging().process(player);
            return;
        }
        if (Math.random() < GameManager.EVENT_NOOP_PROBABILITY) {
            new NoopEvent().process(player);
        }

    }
}
