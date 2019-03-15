package com.example.m4104_tp_turkcan_erwan_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private EditText champ;
    private Button boutton;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.champ = findViewById(R.id.editText);
        this.boutton = findViewById(R.id.valider);
        boutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (champ.getText().toString().equals(""))
                { MessageBox("Vide"); }
                else { MessageBox("Bienvenue " + champ.getText().toString());
                    setContentView(R.layout.activity2);
                }
            }
        });
    }

    public void MessageBox(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
