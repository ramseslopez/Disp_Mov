package com.example.finalproject.entidades;

import java.io.Serializable;

public class Book implements Serializable {

    private String book_title;
    private int book_grade;
    private String book_description;
    private int book_user_id;

    public Book() {}

    public Book(String book_title, int book_grade, String book_description, int book_user_id) {
        this.book_title = book_title;
        this.book_grade = book_grade;
        this.book_description = book_description;
        this.book_user_id = book_user_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public int getBook_grade() {
        return book_grade;
    }

    public void setBook_grade(int book_grade) {
        this.book_grade = book_grade;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public int getBook_userId() {
        return book_user_id;
    }

    public void setBook_user_id(int book_user_id) {
        this.book_user_id = book_user_id;
    }
}
