package com.company;
import java.util.List;

public class Person {
    public String name;
    public int move;
    public int roundPoints;
    public List<Integer> score;

    public Person(String name, int move, List<Integer> score) {
        this.name = name;
        this.move = move;
        this.score = score;
    }

    public int getRoundPoints() {
        return roundPoints;
    }

    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }
    public String getName() {
        return name;
    }
    public int getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ",placeringar=" + score +
                //  "poäng i omgång=" + roundPoints +
                '}';
    }
    public void setMove(int move) {
        this.move = move;
    }
    public List<Integer> getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
}

