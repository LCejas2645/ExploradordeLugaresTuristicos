package com.softlc.exploradordelugaresturisticos.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softlc.exploradordelugaresturisticos.R;
import com.softlc.exploradordelugaresturisticos.ui.Modelo.LugarTuristico;

import java.util.List;

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.ViewHolder> {
    private List<LugarTuristico> listaDeLugares;
    private Context context;
    private LayoutInflater li;

    public LugarAdapter(List<LugarTuristico> listaDeLugares, Context context, LayoutInflater li) {
        this.listaDeLugares = listaDeLugares;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LugarTuristico lt = listaDeLugares.get(position);
        holder.nombre.setText(lt.getNombre());
        holder.descripcion.setText(lt.getDescripcion());
        holder.foto.setImageResource(lt.getFoto());
    }

    @Override
    public int getItemCount() {
        return listaDeLugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,descripcion;
        ImageView foto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre=itemView.findViewById(R.id.tvNombre);
            descripcion=itemView.findViewById(R.id.tvDescripcion);
            foto=itemView.findViewById(R.id.imFoto);

        }
    }

}
