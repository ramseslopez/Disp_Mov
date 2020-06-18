package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
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
                break;
            case R.id.book_button:
                break;
            case R.id.game_button:
                break;
        }
    }
}
