package com.example.fartos2086;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CharacterSelect extends Activity {
    EditText nom1, nom2, nom3, nom4, nom5, nom6;
    Button mesJugadors, aceptar;
    List<String> noms = new ArrayList<>();
    List<EditText> mesNoms = new ArrayList<>();
    int jugadors = 3;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.character_layout);
        nom1 = (EditText) findViewById(R.id.nom1);
        nom2 = (EditText) findViewById(R.id.nom2);
        nom3 = (EditText) findViewById(R.id.nom3);
        nom4 = (EditText) findViewById(R.id.nom4);
        nom5 = (EditText) findViewById(R.id.nom5);
        nom6 = (EditText) findViewById(R.id.nom6);
        mesNoms.add(nom4);
        mesNoms.add(nom5);
        mesNoms.add(nom6);
        EditText[] totalNoms = {nom1, nom2, nom3, nom4, nom5, nom6};

        mesJugadors = (Button) findViewById(R.id.mesJugadors);
        aceptar = (Button) findViewById(R.id.aceptar);

        mesJugadors.setOnClickListener(view -> {
             if (mesNoms.size() != 0){
                 mesNoms.get(0).setVisibility(View.VISIBLE);
                 mesNoms.remove(0);
                 jugadors++;
             }
             else {
                 Toast.makeText(this, "Només 6 jugadors", Toast.LENGTH_SHORT).show();
             }
        });

        aceptar.setOnClickListener(view -> {
            for (EditText totalNom : totalNoms) {
                noms.add(totalNom.getText().toString());
                System.out.println(totalNom.getText().toString());
            }
            Intent intent =  new Intent(CharacterSelect.this, Joc.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARRAYLIST", (Serializable) noms);
            intent.putExtra("NOMS_JUGADORS", bundle);
            startActivity(intent);
        });
    }
}
