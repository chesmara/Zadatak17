package com.example.sninkovic_ns.zadatak15.activities.provider;

import com.example.sninkovic_ns.zadatak15.activities.model.Jelo;
import com.example.sninkovic_ns.zadatak15.activities.model.Kategorija;
import com.example.sninkovic_ns.zadatak15.activities.model.Sastojak;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class JeloProvajder {

    public static List<String> getJelaNazivi() {

        List<String> nazivi = new ArrayList<>();
        nazivi.add("Pasulj");
        nazivi.add("Grasak");
        nazivi.add("Cevapi");
        nazivi.add("Pljeska");
        nazivi.add("Kobaja");
        return nazivi;
    }


    public static Jelo getJeloById(int id){
        Kategorija varivo = new Kategorija(0,"Varivo");
        Kategorija rostilj=new Kategorija(1,"Rostilj");

        Jelo rezultat;
        switch(id){

            case 0: {
                rezultat = new Jelo(0, "pasulj.jpg", "Pasulj", "Prebranac sa rebarcima i slaninom", varivo, 250, BigDecimal.valueOf(850));
                rezultat.getSastojci().add(new Sastojak(0, "Pasulj Tetovac", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Suva rebra", rezultat));
                break;
            }
            case 1: {
                rezultat = new Jelo(0, "grasak.jpg", "Grasak", "Grasak sa komadima mesa", varivo, 350, BigDecimal.valueOf(950));
                rezultat.getSastojci().add(new Sastojak(0, "Grasak", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Seckano meso", rezultat));
                break;
            }
            case 2: {
                rezultat = new Jelo(0, "cevapi.jpg", "Cevapi", "Sarajevski cevapi", rostilj, 250, BigDecimal.valueOf(350));
                rezultat.getSastojci().add(new Sastojak(0, "Junetina", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Ovcetina", rezultat));
                 break;
            }
            case 3: {
                rezultat = new Jelo(0, "pljeska.jpg", "Pljeska", "Sarajevska pljeska", rostilj, 250, BigDecimal.valueOf(350));
                rezultat.getSastojci().add(new Sastojak(0, "Junetina", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Ovcetina", rezultat));
                break;
            }
            case 4: {
                rezultat = new Jelo(0, "kobaja.jpg", "Kobaja", "Dimljena kobasica", rostilj, 450, BigDecimal.valueOf(450));
                rezultat.getSastojci().add(new Sastojak(0, "Junetina", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Ovcetina", rezultat));
                break;
            }
            default:
                rezultat=null;
        }

        return rezultat;

    }

}
