package com.company;

import java.time.LocalTime;
import java.util.*;

class Main {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        Highscore highscore = new Highscore();
        List<String> round = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Move move = new Move();
        Playgame playgame = new Playgame();
        int usermove = 0;
        int match = 0;
        List<Person> tabell = new ArrayList<>();
        List<Integer> userscore = new ArrayList<>();
        List<Integer> personscore = new ArrayList<>();
        List<Integer> person1score = new ArrayList<>();
        List<Integer> person2score = new ArrayList<>();


        Person user = new Person("user", usermove, userscore);
        Person person = new Person("Clockworth", move.clock(), personscore);
        Person person1 = new Person("Miss Random", move.slump(), person1score);
        Person person2 = new Person("Mr Code",move.hashCode(tabell), person2score);

        tabell.add(user); tabell.add(person); tabell.add(person1); tabell.add(person2);
        System.out.println("Vänligen ange ditt namn ");
        user.setName(scanner.nextLine());

        boolean run = true;
        while (run) {
            move.menu();
            int select = scanner.nextInt();
            switch (select) {
                case 1 -> {
                    System.out.println("Select your move please, \n1. Sten \n2. Sax \n3. Påse");
                    user.setMove(scanner.nextInt());
                    System.out.println("Semifinal nummer 1, du möter " + person.getName());
                    Person finalist1 = playgame.action(user, person);
                    System.out.println();
                    System.out.println("Semifinal nummer 2 är mellan " + person1.getName() + " - " + person2.getName());
                    Person finalist2 = playgame.action(person1, person2);
                    System.out.println();
                    System.out.println("För match två, vänligen gör ett nytt drag");
                    System.out.println("1. Sten, 2. Sax, 3. Påse");
                    person2.setMove(person2score.hashCode());
                    user.setMove(scanner.nextInt());

                    System.out.println("I finalen så händer följande: ");
                    System.out.println(playgame.action(finalist1, finalist2));
                    List<Person> bronsmatch = tabell.stream()
                            .sorted(Comparator.comparing(Person::getRoundPoints))
                            .limit(2).toList();

                    Person third1 = bronsmatch.get(0);
                    Person third2 = bronsmatch.get(1);

                    System.out.println("I match om tredje pris sker följande: ");
                    System.out.println(playgame.action(third1, third2));           //match om tredjepris går av

                    List<Person > oneRound = tabell.stream().                     //oneRound = en omgång
                            sorted(Comparator.comparing(Person::getRoundPoints)
                            .reversed())
                            .toList();
                    int rank = 1;
                    for (Person p: oneRound
                    ) {
                        p.roundPoints = rank;
                        rank++;
                    }

                    for (Person p: oneRound
                    ) { round.add(p.name + " med placering " + p.getRoundPoints());
                        match++;
                    }
                    localTime = LocalTime.now();                                        //Lägger till klockslag till varje spel
                    localTime = LocalTime.of(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
                    round.add(localTime.toString());


                    userscore.add(user.roundPoints);                            //nollställer score inför varje omgång
                    personscore.add(person.roundPoints);
                    person1score.add(person1.roundPoints);
                    person2score.add(person2.roundPoints);

                    System.out.println("Resultat för omgången blir! \n");
                    System.out.println(oneRound.get(0).getName() + ". " + oneRound.get(0).roundPoints);
                    System.out.println(oneRound.get(1).getName() + ". " + oneRound.get(1).roundPoints);
                    System.out.println(oneRound.get(2).getName() + ". " + oneRound.get(2).roundPoints);
                    System.out.println(oneRound.get(3).getName() + ". " + oneRound.get(3).roundPoints);

                    user.setRoundPoints(0); person.setRoundPoints(0);
                    person1.setRoundPoints(0); person2.setRoundPoints(0);
                    System.out.println();
                }

                case 2 -> {
                    System.out.println("-----------------------");
                    highscore.placering(user.name, userscore);
                    highscore.placering(person.name, personscore);
                    highscore.placering(person1.name, person1score);
                    highscore.placering(person2.name, person2score);
                    System.out.println("""
                            Extramaterial, välj\s
                            (P) för att se en viss person alternativt\s
                            (M) för att se en viss match\s
                            (A) för att se alla score per omgång\s
                            alternativt någon annan tangent för att komma tillbaka\s""");
                    String extra = scanner.next().toUpperCase();
                    switch (extra) {
                        case "M" -> highscore.printomgang(round, match, localTime);
                        case "P" -> highscore.printAllaNamn(tabell);
                        case "A" -> highscore.ranking(tabell);
                    }
                }
                case 3 -> {
                    System.out.println("Tack för att du spelade "); run = false;
                }
            }
        }
    }
}
