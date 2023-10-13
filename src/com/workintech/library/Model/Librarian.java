package com.workintech.library.Model;

import com.workintech.library.Enum.Role;

import java.util.List;

public class Librarian extends Person{
    private String password;                                //Kütüphaneci için bir şifre alanı.

    public Librarian(int id, String name, Role role, String password) {
        super(id, name, role);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


            ///Bu metodun amacı, kütüphanedeki kitapları başlık (title) üzerinden aramaktır

    public Book searchBook(String title , Library library){
        List<Book> books =library.getBooks();
        for (Book book:books){
            if(book.getTitle().toLowerCase().equals(title.toLowerCase())){
                System.out.println("Kitap Bulundu:" + searchBook( title, library));
                return book;

            }
        }
        return null;
    }


            // Kullanıcı null mı User mı ona bak
    public boolean  dogrulaUye(Reader reader){
        return reader !=null && reader.getRole() ==Role.USER;
    }

    public void KitapLimitKontrol(Reader reader, Book book,Library library){
        if(reader == null || reader.getRole() !=Role.USER){
            System.out.println("Okuyucu Değildir ");
            return;
        }

        reader.borrowBooks(book);
        library.oduncVer(reader,book);
        System.out.println( book.getTitle() + " Adlı Kitap " + reader.getName() + " Adlı Kişiye Ödünç verilmiştir.");
    }

    public void faturaOlustur(Reader reader,double miktar){
        reader.setBillAmount(reader.getBillAmount()+ miktar);
        System.out.println(reader.getName() + "" + "Adlı kişinin ödeyeceği Tutar" + miktar +"tl"  );

    }
    public void iadeEt( Book book , Reader reader, Library library){
        if(book.getStatus().equals("Ödünç Alınmış") && reader.getBorrowedBooks().contains(book)){
            reader.returnBook(book);
            library.kitabiGeriAl(book);
            System.out.println( book.getTitle()+ "Adlı kitap " + " "+ reader.getName() + " " + "adlı kişiden geri alındı");
        }else {
            System.out.println("İşlem başarısız geri alınamaz");
        }
    }
    @Override
    public Role getRole () {
        return Role.ADMIN;
    }
}
