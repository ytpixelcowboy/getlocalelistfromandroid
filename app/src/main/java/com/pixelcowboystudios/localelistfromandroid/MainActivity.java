package com.pixelcowboystudios.localelistfromandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arry_iso = new ArrayList<>();
    ArrayList<String> arry_names = new ArrayList<>();

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        String[] locales = Locale.getISOCountries();

        for (String locale : locales) {
            Locale locale1 = new Locale("", locale); //Gets the Country Name via ISO Country Code
            arry_names.add(locale1.getDisplayCountry()); //Gets the Country name 
            arry_iso.add(locale); //Gets the Country ISO Code
        }

        Log.i("Locales names", arry_names.toString());
        Log.i("Locales iso", arry_iso.toString());

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        RecyclerViewAdapter_country adapter_country = new RecyclerViewAdapter_country(MainActivity.this, arry_names, arry_iso, new RecyclerViewAdapter_country.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Country Name: " + arry_names.get(position) + "\n" +"ISO Code: " + arry_iso.get(position))
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Do something
                            }
                        })
                        .setTitle("Country")
                        .setCancelable(false).show();
            }
        });

        rv.setLayoutManager(llm);
        rv.setAdapter(adapter_country);
    }
}
