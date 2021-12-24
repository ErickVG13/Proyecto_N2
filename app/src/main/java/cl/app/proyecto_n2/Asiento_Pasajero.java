package cl.app.proyecto_n2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Asiento_Pasajero extends AppCompatActivity {

    Button bt_reserva;

    EditText txt_libre;
    EditText txt_ocupado;

    RadioButton rd_1;
    RadioButton rd_2;
    RadioButton rd_3;
    RadioButton rd_4;
    RadioButton rd_5;
    RadioButton rd_6;
    RadioButton rd_7;
    RadioButton rd_8;
    RadioButton rd_9;
    RadioButton rd_10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asiento_pasajero);

        List <Asiento_Pasajero> items = new ArrayList<Asiento_Pasajero>(40);
        items.add(new Asiento_Pasajero());


        bt_reserva = (Button)  findViewById(R.id.bt_reserva);

        txt_libre = (EditText)  findViewById(R.id.txt_libre);
        txt_ocupado = (EditText)  findViewById(R.id.txt_ocupado);

        rd_1 = (RadioButton)  findViewById(R.id.rd_1);
        rd_2 = (RadioButton)  findViewById(R.id.rd_2);
        rd_3 = (RadioButton)  findViewById(R.id.rd_3);
        rd_4 = (RadioButton)  findViewById(R.id.rd_4);
        rd_5 = (RadioButton)  findViewById(R.id.rd_5);
        rd_6 = (RadioButton)  findViewById(R.id.rd_6);
        rd_7 = (RadioButton)  findViewById(R.id.rd_7);
        rd_8 = (RadioButton)  findViewById(R.id.rd_8);
        rd_9 = (RadioButton)  findViewById(R.id.rd_9);
        rd_10 = (RadioButton)  findViewById(R.id.rd_10);

        bt_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

//Intanciando la otra ventana de android

    public void reserva(View v){
        Intent reserva = new Intent(this, Boleto_Reserva.class);
        startActivity(reserva);
        finish();

    }
}