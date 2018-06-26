package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewDetails extends AppCompatActivity {
    SQLiteHelper sq;
    Button sub, hm, reg;
    EditText loc;
    TextView ke, tf, st, ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        sq = new SQLiteHelper(this);
        //hm=(Button) findViewById(R.id.button2);
        sub = findViewById(R.id.button1);
        loc = findViewById(R.id.editText1);
        ke = findViewById(R.id.textView2);
        tf = findViewById(R.id.textView3);
        st = findViewById(R.id.TextView01);
        ps = findViewById(R.id.TextView02);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String loca = loc.getText().toString();
                String loca1 = loc.getText().toString();
                String loca2 = loc.getText().toString();
                String loca3 = loc.getText().toString();
                String r = sq.getkey(loca);
                String r1 = sq.getkey1(loca1);
                String r2 = sq.getkey2(loca1);
                String r3 = sq.getkey3(loca1);
                ke.setText(r);
                tf.setText(r1);
                st.setText(r2);
                ps.setText(r3);
            }
        });
        reg = findViewById(R.id.button2);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(ViewDetails.this, AddDetail.class);
                startActivity(in);
            }
        });
        hm = findViewById(R.id.button3);
        hm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(ViewDetails.this, FourToSix.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_details, menu);
        return true;
    }
}
