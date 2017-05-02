package edu.uw.cjjaeger.labmap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        LatLng mary= new LatLng(47.655, -122.3078);
        LatLng johnson = new LatLng(47.6546, -122.3089);
        LatLng fount1 = new LatLng(47.653951, -122.308179);
        LatLng middle = new LatLng(47.654404, -122.308164);
        LatLng fount2 = new LatLng(47.654095, -122.3079);



        mMap.addMarker(new MarkerOptions()
                .position(mary)
                .title("Marker at Mary Gates Hall")
                .snippet("Wow mary gates is sooooo great!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mary));

        PolylineOptions opts = new PolylineOptions();
        opts.add(johnson, fount1, middle,fount2, mary );
        mMap.addPolyline(opts.color(Color.BLUE).width(10));

    }
}
