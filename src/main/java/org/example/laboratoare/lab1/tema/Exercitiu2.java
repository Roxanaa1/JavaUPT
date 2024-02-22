package org.example.laboratoare.lab1.tema;

import java.io.*;
import java.util.Scanner;

public class Exercitiu2
{
    /* Să se scrie un program care citește un set de numerele din fișierul de intrare in.txt, care
conține câte un număr pe un rând, având valorile din figura 18. Programul va determină suma
lor, media aritmetică, valoarea minimă, valoarea maximă, va afișa aceste valori pe ecran și le
va scrie în fișierul de ieșire out.txt. Media aritmetică va fi afișată ca un număr real.
*/
    public static void main(String[] args) throws IOException
    {
        int suma = 0;
        int numarElemente = 0;
        int valoareMinima = Integer.MAX_VALUE;
        int valoareMaxima = Integer.MIN_VALUE;
        float mediaAritmetica = suma / (float) numarElemente;
        String line;
        try {
            Scanner scanner=new Scanner(new File("src/main/resources/in.txt"));

            while(scanner.hasNext())
            {
                int a=scanner.nextInt();
                System.out.println(a);
            }

        }catch (IOException  e)
        {
            e.getMessage();
        }

        System.out.println("Suma: " + suma);
        System.out.println("Media aritmetică: " + mediaAritmetica);
        System.out.println("Valoarea minimă: " + valoareMinima);
        System.out.println("Valoarea maximă: " + valoareMaxima);
        FileWriter writer = new FileWriter("out.txt");
        writer.write("Suma: " + suma + "\r\n");
        writer.write("Media aritmetică: " + mediaAritmetica + "\r\n");
        writer.write("Valoarea minimă: " + valoareMinima + "\r\n");
        writer.write("Valoarea maximă: " + valoareMaxima + "\r\n");
        writer.close();



    }
}
