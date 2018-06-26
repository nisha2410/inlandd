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

public class AddExam extends AppCompatActivity implements View.OnClickListener {
    Spinner s1;
    Spinner s2;
    Spinner s3;
    private Button btn_save;
    private EditText edit_first, edit_last;
    private DbHelper1 mHelper;
    private SQLiteDatabase dataBase;
    private String id, fname, lname, selState, selmnth, selyear;
    private boolean isUpdate;
    private String[] state = {"Forenoon", "Afternoon"};
    private String[] mnth = {"Written", "Oral"};
    private String[] year = {"1", "2", "3", "4", "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);
        btn_save = findViewById(R.id.save_btn);
        edit_first = findViewById(R.id.frst_editTxt);
        edit_last = findViewById(R.id.sec_editTxt);
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
            edit_first.setText(fname);
            edit_last.setText(lname);
        }
        btn_save.setOnClickListener(this);
        mHelper = new DbHelper1(this);
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
        selState = (String) s1.getSelectedItem();
        selmnth = (String) s2.getSelectedItem();
        selyear = (String) s3.getSelectedItem();
        if (fname.length() > 0 && lname.length() > 0 && selState.length() > 0 && selmnth.length() > 0 && selyear.length() > 0) {
            saveData();
        } else {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddExam.this);
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
        values.put(DbHelper1.KEY_FNAME, fname);
        values.put(DbHelper1.KEY_LNAME, lname);
        values.put(DbHelper1.KEY_SPIN, selState);
        values.put(DbHelper1.KEY_SPIN1, selmnth);
        values.put(DbHelper1.KEY_SPIN2, selyear);
        System.out.println("");
        if (isUpdate) {
            //update database with new data
            dataBase.update(DbHelper1.TABLE_NAME, values, DbHelper1.KEY_ID + "=" + id, null);
        } else {
            //insert data into database
            dataBase.insert(DbHelper1.TABLE_NAME, null, values);
        }
        //close database
        dataBase.close();
        finish();
    }
}