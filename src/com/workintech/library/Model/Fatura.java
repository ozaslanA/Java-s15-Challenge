                            // FATURA SINIFIMIZ
                            //

package com.workintech.library.Model;
import java.time.LocalDate;

public class Fatura {
    private static int FaturaCounter = 1;  // static olusturduk cunku tüm sınıflar arasında ortak olacak benzersiz bir numara olacak her yeni faturada sayac artacak
    private  int faturaID;
    private LocalDate verilisTarihi;
    private double AlınanKitapSayisi;
    private Reader müşteri;

    public Fatura(int faturaID, LocalDate verilisTarihi, double alınanKitapSayisi, Reader müşteri) {
        this.faturaID = faturaID;
        this.verilisTarihi = verilisTarihi;
        AlınanKitapSayisi = alınanKitapSayisi;
        this.müşteri = müşteri;
    }

    public static int getFaturaCounter() {
        return FaturaCounter;
    }

    public static void setFaturaCounter(int faturaCounter) {
        FaturaCounter = faturaCounter;
    }

    public int getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(int faturaID) {
        this.faturaID = faturaID;
    }

    public LocalDate getVerilisTarihi() {
        return verilisTarihi;
    }

    public void setVerilisTarihi(LocalDate verilisTarihi) {
        this.verilisTarihi = verilisTarihi;
    }

    public double getAlınanKitapSayisi() {
        return AlınanKitapSayisi;
    }

    public void setAlınanKitapSayisi(double alınanKitapSayisi) {
        AlınanKitapSayisi = alınanKitapSayisi;
    }

    public Reader getMüşteri() {
        return müşteri;
    }

    public void setMüşteri(Reader müşteri) {
        this.müşteri = müşteri;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "faturaID=" + faturaID +
                ", verilisTarihi=" + verilisTarihi +
                ", AlınanKitapSayisi=" + AlınanKitapSayisi +
                ", müşteri=" + müşteri +
                '}';
    }
}
