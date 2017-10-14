package com.joseaguilar.calendariohora_timepicker;


import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//Instanciamos variables de los elementos del layout
    EditText edtresultado;
    Button btnseleccion;

    //TimePicker - Paso 1: creamos variables int de hora y minutos
     int hora,minuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vinculamos elementos
        edtresultado = (EditText)findViewById(R.id.edthora);
        btnseleccion =(Button)findViewById(R.id.btngo);

        btnseleccion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnseleccion){
            //TimePicker - Paso 2: Instanciamos variable de la clase Calendar -- tiene que ser de java.util.Calendar
            final Calendar c = Calendar.getInstance();
            //TimePicker - Paso 3: establecemos formato de las variables
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);
            //TimePicker - Paso 4: Instanciamos variable de la clase TimePickerDialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    //TimePicker - Paso 5: hacemos que nuestro edittext recoja el resultado
                    edtresultado.setText(hourOfDay+":"+minute);
                }
            },hora,minuto,false);
            timePickerDialog.show();
        }
    }
}
