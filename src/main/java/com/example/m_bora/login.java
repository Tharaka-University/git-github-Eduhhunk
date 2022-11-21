package com.example.m_bora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login extends AppCompatActivity {
    Button register_button,loginbtn;
    TextInputLayout username_var,password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        register_button=findViewById(R.id.register);
        loginbtn=findViewById(R.id.login_button);

        username_var=findViewById(R.id.username);
        password_var=findViewById(R.id.password);

        loginbtn.setOnClickListener(v -> {
            String username= Objects.requireNonNull(username_var.getEditText()).getText().toString();
            String password= Objects.requireNonNull(password_var.getEditText()).getText().toString();
            if (!username.isEmpty()){
                username_var.setError(null);
                username_var.setEnabled(false);
                if (!password.isEmpty()){
                    password_var.setError(null);
                    password_var.setEnabled(false);

                    final String username_data=username_var.getEditText().getText().toString();
                    final String password_data=password_var.getEditText().getText().toString();
                    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference=firebaseDatabase.getReference("data");
                    Query check_username=databaseReference.orderByChild("username").equalTo(username_data);
                    check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                username_var.setError(null);
                                username_var.setEnabled(false);
                                String passwordcheck=snapshot.child(username_data).child("password").getValue(String.class);
                                assert passwordcheck != null;
                                if(passwordcheck.equals(password_data)){
                                    password_var.setError(null);
                                    password_var.setEnabled(false);
                                    Toast.makeText(getApplicationContext(), "login successful", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),Services2.class);
                                    startActivity(intent);
                                    finish();


                                }else{
                                    password_var.setError("please enter correct password");
                                }


                            }else{
                                username_var.setError("username doesn't exist");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




                }else{
                    password_var.setError("enter correct password");
                }

            }else{
                username_var.setError("enter correct username");
            }

        });













        register_button.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),signup.class);
            startActivity(intent);


        });
    }
}