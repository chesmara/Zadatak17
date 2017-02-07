package com.example.sninkovic_ns.zadatak15.activities.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.sninkovic_ns.zadatak15.R;
import com.example.sninkovic_ns.zadatak15.activities.fragments.DetailFragment;
import com.example.sninkovic_ns.zadatak15.activities.fragments.MasterFragment;

public class MainActivity extends Activity implements MasterFragment.OnItemSelectedListener{


    boolean landscape = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MasterFragment masterFragment = new MasterFragment();
            ft.add(R.id.listJela, masterFragment, "Master_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }


        if (findViewById(R.id.detail_view) != null) {
            landscape = true;
            getFragmentManager().popBackStack();

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            if(detailFragment == null){
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                detailFragment=new DetailFragment();
                ft.replace(R.id.detail_view,detailFragment, "Detail_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }


        }




    }

    /*
        public MainActivity() {
            super();
        }
    */
    @Override
    protected void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.

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
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public void onItemSelected(int postion){
        if(landscape){
            DetailFragment detailFragment=(DetailFragment) getFragmentManager().findFragmentById( R.id.detail_view );
            detailFragment.updateContent(postion);
        }else{
            DetailFragment detailFragment=new DetailFragment();
            detailFragment.setContent( postion );
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.replace( R.id.listJela, detailFragment , "Detail_fragment_2");
            ft.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
            ft.addToBackStack( null);
            ft.commit();

        }
    }




}



