package org.example.laboratoare.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.loadLibrary;

public class Main
{
    public static void main(String[] args) {
        List<Echipament> echipamente = new ArrayList<>();
        try {
            File file = new File("src/main/resources/echipamente.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String denumire = parts[0].trim();
                    int nr_inv = Integer.parseInt(parts[1].trim());
                    int pret = Integer.parseInt(parts[2].trim());
                    String zona_mag = parts[3].trim();
                    StareEchipament stareEchipament = StareEchipament.valueOf(parts[4].trim().toUpperCase());

                    if (parts.length >= 6) {
                        if (parts[5].equalsIgnoreCase("IMPRIMANTA") && parts.length >= 10) {
                            int ppm = Integer.parseInt(parts[6].trim());
                            String dpi = parts[7].trim();
                            int paginiCarutus = Integer.parseInt(parts[8].trim());
                            ModTiparire modDeTiparire = ModTiparire.valueOf(parts[9].trim().toUpperCase());
                            echipamente.add(new Imprimanta(denumire, nr_inv, pret, zona_mag, stareEchipament, ppm, dpi, paginiCarutus, modDeTiparire));
                        } else if (parts[5].equalsIgnoreCase("COPIATOR") && parts.length >= 8) {
                            int paginiToner = Integer.parseInt(parts[6].trim());
                            FormatCopiere formatCopiere = FormatCopiere.valueOf(parts[7].trim().toUpperCase());
                            echipamente.add(new Copiator(denumire, nr_inv, pret, zona_mag, stareEchipament, paginiToner, formatCopiere));
                        } else if (parts[5].equalsIgnoreCase("SISTEM DE CALCUL") && parts.length >= 9) {
                            String tipMonitor = parts[6].trim();
                            double vitezaProcesor = Double.parseDouble(parts[7].trim());
                            int capacitateHDD = Integer.parseInt(parts[8].trim());
                            SistemOperare sistemOperare = SistemOperare.valueOf(parts[9].trim().toUpperCase());
                            echipamente.add(new SistemDeCalcul(denumire, nr_inv, pret, zona_mag, stareEchipament, tipMonitor, vitezaProcesor, capacitateHDD, sistemOperare));
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit:" + e.getMessage());
        }
        while (true) {
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Meniu:");
            System.out.println("0.Iesire");
            System.out.println("1.Afişarea tuturor echipamentelor");
            System.out.println("2.Afişarea imprimantelor");
            System.out.println("3.Afişarea copiatoarelor");
            System.out.println("4.Afişarea sistemelor de calcul");
            System.out.println("5.Modificarea stării în care se află un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimantă");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare ");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9.Afişarea echipamentelor vândute");
            System.out.println("10.Să se realizeze două metode statice pentru serializarea / deserializarea colecției de obiecte în fișierul echip.bin");
            System.out.println("Alegeti o optiune:");
            int optiune = scanner1.nextInt();
            switch (optiune) {
                case 0: {
                    exit(0);

                    break;
                }
                case 1: {
                    if (echipamente.isEmpty()) {
                        System.out.println("Nu există echipamente de afișat.");
                    } else {
                        for (Echipament echipament : echipamente) {
                            System.out.println(echipament);
                        }
                    }
                    break;
                }
                case 2: {
                    for (Echipament echipament : echipamente) {
                        if (echipament instanceof Imprimanta) {
                            Imprimanta imprimanta = (Imprimanta) echipament;
                            System.out.println(imprimanta);
                        }
                    }
                    break;
                }
                case 3: {
                    for (Echipament echipament : echipamente) {
                        if (echipament.getClass() == Copiator.class) {

                            Copiator copiator = (Copiator) echipament;
                            System.out.println(copiator);
                        }
                    }

                    break;
                }
                case 4: {
                    for (Echipament echipament : echipamente) {
                        if (echipament.getClass() == SistemDeCalcul.class) {
                            SistemDeCalcul sistemDeCalcul = (SistemDeCalcul) echipament;
                            System.out.println(sistemDeCalcul);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Introduceti numarul de inventar al echipamentului pentru modificarea starii:");
                    int nrInv = scanner1.nextInt();
                    boolean found = false;
                    for (Echipament e : echipamente) {
                        if (e.getNr_inv() == nrInv) {
                            System.out.println("Stare actuala: " + e.getStareEchipament());
                            System.out.println("Introduceți noua stare (ACHIZITIONAT, EXPUS, VANDUT):");
                            String nouaStare = scanner1.next().toUpperCase();
                            e.setStareEchipament(StareEchipament.valueOf(nouaStare));
                            System.out.println("Starea a fost actualizata.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Echipamentul nu a fost gasit.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Introduceti numarul de inventar al imprimantei pentru modificarea modului de tiparire:");
                    int nrInvImpr = scanner1.nextInt();
                    boolean found = false;
                    for (Echipament e : echipamente) {
                        if (e.getNr_inv() == nrInvImpr && e instanceof Imprimanta) {
                            Imprimanta impr = (Imprimanta) e;
                            System.out.println("Mod de tiparire actual: " + impr.getModDeTiparire());
                            System.out.println("Introduceti noul mod de tiparire (COLOR, ALB_NEGRU):");
                            String nouMod = scanner1.next().toUpperCase();
                            impr.setModDeTiparire(ModTiparire.valueOf(nouMod));
                            System.out.println("Modul de tiparire a fost actualizat.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Imprimanta nu a fost gasita.");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Introduceți numarul de inventar al copiatorului pentru modificarea formatului de copiere:");
                    int nrInvCop = scanner1.nextInt();
                    boolean found = false;
                    for (Echipament e : echipamente) {
                        if (e.getNr_inv() == nrInvCop && e instanceof Copiator) {
                            Copiator cop = (Copiator) e;
                            System.out.println("Format de copiere actual: " + cop.getFormatCopiere());
                            System.out.println("Introduceti noul format de copiere (A3, A4):");
                            String nouFormat = scanner1.next().toUpperCase();
                            cop.setFormatCopiere(FormatCopiere.valueOf(nouFormat));
                            System.out.println("Formatul de copiere a fost actualizat.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Copiatorul nu a fost gasit.");
                    }
                    break;
                }
                case 8: {
                    System.out.println("Introduceti numarul de inventar al sistemului de calcul pentru instalarea sistemului de operare:");
                    int nrInvSist = scanner1.nextInt();
                    boolean found = false;
                    for (Echipament e : echipamente) {
                        if (e.getNr_inv() == nrInvSist && e instanceof SistemDeCalcul) {
                            SistemDeCalcul sist = (SistemDeCalcul) e;
                            System.out.println("Sistem de operare actual: " + (sist.getSistemOperare() != null ? sist.getSistemOperare() : "N/A"));
                            System.out.println("Introduceti noul sistem de operare (WINDOWS, LINUX):");
                            String nouSO = scanner1.next().toUpperCase();
                            sist.setSistemOperare(SistemOperare.valueOf(nouSO));
                            System.out.println("Sistemul de operare a fost instalat.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Sistemul de calcul nu a fost gasit.");
                        break;
                    }
                }
                case 9:
                {
                    System.out.println("Echipamente vandute:");
                    boolean areVandute = false;
                    for (Echipament e : echipamente) {
                        if (e.getStareEchipament() == StareEchipament.VANDUT) {
                            System.out.println(e);
                            areVandute = true;
                        }
                    }
                    if (!areVandute) {
                        System.out.println("Nu exista echipamente vandute.");
                    }
                    break;
                }
                case 10:
                {
                    break;
                }
            }
        }
    }
}
