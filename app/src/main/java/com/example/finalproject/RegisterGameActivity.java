package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.utilidades.Utilidades;

public class RegisterGameActivity extends AppCompatActivity {

    public EditText game_title_field;
    public EditText game_grade_field;
    public EditText game_description_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_game);

        game_title_field = (EditText) findViewById(R.id.game_title_field);
        game_grade_field = (EditText) findViewById(R.id.game_grade_field);
        game_description_field = (EditText) findViewById(R.id.game_description_field);

    }

    public void onClick(View view) {
        Intent intent = null;
        gameRegister();
        intent = new Intent(RegisterGameActivity.this, WelcomeActivity.class);
        startActivity(intent);
        Toast.makeText(RegisterGameActivity.this, "Agregado", Toast.LENGTH_LONG).show();
    }

    private void gameRegister() {
        SQLiteHelperConection con = new SQLiteHelperConection(this, "db_final", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        try {
            String insert = "INSERT INTO " + Utilidades.GAME_TABLE +
                    " (" + Utilidades.GAME_TITLE + ", " + Utilidades.GAME_DESCRIPTION + ", " + Utilidades.GAME_GRADE + ")" +
                    "VALUES ('" + game_title_field.getText().toString() + "', '" + game_description_field.getText().toString() + "', '" +
                    game_grade_field.getText().toString() + "')";

            db.execSQL(insert);
            db.close();
        } catch (Exception e) {
            Toast.makeText(RegisterGameActivity.this, "¡Ha ocurrido un error!", Toast.LENGTH_LONG).show();
        }
    }
}
