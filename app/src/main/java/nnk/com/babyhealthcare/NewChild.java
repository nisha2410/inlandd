package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewChild extends AppCompatActivity implements View.OnClickListener {
    SQLiteHelper sq;

    String name, un, em, pw, mn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_child);

        sq = new SQLiteHelper(this);

        final EditText e1 = findViewById(R.id.editText1);
        final EditText e2 = findViewById(R.id.editText2);
        final EditText e3 = findViewById(R.id.editText3);
        final EditText e4 = findViewById(R.id.editText4);
        final EditText e5 = findViewById(R.id.editText5);
        Button b = findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                name = e1.getText().toString();
                un = e2.getText().toString();
                pw = e3.getText().toString();
                em = e4.getText().toString();
                mn = e5.getText().toString();


                if (name.length() != 0 && un.length() != 0
                        && pw.length() != 0 && em.length() != 0
                        && mn.length() != 0) {

                    int r = sq.insertData2(name, un, pw, em, mn);
                    Intent i = new Intent(NewChild.this, Child.class);
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), "please fill all the  fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_child, menu);
        return true;
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }
}
