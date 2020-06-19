package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.utilidades.Utilidades;

public class RegisterBookActivity extends AppCompatActivity {

    public EditText book_title_field;
    public EditText book_grade_field;
    public EditText book_description_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_book);

        book_title_field = (EditText) findViewById(R.id.book_title_field);
        book_grade_field = (EditText) findViewById(R.id.book_grade_field);
        book_description_field = (EditText) findViewById(R.id.book_description_field);

    }

    public void onClick(View view) {
        Intent intent = null;
        bookRegister();
        intent = new Intent(RegisterBookActivity.this, WelcomeActivity.class);
        startActivity(intent);
        Toast.makeText(RegisterBookActivity.this, "Agregado", Toast.LENGTH_LONG).show();
    }

    private void bookRegister() {
        SQLiteHelperConection con = new SQLiteHelperConection(this, "db_final", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        try {
            String insert = "INSERT INTO " + Utilidades.BOOK_TABLE +
                    " (" + Utilidades.BOOK_TITLE + ", " + Utilidades.BOOK_DESCRIPTION + ", " + Utilidades.BOOK_GRADE + ")" +
                    "VALUES ('" + book_title_field.getText().toString() + "', '" + book_description_field.getText().toString() + "', '" +
                    book_grade_field.getText().toString() + "')";

            db.execSQL(insert);
            db.close();
        } catch (Exception e) {
            Toast.makeText(RegisterBookActivity.this, "¡Ha ocurrido un error!", Toast.LENGTH_LONG).show();
        }
    }
}
