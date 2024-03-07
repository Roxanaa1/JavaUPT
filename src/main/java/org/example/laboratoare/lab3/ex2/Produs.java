package org.example.laboratoare.lab3.ex2;

import java.time.LocalDate;
/* Să se scrie un program care citește din fișierul produse.csv informații referitoare la
produsele dintr-un magazin. Pe fiecare linie se află: denumirea produsului, preţul (număr real)
cantitatea (număr întreg), data expirării (LocalDate). Cele patru elemente sunt separate prin
caracterul "," (zahar, 1.5, 50, 2024-02-25). Pentru fiecare rând citit se va crea un obiect de tip
Produs care se va adăuga unei colecții de obiecte de tip List. Se va defini o clasă Produs care
va conține: variabile membre private corespunzătoare celor trei elemente care descriu un produs,
cel puţin un constructor, gettere si settere în funcție de necesități şi redefinirea metodei toString()
din clasa Object, metodă care va fi utilizată pentru afișarea produselor.
Să se realizeze un program care va dispune de un meniu și va implementa următoarele
cerințe:
a) afișarea tuturor produselor din colecția List
b) afișarea produselor expirate
c) vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.
Daca produsul ajunge la cantitate zero, se elimina din listă. În clasa Produs se va declara
o variabilă statica încasări care se va actualiza la fiecare vânzare a unui produs, luând în
considerare prețul produsului vândut şi cantitatea vândută .
d) afișarea produselor cu prețul minim (pot fi mai multe cu același preț)
e) salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură
într-un fișier de ieșire. */
public class Produs
{


    private String nume;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirari;
    private static double incasari = 0;
    public Produs(String nume,double pret,int cantitate,String  dataExpirari)
    {
        this.nume=nume;
        this.pret=pret;
        this.cantitate=cantitate;
        this.dataExpirari=LocalDate.parse(dataExpirari);
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setDataExpirari(LocalDate dataExpirari) {
        this.dataExpirari = dataExpirari;
    }
    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public LocalDate getDataExpirari() {
        return dataExpirari;
    }

    public static double getIncasari()
    {
        return incasari;
    }
    public static void adaugaIncasari(double suma)
    {
        incasari += suma;
    }
    @Override
    public String toString() {
        return String.format("Nume: %s, Pret: %.2f, Cantitate: %d, Data expirarii: %s", nume, pret, cantitate, dataExpirari);
    }
}
