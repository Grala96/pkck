package app;

import data.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {

    public Database database;

    @Override
    public void start(Stage primaryStage) throws Exception{


//        URL res = getClass().getClassLoader().getResource("personDataBase.xml");
//        File file = Paths.get(res.toURI()).toFile();
//        String absolutePath = file.getAbsolutePath();
//
////        System.out.println(absolutePath);
//        FileController fileController = new FileController();
//        this.database = fileController.loadXML(absolutePath);
//        System.out.println(database.toString());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("PKCK XML Editor");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
