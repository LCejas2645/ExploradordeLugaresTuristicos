package com.softlc.exploradordelugaresturisticos.ui.salir;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softlc.exploradordelugaresturisticos.databinding.FragmentGalleryBinding;
import com.softlc.exploradordelugaresturisticos.databinding.FragmentSalirBinding;
import com.softlc.exploradordelugaresturisticos.ui.gallery.GalleryViewModel;

public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Dialogo.mostrarDialogo(getContext());
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
