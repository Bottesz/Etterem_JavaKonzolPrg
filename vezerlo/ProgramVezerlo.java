package vezerlo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import modell.AsztalModell;
import modell.EtelModell;
import nezet.EtelKiiroNezet;

public class ProgramVezerlo {

    private ArrayList<AsztalModell> asztalok = new ArrayList<>();

    
    public ArrayList<EtelModell> beolvasEtelek(String fajlnev) {
        ArrayList<EtelModell> etelek = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fajlnev));
            while (sc.hasNext()) {
                String sor = sc.nextLine().trim();
                if (!sor.isEmpty()) {
                    String[] resz = sor.split("\\|");
                    String nev = resz[0].trim();
                    int ar = Integer.parseInt(resz[1].trim());
                    etelek.add(new EtelModell(nev, ar));
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Hiba az etelek beolvasásánál: " + e.getMessage());
        }
        return etelek;
    }

    
    public void beolvasAsztalok(String fajlnev, ArrayList<EtelModell> etelek) {
        try {
            Scanner sc = new Scanner(new File(fajlnev));
            AsztalModell aktualis = null;

            while (sc.hasNextLine()) {
                String sor = sc.nextLine().trim();
                if (sor.isEmpty()) continue;

                
                aktualis = new AsztalModell(sor);
                asztalok.add(aktualis);

                
                while (sc.hasNextLine()) {
                    String etelSor = sc.nextLine().trim();
                    if (etelSor.isEmpty()) break; 

                    
                    for (EtelModell e : etelek) {
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
        ArrayList<EtelModell> etelek = beolvasEtelek("src/etelek.txt");
        beolvasAsztalok("src/asztalok.txt", etelek);

        EtelKiiroNezet kiiro = new EtelKiiroNezet();
        kiiro.kiir(asztalok);
    }
}
