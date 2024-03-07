package org.example.laboratoare.lab3.ex1;

public class Parabola
{
    private int a;
    private int b;
    private int c;
    public Parabola(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public Punct getVarfParabola()
    {
        double x=-b/(2*a);
        double y=(-b*b+4*a*c) / (4 * a);

        return new Punct(x,y);
    }
    @Override
    public String toString()
    {
        return "f(x) = " + a + " x^2 + " + b + " x + " + c;
    }
    public static Punct getMijlocVarf(Parabola parabola1, Parabola parabola2) {
        Punct varf1 = parabola1.getVarfParabola();
        Punct varf2 = parabola2.getVarfParabola();

        double mijlocX = (varf1.getX() + varf2.getX()) / 2;
        double mijlocY = (varf1.getY() + varf2.getY()) / 2;

        return new Punct(mijlocX, mijlocY);
    }
    public Punct getMijloc(Parabola p) {
        return Parabola.getMijlocVarf(this, p);
    }
    public static double getLungime(Parabola parabola1, Parabola parabola2)
    {
        Punct varf1 = parabola1.getVarfParabola();
        Punct varf2 = parabola2.getVarfParabola();
        // Utilizează Math.hypot pentru a calcula distanța Euclidiană între cele două puncte
        return Math.hypot(varf1.getX() - varf2.getX(), varf1.getY() - varf2.getY());
    }

    public double getLungime(Parabola p)
    {
        return Parabola.getLungime(this, p);
    }
}
