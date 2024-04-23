package com.softlc.exploradordelugaresturisticos.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softlc.exploradordelugaresturisticos.MainActivity;
import com.softlc.exploradordelugaresturisticos.databinding.FragmentHomeBinding;
import com.softlc.exploradordelugaresturisticos.ui.Modelo.LugarTuristico;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getMlistaLugar().observe(getViewLifecycleOwner(), new Observer<List<LugarTuristico>>() {
            @Override
            public void onChanged(List<LugarTuristico> lugarTuristicos) {
                LugarAdapter la = new LugarAdapter(lugarTuristicos, getContext(),getLayoutInflater());
                GridLayoutManager glm=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
                RecyclerView rc=binding.lista;
                rc.setLayoutManager(glm);
                rc.setAdapter(la);
            }
        });
        homeViewModel.crearListaLugar();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}