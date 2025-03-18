package Example;
import java.util.*;

// Singleton Pattern: Library class
class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("New book added: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Factory Method Pattern: Creating different types of books
abstract class Book {
    protected String title;
    protected String author;
    protected String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayInfo();
}

class PrintedBook extends Book {
    public PrintedBook(String title, String author, String genre) {
        super(title, author, genre);
    }

    @Override
    public void displayInfo() {
        System.out.println("Printed Book: " + title + " by " + author);
    }
}

class EBook extends Book {
    public EBook(String title, String author, String genre) {
        super(title, author, genre);
    }

    @Override
    public void displayInfo() {
        System.out.println("E-Book: " + title + " by " + author);
    }
}

class BookFactory {
    public static Book createBook(String type, String title, String author, String genre) {
        return switch (type.toLowerCase()) {
            case "printed" -> new PrintedBook(title, author, genre);
            case "ebook" -> new EBook(title, author, genre);
            default -> throw new IllegalArgumentException("Unknown book type");
        };
    }
}

// Strategy Pattern: Different search strategies
interface SearchStrategy {
    List<Book> search(List<Book> books, String query);
}

class SearchByTitle implements SearchStrategy {
    public List<Book> search(List<Book> books, String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query)) {
                result.add(book);
            }
        }
        return result;
    }
}

class SearchByAuthor implements SearchStrategy {
    public List<Book> search(List<Book> books, String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.author.equalsIgnoreCase(query)) {
                result.add(book);
            }
        }
        return result;
    }
}

class SearchByGenre implements SearchStrategy {
    public List<Book> search(List<Book> books, String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.genre.equalsIgnoreCase(query)) {
                result.add(book);
            }
        }
        return result;
    }
}

// Observer Pattern: Notification system
interface Observer {
    void update(String message);
}

class LibraryUser implements Observer {
    private String name;

    public LibraryUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}

// Decorator Pattern: Enhancing book borrowing
interface Borrowable {
    void borrow();
}

class BasicBorrowing implements Borrowable {
    @Override
    public void borrow() {
        System.out.println("Borrowing book with standard duration.");
    }
}

class ExtendedBorrowing extends BasicBorrowing {
    @Override
    public void borrow() {
        System.out.println("Borrowing book with extended duration.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        LibraryUser user1 = new LibraryUser("Alice");
        library.addObserver(user1);

        Book book1 = BookFactory.createBook("printed", "The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        Book book2 = BookFactory.createBook("ebook", "1984", "George Orwell", "Dystopian");
        library.addBook(book1);
        library.addBook(book2);

        SearchStrategy searchByTitle = new SearchByTitle();
        List<Book> foundBooks = searchByTitle.search(library.getBooks(), "1984");
        System.out.println("Search results: " + foundBooks.size());

        Borrowable standardBorrow = new BasicBorrowing();
        Borrowable extendedBorrow = new ExtendedBorrowing();
        standardBorrow.borrow();
        extendedBorrow.borrow();
    }
}