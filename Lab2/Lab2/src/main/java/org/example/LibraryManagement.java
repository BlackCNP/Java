package org.example;

import java.util.ArrayList;
import java.util.HashMap;

class Item {
    private String title;
    private String type;


    public Item(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Назва: " + title + "\nТип: " + type + "\n";
    }
}

class Book extends Item {
    private String author;
    private String isbn;
    private int publicationYear;
    private Client borrowedBy;

    public Book(String title, String author, String isbn, int publicationYear) {
        super(title, "Книга");
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.borrowedBy = null;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setBorrowedBy(Client client) {
        this.borrowedBy = client;
    }

    @Override
    public String toString() {
        if (borrowedBy != null) {
            return super.toString() + "Автор: " + author + "\nISBN: " + isbn + "\nРік публікації: " + publicationYear + "\nВзята клієнтом: " + borrowedBy.getName() + "\n";
        } else {
            return super.toString() + "Автор: " + author + "\nISBN: " + isbn + "\nРік публікації: " + publicationYear + "\n";
        }
    }
}

class DVD extends Item {
    private String director;
    private int releaseYear;
    private Client borrowedBy;

    public DVD(String title, String director, int releaseYear) {
        super(title, "DVD");
        this.director = director;
        this.releaseYear = releaseYear;
        this.borrowedBy = null;
    }

    public void setBorrowedBy(Client client) {
        this.borrowedBy = client;
    }

    @Override
    public String toString() {
        if (borrowedBy != null) {
            return super.toString() + "Режисер: " + director + "\nРік випуску: " + releaseYear + "\nВзято клієнтом: " + borrowedBy.getName() + "\n";
        } else {
            return super.toString() + "Режисер: " + director + "\nРік випуску: " + releaseYear + "\n";
        }
    }
}

class Client {
    private String name;
    private ArrayList<Item> borrowedItems;

    public Client(String name) {
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowItem(Item item) {
        borrowedItems.add(item);
        if (item instanceof Book) {
            ((Book) item).setBorrowedBy(this);
        } else if (item instanceof DVD) {
            ((DVD) item).setBorrowedBy(this);
        }
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
        if (item instanceof Book) {
            ((Book) item).setBorrowedBy(null);
        } else if (item instanceof DVD) {
            ((DVD) item).setBorrowedBy(null);
        }
    }

    public ArrayList<Item> getBorrowedItems() {
        return borrowedItems;
    }


}


class LibraryManager {

    private ArrayList<Item> availableItems;
    private ArrayList<Item> borrowedItems;
    private HashMap<String, Client> clients;
    private ArrayList<Item> returnedItems;

    public LibraryManager() {
        this.availableItems = new ArrayList<>();
        this.borrowedItems = new ArrayList<>();
        this.clients = new HashMap<>();
        this.returnedItems = new ArrayList<>();
    }


    public void addItem(Item item) {
        availableItems.add(item);
    }



    public void registerClient(Client client) {
        clients.put(client.getName(), client);
    }

    public void lendItem(Item item, Client client) {
        if (availableItems.contains(item)) {
            availableItems.remove(item);
            borrowedItems.add(item);
            client.borrowItem(item);
        }
    }

    public void returnItem(Item item, Client client) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            availableItems.add(item);
            client.returnItem(item);
            returnedItems.add(item);
        }
    }
    public void displayReturnedItems() {
        System.out.println("Повернуті елементи:");
        for (Item item : returnedItems) {
            System.out.println(item);
        }
    }

    public void displayAvailableItems() {
        System.out.println("Доступні елементи:");
        for (Item item : availableItems) {
            System.out.println(item);
        }
    }
    public void deleteBookByISBN(String isbn) {
        for (Item item : availableItems) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getIsbn().equals(isbn)) {
                    availableItems.remove(item);
                    System.out.println("Книга з ISBN " + isbn + " була успішно видалена.");
                    return;
                }
            }
        }
        System.out.println("Книга з ISBN " + isbn + " не знайдена.");
    }

    public void displayBorrowedItems() {
        System.out.println("Позичені елементи:");
        for (Item item : borrowedItems) {
            System.out.println(item);
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        //додати книги
        Book book1 = new Book("Книга1", "Автор1", "978-3-16-148410-0", 1967);
        Book book2 = new Book("Книга2", "Автор2", "978-3-16-148410-1", 1697);
        DVD dvd1 = new DVD("DVD1", "Режисер1", 1975);

        libraryManager.addItem(book1);
        libraryManager.addItem(book2);
        libraryManager.addItem(dvd1);

        Client client1 = new Client("Іван Іванов");
        Client client2 = new Client("Марія Петренко");
        System.out.println("База даних");
        libraryManager.registerClient(client1);
        libraryManager.registerClient(client2);
        libraryManager.deleteBookByISBN("978-3-16-148410-1");
        libraryManager.displayAvailableItems();

        libraryManager.lendItem(book1, client1);
        libraryManager.lendItem(book2, client2);
        //libraryManager.lendItem(dvd1, client1);


        // доступні libraryManager.displayAvailableItems();
        libraryManager.displayBorrowedItems();
        //повернути книги або двд
        libraryManager.returnItem(book1, client1);
        /*libraryManager.returnItem(book1, client1);
        libraryManager.returnItem(book1, client1);
        libraryManager.returnItem(book1, client1);*/
        libraryManager.displayReturnedItems();


        //відобразити доступні та взяті
        libraryManager.displayAvailableItems();
        libraryManager.displayBorrowedItems();
    }
}
