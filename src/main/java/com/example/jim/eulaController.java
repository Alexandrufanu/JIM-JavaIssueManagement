package com.example.jim;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class eulaController implements SceneController{
    public Stage stage;
    public Scene scene;
    public Parent root;

    public void signup(ActionEvent event)throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));

        root = loader.load();

        System.out.println("logged in");

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void signout(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize() throws SQLException, ClassNotFoundException {

    }

    @Override
    public void gotostage(ActionEvent event, String stagestr) throws IOException {

    }
}
