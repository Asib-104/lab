package com.example.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook("Book1", "Author1", "mystery", 5);
        library.addBook("Book2", "Author2", "fantasy", 3);
    }

    @Test
    public void testAddBook() {
        List<Book> mysteryBooks = library.showBooksByGenre("mystery");
        assertEquals(1, mysteryBooks.size());
        assertEquals("Book1", mysteryBooks.get(0).getTitle());

        List<Book> fantasyBooks = library.showBooksByGenre("fantasy");
        assertEquals(1, fantasyBooks.size());
        assertEquals("Book2", fantasyBooks.get(0).getTitle());
    }

    @Test
    public void testBorrowBook() {
        library.borrowBook("Book1", 3, "mystery");
        List<Book> mysteryBooks = library.showBooksByGenre("mystery");
        assertEquals(1, mysteryBooks.size());
        assertEquals(2, mysteryBooks.get(0).getUnits()); // Assuming units are correctly deducted

        // Test borrowing more units than available
        library.borrowBook("Book1", 10, "mystery");
        assertEquals(2, mysteryBooks.get(0).getUnits()); // Units should remain unchanged
    }

    @Test
    public void testShowBooksByGenre() {
        List<Book> thrillerBooks = library.showBooksByGenre("thriller");
        assertTrue(thrillerBooks.isEmpty()); // No books added for thriller genre
    }
}