package org.example.laboratoare.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Judete
{
    /*1. Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.
*/
    public static void main(String[] args)
    {
        List<String > list=new ArrayList<>();
        try
        {
            Scanner scanner=new Scanner(new File("src/main/resources/judete_in.txt"));
            while(scanner.hasNextLine())
            {
                String judete=scanner.nextLine().toLowerCase();
                list.add(judete);
            }
            Collections.sort(list);
            System.out.println("Lista sortata:"+list);

            Scanner scanner1=new Scanner(System.in);
            System.out.println("Introduceti judetul cautat:");
            String judetCautat=scanner1.nextLine().toLowerCase();
            int pozitie=Collections.binarySearch(list,judetCautat);
            if(pozitie>=0)
            {
                System.out.println("Judetul:"+judetCautat+" a fost gasit pe pozitia:"+pozitie);
            }
            else
            {
                System.out.println("Judetul cautat nu este in lista");
            }


        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
