package com.gallale.whatdididotoday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

public class SQLiteDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tache.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public static class tacheTable implements BaseColumns{
        public static final String TABLE_NAME = "tb_tache";
        public static final String COLUMN_VALUE_TXT = "txt_value";
        public static final String COLUMN_VALUE_IMG = "img_value";
    }

    public SQLiteDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " +
                tacheTable.TABLE_NAME + " ( " +
                tacheTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                tacheTable.COLUMN_VALUE_TXT + " TEXT, " +
                tacheTable.COLUMN_VALUE_IMG + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_NOTES_TABLE);
        this.addDefaultTasks();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tacheTable.TABLE_NAME);
        onCreate(db);
    }

    // Ajoute une tache
    public void addTache(String valeurTache, int imageTache) {
        ContentValues cv = new ContentValues();
        cv.put(tacheTable.COLUMN_VALUE_TXT, valeurTache);
        cv.put(tacheTable.COLUMN_VALUE_IMG, imageTache);
        db.insert(tacheTable.TABLE_NAME, null, cv);
    }

    public void editTache(int indexTache, String nouvelleValeur, int valeurImage){
        ContentValues cv = new ContentValues();
        cv.put(tacheTable.COLUMN_VALUE_TXT, nouvelleValeur);
        cv.put(tacheTable.COLUMN_VALUE_IMG, valeurImage);
        db.update(tacheTable.TABLE_NAME, cv, "_id=" + indexTache, null);
    }

    // Retourne toutes les taches
    public ArrayList<tache> getAlltaches() {
        ArrayList<tache> tachelist = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + tacheTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                tache tache = new tache();
                tache.setValueTxt(c.getString(c.getColumnIndex(tacheTable.COLUMN_VALUE_TXT)));
                tache.setValueImg(c.getInt(c.getColumnIndex(tacheTable.COLUMN_VALUE_IMG)));
                tachelist.add(tache);
            } while (c.moveToNext());
        }

        c.close();
        return tachelist;
    }
    public ArrayList<String> getAlltachesTxt() {
        ArrayList<String> tachelist = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " +  tacheTable.COLUMN_VALUE_TXT + " FROM " + tacheTable.TABLE_NAME , null);
        if (c.moveToFirst()) {
            do {
                String tache;
                tache = c.getString(c.getColumnIndex(tacheTable.COLUMN_VALUE_TXT));
                tachelist.add(tache);
            } while (c.moveToNext());
        }

        c.close();
        return tachelist;
    }
    public ArrayList<Integer> getAlltachesImg() {
        ArrayList<Integer> tachelist = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " + tacheTable.COLUMN_VALUE_IMG + " FROM " + tacheTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                int tache;
                tache = c.getInt(c.getColumnIndex(tacheTable.COLUMN_VALUE_IMG));
                tachelist.add(tache);
            } while (c.moveToNext());
        }

        c.close();
        return tachelist;
    }

    // Ajoute les 5 tâches par defaults
    public void addDefaultTasks(){
        this.addTache("default 1", -1);
        this.addTache("default 2", -1);
        this.addTache("default 3", -1);
        this.addTache("default 4", -1);
        this.addTache("default 5", -1);
    }

    public void deleteDB(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + tacheTable.TABLE_NAME);
        onCreate(db);
    }

    public void resetDB(){
        deleteDB(db);
    }
}
