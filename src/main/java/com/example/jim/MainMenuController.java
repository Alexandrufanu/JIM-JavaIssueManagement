package com.example.jim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenuController implements SceneController{

    @FXML
    Label welcomeLabel;

    public Stage stage;
    public Scene scene;
    public Parent root;


    public void greet(String name){
        welcomeLabel.setText("Welcome back " + name+" !");

    }

    public void signout(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void issuepage(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("issuepage.fxml"));

        root = loader.load();

        IssuepageController issuepageController = loader.getController();


//        issuepageController.setLabel("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss ddddddddddddddddddddddddddddfd\nrfgr\n");

//        issuepageController.setLabel("This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}This is a very long single line string which might be used to display assertion messages or some text.\n It has much more than 80 symbols so it would take more then one screen in your text editor to view it.\n Hello ${world}");
        issuepageController.setLabel("Select a issue and it will be displayed here");

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
//        issuepageController.scrollPane.setFitToHeight(true);
//        issuepageController.scrollPane.setFitToWidth(true);
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
