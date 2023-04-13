package com.example.fartos2086;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFotos extends RecyclerView.Adapter<AdapterFotos.ViewHolder> {
    private final List<Jugador> jugadorList;

    public interface onItemClickListener {
        void onItemClick(Jugador jugador);
    }

    private onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }


    public AdapterFotos(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.fotoJugadorFragment);
        }
        public ImageView getFoto(){
            return foto;
        }
    }


    @NonNull
    @Override
    public AdapterFotos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.imatges_dades, parent, false);
        return new AdapterFotos.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFotos.ViewHolder holder, int position) {
        holder.foto.setImageResource(jugadorList.get(position).getFoto());
        holder.foto.setOnClickListener(view -> {
            Jugador jugador = jugadorList.get(position);
            if (listener != null) {
                listener.onItemClick(jugador);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jugadorList.size();
    }
}
