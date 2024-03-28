package org.example.laboratoare.lab6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Angajat
{
    private String nume;
    private String post;
    LocalDate dataAngajarii;
    private float salariu;
    @Override
    public String toString()
    {
        return "Nume:"+nume+",post:"+post+",data angajarii:"+dataAngajarii+",salariu:"+salariu;
    }
}
