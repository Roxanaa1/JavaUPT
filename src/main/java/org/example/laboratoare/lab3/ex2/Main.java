package org.example.laboratoare.lab3.ex2;

import org.example.laboratoare.lab4.Copiator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main
{
    public static void main(String[] args)
    {
        GestiuneProduse produse = new GestiuneProduse();
        citesteProduseDinFisier(produse);

        Scanner scanner=new Scanner(System.in);
        while(true)
        {
            System.out.println("Meniu:");
            System.out.println("1.Afisare");
            System.out.println("2.Afisare produse expirate");
            System.out.println("3.Vanzarea unui produs");
            System.out.println("4.Afisare produse cu pret minim");
            System.out.println("5.Salvare produse care au cantitatea mai mica decat o valoare citita de la tastatura");

            System.out.println("Alegeti o optiune:");
            int optiune=scanner.nextInt();

            switch (optiune)
            {
                case 0:
                    exit(0);
                    break;
                case 1:

                    produse.afisareProduse();
                    break;
                case 2:
                    produse.afisareProduseExpirate();
                    break;
                case 3:
                   produse.vanzareProdus();
                    break;
                case 4:
                    produse.afisareProduseCuPretMinim();
                    break;
                case 5:
                    produse.salvareProduse();
                    break;
                default:
                    System.out.println("Ati introdus o optiune gresita!");
                    break;

            }
        }
    }
    private static void citesteProduseDinFisier(GestiuneProduse produse)
    {


        try (Scanner scanner = new Scanner(new File("src/main/resources/produse.csv")))
        {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                String[] atribute = linie.split(",");
                if (atribute.length == 4)
                {
                    String nume = atribute[0].trim();
                    double pret = Double.parseDouble(atribute[1].trim());
                    int cantitate = Integer.parseInt(atribute[2].trim());
                    String dataExpirarii = atribute[3].trim();
                    Produs produs = new Produs(nume, pret, cantitate, dataExpirarii);
                    produse.addProdus(produs);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Eroare la parsarea numerelor: " + e.getMessage());
        }

    }
}
