package com.example.finalproject.entidades;

import java.io.Serializable;

public class Game implements Serializable {

    private String game_title;
    private int game_grade;
    private String game_description;
    private int game_user_id;

    public Game() {}

    public Game(String game_title, int game_grade, String game_description, int game_user_id) {
        this.game_title = game_title;
        this.game_grade = game_grade;
        this.game_description = game_description;
        this.game_user_id = game_user_id;
    }


    public String getGame_title() {
        return game_title;
    }

    public void setGame_title(String game_title) {
        this.game_title = game_title;
    }

    public int getGame_grade() {
        return game_grade;
    }

    public void setGame_grade(int game_grade) {
        this.game_grade = game_grade;
    }

    public String getGame_description() {
        return game_description;
    }

    public void setGame_description(String game_description) {
        this.game_description = game_description;
    }

    public int getGame_user_id() {
        return game_user_id;
    }

    public void setGame_user_id(int game_iser_id) {
        this.game_user_id = game_iser_id;
    }

}
