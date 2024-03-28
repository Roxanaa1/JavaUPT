package org.example.laboratoare.lab5.ex1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerecheNumere
{
    private int numar1;
    private int numar2;
    @Override

    public String toString()
    {
        return "primul numar="+numar1+",al doilea numar="+numar2;
    }

    public boolean suntConsecutiveInFibonacci()
    {
        int a = 0;
        int b = 1;
        int c = a + b;

        // Verificăm dacă fiecare număr este consecutiv în șirul Fibonacci
        while (c <= numar2) {
            if ((a == numar1 && b == numar2) || (a == numar2 && b == numar1))
            {
                return true;
            }

            // Trecem la următoarea pereche de numere consecutive din șirul Fibonacci
            a = b;
            b = c;
            c = a + b;
        }

        // Dacă nu am găsit o pereche de numere consecutive, returnăm false
        return false;
    }

    private int cmmdc()
    {
        int a = numar1;
        int b = numar2;
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int cmmc()
    {
        return (numar1*numar2)/cmmdc();
    }
    public boolean sumaCifrelorEgala()
    {
        return sumaCifre(numar1) == sumaCifre(numar2);
    }

    private int sumaCifre(int numar)
    {
        int suma = 0;
        while (numar != 0)
        {
            suma = suma+numar % 10;
            numar =numar/ 10;
        }
        return suma;
    }

    public boolean numarCifrePareEgale()
    {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int numar)
    {
        int numarCifrePare = 0;
        while (numar != 0)
        {
            if ((numar % 10) % 2 == 0)
            {
                numarCifrePare++;
            }
            numar =numar/ 10;
        }
        return numarCifrePare;
    }

}
