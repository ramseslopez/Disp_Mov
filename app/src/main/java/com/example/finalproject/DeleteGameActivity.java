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

public class DeleteGameActivity extends AppCompatActivity {

    public EditText delete_game_field;
    public Button delete_game_button;
    public SQLiteHelperConection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_game);

        delete_game_field = (EditText) findViewById(R.id.delete_game_field);
        delete_game_button = (Button) findViewById(R.id.delete_game_button);

    }

    public void onClick(View v) {
        Intent intent = new Intent(DeleteGameActivity.this, WelcomeActivity.class);
        deleteGame();
        startActivity(intent);
    }

    private void deleteGame() {
        con = new SQLiteHelperConection(this, "db_final", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + Utilidades.GAME_TITLE + " FROM " + Utilidades.GAME_TABLE, null);
        cursor.moveToFirst();
        String str = cursor.getString(0);
        try {
            if (delete_game_field.getText().toString().equals(str)) {
                db.execSQL("DELETE FROM " + Utilidades.GAME_TABLE + " WHERE " + Utilidades.GAME_TITLE + " = '" + str + "'");
                Toast.makeText(DeleteGameActivity.this, "Eliminado", Toast.LENGTH_SHORT).show();
                db.close();
            } else {
                Toast.makeText(DeleteGameActivity.this, "Inténtalo de nuevo", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(DeleteGameActivity.this, "No ha sido posible la acción", Toast.LENGTH_SHORT).show();
        }
    }
}
