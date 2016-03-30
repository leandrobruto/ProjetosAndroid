package com.example.leandro.programinha;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.support.v7.app.WindowDecorActionBar;

/**
 * Created by Leandro on 17/03/16.
 */
public class ActMain extends Activity implements View.OnClickListener{

    private EditText edtValor1;
    private EditText edtValor2;
    private  Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_main);

        edtValor1 = (EditText)findViewById(R.id.edtValor1);
        edtValor2 = (EditText)findViewById(R.id.edtValor2);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);

    }

    public void onClick(View v){

        String v1 = edtValor1.getText().toString();
        String v2 = edtValor2.getText().toString();

        if(v1.trim().isEmpty() || v2.trim().isEmpty()){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Informe dois numeros pra efetuar a soma!");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }else {
            double valor1 = Double.parseDouble(edtValor1.getText().toString());
            double valor2 = Double.parseDouble(edtValor2.getText().toString());
            double resultado = valor1 + valor2;

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("O resultado da soma é: " + resultado);
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

}
