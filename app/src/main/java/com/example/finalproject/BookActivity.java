package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.finalproject.entidades.Book;
import com.example.finalproject.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private FloatingActionButton button;
    public ListView books_list_view;
    public ArrayList<String> info_list;
    public ArrayList<Book> book_list;
    public SQLiteHelperConection con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        con = new SQLiteHelperConection(getApplicationContext(), "db_final", null, 1);
        books_list_view = (ListView)findViewById(R.id.list_view_id);

        button = (FloatingActionButton)findViewById(R.id.register_book_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this, RegisterBookActivity.class);
                startActivity(intent);
            }
        });

        showBookList();

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_list, R.id.textView, info_list);
        books_list_view.setAdapter(adapter);

        books_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String info = "Título: " + book_list.get(position).getBook_title() + "\n";
                info += "Sinopsis: " + book_list.get(position).getBook_description() + "\n";
                info += "Califcación: " + book_list.get(position).getBook_grade();

                Toast.makeText(BookActivity.this, info, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showBookList() {
        SQLiteDatabase db = con.getReadableDatabase();
        Book book = null;
        book_list = new ArrayList<Book>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.BOOK_TABLE, null);

        while (cursor.moveToNext()) {
            book = new Book();
            book.setBook_title(cursor.getString(1));
            book.setBook_description(cursor.getString(2));
            book.setBook_grade(cursor.getInt(3));

            book_list.add(book);
        }
        getList();
    }

    private void getList() {
        info_list = new ArrayList<String>();

        for (int i = 0; i < book_list.size(); i++) {
            info_list.add(book_list.get(i).getBook_title());
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(BookActivity.this, DeleteBookActivity.class);
        startActivity(intent);
    }
}
