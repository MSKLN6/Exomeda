package be.fiiw.exomeda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Player;
import view.PlayerView;

public class ExomedaFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane playerSchip;

    @FXML
    private AnchorPane spelView;
    
    private Player model;
    private PlayerView view;
    
    @FXML
    void initialize() {
        model = new Player();
        view = new PlayerView(model);
        playerSchip.getChildren().addAll(view);
        
        playerSchip.setOnKeyPressed(this::beweegPlayer);
        
        view.setFocusTraversable(true);
    }

    private void beweegPlayer(KeyEvent t) {
        switch(t.getCode()){
            case RIGHT:
                model.beweegRechts();
                break;
            case LEFT:
                model.beweegLinks();
                break;
        }
        update();
    }

    private void update() {
        view.update();
    }

}
