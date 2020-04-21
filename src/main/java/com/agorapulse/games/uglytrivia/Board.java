package com.agorapulse.games.uglytrivia;

import java.util.ArrayList;

public class Board {
    private static final int MAX_PLAYER = 6;
    private final int BOARD_SIZE = 12;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public Board() {
        players = new ArrayList<Player>();
        currentPlayerIndex = 0;
    }

    public boolean addPlayer(String name) {
        if (getPlayerNumber() < MAX_PLAYER) {
            players.add(new Player(name));
            System.out.println(name + " was added");
            System.out.println("They are player number " + getPlayerNumber());
            return true;
        } else {
            System.out.println("The maximum number of players is 6");
            return false;
        }
    }

    public boolean isPlayable() {
        return (getPlayerNumber() >= 2);
    }

    public int getPlayerNumber() {
        return players.size();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % getPlayerNumber();
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public String currentCategory() {
        int playerPlace = getCurrentPlayer().getPlace();
        if (playerPlace % 4 == 0) return "Pop";
        if (playerPlace % 4 == 1) return "Science";
        if (playerPlace % 4 == 2) return "Sports";
        return "Rock";
    }
}
