package com.hugoe.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    TextView tvNombre;
    TextView tvNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String cumpleaños = extras.getString("cumpleaños");
        String telefono = extras.getString("telefono");
        String email = extras.getString("email");
        String descripcion = extras.getString("descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNacimiento = (TextView) findViewById(R.id.tvNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);


        tvNombre.setText(nombre);
        tvNacimiento.setText(cumpleaños);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }
    public void enviarInfo(View v){
        Log.w("INFO", "ENVIANDO");
        Intent i = new Intent(ConfirmacionActivity.this, MainActivity.class);
        i.putExtra("nombre", ((TextView) findViewById(R.id.tvNombre)).getText().toString());
        i.putExtra("cumpleaños", ((TextView) findViewById(R.id.tvNacimiento)).getText().toString());
        i.putExtra("telefono", ((TextView) findViewById(R.id.tvTelefono)).getText().toString());
        i.putExtra("email", ((TextView)  findViewById(R.id.tvEmail)).getText().toString());
        i.putExtra("descripcion", ((TextView)  findViewById(R.id.tvDescripcion)).getText().toString());
        startActivity(i);
        finish();
    }
}
