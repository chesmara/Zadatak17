package com.example.sninkovic_ns.zadatak15.activities.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sninkovic_ns.zadatak15.R;
import com.example.sninkovic_ns.zadatak15.activities.provider.JeloProvajder;
import com.example.sninkovic_ns.zadatak15.activities.provider.KategorijaProvajder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class DetailFragment extends Fragment {


    private int position = 0;
 //-------------------------------------------------------
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
    }
  //--------------------------------------------------------------
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);



        if(savedInstanceState !=null){
            position= savedInstanceState.getInt("position", 0);
        }

//--------------------------------------image---------------------------------
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is=null;

        try {
            is=getActivity().getAssets().open(JeloProvajder.getJeloById(position).getSlika());
            Drawable drawable=Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
 //-----------------------------------------------------------------------------------------
        TextView tvNaziv = (TextView) getView().findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvajder.getJeloById(position).getNaziv());
 //----------------------------------------------------------------------------------------
        TextView tvOpis = (TextView) getView().findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvajder.getJeloById(position).getOpis());
 //----------------------------------------------------------------------------------------
        Spinner kategorija = (Spinner) getView().findViewById(R.id.sp_kategorija);
        List<String> kategorije= KategorijaProvajder.getKategorijaNazivi();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection(JeloProvajder.getJeloById(position).getKategorija().getId());
//------------------------------------------------------------------------------------------------
        TextView tvKalorije = (TextView) getView().findViewById(R.id.tv_kalorije);
        tvKalorije.setText(JeloProvajder.getJeloById(position).getOpis());
//----------------------------------------------------------------------------------------------------
        TextView tvCena = (TextView) getView().findViewById(R.id.tv_cena);
        tvCena.setText(JeloProvajder.getJeloById(position).getOpis());


    }
    //--------------------------------------------------------------------------------------------
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }
//---------------------------------------------------------------------------------------------------
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState( savedInstanceState );


        savedInstanceState.putInt( "position", position );
    }


    //-------------------------------------------------------------------------------------------------
    public void setContent(final int position){
        this.position=position;

    }
    //------------------------------------------------------------------------------------------------
    public void updateContent(final int position){
        this.position=position;

        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is=null;

        try {
            is=getActivity().getAssets().open(JeloProvajder.getJeloById(position).getSlika());
            Drawable drawable=Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView tvNaziv = (TextView) getView().findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvajder.getJeloById(position).getNaziv());
        //----------------------------------------------------------------------------------------
        TextView tvOpis = (TextView) getView().findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvajder.getJeloById(position).getOpis());
        //----------------------------------------------------------------------------------------
        Spinner kategorija = (Spinner) getView().findViewById(R.id.sp_kategorija);
        List<String> kategorije= KategorijaProvajder.getKategorijaNazivi();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection(JeloProvajder.getJeloById(position).getKategorija().getId());


    }
}
