package com.gallale.whatdididotoday;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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

    private LinearLayout lnrLyt1;
    private LinearLayout lnrLyt2;
    private LinearLayout lnrLyt3;
    private LinearLayout lnrLyt4;
    private LinearLayout lnrLyt5;
    private LinearLayout lnrLyt6;
    private LinearLayout lnrLyt7;
    private LinearLayout lnrLyt8;
    private LinearLayout lnrLyt9;

    private TextView txtvi1;
    private TextView txtvi2;
    private TextView txtvi3;
    private TextView txtvi4;
    private TextView txtvi5;
    private TextView txtvi6;
    private TextView txtvi7;
    private TextView txtvi8;
    private TextView txtvi9;

    private ImageView hobbyImg1;
    private ImageView hobbyImg2;
    private ImageView hobbyImg3;
    private ImageView hobbyImg4;
    private ImageView hobbyImg5;
    private ImageView hobbyImg6;
    private ImageView hobbyImg7;
    private ImageView hobbyImg8;
    private ImageView hobbyImg9;

    private Button btn_newDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent int_ajout = new Intent().setClass(this, ACT_Ajout.class);

        final FloatingActionButton fab = findViewById(R.id.fab);

        rlytLytMain = findViewById(R.id.rltlyt_main);

        db = new SQLiteDB(this);

        try {
            db.getAlltaches();
        } catch (Exception e) {
            Log.i("Reset BD", "Reset de la BD pour cause de MAJ");
            this.deleteDatabase("tache.db");
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(int_ajout);
            }
        });

        arrHobbysImg = new ArrayList<ImageView>();
        arrLnrLyt = new ArrayList<LinearLayout>();
        arrAllTaches = db.getAlltachesAtDay(1);

        btn_newDay = findViewById(R.id.btn_newDay);

        lnrLyt1 = findViewById(R.id.lnrLyt_1);
        lnrLyt2 = findViewById(R.id.lnrLyt_2);
        lnrLyt3 = findViewById(R.id.lnrLyt_3);
        lnrLyt4 = findViewById(R.id.lnrLyt_4);
        lnrLyt5 = findViewById(R.id.lnrLyt_5);
        lnrLyt6 = findViewById(R.id.lnrLyt_6);
        lnrLyt7 = findViewById(R.id.lnrLyt_7);
        lnrLyt8 = findViewById(R.id.lnrLyt_8);
        lnrLyt9 = findViewById(R.id.lnrLyt_9);

        arrLnrLyt.add(lnrLyt1);
        arrLnrLyt.add(lnrLyt2);
        arrLnrLyt.add(lnrLyt3);
        arrLnrLyt.add(lnrLyt4);
        arrLnrLyt.add(lnrLyt5);
        arrLnrLyt.add(lnrLyt6);
        arrLnrLyt.add(lnrLyt7);
        arrLnrLyt.add(lnrLyt8);
        arrLnrLyt.add(lnrLyt9);

        txtvi1 = findViewById(R.id.txt_activity_1);
        txtvi2 = findViewById(R.id.txt_activity_2);
        txtvi3 = findViewById(R.id.txt_activity_3);
        txtvi4 = findViewById(R.id.txt_activity_4);
        txtvi5 = findViewById(R.id.txt_activity_5);
        txtvi6 = findViewById(R.id.txt_activity_6);
        txtvi7 = findViewById(R.id.txt_activity_7);
        txtvi8 = findViewById(R.id.txt_activity_8);
        txtvi9 = findViewById(R.id.txt_activity_9);

        hobbyImg1 = findViewById(R.id.imgvi_play_1);
        hobbyImg2 = findViewById(R.id.imgvi_play_2);
        hobbyImg3 = findViewById(R.id.imgvi_play_3);
        hobbyImg4 = findViewById(R.id.imgvi_play_4);
        hobbyImg5 = findViewById(R.id.imgvi_play_5);
        hobbyImg6 = findViewById(R.id.imgvi_play_6);
        hobbyImg7 = findViewById(R.id.imgvi_play_7);
        hobbyImg8 = findViewById(R.id.imgvi_play_8);
        hobbyImg9 = findViewById(R.id.imgvi_play_9);

        arrHobbysImg.add(hobbyImg1);
        arrHobbysImg.add(hobbyImg2);
        arrHobbysImg.add(hobbyImg3);
        arrHobbysImg.add(hobbyImg4);
        arrHobbysImg.add(hobbyImg5);
        arrHobbysImg.add(hobbyImg6);
        arrHobbysImg.add(hobbyImg7);
        arrHobbysImg.add(hobbyImg8);
        arrHobbysImg.add(hobbyImg9);

        visibilityViews();
        remplAllTxtVi();
        remplAllImgVi();

        if (arrLnrLyt.get(8).getVisibility() == View.VISIBLE) {
            fab.setVisibility(View.INVISIBLE);
        }

        btn_newDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDay();
            }
        });
    }


    /**
     * Gère les images de chaques taches
     * 0 = pas d'images
     * 1 = guitare
     */
    public void remplAllImgVi() {
        for (int i = 0; i < arrAllTaches.size(); i++) {
            switch (arrAllTaches.get(i).getValueImg()) {
                // Pas d'image
                case 0:
                case -1:
                    break;

                // Guitare
                case 1:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_audiotrack_24);
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
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_shopping_cart_24);
                    break;

                // telephone
                case 5:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_call_24);
                    break;

                // pousette
                case 6:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_child_friendly_24);
                    break;

                // voiture
                case 7:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_directions_car_24);
                    break;
                // facebook
                case 8:
                    arrHobbysImg.get(i).setImageResource(R.drawable.facebook_24px);
                    break;

                // fitness
                case 9:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_fitness_center_24);
                    break;

                // caffee
                case 10:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_free_breakfast_24);
                    break;

                // outils
                case 11:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_build_24);
                    break;
                // Diplome
                case 12:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_code_24);
                    break;

                // Diplome
                case 13:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_directions_bike_24);
                    break;

                // Diplome
                case 14:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_school_24);
                    break;

                // Diplome
                case 15:
                    arrHobbysImg.get(i).setImageResource(R.drawable.science_24px);
                    break;

                // Diplome
                case 16:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_speaker_phone_24);
                    break;

                // Diplome
                case 17:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_subscriptions_24);
                    break;

                // Diplome
                case 18:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_message_24);
                    break;

                // Diplome
                case 19:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_two_wheeler_24);
                    break;

                // malette
                case 20:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_work_24);
                    break;

                case 21:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_directions_walk_24);
                    break;

                case 22:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_laptop_24);
                    break;

                case 23:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_menu_book_24);
                    break;

                case 24:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_mic_24);
                    break;

                case 25:
                    arrHobbysImg.get(i).setImageResource(R.drawable.ic_baseline_library_books_24);
                    break;
            }
        }
    }

    /**
     * Remplit les textViews avec les données de la BD
     */
    public void remplAllTxtVi() {
        txtvi1.setText(arrAllTaches.get(0).getValueTxt());
        txtvi2.setText(arrAllTaches.get(1).getValueTxt());
        txtvi3.setText(arrAllTaches.get(2).getValueTxt());
        txtvi4.setText(arrAllTaches.get(3).getValueTxt());
        txtvi5.setText(arrAllTaches.get(4).getValueTxt());
        txtvi6.setText(arrAllTaches.get(5).getValueTxt());
        txtvi7.setText(arrAllTaches.get(6).getValueTxt());
        txtvi8.setText(arrAllTaches.get(7).getValueTxt());
        txtvi9.setText(arrAllTaches.get(8).getValueTxt());
    }

    /**
     * Gère la visibilité des taches
     * ||
     * Cache ou affiche les taches
     */
    public void visibilityViews() {
        for (int i = 0; i < arrHobbysImg.size(); i++) {
            if (arrAllTaches.get(i).getValueImg() == -1) {
                arrLnrLyt.get(i).setVisibility(View.GONE);
            } else {
                arrLnrLyt.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Nouveau jour
     */
    public void newDay() {
        db.minusOneDay();
        db.addDefaultTasks();
        recreate();
    }

}