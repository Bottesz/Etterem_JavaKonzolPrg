
package nezet;

import java.util.ArrayList;
import modell.AsztalModell;
import modell.EtelModell;

public class EtelKiiroNezet {
    
    public void kiir(ArrayList<AsztalModell> asztalok) {
        for (AsztalModell a : asztalok) {
            System.out.println(a.getNev());
            System.out.println("-----------------------");

            for (EtelModell e : a.getEtelek()) {
                System.out.println(e.getNev() + " - " + e.getAr() + " Ft");
            }

            System.out.println("Összesen: " + a.osszeg() + " Ft");
            System.out.println();
        }
    }
    
}
