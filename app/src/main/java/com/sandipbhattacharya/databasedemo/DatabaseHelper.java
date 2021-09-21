package com.sandipbhattacharya.databasedemo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import org.jetbrains.annotations.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydb.db";
    private static final String TABLE_NAME = "contacts";
    // When you do change the structure of the database change the version number from 1 to 2
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ROWID = "_id";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL = "email";
    private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
            " ("+ KEY_ROWID+" integer primary key autoincrement, "+ KEY_NAME + " text, "+ KEY_EMAIL+ " text)";
    private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate called", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLException e){
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}