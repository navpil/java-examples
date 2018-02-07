package ua.lviv.navpil.network;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://static.pinboard.in/ob/thumbs/ob.030.thumb.png");
        System.out.println("protocol = " + url.getProtocol());
        System.out.println("authority = " + url.getAuthority());
        System.out.println("host = " + url.getHost());
        System.out.println("port = " + url.getPort());
        System.out.println("path = " + url.getPath());
        System.out.println("query = " + url.getQuery());
        System.out.println("filename = " + url.getFile());
        System.out.println("ref = " + url.getRef());

        JavaFXTest.inputStream = url;

        JavaFXTest.launch();


    }


    public static class JavaFXTest extends Application {

        public static URL inputStream;

        @Override
        public void start(Stage primaryStage) {
            Button btn = new Button();
            btn.setText("Say 'Hello World'");
            btn.setOnAction(event -> System.out.println("Hello World!"));

            StackPane root = new StackPane();
            root.getChildren().add(btn);
            ImageView imageView = new ImageView();
            imageView.setImage(new Image("https://static.pinboard.in/ob/thumbs/ob.030.thumb.png"));
            root.getChildren().add(imageView);
            Scene scene = new Scene(root, 300, 250);



            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

//        public static void main(String[] args) {
//            launch();
//        }
    }

}
