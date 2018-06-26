package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Display_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_);


    }

    public void addDetails(View v) {
        Intent i = new Intent(Display_Activity.this, ViewDetails.class);
        startActivity(i);

    }

    public void back(View v) {
        Intent i = new Intent(Display_Activity.this, UpTo3.class);
        startActivity(i);

    }
}
