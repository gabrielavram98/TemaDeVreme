package ro.mta.se.lab;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
public class Main extends Application {


    public static void main(String[] args)  {
             launch(args);
    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(this.getClass().getResource("/view/weather.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
