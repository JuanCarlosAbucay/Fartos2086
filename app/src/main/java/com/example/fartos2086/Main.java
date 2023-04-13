package com.example.fartos2086;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Main extends Activity {
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.main_layout);
        Button playButton = (Button) findViewById(R.id.play);
        playButton.setOnClickListener(view -> {
            startActivity(new Intent(Main.this, CharacterSelect.class));
        });
    }
}
