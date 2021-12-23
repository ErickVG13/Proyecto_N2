package cl.app.proyecto_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void siguiente(View v){
        Intent intentSiguiente= new Intent(this, Asiento_Pasajero.class);
        startActivity(intentSiguiente);

    }

}