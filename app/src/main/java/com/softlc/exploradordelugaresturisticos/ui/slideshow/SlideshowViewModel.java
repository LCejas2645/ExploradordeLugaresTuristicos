package com.softlc.exploradordelugaresturisticos.ui.slideshow;

import android.app.Application;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends AndroidViewModel {

//    private MutableLiveData<Boolean> mSwitch = new MutableLiveData<>();

    private boolean mSwitch;
    private MutableLiveData<Integer> mTipoMapa = new MutableLiveData<>();

    public SlideshowViewModel(@NonNull Application application) {
        super(application);
    }

//    public LiveData<Boolean> getMSwitch() {
//        if (mSwitch==null){
//            mSwitch = new MutableLiveData<>();
//        }
//        return mSwitch;
//    }

    public LiveData<Integer> getTipoMapa() {
        if (mTipoMapa==null){
            mTipoMapa = new MutableLiveData<>();
        }
        return mTipoMapa;
    }

    public void cambiarMapa(boolean estado){

        //mSwitch.setValue(estado);
        if (estado==true){
            mTipoMapa.setValue(2);
        }else{
            mTipoMapa.setValue(1);
        }
    }
}