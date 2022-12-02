package com.example.intentexplicito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tercerapaguina extends AppCompatActivity implements View.OnClickListener {

    Button btn1pg3, btn2pg3,btn4;
    int RequestCode = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercerapaguina);

        btn1pg3 =findViewById(R.id.btn1pg3);
        btn2pg3 =findViewById(R.id.btn2pg3);
        btn4 =findViewById(R.id.btn4pg);
        btn4.setOnClickListener(this::Cambiarpagina);
        btn1pg3.setOnClickListener(this);
        btn2pg3.setOnClickListener(this);
    }

    private void Cambiarpagina(View view) {
        //Intent intent = new Intent(getApplicationContext(),ListaCuartaPaguina.class);
        //startActivity(intent);
    }

    private void verificarPermisos() {

            int estadoDePermiso = ContextCompat.checkSelfPermission(Tercerapaguina.this, Manifest.permission.CALL_PHONE);

            if (estadoDePermiso == PackageManager.PERMISSION_GRANTED) {
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:8712209616"));
                startActivity(intent2);
                Toast.makeText(this, "Permiso de llamada concedico", Toast.LENGTH_SHORT).show();
                return;
            } else {
                //si no, entonces pedimos permisos
                //ActivityCompat.requestPermissions(Tercerapaguina.this,new String[]{Manifest.permission.CALL_PHONE},22);
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},22);
                Toast.makeText(this, "No tienes permiso F", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public void onClick(View view) {
        int estadoDePermiso = ContextCompat.checkSelfPermission(Tercerapaguina.this, Manifest.permission.CALL_PHONE);
        switch (view.getId())
        {
            case R.id.btn1pg3:
                        verificarPermisos();
               /* Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8712209614"));
                startActivity(intent);
                */
                //Toast.makeText(this,"btn1pg3",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2pg3:

               //int estadoDePermiso = ContextCompat.checkSelfPermission(Tercerapaguina.this, Manifest.permission.CALL_PHONE);
                if(estadoDePermiso == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"Permiso de llamada concedico",Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(Intent.ACTION_DIAL);
                    intent2.setData(Uri.parse("tel:8712209615"));
                    startActivity(intent2);
                    return;
                }
                else
                {
                    //si no, entonces pedimos permisos
                    ActivityCompat.requestPermissions(Tercerapaguina.this,new String[]{Manifest.permission.CALL_PHONE},22);
                }
                //Toast.makeText(this,"btn2pg3",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void Llamar ()
    {
        Intent intent2 = new Intent(Intent.ACTION_CALL);
        intent2.setData(Uri.parse("tel:8712209617"));
        startActivity(intent2);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 22) {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Llamar();
            }
        }
    }
}