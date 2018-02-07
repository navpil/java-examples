package ua.lviv.navpil.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTableView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Table View example");
        Scene scene = new Scene(
                FXMLLoader.<Pane>load(getClass().getResource("tableview.fxml"))
        );
        scene.getStylesheets().add(getClass().getResource("tableview.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
