package com.workintech.library.Model;

import com.workintech.library.Enum.Role;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {

    private List<Book> booksAuthored;  //Bu liste, Author'ın yazdığı kitapları tutacak.


    // Consturctorları yazdık
    public Author(int id, String name, Role role) {
        super(id, name, role);
        this.booksAuthored = new ArrayList<>();
    }


    // GETTER VE SETTER YAZILDI
    public List<Book> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(List<Book> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }




    /// YENİ KİTAP EKLEDİK  VE  KİTABIN ADINI YAZDIRDIK
    public void newBook(Book book){
        booksAuthored.add(book);
        System.out.println("Yeni Kitap Eklendi Eklenen Kitap:" + book.getTitle());
    }


    //Bu metodun görevi, Author'ın yazdığı kitapları listeleyerek göstermektir.

    public  void showBooks(){
        for(Book book : booksAuthored){
            System.out.println(" - " + book.getTitle());
        }
    }



    //u tür bir metodun kullanılması, programın ilerleyen aşamalarında, bir nesnenin hangi türden
    // olduğunu anlamak ve buna göre işlemler yapmak için f
    @Override
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public String toString() {
        return "Author{" +
                "booksAuthored=" + booksAuthored +
                '}';
    }
}
