package com.example.app7;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;import com.google.android.gms.maps.OnMapReadyCallback;import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
@Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
         CameraUpdate camUpd1 =
            CameraUpdateFactory
                    .newLatLngZoom(new LatLng(-1.0125, -79.4693), 17);
         mapa.moveCamera(camUpd1);

//    LatLng metlife = new LatLng(40.8122, -74.0764);

//    CameraPosition camPos = new CameraPosition.Builder()
//            .target(metlife)
//            .zoom(18)      // Zoom adecuado para ver el estadio completo
//            .bearing(0)    // 0 es Norte (visto desde abajo hacia arriba)
//            .tilt(65)      // Inclinación alta para ver perspectiva
//            .build();
//    CameraUpdate camUpd3 =
//            CameraUpdateFactory.newCameraPosition(camPos);
//    mapa.animateCamera(camUpd3);

    PolylineOptions lineas = new
            PolylineOptions()

            .add(new LatLng(-1.0123, -79.4672))

            .add(new LatLng(-1.0119, -79.4717))

            .add(new LatLng(-1.0130, -79.4716))

            .add(new LatLng(-1.0132, -79.4674))

            .add(new LatLng(-1.0123, -79.4672));

    lineas.width(8);

    lineas.color(Color.RED);

    mapa.addPolyline(lineas);

    LatLng punto = new LatLng(-1.0125,
            -79.4693);
    mapa.addMarker(new
            MarkerOptions().position(punto)
            .title("UTEQ"));
}}
