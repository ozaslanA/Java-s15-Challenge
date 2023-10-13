package com.workintech.library.Model;

import com.workintech.library.Enum.Genre;
import com.workintech.library.Enum.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(new ArrayList<>(), new HashSet<>(),new HashMap<>());
        Librarian librarian = new Librarian(1, "Gökhan Akın ", Role.ADMIN, "1111");


        Book book1 = new Book(1, "F. Scott Fitzgerald", "Küçük Prens", 19.99, "Available", 4, "23.09.2007", Genre.TRAGEDY_AND_DRAMA);
        Book book2 = new Book(2, "Ben Affect", "Süper Mario", 15.99, "Available", 5, "15.05.2005", Genre.HISTORICAL_FICTION);
        Book book3 = new Book(3, "Halil Sezai ", "Paramparça", 12.99, "Available", 3, "12.12.2010", Genre.SCI_FI);
        Book book4 = new Book(4, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 24.99, "Available", 6, "02.04.2001", Genre.FANTASY);
        Book book5 = new Book(5, "Agatha Christie", "Murder on the Orient Express", 10.99, "Available", 2, "18.08.1998", Genre.CRIME_AND_MYSTERY);
        Book book6 = new Book(6, "Jane Austen", "Pride and Prejudice", 14.99, "Available", 5, "30.03.2015", Genre.ROMANCE);
        Book book7 = new Book(7, "J.R.R. Tolkien", "The Hobbit", 18.99, "Available", 4, "07.11.2003", Genre.FANTASY);
        Book book8 = new Book(8, "Leo Tolstoy", "War and Peace", 29.99, "Available", 7, "10.07.2012", Genre.HISTORICAL_FICTION);
        Book book9 = new Book(9, "Stephen King", "The Shining", 16.99, "Available", 3, "05.09.2019", Genre.HORROR);

          // Sisteme yeni kitap eklenebilir.


        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);
        library.newBook(book4);
        library.newBook(book5);
        library.newBook(book6);
        library.newBook(book7);
        library.newBook(book8);
        library.newBook(book9);


        System.out.println("-----------------------");

       // Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir

        library.IdİleBulma(1);



        library.findBookByName("Süper Mario");



        //Sistemde var olan bir kitabın bilgileri güncellenebilir.
        Book bookToUpdate = new Book(3, "Halil Sezai", "Yeni Kitap", 14.99, "Available", 5, "01.01.2023", Genre.ADVENTURE);

        String newTitle = "Yeni Başlık";
        double newPrice = 19.99;


        //Sistemde var olan bir kitap silinebilir.

        Book bookToDelete = library.findBookByName("The Shining");
        library.deleteBook(bookToDelete);

        //Sistemde var olan bir kategorideki tüm kitaplar listelenebilir.

        library.showBooks();


    //Sistemde var olan bir yazarın tüm kitapları listelenebilir

        library.listBooksByAuthor("J.K. Rowling");

        Set<Book> OduncALınankıtap1 = new HashSet<>();
        Set<Book> OduncALınankıtap2 = new HashSet<>();
        Set<Book> OduncALınankıtap3 = new HashSet<>();

        Reader reader1 = new Reader(1, "Alice Norton", Role.USER, 5.0, OduncALınankıtap1, 5);



        librarian.KitapLimitKontrol(reader1, book1, library);









    }

    }

