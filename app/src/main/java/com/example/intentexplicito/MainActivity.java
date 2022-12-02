package com.example.intentexplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    TextView Aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Aviso = (TextView)findViewById(R.id.aviso);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                Aviso.setText("Segundos: " + l/1000);
            }
            @Override
            public void onFinish() {
                Bundle bundle = new Bundle();
                bundle.putString("nombre","Andrea");
                Intent intent = new Intent(getApplicationContext(),SegundaPaguina.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }.start();
    }
}