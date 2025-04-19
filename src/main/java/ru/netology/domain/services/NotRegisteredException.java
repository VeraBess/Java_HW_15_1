package ru.netology.domain.services;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок с именем " + name + "не зарегистирован");
    }
}
