package be.fiiw.exomeda;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Player;
import model.PlayerBeweging;
import model.Projectile;
import view.PlayerView;
import view.ProjectileView;

public class ExomedaFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
        
        spelView.getChildren().addAll(playerView);
        update();
        
        projectileModel = new Projectile(playerModel);
        projectileView = new ProjectileView(projectileModel);
        spelView.getChildren().addAll(projectileView);
        
        spelView.setOnKeyPressed(this::schietProjectile);
        
        spelView.setOnKeyPressed(this::beweegPlayer);
        spelView.setOnKeyReleased(this::stopBeweegPlayer);
        
        start();
        
        playerView.setFocusTraversable(true);
        projectileView.setFocusTraversable(true);
    }
    
    public void start(){
        BeweegPlayer task = new BeweegPlayer(playerModel, this);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(task, 0, 2);
        
        BeweegProjectile task2 = new BeweegProjectile(projectileModel, this);
        Timer t2 = new Timer(true);
        t2.scheduleAtFixedRate(task2, 0, 2);
    }
    
    public void update() {
        playerView.update();
        projectileView.update();
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
    
    private void schietProjectile(KeyEvent t){
        switch (t.getCode()) {
            case UP:
                projectileModel.schiet();
                break;
        }
        update();
    }
}
