package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.entidades.User;
import com.example.finalproject.utilidades.Utilidades;

public class RegisterActivity extends AppCompatActivity {

    public EditText email_field = null;
    public EditText name_field = null;
    public EditText password_field = null;
    public EditText phone_field = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_field = (EditText)findViewById(R.id.email_field);
        name_field = (EditText)findViewById(R.id.name_field);
        password_field = (EditText)findViewById(R.id.password_field);
        phone_field = (EditText)findViewById(R.id.phone_field);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.login_button:
                intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.register_button:
                intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                userRegister();
                startActivity(intent);
                Toast.makeText(RegisterActivity.this, "Bienvenidx " , Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void userRegister() {
        SQLiteHelperConection con = new SQLiteHelperConection(this, "db_final", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        String insert = "INSERT INTO " + Utilidades.USER_TABLE +
                        " (" + Utilidades.EMAIL + ", " + Utilidades.NAME + ", " + Utilidades.PASSWORD + ", " + Utilidades.PHONE + ")" +
                        "VALUES ('" + email_field.getText().toString() + "', '" + name_field.getText().toString()
                                 + "', '" + password_field.getText().toString() + "', '" + phone_field.getText().toString() + "')";

        db.execSQL(insert);
        db.close();
    }
}
