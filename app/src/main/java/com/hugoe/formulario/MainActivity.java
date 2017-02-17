package com.hugoe.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    EditText etNombre;
    EditText etNacimiento;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcion;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCurrentDateOnView();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String cumpleaños = extras.getString("cumpleaños");
            String telefono = extras.getString("telefono");
            String email = extras.getString("email");
            String descripcion = extras.getString("descripcion");

            etNombre = (EditText) findViewById(R.id.etNombre);
            etNacimiento = (EditText) findViewById(R.id.etNacimiento);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);


            etNombre.setText(nombre);
            etNacimiento.setText(cumpleaños);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }
    }

    public void enviarInfo(View v) {
        Log.w("INFO", "ENVIANDO");
        Intent i = new Intent(MainActivity.this, ConfirmacionActivity.class);
        i.putExtra("nombre", ((EditText) findViewById(R.id.etNombre)).getText().toString());
        i.putExtra("cumpleaños", ((EditText) findViewById(R.id.etNacimiento)).getText().toString());
        i.putExtra("telefono", ((EditText) findViewById(R.id.etTelefono)).getText().toString());
        i.putExtra("email", ((EditText) findViewById(R.id.etEmail)).getText().toString());
        i.putExtra("descripcion", ((EditText) findViewById(R.id.etDescripcion)).getText().toString());
        startActivity(i);
        finish();
    }

    public void showDatePickerDialog(View v) {
        // DialogFragment newFragment = new DatePickerFragment();
        //newFragment.show(getSupportFragmentManager(), "datePicker");
        showDialog(DATE_DIALOG_ID);
    }

    public void setCurrentDateOnView() {
        etNacimiento = (EditText) findViewById(R.id.etNacimiento);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        // set current date into textview
        etNacimiento.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(day).append("-").append(month + 1).append("-")
                .append(year).append(" "));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            etNacimiento.setText(new StringBuilder().append(day)
                    .append("-").append(month + 1).append("-").append(year)
                    .append(" "));

        }
    };


}
