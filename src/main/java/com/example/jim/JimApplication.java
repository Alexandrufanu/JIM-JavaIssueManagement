package com.example.jim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class JimApplication extends Application {


    public Stage stage;
    public Scene scene;
    public Parent root;

    @Override
    public void start(Stage primaryStage) throws IOException {


        try {
            System.out.println(System.getProperty("user.dir"));
            File myObj = new File("config.txt");

            String username ="";
            String pass = "";
            Scanner reader = new Scanner(myObj);
            int i=2;
            while (reader.hasNextLine() && i!=0) {
                String data = reader.nextLine();
                if( i==2)
                    username = data;
                else
                    pass = data;

                i--;
            }
            reader.close();

            if(PasswordController.loginAttempt(username, pass)){
                System.out.println("logged in");
                Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

                Scene scene = new Scene(root);

                primaryStage.setScene(scene);
                primaryStage.show();

                primaryStage.setTitle("JIM");
            }
            else {
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

                Scene scene = new Scene(root);

                primaryStage.setScene(scene);
                primaryStage.show();

                primaryStage.setTitle("JIM");
            }

        } catch (FileNotFoundException e) {

            System.out.println("Credentias from config not valid");

            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();

            primaryStage.setTitle("JIM");
        }



    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        launch(args);
//        TableUsersController.insert("eetye","Er","RE","er","er");
//        System.out.println(TableUsersController.checkUniqueUsername("u"));
    }
}