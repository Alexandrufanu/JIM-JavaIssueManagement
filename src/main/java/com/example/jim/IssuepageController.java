package com.example.jim;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;

public class IssuepageController implements SceneController {


    @FXML
    Label label;

    @FXML
    TextField searchbar;

    @FXML
    ListView<String> listview;

    @FXML
    ChoiceBox<String> order;


//
//    @FXML
//    ScrollPane scrollPane;

    public Stage stage;
    public Scene scene;
    public Parent root;
    public static String selectedissue;

//    public IssuepageController() {
//        this.setLabel("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss ddddddddddddddddddddddddddddfd\nrfgr\n");
//
//
//
//    }

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        showall(null);

        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Selected item: " + newValue);
                selectedissue = newValue;
            }
        });

        listview.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                System.out.println( listview.getSelectionModel().getSelectedItem());
                selectedissue = listview.getSelectionModel().getSelectedItem();
                try {
                    this.setLabel(TableIssuesController.selectbysummary(selectedissue).toString());
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }});


        order.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Selected item: " + newValue);

                if (Objects.equals(newValue, "Importance ascending")){
                    sortByImp(0);
                } else if (Objects.equals(newValue, "Importance descending")){
                    sortByImp(0);
                }  else   if (Objects.equals(newValue, "Date ascending")){
                    sortByImp(0);
                }  else   if (Objects.equals(newValue, "Date descending")){
                    sortByImp(0);
                }

            }
        });
    }

    public void sortByImp(int direction){

//        half


    }


    public void selectitem(ActionEvent event) throws SQLException, ClassNotFoundException {

        this.setLabel(selectedissue);

        this.setLabel(TableIssuesController.selectbysummary(selectedissue).toString());


    }


    public void showall(ActionEvent event) throws SQLException, ClassNotFoundException {
        Issue.updateAllIssues();
        listview.getItems().clear();
        for (Issue issue: Issue.allIssues)
         listview.getItems().add(issue.summary);

    }

//    public void deleteitem(ActionEvent event){
//
//    }

    public void setLabel(String s ){
        label.setText(s);
        label.setMaxWidth(350);
        label.setWrapText(true);
    }

    public void search(ActionEvent event) throws SQLException, ClassNotFoundException {
        listview.getItems().add(searchbar.getText());
        Issue.updateAllIssues();

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

    public void addissue(ActionEvent event) throws IOException {
        gotostage(event, "addissue.fxml");
    }


    public void editissue(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editissue.fxml"));

//        EditissueController editissueController = new EditissueController();
//
//        editissueController.loadIssue();
//
//        loader.setController(editissueController);

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

//        loader.setController(editissueController);



//        EditissueController.loadIssue
    }


    public void deleteIssue(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        TableIssuesController.deleteIssue(TableIssuesController.selectbysummary(selectedissue));
        gotostage(event, "issuepage.fxml");


    }

}

class ThreadIssueSort implements Runnable {
    private final ArrayList<Issue> issues;

    public ThreadIssueSort(ArrayList<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public void run() {

        for (int i=0;i<issues.size();i++){
            for (int j=i;j<issues.size();j++){
                if(issues.get(i).id>issues.get(j).id)
                    Collections.swap(issues, i, j);

            }

        }

    }
}

