
package modell;

import java.util.ArrayList;


public class AsztalModell {
    private String nev;
    private ArrayList<EtelModell>etelek;

    public AsztalModell(String nev) {
        this.nev = nev;
        this.etelek = new ArrayList<>();
    }

    public String getNev() {
        return nev;
    }

    public ArrayList<EtelModell> getEtelek() {
        return etelek;
    }
    
    
    public void etelekListaba(EtelModell etel){
        etelek.add(etel);
    
    }
    
    public int osszeg(){
        int sum = 0;
        for (EtelModell e : etelek) {
            sum += e.getAr();
        }
        return sum;
    }
    
}
