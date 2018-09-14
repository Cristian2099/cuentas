package com.cuentas.cuentas;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioCuentas extends AppCompatActivity{

    CardView cardCalculadora;
    TextView total;
    TextView resultadoRestaProductoUno;
    TextView resultadoRestaProductoDos;
    Button calcular;

    //cantidad total de productos enviados
    EditText productoUnoTotal;
    EditText productoDosTotal;

    //cantidad de productos restantes
    EditText productoUnoRestante;
    EditText productoDosRestante;
    EditText comisionProductoUno;
    EditText comisionProductoDos;

    //datos de gastos diarioa
    EditText nombreGastoUno;
    EditText cantidadGastoUno;
    EditText valorGastoUno;

    EditText nombreGastoDos;
    EditText cantidadGastoDos;
    EditText valorGastoDos;

    EditText nombreGastoTres;
    EditText cantidadGastoTres;
    EditText valorGastoTres;

    EditText nombreGastoCuatro;
    EditText cantidadGastoCuatro;
    EditText valorGastoCuatro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cuentas);

        productoUnoTotal = findViewById(R.id.txtProductoUnoTotal);
        productoDosTotal = findViewById(R.id.txtProductoDosTotal);

        productoUnoRestante = findViewById(R.id.txtProductoUnoRestante);
        productoDosRestante = findViewById(R.id.txtProductoDosRestante);

        comisionProductoUno = findViewById(R.id.txtComisionProductoUno);
        comisionProductoDos = findViewById(R.id.txtComisionProductoDos);

        nombreGastoUno = findViewById(R.id.txtNombreGastoUno);
        nombreGastoDos = findViewById(R.id.txtNombreGastoDos);
        nombreGastoTres = findViewById(R.id.txtNombreGastoTres);
        nombreGastoCuatro = findViewById(R.id.txtNombreGastoCuatro);

        cantidadGastoUno = findViewById(R.id.txtCantidadGastoUno);
        cantidadGastoDos = findViewById(R.id.txtCantidadGastoDos);
        cantidadGastoTres = findViewById(R.id.txtCantidadGastoTres);
        cantidadGastoCuatro = findViewById(R.id.txtCantidadGastoCuatro);

        valorGastoUno = findViewById(R.id.txtValorGastoUno);
        valorGastoDos = findViewById(R.id.txtValorGastoDos);
        valorGastoTres = findViewById(R.id.txtValorGastoTres);
        valorGastoCuatro = findViewById(R.id.txtValorGastoCuatro);

        calcular = findViewById(R.id.btnCalcular);
        resultadoRestaProductoUno = findViewById(R.id.txtResultadoRestaProductoUno);
        resultadoRestaProductoDos = findViewById(R.id.txtResultadoRestaProductoDos);
        cardCalculadora = findViewById(R.id.cardCalculadora);
        total = findViewById(R.id.txvTotal);


        productoUnoTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String valorTotalUnoS = productoUnoTotal.getText().toString();
                String valorRestanteS = productoUnoRestante.getText().toString();

                int valorTotalUno = 0;

                if (charSequence.length() != 0){
                    valorTotalUno = Integer.parseInt(valorTotalUnoS);
                    resultadoRestaProductoUno.setText(String.valueOf(valorTotalUno));

                }

                if (charSequence.length() == 0){
                    resultadoRestaProductoUno.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        productoUnoRestante.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String valorTotalUnoS = productoUnoTotal.getText().toString();
                String valorRestanteS = productoUnoRestante.getText().toString();

                int valorTotalUno = 0;
                int valorRestante = 0;
                int restaTotalUno = 0;

                if (charSequence.length() != 0){
                    valorRestante = Integer.parseInt(valorRestanteS);
                    resultadoRestaProductoUno.setText(String.valueOf(valorRestante));

                }

                if (charSequence.length() == 0){
                    resultadoRestaProductoUno.setText("");
                }

                if (charSequence.length() == 0 && valorTotalUnoS.length() != 0){
                    resultadoRestaProductoUno.setText(valorTotalUnoS);
                }

                if (charSequence.length() != 0 && valorTotalUnoS.length() != 0){
                    valorTotalUno = Integer.parseInt(valorTotalUnoS);
                    valorRestante = Integer.parseInt(valorRestanteS);
                    restaTotalUno = valorTotalUno - valorRestante;
                    resultadoRestaProductoUno.setText(String.valueOf(restaTotalUno));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        productoDosTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String valorTotalDosS = productoDosTotal.getText().toString();
                String valorRestanteS = productoDosRestante.getText().toString();

                int valorTotalDos = 0;

                if (charSequence.length() != 0){
                    valorTotalDos = Integer.parseInt(valorTotalDosS);
                    resultadoRestaProductoDos.setText(String.valueOf(valorTotalDos));

                }

                if (charSequence.length() == 0){
                    resultadoRestaProductoDos.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        productoDosRestante.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String valorTotalDosS = productoDosTotal.getText().toString();
                String valorRestanteS = productoDosRestante.getText().toString();

                int valorTotalDos = 0;
                int valorRestante = 0;
                int restaTotalDos = 0;

                if (charSequence.length() != 0){
                    valorRestante = Integer.parseInt(valorRestanteS);
                    resultadoRestaProductoDos.setText(String.valueOf(valorRestante));

                }

                if (charSequence.length() == 0){
                    resultadoRestaProductoDos.setText("");
                }

                if (charSequence.length() == 0 && valorTotalDosS.length() != 0){
                    resultadoRestaProductoDos.setText(valorTotalDosS);
                }

                if (charSequence.length() != 0 && valorTotalDosS.length() != 0){
                    valorTotalDos = Integer.parseInt(valorTotalDosS);
                    valorRestante = Integer.parseInt(valorRestanteS);
                    restaTotalDos = valorTotalDos - valorRestante;
                    resultadoRestaProductoDos.setText(String.valueOf(restaTotalDos));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnCalcular:
                calcularTotal();
                break;

            case R.id.btnCalculadora:
                cardCalculadora.setVisibility(View.VISIBLE);
                FragmentCalculadora calculadora = new FragmentCalculadora();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorCalculadora, calculadora).commit();
                break;
        }

    }

    public void calcularTotal(){
        String totalProductoUnoS = productoUnoTotal.getText().toString();
        String totalProductoDosS = productoDosTotal.getText().toString();

        String restoProductoUnoS = productoUnoRestante.getText().toString();
        String restoProductoDosS = productoDosRestante.getText().toString();

        String comProductoUnoS = comisionProductoUno.getText().toString();
        String comProductoDosS = comisionProductoDos.getText().toString();

        String cantGastoUnoS = cantidadGastoUno.getText().toString();
        String cantGastoDosS = cantidadGastoDos.getText().toString();
        String cantGastoTresS = cantidadGastoTres.getText().toString();
        String cantGastoCuatroS = cantidadGastoCuatro.getText().toString();

        String valGastoUnoS = valorGastoUno.getText().toString();
        String valGastoDosS = valorGastoDos.getText().toString();
        String valGastoTresS = valorGastoTres.getText().toString();
        String valGastoCuatroS = valorGastoCuatro.getText().toString();

        int totalProductoUnoI;
        int totalProductoDosI;

        int restoProductoUnoI;
        int restoProductoDosI;

        int comProductoUnoI;
        int comProductoDosI;

        int cantGastoUnoI;
        int cantGastoDosI;
        int cantGastoTresI;
        int cantGastoCuatroI;

        int valGastoUnoI;
        int valGastoDosI;
        int valGastoTresI;
        int valGastoCuatroI;

        if (totalProductoUnoS.isEmpty()){
            totalProductoUnoI = 0;
        }else{
            totalProductoUnoI = Integer.parseInt(totalProductoUnoS);
        }


        if (totalProductoDosS.isEmpty()){
            totalProductoDosI = 0;
        }else{
            totalProductoDosI = Integer.parseInt(totalProductoDosS);
        }


        if (restoProductoUnoS.isEmpty()){
            restoProductoUnoI = 0;
        }else{
            restoProductoUnoI = Integer.parseInt(restoProductoUnoS);
        }


        if (restoProductoDosS.isEmpty()){
            restoProductoDosI = 0;
        }else{
            restoProductoDosI = Integer.parseInt(restoProductoDosS);
        }


        if (comProductoUnoS.isEmpty()){
            comProductoUnoI = 0;
        }else{
            comProductoUnoI = Integer.parseInt(comProductoUnoS);
        }


        if (comProductoDosS.isEmpty()){
            comProductoDosI = 0;
        }else{
            comProductoDosI = Integer.parseInt(comProductoDosS);
        }


        if (valGastoUnoS.isEmpty()){
            valGastoUnoI = 0;
        }else{
            valGastoUnoI = Integer.parseInt(valGastoUnoS);
        }


        if (valGastoDosS.isEmpty()){
            valGastoDosI = 0;
        }else{
            valGastoDosI = Integer.parseInt(valGastoDosS);
        }


        if (valGastoTresS.isEmpty()){
            valGastoTresI = 0;
        }else{
            valGastoTresI = Integer.parseInt(valGastoTresS);
        }


        if (valGastoCuatroS.isEmpty()){
            valGastoCuatroI = 0;
        }else {
            valGastoCuatroI = Integer.parseInt(valGastoCuatroS);
        }


        if (!cantGastoUnoS.isEmpty() && valGastoUnoI != 0){
            cantGastoUnoI = Integer.parseInt(cantGastoUnoS);
            valGastoUnoI = cantGastoUnoI * valGastoUnoI;

        }else if (cantGastoUnoS.isEmpty() && !valGastoUnoS.isEmpty()){
            Toast.makeText(getApplicationContext(), "Cantidad gasto 1 Vacía: Cantidad = 1",Toast.LENGTH_SHORT).show();
            cantGastoUnoI = 1;
            valGastoUnoI = valGastoUnoI * cantGastoUnoI;
        }else{

            valGastoUnoI = 0;
        }


        if (!cantGastoDosS.isEmpty() && valGastoDosI != 0){
            cantGastoDosI = Integer.parseInt(cantGastoDosS);
            valGastoDosI = cantGastoDosI * valGastoDosI;

        }else if (cantGastoDosS.isEmpty() && !valGastoDosS.isEmpty()){
            Toast.makeText(getApplicationContext(), "Cantidad gasto 2 Vacía: Cantidad = 1",Toast.LENGTH_SHORT).show();
            cantGastoDosI = 1;
            valGastoDosI = valGastoDosI * cantGastoDosI;
        }else{

            valGastoDosI = 0;
        }


        if (!cantGastoTresS.isEmpty() && valGastoTresI != 0){
            cantGastoTresI = Integer.parseInt(cantGastoTresS);
            valGastoTresI = cantGastoTresI * valGastoTresI;

        }else if (cantGastoTresS.isEmpty() && !valGastoTresS.isEmpty()){
            Toast.makeText(getApplicationContext(), "Cantidad gasto 3 Vacía: Cantidad = 1",Toast.LENGTH_SHORT).show();
            cantGastoTresI = 1;
            valGastoTresI = valGastoTresI * cantGastoTresI;
        }else{

            valGastoTresI = 0;
        }


        if (!cantGastoCuatroS.isEmpty() && valGastoCuatroI != 0){
            cantGastoCuatroI = Integer.parseInt(cantGastoCuatroS);
            valGastoCuatroI = cantGastoCuatroI * valGastoCuatroI;

        }else if (cantGastoCuatroS.isEmpty() && !valGastoCuatroS.isEmpty()){
            Toast.makeText(getApplicationContext(), "Cantidad gasto 4 Vacía: Cantidad = 1",Toast.LENGTH_SHORT).show();
            cantGastoCuatroI = 1;
            valGastoCuatroI = valGastoCuatroI * cantGastoCuatroI;
        }else{

            valGastoCuatroI = 0;
        }

        int vendidoProductoUno = totalProductoUnoI - restoProductoUnoI;
        int vendidoProductoDos = totalProductoDosI - restoProductoDosI;

        resultadoRestaProductoUno.setText(String.valueOf(vendidoProductoUno));
        resultadoRestaProductoDos.setText(String.valueOf(vendidoProductoDos));

        int valorTotalProductoUno = vendidoProductoUno * comProductoUnoI;
        int valorTotalProductoDos = vendidoProductoDos * comProductoDosI;

        int valorTotalProductos = valorTotalProductoUno + valorTotalProductoDos;

        valorTotalProductos -= (valGastoUnoI + valGastoDosI + valGastoTresI + valGastoCuatroI);

        total.setText(getString(R.string.textoTotal, valorTotalProductos));
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed(){

        if (cardCalculadora.getVisibility() == View.VISIBLE){
            cardCalculadora.setVisibility(View.INVISIBLE);
        }else{
            super.onBackPressed();
        }

    }

}
