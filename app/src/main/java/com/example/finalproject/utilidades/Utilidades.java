package com.example.finalproject.utilidades;

public class Utilidades {

    // User table

    public static final String USER_TABLE = "user";
    public static final String USER_ID = "user_id";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL + " TEXT, " + NAME + " TEXT, " + PASSWORD + " TEXT, " + PHONE +" TEXT)";
/*
    // Book table

    public static final String BOOK_TABLE = "book";
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_TITLE = "book_title";
    public static final String BOOK_DESCRIPTION = "book_description";
    public static final String BOOK_GRADE = "book_grade";

    public static final String CREATE_BOOK_TABLE = "CREATE TABLE " + BOOK_TABLE + " (" + BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK_TITLE + " TEXT, " + BOOK_DESCRIPTION + " TEXT, " + BOOK_GRADE + " INTEGER," + USER_ID + " INTEGER)";
    // Videogame table

*/

    // Food table


}
