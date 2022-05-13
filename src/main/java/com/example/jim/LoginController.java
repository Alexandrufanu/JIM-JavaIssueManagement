package com.example.jim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController implements SceneController{

    @FXML
    TextField usr_txtField;

    @FXML
    PasswordField usr_passField;

    @FXML
    Label login_error;

    public Stage stage;
    public Scene scene;
    public Parent root;

    public void switchToIssue(){

    }

    public void login(ActionEvent event) throws IOException {

        String userName = usr_txtField.getText();
        String pass = usr_passField.getText();

//        if (pass.length()<5){
//            login_error.setText("PASSWORD too short (5 characters minimum)");
//            return;
//        }




//        String stringText = "";
//        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText);

        if (!PasswordController.loginAttempt(userName, pass))
        {
            login_error.setText("Password and username do not match");
        }
        else {
            System.out.println("logged in");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu.fxml"));

            root = loader.load();

            MainMenuController mainMenuController = loader.getController();

            mainMenuController.greet(userName);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void signup(ActionEvent event)throws IOException{


            FXMLLoader loader = new FXMLLoader(getClass().getResource("eula.fxml"));

            root = loader.load();

//    MainMenuController mainMenuController = loader.getController();
//
//        mainMenuController.;

            System.out.println("logged in");

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


    }

    @Override
    public void initialize() {

    }

    @Override
    public void gotostage(ActionEvent event, String stagestr) {

    }
}
