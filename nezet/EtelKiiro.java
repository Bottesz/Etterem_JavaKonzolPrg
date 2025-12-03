
package nezet;

import java.util.ArrayList;
import modell.Asztal;
import modell.Etel;

public class EtelKiiro {
    
    public void kiir(ArrayList<Asztal> asztalok) {
        for (Asztal a : asztalok) {
            System.out.println(a.getNev());
            System.out.println("-----------------------");

            for (Etel e : a.getEtelek()) {
                System.out.println(e.getNev() + " - " + e.getAr() + " Ft");
            }

            System.out.println("Összesen: " + a.osszeg() + " Ft");
            System.out.println();
        }
    }
    
}
