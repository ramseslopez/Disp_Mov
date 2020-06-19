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

public class DeleteBookActivity extends AppCompatActivity {

    public EditText delete_book_field;
    public Button delete_book_button;
    public SQLiteHelperConection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);

        delete_book_field = (EditText) findViewById(R.id.delete_book_field);
        delete_book_button = (Button) findViewById(R.id.delete_book_button);

    }

    public void onClick(View view) {
        Intent intent = new Intent(DeleteBookActivity.this, WelcomeActivity.class);
        deleteBook();
        startActivity(intent);
    }

    private void deleteBook() {
        con = new SQLiteHelperConection(this, "db_final", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + Utilidades.BOOK_TITLE + " FROM " + Utilidades.BOOK_TABLE, null);
        cursor.moveToFirst();
        String str = cursor.getString(0);
        try {
            if (delete_book_field.getText().toString().equals(str)) {
                db.delete(Utilidades.BOOK_TABLE, Utilidades.BOOK_TITLE + " = " + str, null);
                Toast.makeText(DeleteBookActivity.this, "Eliminado", Toast.LENGTH_SHORT).show();
                db.close();
            }
        } catch (Exception e) {
            Toast.makeText(DeleteBookActivity.this, "No ha sido posible la acción", Toast.LENGTH_SHORT).show();
        }
    }
}
