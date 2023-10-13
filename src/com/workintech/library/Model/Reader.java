package com.workintech.library.Model;

import com.workintech.library.Enum.Role;

import java.util.Set;

public class Reader extends Person {
    private double billAmount;          // toplam ücreti tutar
    private Set<Book> borrowedBooks;  //Ödünç aldığı kitapları liste şeklinde tutar //Set ile yazma sebebim dublicate data tutmak istemiyorum
    private int bookLimit;            ////Ödünç Alabileceği maks limittir.




    // üst sınıf yani Person sınıfından id,name ve kendi özelliklerini alan  bir constructor olusturuldu.
    public Reader(int id, String name, Role role, double billAmount, Set<Book> borrowedBooks,int bookLimit) {
        super(id, name, role);
        this.billAmount = billAmount;
        this.borrowedBooks = borrowedBooks;
        this.bookLimit=bookLimit;


    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Set<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    // İlk olarak, book parametresi olarak gelen kitaptan fiyatını alıyoruz.
    public void satinAlinanKitap(Book book){
        double bookPrice =book.getPrice();


        if(bookPrice <=0){
            System.out.println(book.getTitle()+"Adlı bu kitabı almaya " + getName()+" " +"İsimli Kişinin Parası yetmiyor Kitabı alamaz");
            return;
        }

        if (getBillAmount() >= bookPrice) {  //Eğer kullanıcının bakiyesi, kitabın fiyatından büyük veya eşitse:
        setBillAmount(getBillAmount() - bookPrice);  //Kullanıcının bakiyesinden kitabın fiyatını çıkarıyoruz.

            System.out.println((getName())+" " + "adlı kişi tarafından"+ book.getTitle() + " Satın alındı");

         }else{
            System.out.println(getName()+" adlı kişi tarafından" +book.getTitle()+" Satın alınamadı" );


    }
    }


    // Ödünç alacağın kitap eğer kitap limitinden küçükse alabilirsin eğer küçükse git ve borrowedBooks a ekle
    //ve durumu "Eklendi" olarak güncelle değilse zaten uyarı ver
        public void borrowBooks(Book book){
        if(borrowedBooks.size() <bookLimit){
            borrowedBooks.add(book);
            book.setStatus("Eklendi");
            System.out.println( getName() +" "+ "Tarafından " + book.getTitle() + "Adlı kitap Ödünç Alındı");

        }else{
            System.out.println(getName() + " " + " tarafından kitap alım sınırına ulaşıldı daha fazla alamaz uğraşmasın ");
        }
        }



                    // İADE DURUMU

    //contains metoduyla iade edilen kitap alınan kitapmı diye bakıyoruz eğer eşleşiyorsa siliyoruz
    //eğer bizim borrowedBooks'da yoksa bu kitap işlem başarısız
        public  void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.setStatus("durum güncelleniyor");
            System.out.println(getName()+ " " + "tarafından iade edildi ve listeden silindi");
        }else {
            System.out.println("İşlem Başarısız bu Kitap bize ait değilki "
            );
        }
        }



        // isEmpty ile okuyucunun ödünç aldığı kitapların bulunduğu  borrowedBooks set'inin boş olup olmadığını kontrol ederiz.

    public void showBook() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(getName() + " " +"adlı kişi herhangi bir kitabı ödünç almamıştır.");
            return;
        }


        // Bu metodun amacı, bir okuyucunun ödünç aldığı kitapları konsola güzel bir şekilde yazdırmaktır.

        System.out.println(getName() + "Adlı kişinin aldığı Kitapların listesi burada:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }



    @Override
    public Role getRole() {
        return super.getRole();
    }
    @Override
    public String toString() {
        return "Author{" +
                "booksAuthored=" + borrowedBooks +
                '}';
    }
}

