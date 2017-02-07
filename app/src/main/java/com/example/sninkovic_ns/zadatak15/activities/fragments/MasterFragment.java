package com.example.sninkovic_ns.zadatak15.activities.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.sninkovic_ns.zadatak15.R;
import com.example.sninkovic_ns.zadatak15.activities.provider.JeloProvajder;

import java.util.List;

/**
 * Created by SNinkovic_ns on 7.2.2017.
 */

public class MasterFragment extends Fragment {

    OnItemSelectedListener listener;




  //-----------------------onCreate------------------------------------------------------------------
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

  //---------------------onActivityCreate------------------------------------------------------------
    public void onActivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);


        final List<String> jelaNazivi = JeloProvajder.getJelaNazivi();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, jelaNazivi);
        ListView listView= (ListView) getActivity().findViewById(R.id.listJela);

        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view , int position, long id){
                listener.onItemSelected(position);
            }
        });
    }
  //------------------------onCreateView----------------------------------------------------------------
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(container == null){
            return null;
        }

        View view=inflater.inflate(R.layout.fragment_master, container,false);
        return view;
    }

 //----------------------onAttach------------------------------------------------------------------
    public void onAttach(Activity activity){

        super.onAttach(activity);
        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must implement OnItemSelectListener");
        }
    }

    public interface OnItemSelectedListener{

        public void onItemSelected(int position);
    }
}
