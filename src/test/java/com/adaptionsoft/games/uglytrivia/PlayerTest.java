package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void player_initial_place_is_zero() {
        Player player = new Player("Paul");

        assertEquals(0, player.getPlace());
    }

    @Test
    public void move_should_add_player_place_of_roll_value_if_the_result_is_lower_than_board_size() {
        Player player = new Player("Paul");
        int boardSize = 10;

        player.move(3, boardSize);
        player.move(2, boardSize);

        assertEquals(5, player.getPlace());
    }

    @Test
    public void move_should_restart_player_place_if_the_result_is_upper_than_board_size() {
        Player player = new Player("Paul");

        player.move(6, 5);

        assertEquals(1, player.getPlace());
    }
}