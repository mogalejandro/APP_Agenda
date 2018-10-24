package com.miapp.alejandromota.app_agenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre,et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre=(EditText)findViewById(R.id.editText);
        et_datos=(EditText)findViewById(R.id.editText2);
    }

    public void guardar(View view){
        String nombre=et_nombre.getText().toString();
        String datos=et_datos.getText().toString();

        SharedPreferences preferencia = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor= preferencia.edit();
        obj_editor.putString(nombre,datos);
        obj_editor.commit();
        et_datos.setText("");
        et_nombre.setText("");
        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_LONG).show();
    }

    public void buscar(View view){
        String nombre=et_nombre.getText().toString();

        SharedPreferences preferencia =getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos = preferencia.getString(nombre,"datos");

        if(datos.length() == 0){

            Toast.makeText(this,"No se encontro registro", Toast.LENGTH_LONG);

        }else{

            et_datos.setText(datos);
        }

    }
}
