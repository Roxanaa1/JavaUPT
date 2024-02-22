package org.example.laboratoare.lab1.tema;

import java.util.Scanner;

public class Exercitiu3
{
    /* Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător.*/

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti n:");
        int n,i;
         n=scanner.nextInt();
        while(n<1)
        {
            System.out.println("Numarul trebuie sa fie pozitiv");
            n=scanner.nextInt();
        }
        System.out.println("Divizorii comuni sunt:");
        int numarDivizori=0;
        for( i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                System.out.println(i+" ");
                numarDivizori++;
            }

        }
        if(numarDivizori>2)
        {
            System.out.println("Numarul nu este prim");
        }
        else
        {
            System.out.println("Numarul este prim");
        }

    }
}
