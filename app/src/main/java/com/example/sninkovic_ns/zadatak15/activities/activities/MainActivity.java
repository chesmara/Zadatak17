package com.example.sninkovic_ns.zadatak15.activities.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sninkovic_ns.zadatak15.R;
import com.example.sninkovic_ns.zadatak15.activities.provider.JeloProvajder;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final List<String> jelaNazivi = JeloProvajder.getJelaNazivi();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, jelaNazivi);
        ListView listView= (ListView) findViewById(R.id.listJela);

        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }

        });



    }
/*
    public MainActivity() {
        super();
    }
*/
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
    protected void onPostResume() {
        super.onPostResume();
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
