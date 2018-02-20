package com.adaptionsoft.games.uglytrivia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

public class GameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void add_should_add_player_of_name_sets() {
        Game game = new Game();

        game.add("Luke");

        assertEquals("Luke was added", toRows(outContent)[0]);
        assertEquals("They are player number 1", toRows(outContent)[1]);
    }

    @Test
    public void roll_should_add_move_player() {
        Game game = new Game();
        game.add("Luke");

        game.roll(4);

        assertEquals("Luke is the current player", toRows(outContent)[2]);
        assertEquals("They have rolled a 4", toRows(outContent)[3]);
        assertEquals("Luke's new location is 4", toRows(outContent)[4]);
    }

    private String[] toRows(ByteArrayOutputStream content) {
        return content.toString().split("\\r?\\n");
    }
}
