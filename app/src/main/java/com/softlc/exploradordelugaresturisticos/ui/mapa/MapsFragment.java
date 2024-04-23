package com.softlc.exploradordelugaresturisticos.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softlc.exploradordelugaresturisticos.R;
import com.softlc.exploradordelugaresturisticos.databinding.FragmentMapsBinding;
import com.softlc.exploradordelugaresturisticos.ui.slideshow.SlideshowFragment;

public class MapsFragment extends Fragment {

    //private SlideshowFragment slideshowFragment = new SlideshowFragment();
    private GoogleMap mMap;
    private MapsViewModel mapsViewModel;
    private FusedLocationProviderClient fusedLocationClient;
    private FragmentMapsBinding binding;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            // Solicitar la ubicación actual del dispositivo


            mapsViewModel.getMLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
                @Override
                public void onChanged(Location location) {
                    if (location != null) {
                        mMap.setMapType(SlideshowFragment.tipoMapa);
                        // Agregar marcador para Plaza del Cerro , -33.28196768685058, -66.30024650881231
                        LatLng ubicacionManual6 = new LatLng(-33.28196768685058, -66.30024650881231);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual6).title("Plaza del Cerro"));
                        // Agregar marcador para Cine Teatro San Luis - Espacio Cultural -33.273829558460015, -66.3384475691173
                        LatLng ubicacionManual5 = new LatLng(-33.273829558460015, -66.3384475691173);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual5).title("Cine Teatro San Luis - Espacio Cultural"));
                        // Agregar marcador para Universidad Nacional de San Luis -33.290908574611684, -66.33918790194056
                        LatLng ubicacionManual4 = new LatLng(-33.290908574611684, -66.33918790194056);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual4).title("Universidad Nacional de San Luis"));
                        // Agregar marcador para San Luis Shopping -33.30486178487857, -66.32288605383845
                        LatLng ubicacionManual3 = new LatLng(-33.30486178487857, -66.32288605383845);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual3).title("San Luis Shopping"));
                        // Agregar marcador para lAutódromo Rosendo Hernández -33.32856492575438, -66.39408359042935
                        LatLng ubicacionManual2 = new LatLng(-33.32856492575438, -66.39408359042935);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual2).title("Autódromo Rosendo Hernández"));
                        // Agregar marcador para la Parque de las naciones -33.29114668646438, -66.3123803106226
                        LatLng ubicacionManual1 = new LatLng(-33.29114668646438, -66.3123803106226);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual1).title("Parque de las naciones"));
                        // Agregar marcador para la cancha de estudiantes -33.28766053601576, -66.34066442898747
                        LatLng ubicacionManual = new LatLng(-33.28766053601576, -66.34066442898747);
                        mMap.addMarker(new MarkerOptions().position(ubicacionManual).title("Cancha de estudiantes"));
                        // Agregar marcador en la ubicación actual del dispositivo
                        LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(currentLocation).title("Ubicación Actual"));

                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));

                    }
                }
            });

            mapsViewModel.obtenerUltimaUbicacion();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapsViewModel = new ViewModelProvider(this).get(MapsViewModel.class);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}