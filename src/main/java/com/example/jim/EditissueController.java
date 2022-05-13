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

public class EditissueController implements SceneController{


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
    public void initialize() throws SQLException, ClassNotFoundException {
        System.out.println("Called");
        loadIssue();
    }


    public void loadIssue() throws SQLException, ClassNotFoundException {
            Issue issue = TableIssuesController.selectbysummary(IssuepageController.selectedissue);
            System.out.println("Init with " + issue.toString());

            S.setText(issue.summary);
            P.setText(issue.project);
            T.setValue(issue.type);
            F.setText(issue.inrelease);
            D.setText(issue.description);
            I.setValue(issue.importance);


    }


    public void submit(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Issue issue = TableIssuesController.selectbysummary(IssuepageController.selectedissue);
        issue.summary = S.getText();
        issue.project = P.getText();
        issue.type = T.getValue();
        issue.inrelease = F.getText();
        issue.description = D.getText();
        issue.importance = I.getValue();

        TableIssuesController.editIssue(issue);

        gotostage(event, "issuepage.fxml");

    }


    public void mainmenu(ActionEvent event) throws IOException {
        gotostage(event, "mainmenu.fxml");

    }


    public void gotostage(ActionEvent event, String stagestr) throws IOException {

    try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(stagestr));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (IOException e ){
        errortext.setText("There is a problem in connecting to the database.");
    }


    }



}
