package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    private EditText email_field;
    private EditText password_field;
    public SQLiteHelperConection con;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_field = (EditText)findViewById(R.id.email_field);
        password_field = (EditText)findViewById(R.id.password_field);

        con = new SQLiteHelperConection(this, "db_final", null, 1);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.login_button:
                login();
                break;
            case R.id.create_user_button:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void login(){
        con = new SQLiteHelperConection(this, "db_final", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        String user = email_field.getText().toString();
        String password = password_field.getText().toString();
        try {
            cursor = db.rawQuery("SELECT " + Utilidades.EMAIL + ", " + Utilidades.PASSWORD + " FROM "
                    + Utilidades.USER_TABLE + " WHERE " + Utilidades.EMAIL + " = '" + user + "' AND "
                    + Utilidades.PASSWORD + " = '" + password + "'", null);
            if (cursor.moveToFirst()) {
                String usr = cursor.getString(0);
                String pwd = cursor.getString(1);
                if (user.equals(usr) && password.equals(pwd)) {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
            }
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "El usuario no existe o la información no corresponde", Toast.LENGTH_LONG).show();
            clean();
        }
    }

    private void clean() {
        email_field.setText("");
        password_field.setText("");
    }
}
