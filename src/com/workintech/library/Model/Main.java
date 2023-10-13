package com.workintech.library.Model;

import com.workintech.library.Enum.Genre;
import com.workintech.library.Enum.Role;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader(3, "John Doe", Role.USER, 100.0, new HashSet<>(), 2);

        // Kitap oluştur
        Book book = new Book(1, "Jane Author", "Awesome Book", 0, "Available", "1st Edition", "2023-10-12", Genre.DÖVÜŞ);

        Book book2 = new Book(2, "Apo Author", "Asame Book", 29.99, "Available", "1st Edition", "2023-10-12", Genre.DÖVÜŞ);

        reader.borrowBooks(book);



    }

    }

