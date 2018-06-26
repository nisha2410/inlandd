package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class FourToSix extends AppCompatActivity {
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_to_six);
        reg = findViewById(R.id.button3);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(FourToSix.this, MainActivity.class);
                startActivity(in);
            }
        });
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animScal = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animSca = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        Button btnScale = findViewById(R.id.button1);
        Button btnScal = findViewById(R.id.button2);
        btnScale.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animScale);
                Intent i = new Intent(FourToSix.this, Vaccine.class);
                startActivity(i);
            }
        });
        btnScal.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animScale);
                Intent i = new Intent(FourToSix.this, ViewDetails.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fourtosix, menu);
        return true;
    }
}
