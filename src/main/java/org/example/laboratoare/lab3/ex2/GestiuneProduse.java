package org.example.laboratoare.lab3.ex2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestiuneProduse
{
    private List<Produs> produse;
    public GestiuneProduse() {
        this.produse = new ArrayList<>();
    }

    public void afisareProduse()
    {
        for(Produs produs:produse)
        {
            System.out.println(produs.toString());
        }
    }
    public void afisareProduseExpirate()
    {
        LocalDate dataCurenta=LocalDate.now();
        for(Produs produs:produse)
        {
            if(produs.getDataExpirari().isBefore(dataCurenta))
            {
                System.out.println(produs.toString());
            }
        }

    }
    public void vanzareProdus()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti numele produsului:");
        String numeProdus=scanner.nextLine();
        System.out.println("Introduceti cantitatea dorita:");
        int cantitate=scanner.nextInt();
        for(Produs produs:produse)
        {
            if((produs.getNume().equalsIgnoreCase(numeProdus))&&(produs.getCantitate()>=cantitate))
            {
                produs.setCantitate(produs.getCantitate()-cantitate);
                Produs.adaugaIncasari(produs.getPret()*cantitate);
                System.out.println("Produs vandut");
                return;
            }

        }
        System.out.println("Stoc epuizat");


    }
    public void afisareProduseCuPretMinim()
    {
        if(produse.isEmpty())
        {
            System.out.println("Produsul nu exista");
        }
        double pretMinim=produse.get(0).getPret();
        for(Produs produs:produse)
        {
            if(produs.getPret()<pretMinim)
            {
                pretMinim=produs.getPret();
            }
        }

        for(Produs produs:produse)
        {
            if(produs.getPret()==pretMinim)
            {
                System.out.println(produs.toString());
            }
        }
    }
    public void salvareProduse()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti o cantitate:");
        int cantitate=scanner.nextInt();
        try
        {
            FileWriter writer=new FileWriter("src/main/resources/produse.csv");
            for(Produs produs:produse)
            {
                if(produs.getCantitate()<cantitate)
                {
                    writer.write(produs.toString()+"\n");
                }
            }

        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void addProdus(Produs produs) {
        this.produse.add(produs);
    }
}
