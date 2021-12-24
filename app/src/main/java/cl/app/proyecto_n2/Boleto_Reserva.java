package cl.app.proyecto_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Boleto_Reserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boleto_reserva);
    }
//Esta es la instrucción para salir de la apk

    public void salir (View v){
       finish();
       System.exit(0);

    }
    public  void  aceptar(View v){
        finish();

    }
}