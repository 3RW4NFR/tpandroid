package com.example.m4104_tp_turkcan_erwan_a1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class SecondActivity extends Activity implements View.OnClickListener {

    private Button retour, ajout;
    private EditText Nom, Prenom, Numero;
    private Spinner grp;
    private String groupe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Nom = (EditText)findViewById(R.id.editText5);
        Prenom = (EditText)findViewById(R.id.editText6);
        Numero = (EditText)findViewById(R.id.editText7);

        grp = (Spinner) this.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.groupe_array,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grp.setAdapter(adapter);
        grp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                groupe = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        retour = (Button) this.findViewById(R.id.button);
        retour.setOnClickListener(this);

        ajout = (Button) this.findViewById(R.id.button2);
        ajout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button2){
            String nom = Nom.getText().toString();
            String prenom = Prenom.getText().toString();
            String num = Numero.getText().toString();
            Contact contact = new Contact(nom,prenom,num,/*lat,lon,*/groupe);
            DataBase db = new DataBase(getApplicationContext());
            db.insert(contact);
            Toast.makeText(this, "Contact ajouté(e)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
