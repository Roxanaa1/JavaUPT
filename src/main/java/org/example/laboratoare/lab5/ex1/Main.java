package org.example.laboratoare.lab5.ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        List<PerecheNumere> lista=citire();
        System.out.println(lista);
        for(PerecheNumere p:lista){
            System.out.println(p);
        }
        for (PerecheNumere p : lista) {
            System.out.println(p);
            System.out.println("Sunt consecutive in Fibonacci: " + p.suntConsecutiveInFibonacci());
            System.out.println("CMMDc: " + p.cmmc());
            System.out.println("Suma cifrelor egala: " + p.sumaCifrelorEgala());
            System.out.println("Numar cifre pare egale: " + p.numarCifrePareEgale());
        }
        lista.add(new PerecheNumere(2,3));
        lista.add(new PerecheNumere(3,3));
        lista.add(new PerecheNumere(8,9));
        scriere(lista);

    }
    public static void scriere(List<PerecheNumere> lista)
    {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/perecheNumere.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<PerecheNumere> citire()
    {
        try {
            File file=new File("src/main/resources/perecheNumere.json");
            Scanner scanner=new Scanner(file);
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> perecheNumere = mapper.readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return perecheNumere;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
