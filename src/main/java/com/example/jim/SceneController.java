package com.example.jim;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public interface SceneController {
    public Stage stage = new Stage();
    public Scene scene = null;
    public Parent root = null;

    public void initialize() throws SQLException, ClassNotFoundException;
    public void gotostage(ActionEvent event, String stagestr) throws IOException;

}
