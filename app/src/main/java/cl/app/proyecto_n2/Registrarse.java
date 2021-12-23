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
import cl.app.proyecto_n2.LoginActivity;
import cl.app.proyecto_n2.R;
import org.json.JSONArray;

public class Registrarse extends AppCompatActivity {

    private Button bt_registrar;

    private TextView txt_name;
    private TextView txt_user;
    private TextView txt_pas;
    private TextView txt_edad;

    private String name = "";
    private String user = "";
    private String pas = "";
    private String edad = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        bt_registrar = (Button)  findViewById(R.id.bt_registrar);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        txt_name = (TextView)  findViewById(R.id.txt_name);
        txt_user = (TextView)  findViewById(R.id.txt_user);
        txt_pas = (TextView)  findViewById(R.id.txt_pas);
        txt_edad = (TextView)  findViewById(R.id.txt_edad);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = txt_name.getText().toString();
                user = txt_user.getText().toString();
                pas = txt_pas.getText().toString();
                edad = txt_edad.getText().toString();

                if (!name.isEmpty() && !user.isEmpty() && !pas.isEmpty() && !edad.isEmpty()) {
                    if(pas.length() > 6){

                        registerUser();
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

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(user, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email", user);
                    map.put("pas", pas);
                    map.put("edad", edad);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Registrarse.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registrarse.this, LoginActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(Registrarse.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Registrarse.this, "Debe completar los campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}