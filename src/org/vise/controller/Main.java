package org.vise.controller;

import org.vise.view.FXLauncher;

import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.stage.Stage;

/***
 * 
 * @author mattianavach
 *
 */
public class Main {

    /***
     * 
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        PlatformImpl.startup(() -> {
        });
        final FXLauncher launcher = new FXLauncher();

        Platform.runLater(() -> {
            try {
                final Stage primaryStage = new Stage();
                primaryStage.setTitle("Vise Music");
                launcher.start(primaryStage);
            } catch (Exception e) {
                System.out.println("Unable to load graphic.");
                e.printStackTrace();
            }
        });
    }

    /**
     * 
     */
    public void doStuff() {
    }
}
