package be.fiiw.exomeda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Player;
import model.Projectile;
import view.PlayerView;
import view.ProjectileView;

public class ExomedaFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane playerSchip;

    @FXML
    private AnchorPane spelView;
    
    private Player playerModel;
    private PlayerView playerView;
    private Projectile projectileModel;
    private ProjectileView projectileView;
    
    @FXML
    void initialize() {
        playerModel = new Player();
        playerView = new PlayerView(playerModel);
        playerSchip.getChildren().addAll(playerView);
        
        projectileModel = new Projectile();
        projectileView = new ProjectileView(projectileModel);
        playerSchip.getChildren().addAll(projectileView);
        
        playerSchip.setOnKeyPressed(this::beweegPlayer);
        
        playerView.setFocusTraversable(true);
        projectileView.setFocusTraversable(true);
    }

    private void beweegPlayer(KeyEvent t) {
        switch(t.getCode()){
            case RIGHT:
                playerModel.beweegRechts();
                break;
            case LEFT:
                playerModel.beweegLinks();
                break;
            case UP:
                projectileModel.schiet();
                break;
        }
        update();
    }
    

    private void update() {
        playerView.update();
        projectileView.update();
    }

}
