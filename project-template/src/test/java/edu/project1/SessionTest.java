package edu.project1;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SessionTest {
    @Test
    public void testGameDoesNotStartWithInvalidWordLength() {
        Throwable thrown = catchThrowable(() -> {
            new Session(new StringBuilder(2).toString());
        });
        assertInstanceOf(IllegalArgumentException.class, thrown);

        thrown = catchThrowable(() -> {
            new Session(new StringBuilder(50).toString());
        });
        assertInstanceOf(IllegalArgumentException.class, thrown);
    }

    @Test
    public void testGameReturnsDefeatAfterMaxAttempts() {
        Session session = new Session("APPLE");
        for (int i = 0; i < 5; ++i) {
            session.guess('X');
        }
        assertEquals(GuessResult.Defeat.class, session.guess('X').getClass());
    }

    @Test
    public void testGameCorrectlyUpdatesState() {
        Session session = new Session("APPLE");

        GuessResult result = session.guess('A');
        assertEquals("A____", String.valueOf(result.state()));
        assertEquals(0, result.attempt());

        result = session.guess('P');
        assertEquals("APP__", String.valueOf(result.state()));
        assertEquals(0, result.attempt());

        result = session.guess('X');
        assertEquals("APP__", String.valueOf(result.state()));
        assertEquals(1, result.attempt());

        result = session.guess('X');
        assertEquals("APP__", String.valueOf(result.state()));
        assertEquals(2, result.attempt());
    }

    @Test
    public void testGiveUp() {
        Session session = new Session("APPLE");
        GuessResult result = session.giveUp();
        assertEquals(GuessResult.Defeat.class, result.getClass());
    }
}
