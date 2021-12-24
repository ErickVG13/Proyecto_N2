package cl.app.proyecto_n2;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DB {

    private static DB instancia;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    public static DB getInstancia() {
        if (instancia == null) {
            instancia = new DB();
        }
        return instancia;
    }

    private DB() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    // insertar
    public void registerUser(Usuario usuario) {

        mDatabase.child("Usuarios").child(usuario.getId()).setValue(usuario);
    }


    // leer



    // borrar

    // modificar


}
