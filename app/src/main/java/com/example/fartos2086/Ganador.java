package com.example.fartos2086;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class Ganador extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganador_layout);

        Intent intent = this.getIntent();
        String nomGanador = intent.getStringExtra("GanadorNombre");
        int fotoGanadorInt = intent.getIntExtra("GanadorFoto", 0);
        ImageView fotoGanador = findViewById(R.id.fotoGanador);
        TextView textView = findViewById(R.id.nombreGanador);

        fotoGanador.setImageResource(fotoGanadorInt);
        textView.setText(nomGanador);
    }
}
