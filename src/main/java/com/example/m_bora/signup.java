package com.example.m_bora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signup extends AppCompatActivity {
    TextInputLayout fullname_var,id_No_var,kra_pin_var,username_var,password_var,phone_NO_var;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullname_var =findViewById(R.id.fullname_fields);
        id_No_var=findViewById(R.id.id_No);
        kra_pin_var=findViewById(R.id.kra_pin);
        username_var=findViewById(R.id.username);
        password_var=findViewById(R.id.password);
        phone_NO_var=findViewById(R.id.phone_No);






    }

    public void loginbuttonclick(View view) {
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
        finish();

    }


    public void registerbuttonclick(View view) {
        String fullname= Objects.requireNonNull(fullname_var.getEditText()).getText().toString();
        String id_No= Objects.requireNonNull(id_No_var.getEditText()).getText().toString();
        String kra_pin= Objects.requireNonNull(kra_pin_var.getEditText()).getText().toString();
        String username= Objects.requireNonNull(username_var.getEditText()).getText().toString();
        String password= Objects.requireNonNull(password_var.getEditText()).getText().toString();
        String phone_No= Objects.requireNonNull(phone_NO_var.getEditText()).getText().toString();

        if (!fullname.isEmpty()){
            fullname_var.setError(null);
            fullname_var.setEnabled(false);
            if (!id_No.isEmpty()){
                id_No_var.setError(null);
                id_No_var.setEnabled(false);
                if (!kra_pin.isEmpty()){
                    kra_pin_var.setError(null);
                    kra_pin_var.setEnabled(false);
                    if(!username.isEmpty()){
                        username_var.setError(null);
                        username_var.setEnabled(false);
                        if (!password.isEmpty()){
                            password_var.setError(null);
                            password_var.setEnabled(false);
                            if(!phone_No.isEmpty()){
                                phone_NO_var.setError(null);
                                phone_NO_var.setEnabled(false);

                                firebaseDatabase=FirebaseDatabase.getInstance();
                                reference=firebaseDatabase.getReference("data");
                               String fullname_s =Objects.requireNonNull(fullname_var.getEditText()).getText().toString();
                                String id_No_s= Objects.requireNonNull(id_No_var.getEditText()).getText().toString();
                                String kra_pin_s= Objects.requireNonNull(kra_pin_var.getEditText()).getText().toString();
                                String username_s= Objects.requireNonNull(username_var.getEditText()).getText().toString();
                                String password_s= Objects.requireNonNull(password_var.getEditText()).getText().toString();
                                String phone_No_s= Objects.requireNonNull(phone_NO_var.getEditText()).getText().toString();

                                storingdata storingdatass=new storingdata(fullname_s,id_No_s,kra_pin_s,username_s,password_s,phone_No_s);
                                reference.child(username_s).setValue(storingdatass);
                                Toast.makeText( getApplicationContext(), "Registered successful", Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(getApplicationContext(), Services2.class);
                                startActivity(intent);
                            }else {
                                phone_NO_var.setError("Enter correct phone");
                            }

                        }else {
                            password_var.setError("Enter your password");
                        }

                    }else{
                        username_var.setError("Enter your username");
                    }
                }else{
                    kra_pin_var.setError("Enter your KRA");
                }

            }else{
                id_No_var.setError("Enter your id");
            }

        }else{
            fullname_var.setError("Enter your fullname");
        }

    }
}