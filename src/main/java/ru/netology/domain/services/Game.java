package ru.netology.domain.services;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1); // полуение игрока 1 из мапы
        Player player2 = players.get(playerName2); // получение игрока 2 из мапы

        if (player1 == null) {   //выбрасываем исключение если игроки не зарегистрированны
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrengh() > player2.getStrengh()) { //определение победителя
            return 1;
        }
        if (player1.getStrengh() < player2.getStrengh()) {
            return 2;
        } else {
            return 0;
        }
    }
}
