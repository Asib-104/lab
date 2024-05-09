package com.example.lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Info {
    private int units;
    private String genreName;

    public Info(int units, String genreName) {
        this.units = units;
        this.genreName = genreName;
    }

    public int getUnits() {
        return units;
    }

    public String getGenreName() {
        return genreName;
    }
}

class Genre {
    private Map<String, List<Book>> booksByGenre;

    public Genre() {
        booksByGenre = new HashMap<>();
        booksByGenre.put("mystery", new ArrayList<>());
        booksByGenre.put("fantasy", new ArrayList<>());
        booksByGenre.put("thriller", new ArrayList<>());
    }

    public void addBook(Book book, String genre) {
        booksByGenre.get(genre).add(book);
    }

    public List<Book> showBookInfoByGenre(String genre) {
        return booksByGenre.getOrDefault(genre, new ArrayList<>());
    }
}



public class MainActivity extends AppCompatActivity {


    private Button addBookButton;
    private Button borrowBookButton;
    private Button showBooksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBookButton = findViewById(R.id.addBookButton);
        borrowBookButton = findViewById(R.id.borrowBookButton);
        showBooksButton = findViewById(R.id.showBooksButton);

        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddBookActivity();
            }
        });

        borrowBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBorrowBookActivity();
            }
        });

        showBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowBooksActivity();
            }
        });
    }

    private void openAddBookActivity() {
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }

    private void openBorrowBookActivity() {
        Intent intent = new Intent(this, BorrowBookActivity.class);
        startActivity(intent);
    }

    private void openShowBooksActivity() {
        Intent intent = new Intent(this, ShowBooksActivity.class);
        startActivity(intent);
    }
}