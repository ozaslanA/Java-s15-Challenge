                    // YAZAR SINIFIMIZ
  //yazarın yazdığı kitapları yönetir. Ayrıca, yeni kitap ekleyebilir, yazdığı kitapları gösterebilir

package com.workintech.library.Model;

import com.workintech.library.Enum.Role;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {

    private List<Book> booksAuthored;  //Bu liste, Author'ın yazdığı kitapları tutacak.


    // Consturctorları yazdık
    public Author(int id, String name, Role role) {
        super(id, name, role);             // SUPER üst sınıftaki Constructorları çağırır.
        this.booksAuthored = new ArrayList<>();
    }


    // GETTER VE SETTER YAZILDI
    public List<Book> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(List<Book> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }




    /// YENİ KİTAP EKLER  VE  KİTABIN ADINI YAZDIRIR
    public void newBook(Book book){
        booksAuthored.add(book);
        System.out.println("Yazarımız Yeni Bir Kitap Ekledi:" + book.getTitle());
    }


    //Bu metodun görevi, Author'ın yazdığı kitapları listeleyerek göstermektir.





 // Kullanıcımız kim Burada Role enumu override ederiz ve kullanıcımızın AUTHOR OLDUĞUNU SÖYLERİZ.
    @Override
    public Role getRole() {
        return Role.AUTHOR;
    }


    @Override
    public String toString() {
        return "Author{" +
                "booksAuthored=" + booksAuthored +
                '}';
    }
}
