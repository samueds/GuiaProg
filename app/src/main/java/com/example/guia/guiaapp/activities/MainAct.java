package com.example.guia.guiaapp.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guia.guiaapp.R;

public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        if(android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy =  new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button botaolog = (Button) findViewById(R.id.bto_loginScreen);
        botaolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent itlog = new Intent(MainAct.this, Act_log.class);

                startActivity(itlog);
            }
        });

        Button botaocad = (Button) findViewById(R.id.bto_cadScreen);
        botaocad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent itcad = new Intent(MainAct.this, Act_cad.class);

                startActivity(itcad);
            }
        });
     }
}
