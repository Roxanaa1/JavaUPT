package org.example.laboratoare.lab3.ex1;

public class Punct
{
    private final double x;
    private final double y;
    public Punct(double x, double y)
    {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX()
    {

        return x;
    }

    public double getY()
    {
        return y;
    }
    @Override
    public String toString()
    {
        return "Varful:"+x+","+y;
    }
}
