package com.softlc.exploradordelugaresturisticos.ui.gallery;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class GalleryViewModel extends AndroidViewModel {
    private FusedLocationProviderClient fused;
    private MutableLiveData<Location> mLocation;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());

    }

    public LiveData<Location> getMLocation() {
        if (mLocation == null) {
            this.mLocation = new MutableLiveData<Location>();
        }

        return mLocation;
    }

    public void obtenerUltimaUbicacion() {
        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d("salida", "obtenerUltimaUbicacion: sin permiso ");
            return;
        }
        Task<Location> task = fused.getLastLocation();
        task.addOnSuccessListener(getApplication().getMainExecutor()    , new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    mLocation.postValue(location);
                }
            }
        });
    }
}