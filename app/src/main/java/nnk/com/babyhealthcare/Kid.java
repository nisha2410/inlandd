package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kid extends AppCompatActivity {
    Button log, reg;
    EditText e1, e2;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid);
        sq = new SQLiteHelper(this);
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        log = findViewById(R.id.button1);
        reg = findViewById(R.id.button2);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String n = e1.getText().toString();
                String p = e2.getText().toString();
                String m = sq.loginData(n, p);
                if (m.equals("ok")) {
                    Intent i = new Intent(Kid.this, SevebTo10.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Kid.this, NewKid.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.kid, menu);
        return true;
    }
}
