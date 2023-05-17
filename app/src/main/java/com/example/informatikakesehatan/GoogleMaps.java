package com.example.informatikakesehatan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GoogleMaps extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    boolean isPermissionGranted;
    GoogleMap mGoogleMap;
    FloatingActionButton fab, fab1, fab2, fab3, fab4;
    ExtendedFloatingActionButton efab1;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;


    private FusedLocationProviderClient mLocationClient;
    private int GPS_REQUEST_CODE = 9001;
    EditText locSearch;
    ImageView searchIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);
        fab4 = findViewById(R.id.fab4);

        efab1 = findViewById(R.id.efab3);


        locSearch = findViewById(R.id.et_search);
        searchIcon = findViewById(R.id.search_icon);

        // Animation
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);


        checkMyPermission();

        initMap();

        mLocationClient = new FusedLocationProviderClient(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(GoogleMaps.this, "Normal", Toast.LENGTH_SHORT).show();
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(GoogleMaps.this, "Terrain", Toast.LENGTH_SHORT).show();
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(GoogleMaps.this, "Satellite", Toast.LENGTH_SHORT).show();
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(GoogleMaps.this, "Hybrid", Toast.LENGTH_SHORT).show();
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        efab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearbyplaceHos();
            }
        });


        searchIcon.setOnClickListener(this::geoLocate);

    }

    private void nearbyplaceHos() {

        //If the device does not have a map installed, then redirect it to play store
        try {
            //When google map is installed
            //Initialize uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/search/Nearby" + "hospital");
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //Set package
            intent.setPackage("com.google.android.apps.maps");
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            //When google map is not installed
            //Initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);
        }

    }



    private void animateFab() {
        if (isOpen) {

            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab4.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            isOpen = false;

        } else {

            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab4.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            isOpen = true;

        }
    }


    private void geoLocate(View view) {
        String locationName = locSearch.getText().toString();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addressList = geocoder.getFromLocationName(locationName, 3);

            if (addressList.size() > 0) {
                Address address = addressList.get(0);

                gotoLocation(address.getLatitude(), address.getLongitude());

                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(address.getLatitude(), address.getLongitude())));

                Toast.makeText(this, address.getLocality(), Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
        }
    }

    private void initMap() {
        if (isPermissionGranted) {
            if (isGPSenable()) {
                SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                supportMapFragment.getMapAsync(this);
            }
        }
    }


    private boolean isGPSenable() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        boolean providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (providerEnable) {
            return true;
        } else {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("GPS Permission")
                    .setMessage("GPS is required for this app to work. Please enable GPS")
                    .setPositiveButton("Yes", ((dialogInterface, i) -> {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_REQUEST_CODE);
                    }))
                    .setCancelable(false)
                    .show();
        }
        return false;
    }


    @SuppressLint("MissingPermission")
    private void getCurrLoc() {
        mLocationClient.getLastLocation().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Location location = task.getResult();
                gotoLocation(location.getLatitude(), location.getLongitude());
            }
        });
    }

    private void gotoLocation(double latitude, double longitude) {
        LatLng LatLng = new LatLng(latitude, longitude);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng, 18);
        mGoogleMap.moveCamera(cameraUpdate);

    }

    private void checkMyPermission() {
        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(GoogleMaps.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                isPermissionGranted = true;
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Intent intent5 = new Intent();
                intent5.setAction(Settings.ACTION_APPLICATION_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), "");
                intent5.setData(uri);
                startActivity(intent5);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMyLocationEnabled(true);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GPS_REQUEST_CODE) {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            boolean providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (providerEnable) {
                Toast.makeText(this, "GPS is enable", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS is not enable", Toast.LENGTH_SHORT).show();
            }
        }
    }
}