package org.vise.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * 
 * @author mattianavach
 *
 */
public class RLFormScreenController {

    @FXML
    private Text txtUtilizzaOffline;

    @FXML
    private VBox rlformPane;

    /**
     * @throws IOException 
     * @throws Exception 
     * 
     */
    @FXML
    public void utilizzaOffline() throws IOException {
        final VBox pane = FXMLLoader.load(getClass().getResource(Screens.PLAYER.getResourcePath()));
        this.rlformPane.getChildren().setAll(pane);
    }
}
