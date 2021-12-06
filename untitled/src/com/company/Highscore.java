package com.company;

import java.time.LocalTime;
import java.util.*;

public class Highscore {
    int id = 0;

    public void printAllaNamn(List<Person> tabell) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("vilken person vill du se?");
        System.out.println("1. " + tabell.get(0).getName() + "\n2. " + tabell.get(1).getName() + "\n3. " + tabell.get(2).getName()
                + "\n4. " + tabell.get(3).getName());
        id = scanner.nextInt();
        switch (id) {
            case 1 -> System.out.println(tabell.get(0));
            case 2 -> System.out.println(tabell.get(1));
            case 3 -> System.out.println(tabell.get(2));
            case 4 -> System.out.println(tabell.get(3));
        }
    }

    public void printomgang(List<String> runda, int antaletMatcher_, LocalTime time) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Det finns " + antaletMatcher_ / 4 + " rundor, vilken omgång vill du se?");
        id = scanner.nextInt() - 1;
        System.out.println(runda.stream().skip(id * 5L).limit(5).toList());
    }

    public void ranking(List<Person> raan) {
        System.out.println(raan.get(0).getName() + ". " +  raan.get(0).getScore());
        System.out.println(raan.get(1).getName() + ". " +  raan.get(1).getScore());
        System.out.println(raan.get(2).getName() + ". " +  raan.get(2).getScore());
        System.out.println(raan.get(3).getName() + ". " +  raan.get(3).getScore());

    }

    public void placering(String name, List<Integer> muu) {
        int newValue = 0;
        for (Integer i : muu) {
            newValue = i + newValue;
        }
        System.out.println(name.toUpperCase() + " har som sämst placering " + muu.stream().max(Comparator.naturalOrder()).orElseThrow());
        System.out.println(name.toUpperCase() + " har som bäst placering " + muu.stream().min(Comparator.naturalOrder()).orElseThrow());
        System.out.println(name.toUpperCase() + " har en snittplacering på " + muu.stream().mapToDouble(Integer::intValue).average().orElseThrow());
        System.out.println("---------------------------------");

    }
}



