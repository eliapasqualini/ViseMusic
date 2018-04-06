package org.vise.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/***
 * 
 * @author mattianavach
 *
 */
public class FXLauncher extends Application {

    private static final int WIDTH_START = 900;
    private static final int HEIGHT_START = 600;

    /**(non-Javadoc).
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Pane root = (VBox) FXMLLoader.load(getClass().getResource(Screens.RLFORM.getResourcePath()));
        final Scene scene = new Scene(root, FXLauncher.WIDTH_START, FXLauncher.HEIGHT_START);
        final Stage stage = primaryStage;

        stage.setScene(scene);
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.show();
    }
}
