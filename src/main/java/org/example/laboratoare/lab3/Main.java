package org.example.laboratoare.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try{
            Scanner scanner=new Scanner(new File("src/main/resources/parabola.txt"));
            List<Parabola> parabole=new ArrayList<>();

            while(scanner.hasNextLine())
            {
                String line=scanner.nextLine();
                String[] parts = line.split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                parabole.add(new Parabola(a, b, c));
            }
            scanner.close();

            for (Parabola p : parabole)
            {
                System.out.println(p);
                System.out.println("Varful: (" + p.getVarfParabola()[0] + ", " + p.getVarfParabola()[1] + ")");
            }
        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
