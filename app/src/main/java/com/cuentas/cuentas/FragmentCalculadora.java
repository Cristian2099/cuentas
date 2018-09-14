package com.cuentas.cuentas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class FragmentCalculadora extends Fragment implements View.OnClickListener{

    Button btnUno;
    Button btnDos;
    Button btnTres;
    Button btnCuatro;
    Button btnCinco;
    Button btnSeis;
    Button btnSiete;
    Button btnOcho;
    Button btnNueve;
    Button btnCero;
    Button btnSuma;
    Button btnResta;
    Button btnMulti;
    Button btnDiv;
    Button btnIgual;
    Button btnLimpiar;
    TextView txvResultados;

    int numeroUno = 0;
    int numeroDos = 0;
    int resultado = 0;
    String expresion = "";
    boolean esSuma = false;
    boolean esResta = false;
    boolean esMulti = false;
    boolean esDiv = false;
    boolean esIgual = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_formulario_calculadora, container,false);

        txvResultados = (TextView) view.findViewById(R.id.txvResultados);
        btnUno = (Button) view.findViewById(R.id.btnUno);
        btnDos = (Button) view.findViewById(R.id.btnDos);
        btnTres = (Button) view.findViewById(R.id.btnTres);
        btnCuatro = (Button) view.findViewById(R.id.btnCuatro);
        btnCinco = (Button) view.findViewById(R.id.btnCinco);
        btnSeis = (Button) view.findViewById(R.id.btnSeis);
        btnSiete = (Button) view.findViewById(R.id.btnSiete);
        btnOcho = (Button) view.findViewById(R.id.btnOcho);
        btnNueve = (Button) view.findViewById(R.id.btnNueve);
        btnCero = (Button) view.findViewById(R.id.btnCero);
        btnSuma = (Button) view.findViewById(R.id.btnSuma);
        btnResta = (Button) view.findViewById(R.id.btnResta);
        btnMulti = (Button) view.findViewById(R.id.btnMulti);
        btnDiv = (Button) view.findViewById(R.id.btnDiv);
        btnIgual = (Button) view.findViewById(R.id.btnIgual);
        btnLimpiar = (Button) view.findViewById(R.id.btnLimpiar);

        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSiete.setOnClickListener(this);
        btnOcho.setOnClickListener(this);
        btnNueve.setOnClickListener(this);
        btnCero.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btnLimpiar:
                txvResultados.setText("");
                numeroUno = 0;
                numeroDos = 0;
                resultado = 0;
                expresion = "";
                break;
            case R.id.btnUno:
                txvResultados.setText(txvResultados.getText() + "1");
                break;

            case R.id.btnDos:
                txvResultados.setText(txvResultados.getText() + "2");
                break;

            case R.id.btnTres:
                txvResultados.setText(txvResultados.getText() + "3");
                break;

            case R.id.btnCuatro:
                txvResultados.setText(txvResultados.getText() + "4");
                break;

            case R.id.btnCinco:
                txvResultados.setText(txvResultados.getText() + "5");
                break;

            case R.id.btnSeis:
                txvResultados.setText(txvResultados.getText() + "6");
                break;

            case R.id.btnSiete:
                txvResultados.setText(txvResultados.getText() + "7");
                break;

            case R.id.btnOcho:
                txvResultados.setText(txvResultados.getText() + "8");
                break;

            case R.id.btnNueve:
                txvResultados.setText(txvResultados.getText() + "9");
                break;

            case R.id.btnCero:
                txvResultados.setText(txvResultados.getText() + "0");
                break;

            case R.id.btnDiv:
                expresion = lastToken(txvResultados.getText().toString());
                if (expresion.isEmpty()){
                    numeroUno = 0;
                }else{
                    numeroUno = Integer.parseInt(lastToken(expresion));
                }

                expresion += " / ";
                txvResultados.setText("");
                esDiv = true;

                break;

            case R.id.btnSuma:
                expresion = lastToken(txvResultados.getText().toString());
                if (txvResultados.getText().equals("")){
                    numeroUno = 0;
                }else{
                    numeroUno = Integer.parseInt(lastToken(expresion));
                }
                expresion += " + ";
                txvResultados.setText("");
                esSuma = true;

                break;

            case R.id.btnResta:
                expresion = lastToken(txvResultados.getText().toString());
                if (txvResultados.getText().equals("")){
                    numeroUno = 0;
                }else{
                    numeroUno = Integer.parseInt(lastToken(expresion));
                }
                expresion += " - ";
                txvResultados.setText("");
                esResta = true;

                break;

            case R.id.btnMulti:
                expresion = lastToken(txvResultados.getText().toString());
                if (txvResultados.getText().equals("")){
                    numeroUno = 0;
                }else{
                    numeroUno = Integer.parseInt(lastToken(expresion));
                }
                expresion += " * ";
                txvResultados.setText("");
                esMulti = true;

                break;


            case R.id.btnIgual:
                expresion += lastToken(txvResultados.getText().toString());
                if (esSuma){
                    esSuma = false;
                    if (txvResultados.equals("")){
                        numeroDos = 0;
                    }else {
                        numeroDos = Integer.parseInt(lastToken(expresion));
                    }
                    resultado = numeroUno + numeroDos;


                }else if(esResta){
                    esResta = false;
                    if (txvResultados.equals("")){
                        numeroDos = 0;
                    }else {
                        numeroDos = Integer.parseInt(lastToken(expresion));
                    }
                    resultado = numeroUno - numeroDos;

                }else if(esMulti){
                    esMulti = false;
                    if (txvResultados.equals("")){
                        numeroDos = 0;
                    }else{
                        numeroDos = Integer.parseInt(lastToken(expresion));
                    }
                    resultado = numeroUno * numeroDos;

                }else if(esDiv){
                    esDiv = false;
                    if (txvResultados.equals("")){
                        numeroDos = 0;
                    }else{
                        numeroDos = Integer.parseInt(lastToken(expresion));
                    }
                    resultado = numeroUno / numeroDos;
                }

                expresion += " = " + resultado;
                txvResultados.setText(expresion);
                expresion = "";

        }
    }

    public String lastToken(String expresion){
        StringTokenizer tokens = new StringTokenizer(expresion);
        String lastToken = "";
        while (tokens.hasMoreTokens()){
            lastToken = tokens.nextToken();
        }

        return lastToken;
    }
}
