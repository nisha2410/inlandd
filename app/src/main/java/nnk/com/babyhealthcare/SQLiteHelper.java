package nnk.com.babyhealthcare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

static class OpenHelper extends SQLiteOpenHelper {
    OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + "(" + "ke INTEGER PRIMARY KEY," + "name TEXT, " + "un TEXT," + "pw TEXT," + "em TEXT," + "mn TEXT)");
        db.execSQL("CREATE TABLE " + STUDENT_TABLE1 + "(" + "ke INTEGER PRIMARY KEY," + "name TEXT, " + "un TEXT," + "pw TEXT," + "em TEXT," + "mn TEXT)");
        db.execSQL("CREATE TABLE " + STUDENT_TABLE2 + "(" + "ke INTEGER PRIMARY KEY," + "name TEXT, " + "un TEXT," + "pw TEXT," + "em TEXT," + "mn TEXT)");
        db.execSQL("CREATE TABLE " + STUDENT_TABLE3 + "(" + "ke INTEGER PRIMARY KEY," + "loca TEXT, " + "amnt TEXT," + "tof TEXT," + "st TEXT," + "ps TEXT)");
        db.execSQL("CREATE TABLE " + STUDENT_TABLE4 + "(" + "ke INTEGER PRIMARY KEY," + "loca TEXT, " + "amnt TEXT," + "tof TEXT," + "st TEXT," + "ps TEXT)");
        db.execSQL("CREATE TABLE " + STUDENT_TABLE5 + "(" + "ke INTEGER PRIMARY KEY," + "loca TEXT, " + "amnt TEXT," + "tof TEXT," + "st TEXT," + "ps TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("Catch DB",
                "Upgrading database, this will drop tables and recreate.");
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
        Log.w("Catch DB",
                "Upgrading database, this will drop tables and recreate.");
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE1);
        onCreate(db);
        Log.w("Catch DB",
                "Upgrading database, this will drop tables and recreate.");
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE2);
        onCreate(db);
        Log.w("Catch DB",
                "Upgrading database, this will drop tables and recreate.");
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE3);
        onCreate(db);
        Log.w("Catch DB",
                "Upgrading database, this will drop tables and recreate.");
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE4);
        onCreate(db);
        Log.w("Catch DB",
                "Upgrading database, this will drop tables and recreate.");
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE5);
        onCreate(db);
    }
}
{public static ArrayList<String[]>DATA=new ArrayList<String[]>();
        OpenHelper openHelper;
private Context context;
private SQLiteDatabase db=null;

public SQLiteHelper(Context context){
        this.context=context;

        if(db!=null)
        if(db.isOpen())
        db.close();

        openHelper=new OpenHelper(this.context);
        this.db=openHelper.getWritableDatabase();
        }

public void close(){
        if(openHelper!=null){
        openHelper.close();
        }
        }

public int insertData(String name,String un,String pw,String em,String mn){
        int entryId=0;
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("un",un);
        values.put("pw",pw);
        values.put("em",em);
        values.put("mn",mn);

        entryId=(int)this.db.insert(STUDENT_TABLE,null,values);
        return entryId;
        }
public int insertData1(String name,String un,String pw,String em,String mn){
        int entryId=0;
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("un",un);
        values.put("pw",pw);
        values.put("em",em);
        values.put("mn",mn);

        entryId=(int)this.db.insert(STUDENT_TABLE1,null,values);
        return entryId;
        }
public int insertData2(String name,String un,String pw,String em,String mn){
        int entryId=0;
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("un",un);
        values.put("pw",pw);
        values.put("em",em);
        values.put("mn",mn);

        entryId=(int)this.db.insert(STUDENT_TABLE2,null,values);
        return entryId;
        }

public int insertData9(String loca,String amnt,String tof,String st,String ps)
        {
        int entryId=0;
        ContentValues values=new ContentValues();
        values.put("loca",loca);
        values.put("amnt",amnt);
        values.put("tof",tof);
        values.put("st",st);
        values.put("ps",ps);


        entryId=(int)this.db.insert(STUDENT_TABLE3,null,values);
        return entryId;
        }

public String getkey(String loca)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;

        String n2=null;

        DATA.clear();
        String[]columns=new String[]{"amnt"};

        c1=db.query(STUDENT_TABLE3,columns,"loca=?",new String[]{loca},null,null,null);


        if(c1.moveToNext()){

        n2=c1.getString(0);

        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }

public String getkey1(String loca1)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;

        String n2=null;

        DATA.clear();
        String[]columns=new String[]{"tof"};

        c1=db.query(STUDENT_TABLE3,columns,"loca=?",new String[]{loca1},null,null,null);


        if(c1.moveToNext()){

        n2=c1.getString(0);

        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }

public String getkey2(String loca2)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;

        String n2=null;

        DATA.clear();
        String[]columns=new String[]{"st"};

        c1=db.query(STUDENT_TABLE3,columns,"loca=?",new String[]{loca2},null,null,null);


        if(c1.moveToNext()){

        n2=c1.getString(0);

        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey3(String loca3)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"ps"};
        c1=db.query(STUDENT_TABLE3,columns,"loca=?",new String[]{loca3},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public int insertData10(String loca,String amnt,String tof,String st,String ps)
        {
        int entryId=0;
        ContentValues values=new ContentValues();
        values.put("loca",loca);
        values.put("amnt",amnt);
        values.put("tof",tof);
        values.put("st",st);
        values.put("ps",ps);
        entryId=(int)this.db.insert(STUDENT_TABLE4,null,values);
        return entryId;
        }
public String getkey4(String loca)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"amnt"};
        c1=db.query(STUDENT_TABLE4,columns,"loca=?",new String[]{loca},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey5(String loca1)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"tof"};
        c1=db.query(STUDENT_TABLE4,columns,"loca=?",new String[]{loca1},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey6(String loca2)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"st"};
        c1=db.query(STUDENT_TABLE4,columns,"loca=?",new String[]{loca2},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey7(String loca3)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"ps"};
        c1=db.query(STUDENT_TABLE4,columns,"loca=?",new String[]{loca3},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public int insertData11(String loca,String amnt,String tof,String st,String ps)
        {
        int entryId=0;
        ContentValues values=new ContentValues();
        values.put("loca",loca);
        values.put("amnt",amnt);
        values.put("tof",tof);
        values.put("st",st);
        values.put("ps",ps);
        entryId=(int)this.db.insert(STUDENT_TABLE5,null,values);
        return entryId;
        }
public String getkey8(String loca)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"amnt"};
        c1=db.query(STUDENT_TABLE5,columns,"loca=?",new String[]{loca},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey9(String loca1)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"tof"};
        c1=db.query(STUDENT_TABLE5,columns,"loca=?",new String[]{loca1},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey10(String loca2)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"st"};
        c1=db.query(STUDENT_TABLE5,columns,"loca=?",new String[]{loca2},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public String getkey11(String loca3)
        {
        // TODO Auto-generated method stub
        Cursor c1=null;
        String n2=null;
        DATA.clear();
        String[]columns=new String[]{"ps"};
        c1=db.query(STUDENT_TABLE5,columns,"loca=?",new String[]{loca3},null,null,null);
        if(c1.moveToNext())
        {
        n2=c1.getString(0);
        Log.d(n2,"00000000000000000000");
        }
        return n2;
        }
public ArrayList<String[]>selectdatabase(String search){
        Cursor c=null;
        DATA.clear();
        String[]columns=new String[]{"seat"};
        c=db.query(STUDENT_TABLE,columns,
        "travels=",new String[]{search,
        search,search},null,null,"id DESC");
        if(c.moveToFirst()){
        do{
        if(c.getColumnCount()==4){
        String[]str=new String[3];
        str[0]=c.getString(1);
        str[1]=c.getString(2);
        str[2]=c.getString(3);
        DATA.add(str);
        }
        }while(c.moveToNext());
        }
        if(c!=null&&!c.isClosed())
        {
        c.close();
        }
        return DATA;
        }
public void cr(String k,String k1)
        {
        ContentValues values=new ContentValues();
        values.put("cn1",k);
        int id=db.update(STUDENT_TABLE,values,"name=?",new String[]{k1});
        }
public String loginData(String h,String h1)
        {
        Cursor c1=null;
        DATA.clear();
        String[]columns=new String[]{"name","un"};

        c1=db.query(STUDENT_TABLE,columns,"name=? AND un=?  ",new String[]{h,h1},null,null,null);
        if(c1.moveToNext()){

        String n=c1.getString(0);
        return"ok";
        }
        else
        {
        return"no";
        }
        }
public String loginData3(String h,String h1)
        {
        Cursor c1=null;
        DATA.clear();
        String[]columns=new String[]{"name","un"};
        c1=db.query(STUDENT_TABLE1,columns,"name=? AND un=?  ",new String[]{h,h1},null,null,null);
        if(c1.moveToNext())
        {
        String n=c1.getString(0);
        return"ok";
        }
        else
        {
        return"no";
        }
        }
public String loginData1(String h,String h1)
        {
        Cursor c1=null;
        DATA.clear();
        String[]columns=new String[]{"name","un"};
        c1=db.query(STUDENT_TABLE2,columns,"name=? AND un=?  ",new String[]{h,h1},null,null,null);
        if(c1.moveToNext())
        {
        String n=c1.getString(0);
        return"ok";
        }
        else
        {
        return"no";
        }
        }

public SQLiteDatabase getWritableDatabase()
        {
        return null;
        }

/**
 * Created by LENOVO-PC on 11/26/2017.
 */

public class SQLiteHelper
        private static final String DATABASE_NAME = "friendmapper.db";
        private static final int DATABASE_VERSION = 1;
        private static final String STUDENT_TABLE = "friend";
        private static final String STUDENT_TABLE1 = "friends";
        private static final String STUDENT_TABLE2 = "friendss";
        private static final String STUDENT_TABLE3 = "Details";
        private static final String STUDENT_TABLE4 = "Fees";
        private static final String STUDENT_TABLE5 = "vaccination";

}
