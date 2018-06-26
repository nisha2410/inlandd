package nnk.com.babyhealthcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewExam extends AppCompatActivity {
    Button sub;
    private DbHelper1 mHelper;
    private SQLiteDatabase dataBase;
    private ArrayList<String> userId = new ArrayList<String>();
    private ArrayList<String> user_fName = new ArrayList<String>();
    private ArrayList<String> user_lName = new ArrayList<String>();
    private ArrayList<String> user_selState = new ArrayList<String>();
    private ArrayList<String> user_selmnth = new ArrayList<String>();
    private ArrayList<String> user_selyear = new ArrayList<String>();
    private ListView userList;
    private AlertDialog.Builder build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam);
        sub = findViewById(R.id.Button01);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(ViewExam.this, SevebTo10.class);
                startActivity(in);
            }
        });
        userList = findViewById(R.id.List);
        mHelper = new DbHelper1(this);
        //add new record
        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddExam.class);
                i.putExtra("update", false);
                startActivity(i);
            }
        });
        //click to update data
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent i = new Intent(getApplicationContext(), AddExam.class);
                i.putExtra("Fname", user_fName.get(arg2));
                i.putExtra("Lname", user_lName.get(arg2));
                i.putExtra("spin", user_selState.get(arg2));
                i.putExtra("spin1", user_selmnth.get(arg2));
                i.putExtra("spin2", user_selyear.get(arg2));
                i.putExtra("ID", userId.get(arg2));
                i.putExtra("update", true);
                startActivity(i);
            }
        });
        //long click to delete data
        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int arg2, long arg3) {

                build = new AlertDialog.Builder(ViewExam.this);
                build.setTitle("Delete " + user_fName.get(arg2) + " " + user_lName.get(arg2) + user_selState.get(arg2) + " " + user_selmnth.get(arg2) + user_selyear.get(arg2));
                build.setMessage("Do you want to delete ?");
                build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), user_fName.get(arg2) + " " + user_lName.get(arg2) + " " + user_selState.get(arg2) + " " + user_selmnth.get(arg2) + " " + user_selyear.get(arg2) + " is deleted.", 3000).show();
                        dataBase.delete(DbHelper1.TABLE_NAME, DbHelper1.KEY_ID + "=" + userId.get(arg2), null);
                        displayData();
                        dialog.cancel();
                    }
                });
                build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = build.create();
                alert.show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        displayData();
        super.onResume();
    }

    /**
     * displays data from SQLite
     */
    private void displayData() {
        dataBase = mHelper.getWritableDatabase();
        Cursor mCursor = dataBase.rawQuery("SELECT * FROM " + DbHelper1.TABLE_NAME, null);
        userId.clear();
        user_fName.clear();
        user_lName.clear();
        user_selState.clear();
        user_selmnth.clear();
        user_selyear.clear();
        if (mCursor.moveToFirst()) {
            do {
                userId.add(mCursor.getString(mCursor.getColumnIndex(DbHelper1.KEY_ID)));
                user_fName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper1.KEY_FNAME)));
                user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper1.KEY_LNAME)));
                user_selState.add(mCursor.getString(mCursor.getColumnIndex(DbHelper1.KEY_SPIN)));
                user_selmnth.add(mCursor.getString(mCursor.getColumnIndex(DbHelper1.KEY_SPIN1)));
                user_selyear.add(mCursor.getString(mCursor.getColumnIndex(DbHelper1.KEY_SPIN2)));

            } while (mCursor.moveToNext());
        }
        DisplayAdaper1 disadpt = new DisplayAdaper1();
        userList.setAdapter(disadpt);
        mCursor.close();
    }
}
