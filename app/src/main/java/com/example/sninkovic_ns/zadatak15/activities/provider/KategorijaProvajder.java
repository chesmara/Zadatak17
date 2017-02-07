package com.example.sninkovic_ns.zadatak15.activities.provider;

import com.example.sninkovic_ns.zadatak15.activities.model.Kategorija;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SNinkovic_ns on 3.2.2017.
 */

public class KategorijaProvajder {

    public static List<String> getKategorijaNazivi(){

        List<String> nazivi=new ArrayList<>();
        nazivi.add("varivo");
        nazivi.add("rostilj");
        return nazivi;

    }

    public static Kategorija getKategorijaById(int id){

        switch (id){
            case 0:
                return new Kategorija(0,"varivo");
            case 1:
                return new Kategorija(1, "rostilj");
            default:
                return null;

        }
    }
}
