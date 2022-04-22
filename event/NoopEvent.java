package de.materna.candyLord.event;

import de.materna.candyLord.Player;

public class NoopEvent extends Event {
    @Override
    public void process(Player player) { }

}
