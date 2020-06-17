package com.example.applogin;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Maps extends FragmentActivity implements OnMapReadyCallback {
    float latitud , longitud;
    String  latitudString , longitudString;
    String informacion;



    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        informacion = getIntent().getStringExtra("Informacion");
        String[] infom = informacion.split("\n");
        String[] info2=infom[3].split("=");
        String[] info3=infom[4].split("=");
        latitudString = info2 [1];
        longitudString = info3 [1];
        latitud = Float.valueOf(latitudString);
        longitud = Float.valueOf(longitudString);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Republica Domnicana"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
    }
}
