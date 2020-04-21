package com.agorapulse.games.uglytrivia;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void addPlayer_should_add_player_when_number_of_player_is_lower_than_six() {
        Board board = new Board();

        assertEquals(true, board.addPlayer("Pierre"));
        assertEquals(true, board.addPlayer("Paul"));
        assertEquals(true, board.addPlayer("Jacques"));
        assertEquals(3, board.getPlayerNumber());
    }

    @Test
    public void addPlayer_should_not_add_player_when_number_of_player_is_upper_than_six() {
        Board board = new Board();

        board.addPlayer("Name1");
        board.addPlayer("Name2");
        board.addPlayer("Name3");
        board.addPlayer("Name4");
        board.addPlayer("Name5");
        board.addPlayer("Name6");

        assertEquals(false, board.addPlayer("Name7"));
        assertEquals(6, board.getPlayerNumber());
    }

    @Test
    public void getCurrentPlayer_should_return_the_first_player_added_at_the_beginning() {
        Board board = new Board();
        board.addPlayer("Pierre");
        board.addPlayer("Paul");

        assertEquals("Pierre", board.getCurrentPlayer().getName());
    }

    @Test
    public void nextPlayer_should_change_the_current_player() {
        Board board = new Board();
        board.addPlayer("Pierre");
        board.addPlayer("Paul");

        board.nextPlayer();
        assertEquals("Paul", board.getCurrentPlayer().getName());

        board.nextPlayer();
        assertEquals("Pierre", board.getCurrentPlayer().getName());
    }
}