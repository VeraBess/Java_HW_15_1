package ru.netology.domain.services;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null; // переменная для игрока 1
        Player player2 = null; // переменная для игрока 2

        for (Player player : players) {  // проверяем зарегистрированны ли игроки
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
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
