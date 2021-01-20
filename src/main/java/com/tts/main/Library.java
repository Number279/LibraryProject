package com.tts.main;

import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    Book bk;
    String libraryBookTitle;
    private String location;
    private final ArrayList<Book> books;

    public Library(String location) {
        this.location = location;
        books = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static void printOpeningHours(){
        System.out.println("The Library is open from 9AM to 5PM.");
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void printAddress(){
        System.out.format("The library's address is %s", location);
    }

    public void borrowBook (String title) {
        for (Book book : books) {
            if(title.equals(book.getTitle())) {
                if (book.isBorrowed()) {
                    System.out.println("Sorry this book is borrowed.");
                } else {
                    book.returned();
                    System.out.println("This book has been returned.");
                }
            }
        }
    }

    public void returnBook (String title) {
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                book.returned();
                System.out.format("%s has been successfully returned", title);
            }

        }
    }

    public void printAvailableBooks() {
        if (books.isEmpty()){
            System.out.println("No books in catalog");
        }
        else {
            for (Book book : books)
                if(!book.isBorrowed()) System.out.println(book.getTitle());
        }
        System.out.println();
    }

}