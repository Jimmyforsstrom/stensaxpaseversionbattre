package com.company;

import java.util.Random;
public class Playgame {

    public Person action(Person x, Person y) {

        // Sten är 1, Sax är 2, Påse är 3
        if (x.getMove() == 1 && y.getMove() == 2) {
            System.out.println(x.getName() + " valde Sten och " + y.getName() + " valde Sax");
            System.out.println("Sten slår sax. " + x.getName() + " VINNER");
            if (x.getRoundPoints() == 1) {
                x.setRoundPoints(3);
                y.setRoundPoints(2);
            } else {
                x.setRoundPoints(1);
            }
            return x;

        } else if (x.getMove() == 1 && y.getMove() == 3) {
            System.out.println(x.getName() + " valde Sten och " + y.getName() + " valde Påse");
            System.out.println("sten förlorar mot påse. " + y.getName() + " VINNER");
            if (y.getRoundPoints() ==1 ) {
                y.setRoundPoints(3);
                x.setRoundPoints(2);
            } else {
                y.setRoundPoints(1);
            }
            return y;

        } else if (x.getMove() == 2 && y.getMove() == 3) {
            System.out.println(x.getName() + " valde Sax och " + y.getName() + " valde Påse");
            System.out.println("sax slår påse. " + x.getName() + " VINNER");
            if (x.getRoundPoints() == 1) {
                x.setRoundPoints(3);
                y.setRoundPoints(2);
            } else {
                x.setRoundPoints(1);
            }
            return x;

        } else if (x.getMove() == 2 && y.getMove() == 1) {
            System.out.println(x.getName() + " valde Sax och " + y.getName() + " valde Sten");
            System.out.println("sax förlorar mot sten. " + y.getName() + " VINNER");
            if (y.getRoundPoints() == 1) {
                y.setRoundPoints(3);
                x.setRoundPoints(2);
            } else {
                y.setRoundPoints(1);
            }
            return y;

        } else if (x.getMove() == 3 && y.getMove() == 1) {
            System.out.println(x.getName() + " valde Påse och " + y.getName() + " valde Sten");
            System.out.println("påse slår sten. " + x.getName() + " VINNER");
            if (x.getRoundPoints() == 1) {
                x.setRoundPoints(3);
                y.setRoundPoints(2);
            } else {
                x.setRoundPoints(1);
            }
            return x;

        } else if (x.getMove() == 3 && y.getMove() == 2) {
            System.out.println(x.getName() + " valde Påse och " + y.getName() + " valde Sax");
            System.out.println("påse förlorar mot sax. " + y.getName() + " VINNER");
            if (y.getRoundPoints() == 1) {
                y.setRoundPoints(3);
                x.setRoundPoints(2);
            } else {
                y.setRoundPoints(1);
            }
            return y;

        } else {
            Random random = new Random();           //vid oavgjort så slumpas resultatet
            int first = random.nextInt(3) + 1;
            int second = random.nextInt(3) + 1;
            x.setMove(first);
            y.setMove(second);
            System.out.println("Oavgjort, det blir lottning ");
            return action(x, y);
        }
    }
}
