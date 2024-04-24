package com.softlc.exploradordelugaresturisticos.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softlc.exploradordelugaresturisticos.R;
import com.softlc.exploradordelugaresturisticos.databinding.FragmentDescripcionBinding;
import com.softlc.exploradordelugaresturisticos.ui.Modelo.LugarTuristico;

public class DescripcionFragment extends Fragment {
    private FragmentDescripcionBinding binding;
    private DescripcionViewModel mViewModel;

    public static DescripcionFragment newInstance() {
        return new DescripcionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DescripcionViewModel descripcionViewModel = new ViewModelProvider(this).get(DescripcionViewModel.class);

        binding = FragmentDescripcionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        descripcionViewModel.getMLugar().observe(getViewLifecycleOwner(), new Observer<LugarTuristico>() {
            @Override
            public void onChanged(LugarTuristico lugarTuristico) {
                if(lugarTuristico!= null){
                    TextView lugar =binding.tvTitulo;
                    TextView descripcion = binding.tvDescripcionLugar;
                    ImageView foto = binding.ivFoto;
                    TextView hora = binding.tvHorario;

                    lugar.setText(lugarTuristico.getNombre());
                    descripcion.setText(lugarTuristico.getDescripcion());
                    foto.setImageResource(lugarTuristico.getFoto());
                    hora.setText(lugarTuristico.getHorario());
                }
            }
        });

        Bundle bundle = getArguments();
        descripcionViewModel.descripcionLugar(bundle);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DescripcionViewModel.class);
        // TODO: Use the ViewModel
    }

}