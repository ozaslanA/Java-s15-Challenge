                      // KÜTÜPHANE SINIFIMIZ
                     //Bu sınıf, kütüphane işlemlerini gerçekleştirmek için kullanılabilir
                   // ve kullanıcıya çeşitli bilgileri konsola yazdırarak işlemlerin durumu hakkında bilgi verir.
package com.workintech.library.Model;
import com.workintech.library.Enum.Genre;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

                      public class Library {
    private List<Book>books;                  // Kütüphanedeki tüm kitapların listesini tutar.
    private Set<Reader>readers;              //Aynı Okuyucuyu birden fazla kez tutmak istemiyoruz.O yüzden Set
    private Map<Book,Reader> borrowedBooks;  // Book nesnesini key,Reader nesnesini değer olarak tutacağım bu sayede
                                             // - kitap ödünç alındığında hızlıca kim tarafından alındığını bulurum
    public Library(List<Book> books, Set<Reader> readers, Map<Book, Reader> oduncBooks) {
        this.books = books;
        this.readers = readers;
        this.borrowedBooks = borrowedBooks;
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
        return borrowedBooks;
    }

    public void setOduncBooks(Map<Book, Reader> oduncBooks) {
        this.borrowedBooks = oduncBooks;
    }



    // Kütüphaneye yeni bir kitap eklemek için add metodunu kullandık
    public void newBook(Book book){
        books.add(book);
        System.out.println("Kitap eklendi eklenen kitap bilgileri : \n " + book);
    }


    // Kütüphaneden Kitap Silmek için remove metodu kullandık.
    public void  deleteBook(Book bookToDelete){
        if(books.contains(bookToDelete)){
        books.remove(bookToDelete);
        System.out.println( bookToDelete.getTitle() +""+  "Adlı Kitap Silindi");
    }else {
            System.out.println("Kitap bulunamadı.");
        }

    }

                // ID İLE BULMAK İSTERSEK
public Book IdİleBulma(int bookID){
        for(Book book: books){
            if(book.getBookID() == bookID){
                System.out.println("Kitap Bulundu " + book);
                return book;
            }
        }
        return null;
}
      // İSİM İLE BULMAK İSTERSEK

    public Book findBookByName(String bookName) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(bookName.toLowerCase())) {
                System.out.println("Kitap Bulundu Tüm bilgileri:" + book);
                return book;
            }
        }
        return null;
    }






    //Bu metodun amacı, belirli bir yazarın yazdığı kitapları listelemektir.

    public List<Book> listBooksByAuthor(String authorName) {
        List<Book> booksByAuthor = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());

        if (booksByAuthor.isEmpty()) {
            System.out.println(authorName + " isimli yazarın kitapları bulunmuyor.");
        } else {
            System.out.println(authorName + " isimli yazarın kitapları:");
            for (Book book : booksByAuthor) {
                System.out.println("- " + book.getTitle());
            }
        }

        return booksByAuthor;
    }
        //// BİLGİLERİ GÜNCELLEME KISMI

        public void updateBook(Book bookToUpdate, String newTitle , double newPrice){
        for(Book book : books){
            if(book.equals(bookToUpdate)){
                book.setTitle(newTitle);
                book.setPrice(newPrice);
               System.out.println("Kitap Güncellendi" + book);
                return;
            }
        }
        }









    // bir kitabı okuyucuya ödünç vereceğiz ilk önce containskey ile kitap mevcutmu bakarız
    // mevcutsa  "Kitap Zaten ödünç alınmış" yazarız değilse kitabı put ile listeye ekleriz
    // borrowBooks çağırıp kitabı ödünç verdik okuyucuya
    public  void oduncVer(Reader reader,Book book ){  // bir kitabı bir okuyucaya ödünç vermek için
        if(borrowedBooks.containsKey(book)){
            System.out.println("Kitap Zaten ödünç alınmış" + borrowedBooks.get(book).getName());
        }else {
            borrowedBooks.put(book, reader); // eklemek için maplerde put kullandık
            reader.borrowBooks(book);
            System.out.println(book.getTitle() + " isimli kitap " + reader.getName() + " Adlı okuyucu tarafından ödünç alındı");
        } }



    // bir kitabı okuyucuya geri alacağız ilk önce containskey ile kitap bizde mevcutmu bakarız
    // Bir kitabın ödünç alınmışsa geri alır.
    public  void kitabiGeriAl( Book book){
        if(borrowedBooks.containsKey(book)) {
    Reader reader =borrowedBooks.get(book);   //ifadesi kullanılarak, ödünç alınan kitaba ait Reader nesnesi alınır ve reader adlı değişkene atanır.
            borrowedBooks.remove(book);
      reader.returnBook(book);  // ifadesi ile, kitabın iadesini yöneten returnBook metodunu çağırarak kitap iade edilir.
      System.out.println(book.getTitle() + "Kitap Geri İade Edildi " + reader.getName()+ " " + "Adlı Kişi tarafından");
        }else{
            System.out.println("İşlemi gerçekleştiremiyoruz ");
        }
    }



    // Kütüphanedeki kitapları listeler.

    public void showBooks(){
        System.out.println("Kütüphanedeki Kitaplar ");
        for(Book book : books){
            System.out.println(" - " + book.getTitle());
        }

    }


}
