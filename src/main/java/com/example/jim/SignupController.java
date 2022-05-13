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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class SignupController implements SceneController{



    @FXML
    TextField FN;

    @FXML
    TextField LN;

    @FXML
    TextField E;

    @FXML
    PasswordField RP;

    @FXML
    PasswordField NP;

    @FXML
    TextField UN;

    @FXML
    TextField CC;

    @FXML
    Label errortext;


    public Stage stage;
    public Scene scene;
    public Parent root;


    public void signup(ActionEvent event) throws IOException, SQLException {
        String fn = FN.getText();
        String ln = LN.getText();
        String e = E.getText();
        String rp = RP.getText();
        String np = NP.getText();
        String un = UN.getText();
        String cc = CC.getText();

        ArrayList <String> all = new ArrayList<>() ;
        all.add(fn);
        all.add(ln);
        all.add(e);
        all.add(rp);
        all.add(np);
        all.add(un);
        all.add(cc);

        for (String s: all){
            if (s.length() == 0){
                System.out.println("here");
                errortext.setText("Please fill up all boxes");
                return;
            }
        }



        if(!TableUsersController.checkUniqueUsername(un)){
            errortext.setText("Username "+un+" already taken, please choose another one!");
            return;
        }





        else if(!Objects.equals(rp, np)){
            errortext.setText("Passwords do not match, please try again!");
            return;
        }



        if(!TableUsersController.insert(un, fn, ln, e, cc))
        {
            errortext.setText("Data could not be inserted in thye database");
            return;
        }
        PasswordController.insert(un, np);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu.fxml"));

        root = loader.load();

        System.out.println("logged in");

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
