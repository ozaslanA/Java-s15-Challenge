                                        // BOOK SINIFI
                                   //     Book sınıfı bir kitabın özelliklerini temsil eder.


package com.workintech.library.Model;
import com.workintech.library.Enum.Genre;

import java.util.Objects;

public class Book {

    private int bookID;
    private String author;
    private String title;
    private double price;
    private String status;
    private int  edition;
    private  String  dateOfPurchase;
    private Genre genre;   /// Genre enum kullanılacak türler sabit olacağına karar verdim.

    public Book(int bookID, String author, String title, double price, String status, int edition, String dateOfPurchase, Genre genre) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.genre = genre;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }



                    // equals sadece ID için yazıldı çünkü bizi eşşsiz kılacak ID olur asla aynı ID çakışmaz
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", author='" + author + '\'' +
                ", name='" + title + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", genre=" + genre +
                '}';
    }

}
