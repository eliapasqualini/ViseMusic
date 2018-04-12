package org.vise.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;

import org.vise.controller.PlayerControllerImpl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/***
 * 
 * @author mattianavach
 *
 */
public class PlayerScreenController {

    private static final int DIMENSION_ICONS = 18;
    private PlayerControllerImpl player;

    @FXML
    private ImageView btnPlay, btnPrev, btnNext, btnReplay;

    @FXML
    private Button btnNewPlaylist;

    @FXML
    private VBox btnCaricaCanzone;

    /**
     * 
     */
    public PlayerScreenController() {
        this.player = new PlayerControllerImpl();
    }

    /**
     * 
     */
    @FXML
    public void newPlaylist() {
        final TextInputDialog dialog = new TextInputDialog();
        dialog.setResizable(false);
        dialog.setGraphic(null);
        dialog.setTitle("Nuova playlist");
        dialog.setHeaderText("Inserire il nome della nuova playlist");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("Dialog.css").toExternalForm());
        dialogPane.getStyleClass().add("Dialog");
        final Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("NEW PLAYLIST: " + result.get());
            //this.controller.newPlaylist(result.get());
        }
    }

    /**
     * 
     */
    @FXML
    public void caricaCanzone() {
        final FileChooser chooser = new FileChooser();
        chooser.setTitle("Seleziona la Canzone da eseguire.");
        final File file = chooser.showOpenDialog(null);
        if (file != null) {
            final String fileAsString = file.toString();
            this.player.loadSong(fileAsString);
        } else {
            System.out.println("No choises");
        }
    }

    /***
     * 
     */
    @FXML
    public void play() {
        InputStream is;
        try {
            is = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "res" + System.getProperty("file.separator") + "icons" + System.getProperty("file.separator") + "stop.png"));
            btnPlay.setImage(new Image(is, PlayerScreenController.DIMENSION_ICONS, PlayerScreenController.DIMENSION_ICONS, true, true));
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }

        this.player.play();
    }

    /**
     * 
     */
    @FXML
    public void prev() {
        System.out.println("PREV");
    }

    /**
     * 
     */
    @FXML
    public void next() {
        System.out.println("NEXT");
    }

    /***
     * 
     */
    @FXML
    public void replay() {
        this.player.replay();
    }
}
