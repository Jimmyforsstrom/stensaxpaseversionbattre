package com.company;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class Move {

    public int slump() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public int clock() {

        LocalTime localTime = LocalTime.now() ;
        int x;
        if (localTime.getSecond() /10 >4 ){
            x = 3;}
        else if (localTime.getSecond() /10 > 2) {
            x = 2; }
        else { x = 1; }
        return x;
    }

    public int hashCode(List<Person> tab) {  //ett drag som ändra beroende på tabellens hashcode;

        int x = tab.hashCode();
        if (x % 3 == 0) { x = 3;}  //delbart med 3 dvs 0,3,6,9,12 (påse)
        else if ( x % 2 == 0) { x = 2; } //delbart med 2 dvs 2,4,6,8,10 (sax)
        else { x =1; }

        return x;
    }
    public void menu() {
        System.out.println("Välkommen, vänligen välj \n1 Spela \n2 Se historik \n3 Avsluta ");
    }
}



