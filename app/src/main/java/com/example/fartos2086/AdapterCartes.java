package com.example.fartos2086;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCartes extends RecyclerView.Adapter<AdapterCartes.ViewHolder> {
    private final List<Carta> baralla;
    public interface onItemClickListener {
        void onItemClick(GameState gameState);
    }

    private onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public enum tipuscarta {
        MOV_1(28), MOV_2(18), MOV_3(10),
        TELEPORT(3), ZANCADILLA(4), PATADA(3),
        HUNDIMIENTO(2), BROMA(2);

        private int numCartes;
        public int getNumCartes() { return numCartes; }

        tipuscarta(int numCartes) {
            this.numCartes = numCartes;
        }
    }
    public AdapterCartes(List<Carta> baralla) {
        this.baralla = baralla;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView carta1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carta1 = (ImageView) itemView.findViewById(R.id.carta1);
        }
        public ImageView getCarta1(){
            return carta1;
        }
    }

    @NonNull
    @Override
    public AdapterCartes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartes_dades, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Carta carta = baralla.get(position);
        switch (carta.getEfecte()){
            case MOV_1:
                holder.carta1.setImageResource(R.drawable.mover_1);
                break;
            case MOV_2:
                holder.carta1.setImageResource(R.drawable.mover_2);
                break;
            case MOV_3:
                holder.carta1.setImageResource(R.drawable.mover_3);
                break;
            case TELEPORT:
                holder.carta1.setImageResource(R.drawable.teleport);
                break;
            case ZANCADILLA:
                holder.carta1.setImageResource(R.drawable.zancadilla);
                break;
            case PATADA:
                holder.carta1.setImageResource(R.drawable.patada);
                break;
            case BROMA:
                holder.carta1.setImageResource(R.drawable.broma);
                break;
            case HUNDIMIENTO:
                holder.carta1.setImageResource(R.drawable.hundimiento);
                break;
        }
        holder.carta1.setOnClickListener(view -> {
            GameState gameState = new GameState();
            gameState.setCardPosition(position);
            gameState.setCardName(carta.getEfecte().toString());
            if (listener != null) {
                listener.onItemClick(gameState);
            }
        });
    }

    @Override
    public int getItemCount() {
        return baralla.size();
    }
}
