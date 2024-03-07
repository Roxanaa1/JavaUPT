package org.example.laboratoare.lab3.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/parabola.txt"));
            List<Parabola> parabole = new ArrayList<>();

            while (scanner.hasNextLine()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                parabole.add(new Parabola(a, b, c));
            }
            scanner.close();

            for (Parabola p : parabole) {
                System.out.println(p);
                Punct varf = p.getVarfParabola();
                System.out.printf("Varful: (%.2f, %.2f)\n\n", varf.getX(), varf.getY());
            }

            if (parabole.size() > 1) {
                Punct mijlocVarf = Parabola.getMijlocVarf(parabole.get(0), parabole.get(1));
                System.out.println("Mijlocul varfurilor: " + mijlocVarf);

                Punct mijloc = parabole.get(0).getMijloc(parabole.get(1));
                System.out.println("Mijloc: " + mijloc);

                double lungime = parabole.get(0).getLungime(parabole.get(1));
                System.out.printf("Lungimea dintre varfuri: %.2f\n", lungime);

            } else {
                System.out.println("Trebuie să fie cel putin 2 parabole.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
        }
    }
}
