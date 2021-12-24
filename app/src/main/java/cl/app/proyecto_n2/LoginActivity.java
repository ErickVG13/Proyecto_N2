package cl.app.proyecto_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    Button bt_reg;
    Button bt_log;
    Button bt_getUsersButton;
    TextView txt_correo;
    TextView txt_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_correo = (TextView)  findViewById(R.id.txt_correo);
        txt_contraseña = (TextView)  findViewById(R.id.txt_contraseña);



        bt_reg = (Button)  findViewById(R.id.bt_reg);
        bt_log = (Button)  findViewById(R.id.bt_log);
        bt_getUsersButton = (Button) findViewById(R.id.getUsersButton);

    }



    public void login (View v){
        if(!txt_correo.getText().toString().isEmpty()   && !txt_contraseña.getText().toString().isEmpty() ){


            Intent intentlog = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentlog);

        }else{
            Toast.makeText( LoginActivity.this, "Debe completar los campos vacios", Toast.LENGTH_SHORT).show();

        }


    }

    public void registrar (View v){
        Intent intentRegistro = new Intent(this, Registrarse.class);
        startActivity(intentRegistro);

    }


}