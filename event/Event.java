package de.materna.candyLord.event;

import de.materna.candyLord.GameManager;
import de.materna.candyLord.Player;

public class Event {

    public void process(Player player){

        if (Math.random() < GameManager.eventGiftProbability) {
            new Gift().process(player);
            return;
        }
        if (Math.random() < GameManager.eventMuggProbability) {
            new Mugging().process(player);
            return;
        }
        if (Math.random() < GameManager.eventNoopProbability) {
            new NoopEvent().process(player);
        }

    }
}
