package org.vise.controller;

import java.io.IOException;
import org.vise.view.Screens;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

/***
 * 
 * @author mattianavach
 *
 */
public class Main extends Application {
    private static final int WIDTH_START = 900;
    private static final int HEIGHT_START = 600;
    /**
     * @throws IOException *
     * 
     */
    @Override
    public void start(final Stage primaryStage) throws IOException {

        final VBox root = (VBox) FXMLLoader.load(getClass().getResource(Screens.PLAYER.getResourcePath()));
        final Scene scene = new Scene(root, Main.WIDTH_START, Main.HEIGHT_START);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /***
     * 
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
