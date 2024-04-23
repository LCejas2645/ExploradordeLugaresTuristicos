package com.softlc.exploradordelugaresturisticos.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;
import com.softlc.exploradordelugaresturisticos.R;
import com.softlc.exploradordelugaresturisticos.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    public static int tipoMapa = 1;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Switch switchMapa = binding.switchMapa;
        Switch switchIdioma = binding.switchIdioma;


        slideshowViewModel.getTipoMapa().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer tipoMapa2) {
                Log.d("salida", "onChanged: cambio tipo de mapa a "+tipoMapa2);
                tipoMapa = tipoMapa2;
            }
        });

        switchMapa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("salida", "onCheckedChanged: swtch cambiado");
                slideshowViewModel.cambiarMapa(isChecked);
            }
        });


        //final TextView textView = binding.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}