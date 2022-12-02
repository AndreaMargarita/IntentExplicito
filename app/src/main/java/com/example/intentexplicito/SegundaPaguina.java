package com.example.intentexplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaPaguina extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_paguina);

        Bundle extras= getIntent().getExtras();
        String name= extras.getString("nombre");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
        TextView tv = findViewById(R.id.txtNombre);
        tv.setText(name);
        findViewById(R.id.btn1pg3).setOnClickListener(this::BuscaWeb);
        findViewById(R.id.btn2pg3).setOnClickListener(this::VistaMApa);
        findViewById(R.id.btn3).setOnClickListener(this::Youtube);
        findViewById(R.id.btn4).setOnClickListener(this::ComandoVoz);
        findViewById(R.id.btn5).setOnClickListener(this::VistaTelefono);
        findViewById(R.id.btn6).setOnClickListener(this::VistaContactos);
        findViewById(R.id.btnpagina3).setOnClickListener(this::Cambiarpagina);

    }

    private void Cambiarpagina(View view) {
        Intent intent = new Intent(getApplicationContext(),Tercerapaguina.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view)
    {
        Intent Integer = new Intent(this,SegundaPaguina.class);
        startActivity(Integer);
    }

    public void BuscaWeb(View view)
    {
        Intent intent= new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, "Los valores personales");
        startActivity(intent);
    }

    private void VistaMApa(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.mx/maps/")));
    }

    private void Youtube(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com")));
    }

    private void ComandoVoz(View view)
    {
        startActivity(new Intent(Intent.ACTION_VOICE_COMMAND));
    }

    private void VistaTelefono(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:"));
        startActivity(intent);
    }

    private void VistaContactos(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")));
    }
    }