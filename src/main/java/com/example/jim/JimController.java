package com.example.jim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JimController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void login(){

    }

    public int login(ActionEvent e ){

        System.out.println("logged in");

        return 1;
    }




}