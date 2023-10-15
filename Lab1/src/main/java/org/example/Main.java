package org.example;

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nPublication Year: " + publicationYear + "\n";
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}

class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Книга 1", "Автор 1", "1234567", 2020));
        library.addBook(new Book("Книга 2", "Автор 2", "2345678", 2019));
        library.addBook(new Book("Книга 3", "Автор 3", "3456789", 2021));

        System.out.println("Всі книги в бібліотеці:");
        library.displayBooks();


        String searchTitle = "Книга 2";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Знайдена книга за назвою \"" + searchTitle + "\":\n" + foundBook);
        } else {
            System.out.println("Книга за назвою \"" + searchTitle + "\" не знайдена.");
        }
        String isbnToDelete = "2345678";
        if (library.removeBookByISBN(isbnToDelete)) {
            System.out.println("Книга з ISBN " + isbnToDelete + " була видалена.");
        } else {
            System.out.println("Книга з ISBN " + isbnToDelete + " не знайдена в бібліотеці.");
        }
        System.out.println("Всі книги в бібліотеці після видалення:");
        library.displayBooks();

    }
}