package com.example.sninkovic_ns.zadatak15.activities.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sninkovic_ns.zadatak15.R;
import com.example.sninkovic_ns.zadatak15.activities.provider.JeloProvajder;
import com.example.sninkovic_ns.zadatak15.activities.provider.KategorijaProvajder;
import com.example.sninkovic_ns.zadatak15.activities.provider.SastojakProvajder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

/**
 * Created by SNinkovic_ns on 3.2.2017.
 */

public class SecondActivity extends Activity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_linear);


        final int position = getIntent().getIntExtra("position", 0);

        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is=null;

        try {
            is=getAssets().open(JeloProvajder.getJeloById(position).getSlika());
            Drawable drawable=Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //--------------------------------

        TextView tvNaziv = (TextView) findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvajder.getJeloById(position).getNaziv());

      //----------------------------------
        TextView tvOpis = (TextView) findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvajder.getJeloById(position).getOpis());

      //----------------------------------------
        Spinner kategorija = (Spinner) findViewById(R.id.sp_kategorija);
        List<String> kategorije= KategorijaProvajder.getKategorijaNazivi();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection(JeloProvajder.getJeloById(position).getKategorija().getId());

      //------------------------

        final List<String> sastojciNazivi = SastojakProvajder.getSastojakNazivi(JeloProvajder.getJeloById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, sastojciNazivi);

        ListView listView = (ListView) findViewById(R.id.list_sastojci);
        listView.setAdapter(dataAdapter);

       //-----------------

        TextView tvKalorije = (TextView) findViewById(R.id.tv_kalorije);
        tvKalorije.setText(String.format(Locale.getDefault(), getString(R.string.jelo_calories), JeloProvajder.getJeloById(position).getKalorije() ));

        //-------------------
        TextView tvCena = (TextView) findViewById(R.id.tv_cena);
        tvCena.setText(String.format(Locale.getDefault(), getString(R.string.jelo_price), JeloProvajder.getJeloById(position).getCena()   ));










    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
