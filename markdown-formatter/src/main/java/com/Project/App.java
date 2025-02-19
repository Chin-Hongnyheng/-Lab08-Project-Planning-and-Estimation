package com.nyheng;
<<<<<<< HEAD:markdown-formatter/src/main/java/com/nyheng/App.java
=======
//
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import java.util.Scanner;
>>>>>>> 17a12940b17d3dde4859ce743a850a486456f8b9:markdown-formatter/src/main/java/com/Project/App.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nyheng/Nyheng.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Markdown Previewer");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
