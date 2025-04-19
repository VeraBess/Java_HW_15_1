package ru.netology.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void player1NotRegister() { // исключение если первый игрок не зарегистрирован
        Player sasha = new Player(11, "Саша", 150);
        Game game = new Game();

        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Саша"));
    }

    @Test
    public void player2NotRegister() { // исключение если второй игрок не зарегистрирован
        Player sasha = new Player(11, "Саша", 150);
        Game game = new Game();

        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Саша", "Петя"));
    }

    @Test
    public void roundPlayer1MorePlayer2() { //первый игрок сильнее второго
        Player sasha = new Player(11, "Саша", 150);
        Player olya = new Player(22, "Оля", 120);
        Game game = new Game();

        game.register(sasha);
        game.register(olya);

        int expected = 1;
        int actual = game.round("Саша", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundPlayer1LessPlayer2() { //первый игрок слабее второго
        Player sasha = new Player(11, "Саша", 150);
        Player olya = new Player(22, "Оля", 120);
        Game game = new Game();

        game.register(sasha);
        game.register(olya);

        int expected = 2;
        int actual = game.round("Оля", "Саша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundPlayer1EqualsPlayer2() { // игроки равны
        Player sasha = new Player(11, "Саша", 120);
        Player olya = new Player(22, "Оля", 120);
        Game game = new Game();

        game.register(sasha);
        game.register(olya);

        int expected = 0;
        int actual = game.round("Оля", "Саша");

        Assertions.assertEquals(expected, actual);
    }
}
