package com.example.jim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddissueController implements SceneController{



    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    ChoiceBox<String> T;

    @FXML
    TextField F;

    @FXML
    TextArea D;

    @FXML
    TextField P;

    @FXML
    TextField S;

    @FXML
    ChoiceBox<String> I;

    @FXML
    Button submit;

    @FXML
    Label errortext;

    @FXML
    public void initialize(){

//        C = new ChoiceBox<String>();

////        ObservableList<String> availableChoices = C.getItems();

//        ObservableList<String> availableChoices = FXCollections.observableArrayList("apples", "oranges");
//        C.setItems(availableChoices);

//        C.getItems().add(0, "ItemObtainedProgrammatically");
    }

    public void gotostage(ActionEvent event, String stagestr) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(stagestr));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void mainmenu(ActionEvent event) throws IOException {
        gotostage(event, "mainmenu.fxml");
    }

    public void submit(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
//        gotostage(event, "issuepage.fxml");

        String f = F.getText();
        String d = D.getText();
        String p = P.getText();
        String s = S.getText();

        ArrayList<String> all = new ArrayList<>() ;
        all.add(f);
        all.add(d);
        all.add(p);
        all.add(s);

        for (String ss: all){
            if (ss.length() == 0){
                System.out.println("here");
                errortext.setText("Please fill up all boxes");
                return;
            }
        }

        TableIssuesController.insert(Issue.getnextid(), s, p, T.getSelectionModel().getSelectedItem(),  f, d, I.getSelectionModel().getSelectedItem());

        //System.out.println(Issue.getnextid()+ s+ p+ C.getSelectionModel().getSelectedItem()+  f+ d+ T.getSelectionModel().getSelectedItem());

        gotostage(event, "issuepage.fxml");

        //System.out.println(Issue.getnextid());

    }
}
