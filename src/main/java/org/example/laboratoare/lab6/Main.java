package org.example.laboratoare.lab6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main
{
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/angajati.json");
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>() {});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args)
    {
//        List<Angajat> angajati=new ArrayList<>();
//        angajati.add(new Angajat("Maria", "Caserita", LocalDate.of(2023, 4, 10), 3900));
//        angajati.add(new Angajat("Ion", "Sef", LocalDate.of(2023, 7, 10), 1500));
//        angajati.add(new Angajat("Crina", "Director", LocalDate.of(2023, 1, 10), 2900));
//        angajati.add(new Angajat("Mihai", "Spalator", LocalDate.of(2023, 4, 10), 1900));
//        angajati.add(new Angajat("Ionut", "Sef", LocalDate.of(2023, 9, 10), 4900));
//        scriere(angajati);


        List<Angajat> angajati = citire();
        if(angajati == null) {
            // In cazul în care citirea din fisier a esuat, initializam lista ca fiind goala
            angajati = new ArrayList<>();
        }
        angajati.forEach(System.out::println);

        Scanner scanner1 = new Scanner(System.in);
        int optiune;
        while (true)
        {
            System.out.println("\nMeniu:");
            System.out.println("1. Afisare lista de angajati");
            System.out.println("2. Afisare angajati cu salariul peste 2500 RON");
            System.out.println("3. Afisare angajati din luna aprilie, a anului trecut, cu functie de conducere");
            System.out.println("4. Afisare angajati fara functie de conducere, ordonati descrescator dupa salariu");
            System.out.println("5. Extragere nume angajati scrise cu majuscule");
            System.out.println("6. Afisare salarii mai mici de 3000 RON");
            System.out.println("7. Afisare date primul angajat al firmei");
            System.out.println("8. Afisare statistici referitoare la salariul angajatilor");
            System.out.println("9. Verificare existenta angajat cu numele 'Ion'");
            System.out.println("10. Afisare numar angajati angajati în vara anului precedent");
            System.out.println("0. Iesire");

            System.out.print("Introduceti optiunea: ");
            optiune = scanner1.nextInt();

            switch (optiune) {
                case 1:
                   // Utilizare referinta la metoda println pentru afisarea listei de angajati
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                     //filtrare angajati cu salariul peste 2500 RON
                    Predicate<Angajat> salariuPeste2500 = angajat -> angajat.getSalariu() > 2500;
                    System.out.println("\nSalariile angajatilor cu salariul peste 2500 RON:");
                    angajati.stream()
                            .filter(salariuPeste2500)
                            .map(Angajat::getSalariu)
                            .forEach(System.out::println);

                    break;
                case 3:
                    int anCurent = LocalDate.now().getYear();
                    List<Angajat> angajatiConducereAprilie = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == anCurent - 1 &&
                                    angajat.getDataAngajarii().getMonthValue() == 4 &&
                                    (angajat.getPost().toUpperCase().contains("SEF") || angajat.getPost().toUpperCase().contains("DIRECTOR")))
                            .collect(Collectors.toList());

                    System.out.println("Angajatii din luna aprilie a anului trecut cu functie de conducere:");
                    angajatiConducereAprilie.forEach(System.out::println);

                    break;
                case 4:
                    List<Angajat> angajatiFaraFunctieDeConducere = angajati.stream()
                            .filter(angajat -> !angajat.getPost().contains("director") && !angajat.getPost().contains("sef"))
                            .sorted(Comparator.comparingDouble(Angajat::getSalariu).reversed())
                            .collect(Collectors.toList());

                    System.out.println("Angajatii care nu au functie de conducere, ordonati descrescator dupa salariu:");
                    angajatiFaraFunctieDeConducere.forEach(System.out::println);

                    break;
                case 5:
                    List<String> numeMajuscule = angajati.stream()
                            .filter(angajat -> angajat.getNume().equals(angajat.getNume().toUpperCase()))
                            .map(Angajat::getNume)
                            .collect(Collectors.toList());

                    System.out.println("Numele angajatilor scrise cu majuscule:");
                    numeMajuscule.forEach(System.out::println);
                    break;
                case 6:
                    List<Float> salariiMaiMiciDe3000 = angajati.stream()
                            .map(Angajat::getSalariu)
                            .filter(salariu -> salariu < 3000)
                            .collect(Collectors.toList());
                    System.out.println(" Salariilor mai mici de 3000 de RON :");
                    salariiMaiMiciDe3000.forEach(System.out::println);

                    break;
                case 7:
                    angajati.stream()
                            .min(Comparator.comparing(Angajat::getDataAngajarii))
                            .ifPresentOrElse((a)-> System.out.println(a),()-> System.out.println("Nu este"));

//                    Optional<Angajat> primulAngajat = angajati.stream()
//                            .min(Comparator.comparing(Angajat::getDataAngajarii));
//
//                    if (primulAngajat.isPresent()) {
//                        System.out.println("Primul angajat al firmei:");
//                        System.out.println(primulAngajat.get());
//                    } else {
//                        System.out.println("Nu exista angajati în sistem.");
//                    }

                        break;
                case 8:
                    DoubleSummaryStatistics statisticiSalariu = angajati.stream()
                            .collect(Collectors.summarizingDouble(Angajat::getSalariu));

                    System.out.println("Statistici salariu angajati:");
                    System.out.println("Salariul mediu: " + statisticiSalariu.getAverage() + " RON");
                    System.out.println("Salariul minim: " + statisticiSalariu.getMin() + " RON");
                    System.out.println("Salariul maxim: " + statisticiSalariu.getMax() + " RON");
                    break;
                case 9:
                    Optional<Angajat> angajatCuIon = angajati.stream()
                            .filter(angajat -> angajat.getNume().equalsIgnoreCase("Ion"))
                            .findAny();
                    angajatCuIon.ifPresentOrElse(
                            angajat -> System.out.println("Firma are cel puțin un angajat cu numele Ion"),
                            () -> System.out.println("Firma nu are niciun angajat cu numele Ion")
                    );
                   //if(angajatCuIon.isPresent())
//                    {
//                        System.out.println("Firma are cel putin un angajat cu numele Ion");
//                    }
//                    else
//                    {
//                        System.out.println("Firma nu are niciun angajat cu numele Ion");
//                    }

                    break;
                case 10:

                    int anCurent1 = LocalDate.now().getYear();
                    int anPrecedent = anCurent1 - 1;
                    LocalDate dataInceputVara = LocalDate.of(anPrecedent, Month.JUNE, 1);
                    LocalDate dataSfarsitVara = LocalDate.of(anPrecedent, Month.AUGUST, 31);

                    long numarAngajatiVara = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().isAfter(dataInceputVara) && angajat.getDataAngajarii().isBefore(dataSfarsitVara))
                            .count();
                    System.out.println("Numarul de persoane care s au angajat în vara anului precedent: " + numarAngajatiVara);

                case 0:
                    exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida");
            }
        }

    }

    private static void exit(int i) {
    }
}
