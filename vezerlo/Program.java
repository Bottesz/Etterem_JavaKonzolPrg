package vezerlo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import modell.Asztal;
import modell.Etel;
import nezet.EtelKiiro;

public class Program {

    private ArrayList<Asztal> asztalok = new ArrayList<>();

    
    public ArrayList<Etel> beolvasEtelek(String fajlnev) {
        ArrayList<Etel> etelek = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fajlnev));
            while (sc.hasNext()) {
                String sor = sc.nextLine().trim();
                if (!sor.isEmpty()) {
                    String[] resz = sor.split("\\|");
                    String nev = resz[0].trim();
                    int ar = Integer.parseInt(resz[1].trim());
                    etelek.add(new Etel(nev, ar));
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Hiba az etelek beolvasásánál: " + e.getMessage());
        }
        return etelek;
    }

    
    public void beolvasAsztalok(String fajlnev, ArrayList<Etel> etelek) {
        try {
            Scanner sc = new Scanner(new File(fajlnev));
            Asztal aktualis = null;

            while (sc.hasNextLine()) {
                String sor = sc.nextLine().trim();
                if (sor.isEmpty()) continue;

                
                aktualis = new Asztal(sor);
                asztalok.add(aktualis);

                
                while (sc.hasNextLine()) {
                    String etelSor = sc.nextLine().trim();
                    if (etelSor.isEmpty()) break; 

                    
                    for (Etel e : etelek) {
                        if (e.getNev().equals(etelSor)) {
                            aktualis.etelekListaba(e);
                            break;
                        }
                    }
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Hiba az asztalok beolvasásánál: " + e.getMessage());
        }
    }

    
    public void futtat() {
        ArrayList<Etel> etelek = beolvasEtelek("src/etelek.txt");
        beolvasAsztalok("src/asztalok.txt", etelek);

        EtelKiiro kiiro = new EtelKiiro();
        kiiro.kiir(asztalok);
    }
}
