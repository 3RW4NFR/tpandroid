package com.example.m4104_tp_turkcan_erwan_a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView liste;
    private DataBase db ;
    private ArrayList<Contact> contacts, contacts2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBase(getApplicationContext());
        contacts = db.recup_contact();


        liste = (ListView) this.findViewById(R.id.list);

        String[] information = new String[contacts.size()];
        for(int i=0 ; i<contacts.size() ; i++)
        {
            Contact c = contacts.get(i);
            information[i] = " \n " + c.getNom() + " " +  c.getPrenom() + " \n " + c.getNum();
        }

        final ArrayAdapter<String> afficher = new ArrayAdapter<String>(MainActivity.this,android.
                R.layout.simple_list_item_1, information);
        liste.setAdapter(afficher);
        liste = (ListView) findViewById(R.id.list);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> afficher, View view, int position, long id) {
                Contact c = contacts.get(position);
                Intent intent = new Intent(MainActivity.this, infoContact.class);
                intent.putExtra("Contact", c);
                startActivity(intent);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MainActivity.this.startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
