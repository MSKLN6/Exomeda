/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.Player;

/**
 *
 * @author ramonvd
 */
public class PlayerView extends Region {
    private Player model;
    private AnchorPane playerSchip;

    public PlayerView(Player model) {
        this.model = model;
        tekenPlayer();
        update();
    }

    public void tekenPlayer(){
        playerSchip = new AnchorPane();
        Polygon schip = new Polygon();

        schip.setLayoutX(5);
        schip.setLayoutY(5);
        schip.getPoints().add(15.0);
        schip.getPoints().add(0.0);
        schip.getPoints().add(30.0);
        schip.getPoints().add(30.0);
        schip.getPoints().add(0.0);
        schip.getPoints().add(30.0);
        schip.setFill(Color.WHITE);
        
        playerSchip.getChildren().addAll(schip);
    }
    
    public void update(){
        getChildren().removeAll();
        playerSchip.setTranslateX(model.getPositieX());
        getChildren().addAll(playerSchip);
    }

}
