package com.softlc.exploradordelugaresturisticos.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softlc.exploradordelugaresturisticos.R;
import com.softlc.exploradordelugaresturisticos.ui.Modelo.LugarTuristico;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private  MutableLiveData<List<LugarTuristico>> mlistaLugar;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<LugarTuristico>> getMlistaLugar() {
        if (mlistaLugar==null){
            mlistaLugar = new MutableLiveData<>();
        }
        return mlistaLugar;
    }

    public void crearListaLugar(){
        ArrayList<LugarTuristico> lista=new ArrayList<>();
        lista.add(new LugarTuristico("Estadio Héctor Odicino-Pedro Benoza","Estadio de futbol",R.drawable.estudiantes,"08:00hs a 22:00hs"));
        lista.add(new LugarTuristico("UNSL","Universidad Nacional de San Luis",R.drawable.unsl,"06:00hs a 23:00hs"));
        lista.add(new LugarTuristico("Cine Teatro San Luis - Espacio Cultural","Un espacio que abraza a todas las artes. TICKETS Y FORMULARIO DE VISITAS GUIADAS. Av. Justo Daract y Prof. Berrondo, San Luis, Argentina.",R.drawable.cineteatro,"08:00hs a 20:00hs"));
        lista.add(new LugarTuristico("Parque De Las Naciones","Bienvenidos. Parque de las Naciones. A tan sólo cinco minutos en caminata de la capital de San Luis. Un espacio verde para disfrutar en familia.",R.drawable.parquedelasnaciones,"08:00hs a 23:00hs"));
        lista.add(new LugarTuristico("Plaza del Cerro","Un Buen lugar para Pasar la tarde, disfrutando de una vista espectacular, con bici sendas para correr, disfrutar en familia y Eventos.",R.drawable.plazadelcerro,"abierto las 24hs"));
        lista.add(new LugarTuristico("San Luis Shopping","Centro comercial con populares cadenas de tiendas, cine, área de juego infantil y un amplio patio de comidas.",R.drawable.shopping,"06:00hs a 23:00hs"));
        lista.add(new LugarTuristico("Autódromo Rosendo Hernández","Circuito de carreras",R.drawable.autodromo,"08:00hs a 20:00hs"));
        mlistaLugar.setValue(lista);
    }

}