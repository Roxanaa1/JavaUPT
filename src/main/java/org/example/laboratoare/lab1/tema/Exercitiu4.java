package org.example.laboratoare.lab1.tema;

import java.util.Random;

public class Exercitiu4
{
    public static void main(String[] args)
    {
        Random random=new Random();
        int max=30;
        int a=random.nextInt(max);
        int b=random.nextInt(max);
        int nrMax=0;
        for(int i=1;i<=max;i++)
        {
            if(a%i==0&&b%i==0)
            {
                if(i>nrMax)
                {
                    nrMax=i;
                }
            }
        }
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("Divizorul comun este:"+nrMax);

    }
}
