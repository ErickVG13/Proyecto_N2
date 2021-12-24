package cl.app.proyecto_n2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cl.app.proyecto_n2.LoginActivity;
import cl.app.proyecto_n2.R;
import org.json.JSONArray;

public class Registrarse extends AppCompatActivity {

    private Button bt_registrar;

    private TextView txt_name;
    private TextView txt_user;
    private TextView txt_pas;
    private TextView txt_edad;



    FirebaseAuth mAuth;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        bt_registrar = (Button)  findViewById(R.id.bt_registrar);



        txt_name = (TextView)  findViewById(R.id.txt_name);
        txt_user = (TextView)  findViewById(R.id.txt_user);
        txt_pas = (TextView)  findViewById(R.id.txt_pas);
        txt_edad = (TextView)  findViewById(R.id.txt_edad);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txt_name.getText().toString();
                String user = txt_user.getText().toString();
                String pass = txt_pas.getText().toString();
                String edad = txt_edad.getText().toString();

                if (!name.isEmpty() && !user.isEmpty() && !pass.isEmpty() && !edad.isEmpty()) {
                    if(pass.length() >= 6){
                        Usuario usuario = new Usuario();
                        usuario.setId(UUID.randomUUID().toString());
                        usuario.setEdad(edad);
                        usuario.setName(name);
                        usuario.setUser(user);
                        usuario.setPass(pass);
                        DB.getInstancia().registerUser(usuario);
                        Toast.makeText(getApplicationContext(), "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText( Registrarse.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText( Registrarse.this, "Debe completar los campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}