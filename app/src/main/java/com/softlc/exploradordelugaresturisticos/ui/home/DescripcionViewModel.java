package com.softlc.exploradordelugaresturisticos.ui.home;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softlc.exploradordelugaresturisticos.ui.Modelo.LugarTuristico;

public class DescripcionViewModel extends AndroidViewModel {
    private MutableLiveData<LugarTuristico> mLugar;
    public DescripcionViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<LugarTuristico> getMLugar() {
        if(mLugar == null){
            mLugar = new MutableLiveData<>();
        }
        return mLugar;
    }

    public void descripcionLugar(Bundle bundle){
        LugarTuristico lugar = (LugarTuristico) bundle.getSerializable("lugar");
        if(lugar!= null){
            mLugar.setValue(lugar);
        }
    }
}