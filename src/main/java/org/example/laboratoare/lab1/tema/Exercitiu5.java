package org.example.laboratoare.lab1.tema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class Exercitiu5
{
    /*Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
Programul va determina dacă numărul aparține șirului lui Fobonacci.
*/
    public static void main(String[] args)
    {
        Random random=new Random();
        int a= random.nextInt(0,20);
        System.out.println("Nr:"+a);
        int n1=0;
        int n2=1;
        int n3;

        for(int i=0;i<a;i++)
        {
            n3=n1+n2;
            n1=n2;
            n2=n3;
            if(a==n3)
            {
                System.out.println("Nr apartine sirului Fibonacci");
                exit(0);
            }

        }
        System.out.println("Nr nu apartine sirului Fibonacci");


    }
}
