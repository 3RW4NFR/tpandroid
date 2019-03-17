package com.example.m4104_tp_turkcan_erwan_a1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class infoContact extends Activity implements View.OnClickListener {

    private Contact c;
    private Button appeler, sup, retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_contact);

        c = getIntent().getExtras().getParcelable("Contact");

        TextView tf2 = (TextView) this.findViewById(R.id.tv);
        tf2.setText("Nom : " + c.getNom());
        TextView tf3 = (TextView) this.findViewById(R.id.tv2);
        tf3.setText("Prenom : " + c.getPrenom());
        TextView tf4 = (TextView) this.findViewById(R.id.tv3);
        tf4.setText("Groupe : "+ c.getGroupe());
        TextView tf5 = (TextView) this.findViewById(R.id.tv4);
        tf5.setText("Numéro : "+ c.getNum());

        retour = (Button) this.findViewById(R.id.b3);
        retour.setOnClickListener(this);

        appeler = (Button) this.findViewById(R.id.b);
        appeler.setOnClickListener(this);

        sup = (Button) this.findViewById(R.id.b2);
        sup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        DataBase db = new DataBase(getApplicationContext());
        if(v.getId()==R.id.b3){
            Intent intent = new Intent(infoContact.this, MainActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.b){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + c.getNum()));
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
            startActivity(callIntent);
        }
        if(v.getId()==R.id.b2){

            db.deleteContact(c.getNom(),c.getPrenom());
            Intent intent = new Intent(infoContact.this, MainActivity.class);
            Toast.makeText(this,c.getNom()+" "+c.getPrenom()+" est supprimé", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
}
