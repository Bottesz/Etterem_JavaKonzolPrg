
package modell;

import java.util.ArrayList;


public class Asztal {
    private String nev;
    private ArrayList<Etel>etelek;

    public Asztal(String nev, ArrayList<Etel> Etelek) {
        this.nev = nev;
        this.etelek = Etelek;
    }

    public String getNev() {
        return nev;
    }

    public ArrayList<Etel> getEtelek() {
        return etelek;
    }
    
    
    public void etelekListaba(Etel etel){
        etelek.add(etel);
    
    }
    
    public int osszeg(){
        int sum = 0;
        for (Etel e : etelek) {
            sum += e.getAr();
        }
        return sum;
    }
    
}
