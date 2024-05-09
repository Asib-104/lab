package com.example.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void testGetTitle() {
        Book book = new Book("Title", "Author");
        assertEquals("Title", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        Book book = new Book("Title", "Author");
        assertEquals("Author", book.getAuthor());
    }
}