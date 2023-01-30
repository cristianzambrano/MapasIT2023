package com.example.mapasit2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener

        {
GoogleMap  Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
         mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Mapa = googleMap;
        Mapa.setOnMapClickListener(this);
        Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate camUpd1 =
        CameraUpdateFactory
       .newLatLngZoom(new LatLng(25.263562248891517, 51.44841735592981), 20 );

       Mapa.moveCamera(camUpd1);

        LatLng madrid = new LatLng(25.263562248891517, 51.44841735592981);

       /* CameraPosition camPos = new CameraPosition.Builder()
                .target(madrid)
                .zoom(17)
                .bearing(30)      //noreste arriba
                .tilt(70)         //punto de vista de la cámara 70 grados
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        Mapa.animateCamera(camUpd3);*/

        PolylineOptions lineas = new PolylineOptions()

        .add(new LatLng(25.265066, 51.446383))
        .add(new LatLng(25.262382, 51.446308))
        .add(new LatLng(25.262493, 51.450407))
        .add(new LatLng(25.265414, 51.449508))
        .add(new LatLng(25.265066, 51.446383));

        lineas.width(8);
        lineas.color(Color.RED);

        Mapa.addPolyline(lineas);

        LatLng punto = new LatLng(25.263831,51.448076);
        Mapa.addMarker(new MarkerOptions().position(punto)
        .title("Estadio Internacional Jalifa إستاد خليفة الدولي"));


    }

            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                Projection proj = Mapa.getProjection();
                Point coord = proj.toScreenLocation(latLng);

                    Toast.makeText(
                        MainActivity.this,
                        "Click\n" +
                        "Lat: " + latLng.latitude + "\n" +
                        "Lng: " + latLng.longitude + "\n" +
                        "X: " + coord.x + " - Y: " + coord.y,
                        Toast.LENGTH_SHORT).show();

            }
        }

        //25.265066, 51.446383
//25.262382, 51.446308
//25.262493, 51.450407
//25.265414, 51.449508

