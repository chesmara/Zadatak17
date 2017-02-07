package com.example.sninkovic_ns.zadatak15.activities.provider;

import com.example.sninkovic_ns.zadatak15.activities.model.Jelo;
import com.example.sninkovic_ns.zadatak15.activities.model.Sastojak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SNinkovic_ns on 3.2.2017.
 */

public class SastojakProvajder {

    public static List<String> getSastojakNazivi(Jelo jelo){

        List<String> nazivi= new ArrayList<>();
        for(Sastojak sastojak: jelo.getSastojci()){
            nazivi.add(sastojak.getNaziv());
        }

        return nazivi;
    }

}
