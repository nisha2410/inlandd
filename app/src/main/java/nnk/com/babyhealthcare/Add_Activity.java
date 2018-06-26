package nnk.com.babyhealthcare;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Add_Activity extends AppCompatActivity implements View.OnClickListener {
    Spinner s1;
    Spinner s2;
    Spinner s3;
    private Button btn_save;
    private EditText edit_first, edit_last, edit_text1, edit_text2, edit_text3;
    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    private String id, fname, lname, cname, dname, ename, selmnth, selyear, selState;
    private boolean isUpdate;
    private String[] state = {"Fever", "Rashes", "Cough", "Allergy", "Regular", "Pain"
    };

    private String[] mnth = {"1", "2", "3", "4", "5", "6", " 7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", " 17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", " 27", "28", "29", "30", "31"};

    private String[] year = {"/1", "/2", "/3", "/4", "/5", "/6", "/7", "/8", "/9", "/10", "/11", "/12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btn_save = findViewById(R.id.save_btn);
        edit_first = findViewById(R.id.frst_editTxt);
        edit_last = findViewById(R.id.last_editTxt);
        edit_text1 = findViewById(R.id.editText1);
        edit_text2 = findViewById(R.id.editText2);
        edit_text3 = findViewById(R.id.editText3);


        System.out.println(state.length);
        System.out.println(mnth.length);
        System.out.println(year.length);

        s1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, state);
        adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter_state);

        s2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter_mnth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mnth);
        adapter_mnth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter_mnth);

        s3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, year);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter_year);


        isUpdate = getIntent().getExtras().getBoolean("update");
        if (isUpdate) {
            id = getIntent().getExtras().getString("ID");
            fname = getIntent().getExtras().getString("Fname");
            lname = getIntent().getExtras().getString("Lname");
            cname = getIntent().getExtras().getString("Cname");
            dname = getIntent().getExtras().getString("Dname");
            ename = getIntent().getExtras().getString("Ename");

            edit_first.setText(fname);
            edit_last.setText(lname);
            edit_text1.setText(cname);
            edit_text2.setText(dname);
            edit_text3.setText(ename);


        }


        btn_save.setOnClickListener(this);

        mHelper = new DbHelper(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        s1.setSelection(position);

        //selVersion.setText("Selected Android OS:" + selState);

    }

    public void onItemSelected1(AdapterView<?> parent, View view, int position, long id) {


        s2.setSelection(position);

        //selVersion.setText("Selected Android OS:" + selState);

    }

    public void onItemSelected2(AdapterView<?> parent, View view, int position, long id) {


        s3.setSelection(position);

        //selVersion.setText("Selected Android OS:" + selState);

    }


    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    // saveButton click event
    public void onClick(View v) {
        fname = edit_first.getText().toString().trim();
        lname = edit_last.getText().toString().trim();
        cname = edit_text1.getText().toString().trim();
        dname = edit_text2.getText().toString().trim();
        ename = edit_text3.getText().toString().trim();

        selState = (String) s1.getSelectedItem();
        selmnth = (String) s2.getSelectedItem();
        selyear = (String) s3.getSelectedItem();


        if (fname.length() > 0 && lname.length() > 0 && selState.length() > 0 && selmnth.length() > 0 && selyear.length() > 0 && cname.length() > 0 && dname.length() > 0 && ename.length() > 0) {
            saveData();
        } else {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Add_Activity.this);
            alertBuilder.setTitle("Invalid Data");
            alertBuilder.setMessage("Please, Enter valid data");
            alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            alertBuilder.create().show();
        }

    }

    /**
     * save data into SQLite
     */
    private void saveData() {
        dataBase = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DbHelper.KEY_FNAME, fname);
        values.put(DbHelper.KEY_LNAME, lname);
        values.put(DbHelper.KEY_CNAME, cname);
        values.put(DbHelper.KEY_DNAME, dname);
        values.put(DbHelper.KEY_ENAME, ename);

        values.put(DbHelper.KEY_SPIN, selState);
        values.put(DbHelper.KEY_SPIN1, selmnth);
        values.put(DbHelper.KEY_SPIN2, selyear);

        System.out.println("");
        if (isUpdate) {
            //update database with new data
            dataBase.update(DbHelper.TABLE_NAME, values, DbHelper.KEY_ID + "=" + id, null);
        } else {
            //insert data into database
            dataBase.insert(DbHelper.TABLE_NAME, null, values);
        }
        //close database
        dataBase.close();
        finish();
    }
}