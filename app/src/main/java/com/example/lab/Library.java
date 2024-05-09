package com.example.lab;

import java.util.List;

public class Library {
    private Genre genre;

    public Library() {
        genre = new Genre();
    }

    public void addBook(String title, String author, String genreName, int units) {
        Book book = new Book(title, author);
        genre.addBook(book, genreName);
    }

    public void borrowBook(String title, int units, String genreName) {
        List<Book> books = genre.showBookInfoByGenre(genreName);
        for (Book book : books) {
            if (book.getTitle().equals(title)) {

                break;
            }
        }
    }

    public List<Book> showBooksByGenre(String genreName) {
        return genre.showBookInfoByGenre(genreName);
    }
}
