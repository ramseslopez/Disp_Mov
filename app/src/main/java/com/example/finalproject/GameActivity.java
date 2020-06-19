package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.finalproject.entidades.Book;
import com.example.finalproject.entidades.Game;
import com.example.finalproject.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    public FloatingActionButton button;
    public ListView games_list_view;
    public ArrayList<String> infog_list;
    public ArrayList<Game> game_list;
    public SQLiteHelperConection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        con = new SQLiteHelperConection(getApplicationContext(), "db_final", null, 1);
        games_list_view = (ListView)findViewById(R.id.simple_game_list_id);

        button = (FloatingActionButton)findViewById(R.id.register_game_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, RegisterGameActivity.class);
                startActivity(intent);
            }
        });

        showGameList();

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_list2, R.id.textView3, infog_list);
        games_list_view.setAdapter(adapter);

        games_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String info = "Título: " + game_list.get(position).getGame_title() + "\n";
                info += "Sinopsis: " + game_list.get(position).getGame_description() + "\n";
                info += "Califcación: " + game_list.get(position).getGame_grade();

                Toast.makeText(GameActivity.this, info, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showGameList() {
        SQLiteDatabase db = con.getReadableDatabase();
        Game game = null;
        game_list = new ArrayList<Game>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.GAME_TABLE, null);

        while (cursor.moveToNext()) {
            game = new Game();
            game.setGame_title(cursor.getString(1));
            game.setGame_description(cursor.getString(2));
            game.setGame_grade(cursor.getInt(3));

            game_list.add(game);
        }
        getList();
    }

    private void getList() {
        infog_list = new ArrayList<String>();

        for (int i = 0; i < game_list.size(); i++) {
            infog_list.add(game_list.get(i).getGame_title());
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(GameActivity.this, DeleteGameActivity.class);
        startActivity(intent);
    }
}
