package org.example;

import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private int pages;


    public Book(){
        this(" ", " ", 0, " ", " ",0);
    }

    public Book(String title, String author, int year,
                String publisher, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }



    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть назву книги: ");
        title = sc.nextLine();

        System.out.print("Введіть ПІБ автора: ");
        author = sc.nextLine();

        System.out.print("Введіть рік випуску: ");
        year = sc.nextInt();
        sc.nextLine();

        System.out.print("Введіть назву видавництва: ");
        publisher = sc.nextLine();

        System.out.print("Введіть жанр книги: ");
        genre = sc.nextLine();

        System.out.print("Введіть кількість сторінок: ");
        pages = sc.nextInt();
    }



    // Getter-и
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    // Setter-и
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    public void printInfo() {
        System.out.println("\nІнформація про книгу:");
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Рік випуску: " + year);
        System.out.println("Видавництво: " + publisher);
        System.out.println("Жанр: " + genre);
        System.out.println("Кількість сторінок: " + pages);
    }
}