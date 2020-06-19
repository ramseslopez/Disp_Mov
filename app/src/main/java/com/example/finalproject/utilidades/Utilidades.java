package com.example.finalproject.utilidades;

public class Utilidades {

    // User table

    public static final String USER_TABLE = "user";
    public static final String USER_ID = "user_id";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " (" +
            USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            EMAIL + " TEXT, " + NAME + " TEXT, " +
            PASSWORD + " TEXT, " + PHONE +" TEXT" +
            ")";

    public static final String DELETE_USER_TABLE = "DROP IF EXISTS " + USER_TABLE;

    // Book table

    public static final String BOOK_TABLE = "book";
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_TITLE = "book_title";
    public static final String BOOK_DESCRIPTION = "book_description";
    public static final String BOOK_GRADE = "book_grade";
    public static final String BOOK_USER_ID = "book_user_id";

    public static final String CREATE_BOOK_TABLE = "CREATE TABLE " + BOOK_TABLE + " (" +
            BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BOOK_TITLE + " TEXT, " +
            BOOK_DESCRIPTION + " TEXT, " +
            BOOK_GRADE + " INTEGER, " +
            BOOK_USER_ID + " INTEGER, " +
            "FOREIGN KEY (" + BOOK_USER_ID + ") REFERENCES " + USER_TABLE + " (" + USER_ID + ") " +
            "ON DELETE CASCADE " +
            "ON UPDATE CASCADE " +
            ")";

    public static final String DELETE_BOOK_TABLE =  "DROP IF EXISTS " + BOOK_TABLE;

    // Videogame table

    public static final String GAME_TABLE = "game";
    public static final String GAME_ID = "game_id";
    public static final String GAME_TITLE = "fame_title";
    public static final String GAME_DESCRIPTION = "game_description";
    public static final String GAME_GRADE = "game_grade";
    public static final String GAME_USER_ID = "game_user_id";

    public static final String CREATE_GAME_TABLE = "CREATE TABLE " + GAME_TABLE + " (" +
            GAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GAME_TITLE + " TEXT, " +
            GAME_DESCRIPTION + " TEXT, " +
            GAME_GRADE + " INTEGER, " +
            GAME_USER_ID + " INTEGER, " +
            "FOREIGN KEY (" + GAME_USER_ID + ") REFERENCES " + USER_TABLE + " (" + USER_ID + ") " +
            "ON DELETE CASCADE " +
            "ON UPDATE CASCADE " +
            ")";

    public static final String DELETE_GAME_TABLE = "DROP IF EXISTS " + GAME_ID;





}
