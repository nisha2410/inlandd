package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VaccinationDate extends AppCompatActivity {
    SQLiteHelper sq;
    String na = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_date);
        sq = new SQLiteHelper(this);
        final EditText e1 = findViewById(R.id.editText1);
        final EditText e2 = findViewById(R.id.editText2);
        final EditText e3 = findViewById(R.id.editText3);
        final EditText e4 = findViewById(R.id.EditText01);
        final EditText e5 = findViewById(R.id.EditText02);

        Button b = findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i1 = getIntent();
                na = i1.getStringExtra("n");
                String loca = e1.getText().toString();
                String amnt = e2.getText().toString();
                String tof = e3.getText().toString();
                String st = e4.getText().toString();
                String ps = e5.getText().toString();
                if (loca.length() != 0 && amnt.length() != 0 && tof.length() != 0 && st.length() != 0 && ps.length() != 0) {
                    int r = sq.insertData11(loca, amnt, tof, st, ps);
                    Intent i = new Intent(VaccinationDate.this, Search.class);
                    i.putExtra("n", na);
                    i.putExtra("loc", loca);
                    i.putExtra("amt", amnt);
                    i.putExtra("tof", tof);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "please fill the feilds", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vaccination_date, menu);
        return true;
    }
}
