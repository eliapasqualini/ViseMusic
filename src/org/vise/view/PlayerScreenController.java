package org.vise.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.vise.controller.PlayerController;
import org.vise.controller.PlayerControllerImpl;
import org.vise.model.playlist.Playlist;
import org.vise.model.playlist.Song;
import org.vise.model.playlist.SongImpl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/***
 * 
 * @author mattianavach
 *
 */
public class PlayerScreenController {

    private static final int DIMENSION_ICONS = 18;
    private PlayerController player;
    private boolean lockSliderPositionSong;
    private ObservableList<Playlist> observableListOfPlaylist;
    private Playlist currentPlaylist;
    private boolean tableCreated = false;

    private final ObservableList<Song> data =
            FXCollections.observableArrayList(
                new SongImpl("/Users/mattianavach/Desktop/Vise-Project/res/songs/song1.mp3"),
                new SongImpl("/Users/mattianavach/Desktop/Vise-Project/res/songs/song1.mp3"),
                new SongImpl("/Users/mattianavach/Desktop/Vise-Project/res/songs/song1.mp3")
            );

    @FXML
    private ImageView btnPlay, btnPrev, btnNext, btnReplay;

    @FXML
    private Button btnNewPlaylist, btnAddSongToPlaylist;

    @FXML
    private VBox btnCaricaCanzone, contentPlaylist;

    @FXML
    private ListView<Playlist> listOfPlaylists;

    @FXML
    private Slider sliderVolume, sliderPosition;

    @FXML
    private Text textNamePlaylist, textAuthorPlaylist;

    @FXML
    private TableView<Song> tableViewSongs;

    /**
     * 
     */
    public PlayerScreenController() {
        this.player = new PlayerControllerImpl();
        this.lockSliderPositionSong = false;
    }

    /**
     * 
     */
    @FXML
    public void addSongToPlaylist() {
        /*
        final FileChooser chooser = new FileChooser();
        chooser.setTitle("Seleziona la Canzone da eseguire.");
        final File file = chooser.showOpenDialog(null);
        if (file != null) {
        } else {
            System.out.println("No choises");
        }*/
        data.add(new SongImpl("/Users/mattianavach/Desktop/Vise-Project/res/songs/song1.mp3"));
    }

    /**
     * 
     */
    @FXML
    public void clickOnPlaylist() {
        TableColumn<Song, String> firstNameCol = new TableColumn<>("Titolo");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));

        TableColumn<Song, String> lastNameCol = new TableColumn<>("Album");
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<Song, String>("album")
        );

        TableColumn<Song, String>  emailCol = new TableColumn<>("artist");
        emailCol.setMinWidth(100 + 100);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<Song, String>("artist")
        );
        this.tableViewSongs.setItems(data);
        this.tableViewSongs.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        if (this.observableListOfPlaylist.size() > 0 && this.listOfPlaylists.getSelectionModel().getSelectedItem() != null) {
            this.currentPlaylist = this.listOfPlaylists.getSelectionModel().getSelectedItem();
            this.textNamePlaylist.setText(this.currentPlaylist.getName());
            this.textAuthorPlaylist.setText("di " + this.currentPlaylist.getAuthor());
        }
    }

    /**
     * 
     */
    @FXML
    public void lockSliderPositionSong() {
        this.lockSliderPositionSong = true;
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
        final DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("Dialog.css").toExternalForm());
        dialogPane.getStyleClass().add("Dialog");
        final Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            this.player.addPlaylist(result.get());
            this.updateListViewPlaylist();
        }
    }

    /**
     * 
     */
    @FXML
    public void loadSong() {
        final FileChooser chooser = new FileChooser();
        chooser.setTitle("Seleziona la Canzone da eseguire.");
        final File file = chooser.showOpenDialog(null);
        if (file != null) {
            final String fileAsString = file.toString();
            this.player.loadSong(fileAsString);
            this.sliderPosition.setMax(this.player.getMaxLengthSong());
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
        this.startTimer(this.player, this.sliderPosition, this.lockSliderPositionSong);
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

    /**
     * 
     */
    @FXML
    public void changeVolume() {
        final float amount = (float) this.sliderVolume.getValue();
        this.player.changeVolume(amount);
    }

    /**
     * 
     */
    @FXML
    public void changePosition() {
        System.out.println("Cambio");
        Platform.runLater(() -> {
            final float position = (float) this.sliderPosition.getValue();
            System.out.println("Change position to: " + position);
            this.player.changePosition(position);
            this.lockSliderPositionSong = false;
        });
    }

    /**
     * 
     * @param player
     *          The current player.
     * @param slider
     *          The slider of the song.
     * @param lock
     *          If the slider is lock.
     */
    public void startTimer(final PlayerController player, final Slider slider, final boolean lock) {
        final Timeline oneSecond = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                if (!lock) {
                    int pos = player.getPosition();
                    slider.setValue(pos);
                }
            }
        }));
        oneSecond.setCycleCount(Timeline.INDEFINITE);
        oneSecond.play();
    }

    private void setColumnsTableSongs() {
        /*TableColumn<Song, String> songTitleCol = new TableColumn<Song, String>("Title");
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        final TableColumn<Song, String> songArtistCol = new TableColumn<Song, String>("Artista");
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("artist"));
        final TableColumn<Song, String> songAlbumCol = new TableColumn<Song, String>("Album");
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("album"));
        final TableColumn<Song, String> songDurationCol = new TableColumn<Song, String>("Durata");
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        final TableColumn buttonDeleteCol = new TableColumn("Elimina");
        this.tableViewSongs.getColumns().add(songArtistCol);*/
    }

    private void updateListViewPlaylist() {
        this.observableListOfPlaylist = FXCollections.observableArrayList(this.player.getAllPlaylist());
        this.listOfPlaylists.setItems(this.observableListOfPlaylist);
        this.listOfPlaylists.setCellFactory(param -> new ListCell<Playlist>() {
            @Override
            protected void updateItem(final Playlist item, final boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText("- " + item.getName());
                }
            }
        });
    }

    private void updateTableViewSongs(final List<Song> list) {
        if (!this.tableCreated) {
            this.setColumnsTableSongs();
            this.tableCreated = true;
        }
        //this.tableViewSongs.setItems(FXCollections.observableArrayList(list));
    }
}
