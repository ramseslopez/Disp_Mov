package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.utilidades.Utilidades;

public class WelcomeActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView phone;
    private SQLiteHelperConection con;
    private Cursor cursor;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        showData();
    }


    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()) {
            case R.id.logout_button:
                finish();
                intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.player_button:
                intent = new Intent(WelcomeActivity.this, PlayerActivity.class);
                startActivity(intent);
                break;
            case R.id.book_button:
                intent = new Intent(WelcomeActivity.this, BookActivity.class);
                startActivity(intent);
                break;
            case R.id.game_button:
                intent = new Intent(WelcomeActivity.this, GameActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void showData() {

        name = (TextView)findViewById(R.id.name_user);
        email = (TextView)findViewById(R.id.email_user);
        phone = (TextView)findViewById(R.id.phone_user);

        con = new SQLiteHelperConection(this, "db_final", null, 1);
        db = con.getReadableDatabase();
        cursor = db.rawQuery("SELECT " + Utilidades.NAME + ", " + Utilidades.EMAIL + ", " + Utilidades.PHONE
                              + " FROM " + Utilidades.USER_TABLE, null);
        if (cursor.moveToLast()) {
            name.setText(cursor.getString(0));
            email.setText(cursor.getString(1));
            phone.setText(cursor.getString(2));
        } else {
            Toast.makeText(WelcomeActivity.this, ":P", Toast.LENGTH_LONG).show();
        }
        db.close();
    }
}
