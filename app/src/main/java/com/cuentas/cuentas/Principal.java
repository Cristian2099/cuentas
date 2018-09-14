package com.cuentas.cuentas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button btnJefe;
    Button btnEmpleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnJefe =  findViewById(R.id.btnJefe);
        btnEmpleado = findViewById(R.id.btnCuentas);

    }


    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnJefe:
                intent = new Intent(getApplicationContext(), FormularioJefe.class);
            break;

            case R.id.btnCuentas:
                intent = new Intent(getApplicationContext(), FormularioCuentas.class);
            break;
        }

        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        finish();
    }

}
