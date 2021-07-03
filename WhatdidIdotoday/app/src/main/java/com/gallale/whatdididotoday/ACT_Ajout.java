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
    private ArrayList<tache> arrImg;
    EditText etNomTache;

    private RelativeLayout relativeLayout;

    TextView txtVi_ajoutActiv;
    TextView txtVi_choixImage;

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
    ImageView walkingMan;
    ImageView laptop;
    ImageView book;
    ImageView micro;
    ImageView paper;

    ArrayList<String> arrHint;

    Drawable encadre;

    int selectedImage = 0;

    Button btn_valider;

    ArrayList<ImageView> arr_imgViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        db = new SQLiteDB(this);
        arrImg = db.getAlltachesAtDay(1);
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
        walkingMan = findViewById(R.id.img_walkingMen);
        laptop = findViewById(R.id.img_laptop);
        book = findViewById(R.id.img_livre);
        micro = findViewById(R.id.img_mic);
        paper = findViewById(R.id.img_paper);

        arr_imgViews = new ArrayList<>();
        arr_imgViews.add(guitar);
        arr_imgViews.add(diploma);
        arr_imgViews.add(lampe);
        arr_imgViews.add(caddie);
        arr_imgViews.add(phone);
        arr_imgViews.add(bebe);
        arr_imgViews.add(voiture);
        arr_imgViews.add(facebook);
        arr_imgViews.add(fitness);
        arr_imgViews.add(coffee);
        arr_imgViews.add(reparation);
        arr_imgViews.add(http);
        arr_imgViews.add(bike);
        arr_imgViews.add(education);
        arr_imgViews.add(science);
        arr_imgViews.add(mobile);
        arr_imgViews.add(youtube);
        arr_imgViews.add(message);
        arr_imgViews.add(moto);
        arr_imgViews.add(work);
        arr_imgViews.add(walkingMan);
        arr_imgViews.add(laptop);
        arr_imgViews.add(book);
        arr_imgViews.add(micro);
        arr_imgViews.add(paper);

        btn_valider = findViewById(R.id.btn_valider);
        etNomTache = findViewById(R.id.edtTxt_taskName);
        arrHint = new ArrayList<>();

        arrHint.add("Music");
        arrHint.add("At school");
        arrHint.add("At desk");
        arrHint.add("Shopping");
        arrHint.add("In a call");
        arrHint.add("Taken care of baby");
        arrHint.add("Driving");
        arrHint.add("Facebook time");
        arrHint.add("Sport");
        arrHint.add("Breakfast");
        arrHint.add("Reparing");
        arrHint.add("Coding");
        arrHint.add("Biking");
        arrHint.add("Studying");
        arrHint.add("Science time");
        arrHint.add("Spend time on phone");
        arrHint.add("Youtube");
        arrHint.add("Messaging");
        arrHint.add("Biking");
        arrHint.add("Working");
        arrHint.add("Walking");
        arrHint.add("Spend some time on computer");
        arrHint.add("Read some books");
        arrHint.add("Recorded myself");
        arrHint.add("Paperwork");

        // endregion
        // region onclick Images
        for (int i = 0; i < arr_imgViews.size(); i++) {
            final int finalI = i;
            arr_imgViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedImage = finalI + 1;
                    deselectAll();
                    arr_imgViews.get(finalI).setBackground(encadre);
                    etNomTache.setHint(arrHint.get(finalI));
                }
            });
        }
        //endregion

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImage != 0) {
                    int choixTache = choixTache();
                    if (etNomTache.getText().toString().isEmpty()) {
                        etNomTache.setText(arrHint.get(selectedImage - 1));
                    }

                    if (choixTache > -1 && choixTache <= arrImg.size()) {
                        db.editTache(choixTache, etNomTache.getText().toString(), selectedImage, 1);
                        startActivity(valeurSaisie);
                    }
                }
            }
        });
    }

    /**
     * Enleve l'encadré sur toutes les images selectionnées
     */
    private void deselectAll() {
        for (int i = 0; i < arr_imgViews.size(); i++) {
            arr_imgViews.get(i).setBackground(null);
        }
    }

    /**
     * Choisi quelle tache mettre a jour
     *
     * @return la tache a mettre à jour
     */
    private int choixTache() {
        for (int i = 0; i < arrImg.size(); i++) {
            if (arrImg.get(i).getValueImg() == -1) {
                return i + 1;
            }
        }
        return -1;
    }

}