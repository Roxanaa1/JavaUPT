package org.example.laboratoare.lab2;
 /* Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
îndeplinește următoarele condiții:
• Are 13 caractere
• Toate caracterele sunt cifre
• Prima cifră are una din valorile 1, 2, 5, 6
• Cifra de control a CNP-ului are o valoare validă
Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
formatul nume, CNP, varsta.
     */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Persoana
{
   private String nume;
   private String cnp;
   public Persoana(String nume,String cnp )
   {
       this.nume=nume;
       this.cnp=cnp;

   }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta( )
    {
        String anNasterii=cnp.substring(1,3);
        String lunaNasterii=cnp.substring(3,5);
        String ziuaNasterii=cnp.substring(5,7);

        int an=Integer.parseInt(anNasterii);
        int luna=Integer.parseInt(lunaNasterii);
        int ziua=Integer.parseInt(ziuaNasterii);

        int secol = Character.getNumericValue(cnp.charAt(0));
        if (secol == 1 || secol == 2)
        {
            an += 1900;
        } else if (secol == 3 || secol == 4)
        {
            an += 1800;
        } else if (secol == 5 || secol == 6)
        {
            an += 2000;
        }

        LocalDate dataNasterii = LocalDate.of(an, luna, ziua);
        LocalDate dataCurenta = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Cititi nr de persoane:");
        int n=scanner.nextInt();
        scanner.nextLine();
        Persoana[] persoane = new Persoana[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Introduceti numele persoanei " + (i + 1) + ":");
            String numeP = scanner.nextLine();
            String cnpP;
            while (true)
            {
                System.out.println("Introduceti cnp ul persoanei " + (i + 1) + ":");
                cnpP = scanner.nextLine();
                if (validareCNP(cnpP))
                {
                    persoane[i] = new Persoana(numeP, cnpP);
                    break;
                } else {
                    System.out.println("CNP invalid. Incercati din nou.");
                }
            }
        }
        for (Persoana persoana : persoane)
        {
            System.out.println("Numele:"+persoana.nume + ", " +"cnp:"+ persoana.cnp + ", "+"varsta:" + persoana.getVarsta()+" ani");
        }

    }
    private static boolean validareCNP(String cnp)
    {
        if (cnp.length() != 13||!contineDoarCifre(cnp))
        {
            return false;
        }

        int primaCifra = Character.getNumericValue(cnp.charAt(0));
        if (primaCifra != 1 && primaCifra != 2 && primaCifra != 5 && primaCifra != 6)
        {
            return false;
        }
        return true;
    }
    private static boolean contineDoarCifre(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

}
