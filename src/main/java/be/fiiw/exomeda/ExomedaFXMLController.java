package be.fiiw.exomeda;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Player;
import model.PlayerBeweging;
import model.Projectile;
import view.BackgroundView;
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
    private BackgroundView background;
    private Boolean currentFire;
    
    @FXML
    void initialize() {
        playerModel = new Player();
        playerView = new PlayerView(playerModel);
        
        playerSchip.getChildren().addAll(playerView);
        update();
        
        playerSchip.setOnKeyPressed(this::beweegPlayer);
        playerSchip.setOnKeyReleased(this::stopBeweegPlayer);
        
        ImageController.preloadImages();
        
        this.background = new BackgroundView();
        this.spelView.getChildren().add(this.background);
        
        start();
        
        playerView.setFocusTraversable(true);
    }

    public void start(){
        BeweegPlayer task = new BeweegPlayer(playerModel, this);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(task, 0, 2);
    }
    
    public void updateViews(){
        this.background.update();
    }
    
    public void update() {
        playerView.update();
        Platform.runLater( this::updateViews );
    }

    
    private void beweegPlayer(KeyEvent t) {
        switch(t.getCode()){
            case RIGHT:
                playerModel.setBeweging(PlayerBeweging.RECHTS);
                break;
            case LEFT:
                playerModel.setBeweging(PlayerBeweging.LINKS);
                break;
        }
        update();
    }
    
    private void stopBeweegPlayer(KeyEvent t) {
        switch(t.getCode()){
            case RIGHT:
                playerModel.setBeweging(PlayerBeweging.STIL);
                break;
            case LEFT:
                playerModel.setBeweging(PlayerBeweging.STIL);
                break;
        }
        update();
    }
}