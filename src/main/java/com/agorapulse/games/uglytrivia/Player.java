package com.agorapulse.games.uglytrivia;

public class Player {
    private String name;
    private int place;
    private int purse;
    private boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        place = 0;
        purse = 0;
        inPenaltyBox = false;
    }

    public void move(int roll, int boardSize) {
        place = (place + roll) % boardSize;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public boolean isWinner() {
        return purse == 6;
    }

    public void winGoldCoin() {
        name = name;
        purse++;
        System.out.println(name + " now has " + purse + " Gold Coins.");
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
}
