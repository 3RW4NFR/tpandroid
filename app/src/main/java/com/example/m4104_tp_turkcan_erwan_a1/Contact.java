package com.example.m4104_tp_turkcan_erwan_a1;

import android.os.Parcel;
import android.os.Parcelable;



public class Contact implements Parcelable {

    private int id;
    private String nom;
    private String prenom;
    private String groupe;
    private String num;


    public Contact(int id, String n, String p, String nu, String grp){
        this.id=id;
        this.nom = n;
        this.prenom = p;
        this.num = nu;
        this.groupe = grp;
    }

    public Contact(String n, String p, String nu, String grp){
        this.nom = n;
        this.prenom = p;
        this.num = nu;
        this.groupe = grp;
    }

    protected Contact(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        num = in.readString();
        groupe = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(num);
        dest.writeString(groupe);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getNum() { return num; }

    public void setId(int id) {
        this.id = id;
    }
}