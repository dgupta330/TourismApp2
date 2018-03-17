package com.dgproduction.erdeepak_kumar.tourismapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity  {
Button create_btn,search_btn;
ListView placeslist;
Places_DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        create_btn=findViewById(R.id.btn_create_places);
        search_btn=findViewById(R.id.btn_search_places);
        placeslist=findViewById(R.id.lv_place_places);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PlacesActivity.this,CreatePlaceActivity.class);
                startActivity(i);
            }
        });

        db = new Places_DatabaseHelper(this);

        final ArrayList<Places> placesdetail= db.getAllPlaces();
        final MyPlacesAdapter adapter= new MyPlacesAdapter(this,placesdetail);
        placeslist.setAdapter(adapter);

        placeslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PlacesActivity.this,PlaceDetailActivity.class);
                intent.putExtra("PLACESDETAILS", (Serializable)adapterView.getItemAtPosition(i));
              //  intent.putExtra("PLACESDETAILS", (Serializable) placesdetail.get(i));

                startActivity(intent);
            }
        });
    }
}
