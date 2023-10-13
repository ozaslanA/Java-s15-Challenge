package com.workintech.library.Model;

import com.workintech.library.Enum.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private List<Book>books;
    private Set<Reader>readers;   //Aynı Okuyucuyu birden fazla kez tutmak istemiyoruz.O yüzden Set
    private Map<Book,Reader> oduncBooks;  // Book nesnesini key,Reader nesnesini değer olarak tutacağım bu sayede
                                         // - kitap ödünç alındığında hızlıca kim tarafından alındığını bulurum
    public Library(List<Book> books, Set<Reader> readers, Map<Book, Reader> oduncBooks) {
        this.books = books;
        this.readers = readers;
        this.oduncBooks = oduncBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    public Map<Book, Reader> getOduncBooks() {
        return oduncBooks;
    }

    public void setOduncBooks(Map<Book, Reader> oduncBooks) {
        this.oduncBooks = oduncBooks;
    }

    // Kütüphaneye yeni bir kitap eklemek için add metodunu kullandık
    public void newBook(Book book){
        books.add(book);
    }
    // Kütüphaneden Kitap Silmek için remove metodu kullandık.
    public void  deleteBook(Book book){
        books.remove(book);
    }
  // bookInCategory adında yeni arraylist oluşturduk sonra for ile Genre deki kategoriler gezildi ve
  //kitabın kategorisi Genredeki belirtilen kategoriyle eşleşiyorsa o kitap "bookInCategory" listesine eklenir.
    public List<Book> listBooksCategory(Genre category){
        List<Book> bookInCategory =new ArrayList<>();
        for(Book book:books){
            if(book.getGenre() == category){
                bookInCategory.add(book);
            }
        }
        return bookInCategory;
    }

    //
    //



}
