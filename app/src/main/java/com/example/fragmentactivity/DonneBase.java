package com.example.fragmentactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DonneBase extends SQLiteOpenHelper {

    public DonneBase(Context cn)
    {
        super(cn,"nouha",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person (idp INTEGER primary key ,name TEXT ,ville TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table IF Exists person ");
        onCreate(db);
    }


    //pour ajouter
    public void insertData(int idpr , String nam,String vile)
    {
          SQLiteDatabase db =  this.getWritableDatabase();
          db.execSQL("insert into person values ("+idpr+" ,'"+nam+"' ,'"+vile+"')");
    }

    //pour Modifier
    public void updateData(int idpr , String nam,String vile)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update person set name ='"+nam+"',ville = '"+vile+"'  WHERE idp = "+idpr+"");
    }

    //pour Supprimer
    public void DeleteData( String idpr)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from person WHERE idp = "+idpr+"");
    }

    //pour Afficher
    public ArrayList ReadData()
    {
        ArrayList list= new ArrayList() ;
        SQLiteDatabase db = this.getWritableDatabase();
        String text;
        Cursor cr = db.rawQuery("select * from person",null);
        cr.moveToFirst();
        while(!cr.isAfterLast())
        {
            text =cr.getString(0)+" - "+cr.getString(1);
            list.add(text);
            cr.moveToNext();
        }
        return list;
    }


    public ArrayList ReadDataCondition(String id)
    {
        ArrayList list= new ArrayList() ;
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cr = db.rawQuery("SELECT * FROM person WHERE TRIM(idp) = '"+id.trim()+"'", null);
        cr.moveToFirst();
        while(!cr.isAfterLast())
        {
            list.add(cr.getString(0));
            list.add(cr.getString(1));
            list.add(cr.getString(2));
            cr.moveToNext();
        }
        return list;
    }



    public ArrayList getDataquery(String query)
    {
        ArrayList mylist = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cr = db.rawQuery(query, null);
        cr.moveToFirst();
        while(!cr.isAfterLast())
        {
            mylist.add(cr.getString(0));
            cr.moveToNext();
        }
        return mylist;
    }







}
