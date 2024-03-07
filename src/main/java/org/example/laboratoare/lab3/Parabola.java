package org.example.laboratoare.lab3;

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
    public  double[] getVarfParabola()
    {
        double x=-b/(2*a);
        double y=(-b*b+4*a*c) / (4 * a);

        return new double[]{x,y};
    }
    @Override
    public String toString()
    {
        return "f(x) = " + a + " x^2 + " + b + " x + " + c;
    }
    public static double[] getMijlocVarf(Parabola parabola1,Parabola parabola2)
    {
        double[] varf1=parabola1.getVarfParabola();
        double[] varf2=parabola2.getVarfParabola();

        double mijlocX=(varf1[0]+varf2[0])/2;
        double mijlocY=(varf1[1]+varf2[1])/2;

        return new double[]{mijlocX,mijlocY};

    }
    public double[] getMijloc(Parabola p)
    {
        return Parabola.getMijlocVarf(this, p);
    }
    public static double getLungime(Parabola parabola1,Parabola parabola2)
    {
        double[] varf1 = parabola1.getVarfParabola();
        double[] varf2 = parabola2.getVarfParabola();
        //Math.hypot(double x, double y) pentru a calcula distanta Euclidiana intre cele două puncte
        return Math.hypot(varf1[0] - varf2[0], varf1[1] - varf2[1]);
    }
    public double getLungime(Parabola p)
    {
        return Parabola.getLungime(this, p);
    }
}
