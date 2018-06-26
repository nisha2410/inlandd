package nnk.com.babyhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SevebTo10 extends AppCompatActivity {
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seveb_to10);
        reg = findViewById(R.id.button1);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(SevebTo10.this, MainActivity.class);
                startActivity(in);
            }
        });
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animScal = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animSca = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        Button btnScal = findViewById(R.id.button2);
        //  Button btnSca = (Button)findViewById(R.id.button3);
        btnScal.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animScale);
                Intent i = new Intent(SevebTo10.this, ViewFees.class);
                startActivity(i);
            }
        });
       /* btnSca.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                arg0.startAnimation(animScale);
                Intent i=new Intent(SevebTo10.this,ViewExam.class);
                startActivity(i);
            }});*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sevento10, menu);
        return true;
    }

}
