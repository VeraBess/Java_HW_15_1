package ru.netology.domain.services;

public class Player {
    protected int id;
    protected String name;
    protected int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getStrengh() {
        return strength;
    }

    public String getName() {
        return name;
    }

}
