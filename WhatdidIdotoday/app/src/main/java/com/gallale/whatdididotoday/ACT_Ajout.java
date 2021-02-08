package com.gallale.whatdididotoday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ACT_Ajout extends AppCompatActivity {

    private SQLiteDB db;
    private ArrayList<Integer> arrImg;
    EditText etNomTache;

    private RelativeLayout relativeLayout;

    TextView txtVi_ajoutActiv;
    TextView txtVi_choixImage;
    TextView txtVi_nomTache;

    ImageView guitar;
    ImageView diploma;
    ImageView lampe;
    ImageView caddie;
    ImageView phone;
    ImageView bebe;
    ImageView voiture;
    ImageView facebook;
    ImageView fitness;
    ImageView coffee;
    ImageView reparation;
    ImageView http;
    ImageView bike;
    ImageView education;
    ImageView science;
    ImageView mobile;
    ImageView youtube;
    ImageView message;
    ImageView moto;
    ImageView work;

    Drawable encadre;

    int selectedImage = 0;

    Button btn_valider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        db = new SQLiteDB(this);
        arrImg = db.getAlltachesImg();
        encadre = ContextCompat.getDrawable(this, R.drawable.encardre);

        final Intent valeurSaisie = new Intent().setClass(this, MainActivity.class);

        // region Initialisation
        txtVi_ajoutActiv = findViewById(R.id.txtvi_ajouterActivite);
        txtVi_choixImage = findViewById(R.id.txtvi_choixImage);

        guitar = findViewById(R.id.img_guitare);
        diploma = findViewById(R.id.img_diplome);
        lampe = findViewById(R.id.img_lampe);
        caddie = findViewById(R.id.img_caddie);
        phone = findViewById(R.id.img_telephone);
        bebe = findViewById(R.id.img_pousette);
        voiture = findViewById(R.id.img_voiture);
        facebook = findViewById(R.id.img_facebook);
        fitness = findViewById(R.id.img_fitness);
        coffee = findViewById(R.id.img_caffee);
        reparation = findViewById(R.id.img_outils);
        http = findViewById(R.id.img_http);
        bike = findViewById(R.id.img_velo);
        education = findViewById(R.id.img_etudes);
        science = findViewById(R.id.img_science);
        mobile = findViewById(R.id.img_onde);
        youtube = findViewById(R.id.img_youtube);
        message = findViewById(R.id.img_message);
        moto = findViewById(R.id.img_moto);
        work = findViewById(R.id.img_valise);
        btn_valider = findViewById(R.id.btn_valider);
        etNomTache = findViewById(R.id.edtTxt_taskName);
        // endregion


        // region onclick Images
        guitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 1;
                deselectAll();
                guitar.setBackground(encadre);
            }
        });

        diploma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 2;
                deselectAll();
                diploma.setBackground(encadre);
            }
        });

        lampe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 3;
                deselectAll();
                lampe.setBackground(encadre);
            }
        });

        caddie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 4;
                deselectAll();
                caddie.setBackground(encadre);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 5;
                deselectAll();
                phone.setBackground(encadre);
            }
        });

        bebe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 6;
                deselectAll();
                bebe.setBackground(encadre);
            }
        });

        voiture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 7;
                deselectAll();
                voiture.setBackground(encadre);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 8;
                deselectAll();
                facebook.setBackground(encadre);
            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 9;
                deselectAll();
                fitness.setBackground(encadre);
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 10;
                deselectAll();
                coffee.setBackground(encadre);
            }
        });

        reparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 11;
                deselectAll();
                reparation.setBackground(encadre);
            }
        });

        http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 12;
                deselectAll();
                http.setBackground(encadre);
            }
        });

        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 13;
                deselectAll();
                bike.setBackground(encadre);
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 14;
                deselectAll();
                education.setBackground(encadre);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 15;
                deselectAll();
                science.setBackground(encadre);
            }
        });

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 16;
                deselectAll();
                mobile.setBackground(encadre);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 17;
                deselectAll();
                youtube.setBackground(encadre);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 18;
                deselectAll();
                message.setBackground(encadre);
            }
        });

        moto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 19;
                deselectAll();
                moto.setBackground(encadre);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 20;
                deselectAll();
                work.setBackground(encadre);
            }
        });
        //endregion

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choixTache = choixTache();
                if(choixTache > -1 && choixTache <= arrImg.size()){
                    db.editTache(choixTache, etNomTache.getText().toString(), selectedImage);
                    startActivity(valeurSaisie);
                }
            }
        });
    }

    /**
     * Enleve l'encadré sur toutes les images selectionnées
     */
    private void deselectAll(){
        guitar.setBackground(null);
        diploma.setBackground(null);
        lampe.setBackground(null);
        caddie.setBackground(null);
        phone.setBackground(null);
        bebe.setBackground(null);
        voiture.setBackground(null);
        facebook.setBackground(null);
        fitness.setBackground(null);
        coffee.setBackground(null);
        reparation.setBackground(null);
        http.setBackground(null);
        bike.setBackground(null);
        education.setBackground(null);
        science.setBackground(null);
        mobile.setBackground(null);
        youtube.setBackground(null);
        message.setBackground(null);
        moto.setBackground(null);
        work.setBackground(null);
    }

    /**
     * Choisi quelle tache mettre a jour
     * @return la tache a mettre à jour
     */
    private int choixTache(){
        for(int i=0;i<arrImg.size();i++){
            if(arrImg.get(i) == -1){
                return i + 1;
            }
        }
        return -1;
    }

}