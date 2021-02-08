package com.gallale.whatdididotoday;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rlytLytMain;

    private ArrayList<ImageView> arrHobbysImg;
    private ArrayList<LinearLayout> arrLnrLyt;
    private SQLiteDB db;

    private ArrayList<tache> arrAllTaches;
    private ArrayList<String> arrAllTachesTxt;
    private ArrayList<Integer> arrAllTachesImg;

    private LinearLayout lnrLyt1;
    private LinearLayout lnrLyt2;
    private LinearLayout lnrLyt3;
    private LinearLayout lnrLyt4;
    private LinearLayout lnrLyt5;

    private TextView txtvi1;
    private TextView txtvi2;
    private TextView txtvi3;
    private TextView txtvi4;
    private TextView txtvi5;

    private ImageView hobbyImg1;
    private ImageView hobbyImg2;
    private ImageView hobbyImg3;
    private ImageView hobbyImg4;
    private ImageView hobbyImg5;

    private Button btn_newDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent int_ajout = new Intent().setClass(this, ACT_Ajout.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(int_ajout);
            }
        });

        rlytLytMain = findViewById(R.id.rltlyt_main);

        db = new SQLiteDB(this);
        arrHobbysImg = new ArrayList<ImageView>();
        arrLnrLyt = new ArrayList<LinearLayout>();
        arrAllTaches = db.getAlltaches();
        arrAllTachesTxt = db.getAlltachesTxt();
        arrAllTachesImg = db.getAlltachesImg();

        btn_newDay = findViewById(R.id.btn_newDay);

        lnrLyt1 = findViewById(R.id.lnrLyt_1);
        lnrLyt2 = findViewById(R.id.lnrLyt_2);
        lnrLyt3 = findViewById(R.id.lnrLyt_3);
        lnrLyt4 = findViewById(R.id.lnrLyt_4);
        lnrLyt5 = findViewById(R.id.lnrLyt_5);

        arrLnrLyt.add(lnrLyt1);
        arrLnrLyt.add(lnrLyt2);
        arrLnrLyt.add(lnrLyt3);
        arrLnrLyt.add(lnrLyt4);
        arrLnrLyt.add(lnrLyt5);

        txtvi1 = findViewById(R.id.txt_activity_1);
        txtvi2 = findViewById(R.id.txt_activity_2);
        txtvi3 = findViewById(R.id.txt_activity_3);
        txtvi4 = findViewById(R.id.txt_activity_4);
        txtvi5 = findViewById(R.id.txt_activity_5);

        hobbyImg1 = findViewById(R.id.imgvi_play_1);
        hobbyImg2 = findViewById(R.id.imgvi_play_2);
        hobbyImg3 = findViewById(R.id.imgvi_play_3);
        hobbyImg4 = findViewById(R.id.imgvi_play_4);
        hobbyImg5 = findViewById(R.id.imgvi_play_5);

        arrHobbysImg.add(hobbyImg1);
        arrHobbysImg.add(hobbyImg2);
        arrHobbysImg.add(hobbyImg3);
        arrHobbysImg.add(hobbyImg4);
        arrHobbysImg.add(hobbyImg5);

        visibilityViews();
        remplAllTxtVi();
        remplAllImgVi();

        btn_newDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDay();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.about){
            new AlertDialog.Builder(this)
                    .setTitle("A propos du developpeur")
                    .setMessage("Created by Alex Gallucci\nContact : admin@infajoie.ch")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes, null)

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Gère les images de chaques taches
     * 0 = pas d'images
     * 1 = guitare
     */
    public void remplAllImgVi() {
        for (int i = 0; i < arrAllTachesImg.size(); i++) {
            switch (arrAllTachesImg.get(i)) {
                // Pas d'image
                case 0:
                case -1:
                    break;

                // Guitare
                case 1:
                    arrHobbysImg.get(i).setImageResource(R.drawable.guitar_blacktheme);
                    break;

                // Diplome
                case 2:
                    arrHobbysImg.get(i).setImageResource(R.drawable.diploma_blacktheme);
                    break;

                // lampe
                case 3:
                    arrHobbysImg.get(i).setImageResource(R.drawable.lampe_blacktheme);
                    break;

                // caddie
                case 4:
                    arrHobbysImg.get(i).setImageResource(R.drawable.add_shopping_cart_24px);
                    break;

                // telephone
                case 5:
                    arrHobbysImg.get(i).setImageResource(R.drawable.call_24px);
                    break;

                // pousette
                case 6:
                    arrHobbysImg.get(i).setImageResource(R.drawable.child_friendly_24px);
                    break;

                // voiture
                case 7:
                    arrHobbysImg.get(i).setImageResource(R.drawable.directions_car_24px);
                    break;
                // facebook
                case 8:
                    arrHobbysImg.get(i).setImageResource(R.drawable.facebook_24px);
                    break;

                // fitness
                case 9:
                    arrHobbysImg.get(i).setImageResource(R.drawable.fitness_center_24px);
                    break;

                // caffee
                case 10:
                    arrHobbysImg.get(i).setImageResource(R.drawable.free_breakfast_24px);
                    break;

                // outils
                case 11:
                    arrHobbysImg.get(i).setImageResource(R.drawable.handyman_24px);
                    break;
                // Diplome
                case 12:
                    arrHobbysImg.get(i).setImageResource(R.drawable.http_24px);
                    break;

                // Diplome
                case 13:
                    arrHobbysImg.get(i).setImageResource(R.drawable.pedal_bike_24px);
                    break;

                // Diplome
                case 14:
                    arrHobbysImg.get(i).setImageResource(R.drawable.school_24px);
                    break;

                // Diplome
                case 15:
                    arrHobbysImg.get(i).setImageResource(R.drawable.science_24px);
                    break;

                // Diplome
                case 16:
                    arrHobbysImg.get(i).setImageResource(R.drawable.speaker_phone_24px);
                    break;

                // Diplome
                case 17:
                    arrHobbysImg.get(i).setImageResource(R.drawable.subscriptions_24px);
                    break;

                // Diplome
                case 18:
                    arrHobbysImg.get(i).setImageResource(R.drawable.textsms_24px);
                    break;

                // Diplome
                case 19:
                    arrHobbysImg.get(i).setImageResource(R.drawable.two_wheeler_24px);
                    break;

                // malette
                case 20:
                    arrHobbysImg.get(i).setImageResource(R.drawable.work_outline_24px);
                    break;

            }
        }
    }

    /**
     * Remplit les textViews avec les données de la BD
     */
    public void remplAllTxtVi() {
        txtvi1.setText(arrAllTachesTxt.get(0));
        txtvi2.setText(arrAllTachesTxt.get(1));
        txtvi3.setText(arrAllTachesTxt.get(2));
        txtvi4.setText(arrAllTachesTxt.get(3));
        txtvi5.setText(arrAllTachesTxt.get(4));
    }

    /**
     * Gère la visibilité des taches
     * ||
     * Cache ou affiche les taches
     */
    public void visibilityViews() {
        for (int i = 0; i < arrHobbysImg.size(); i++) {
            if (arrAllTachesImg.get(i) == -1) {
                arrLnrLyt.get(i).setVisibility(View.GONE);
            } else {
                arrLnrLyt.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Nouveau jour
     */
    public void newDay(){
        db.resetDB();
        recreate();
    }

}