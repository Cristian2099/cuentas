package com.cuentas.cuentas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FormularioJefe extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_jefe);
    }

    public void toFormRegistroCuentas(View view){
        Intent intent = new Intent(getApplicationContext(), FormularioRegistro.class);
        startActivity(intent);
    }
}
