package com.example.ongajong.tourismv2.dbforfunction3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.ongajong.tourismv2.dbforfunction3.ItemContract.TABLE;

/**
 * Created by ongajong on 26/11/2017.
 * Helper class for the SQLite Database to handle the whole shit
 */

public class ItemDBHelper extends SQLiteOpenHelper {
    //private final Context context;

    public ItemDBHelper(Context context){
        super(context, ItemContract.TABLE_NAME, null, ItemContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE =String.format("CREATE TABLE %s (" +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "+ "%s TEXT UNIQUE ON CONFLICT FAIL, %s TEXT)", ItemContract.TABLE,ItemContract.Columns.ITEM, ItemContract.Columns.CHECKED);
        Log.d("TaskDBHelper", "Query to form table: "+ SQL_CREATE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ItemContract.TABLE);
        onCreate(sqLiteDatabase);

    }
}
