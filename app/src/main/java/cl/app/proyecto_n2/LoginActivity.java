package cl.app.proyecto_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button bt_reg;
    Button bt_log;
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

        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //    Intent intentReg = new Intent(LoginActivity.this, Registrarse.class)
                //  LoginActivity.this.startActivity(intentReg);

            }
        });

    }
}