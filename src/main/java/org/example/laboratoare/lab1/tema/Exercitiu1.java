package org.example.laboratoare.lab1.tema;

import java.util.Scanner;

public class Exercitiu1
{
    /* Se cere să se scrie un program Java care să calculeze şi să afişeze perimetru şi aria unui
dreptunghi. Valorile pentru lungime şi lățime se citesc de la tastatura. Sa se adauge un break
point pe prima linie care citește valoarea unei laturi si din acel punct să se ruleze programul
linie cu linie urmărind valorile variabilelor în memorie.*/

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti lungimea dreptunghiului:");
        int lungime=scanner.nextInt();
        System.out.println("Introduceti latimea dreptunghiului:");
        int latime=scanner.nextInt();
        int permetru=2*latime+2*lungime;
        System.out.println("Perimetru este:"+permetru);
        int aria=lungime*latime;
        System.out.println("Aria este:"+aria);


    }
}
