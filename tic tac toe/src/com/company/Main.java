package com.company;

public class Main {

    public static void main(String[] args) {

        Div div = new Div();
        Game game = new Game(div);

        game.start();
    }
}
