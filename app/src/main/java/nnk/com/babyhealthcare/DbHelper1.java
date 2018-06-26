package nnk.com.babyhealthcare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LENOVO-PC on 11/27/2017.
 */

public class DbHelper1 extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "user";
    public static final String KEY_FNAME = "fname";
    public static final String KEY_LNAME = "lname";
    public static final String KEY_SPIN = "selState";
    public static final String KEY_SPIN1 = "selmnth";
    public static final String KEY_SPIN2 = "selyear";
    public static final String KEY_ID = "id";
    static String DATABASE_NAME = "userdata1";

    public DbHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_FNAME + " TEXT, " + KEY_LNAME + " TEXT, " + KEY_SPIN + " TEXT, " + KEY_SPIN1 + " TEXT, " + KEY_SPIN2 + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
