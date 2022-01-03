/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.Projectile;

/**
 *
 * @author DaanB
 */
public class ProjectileView extends Region {
    private Projectile model;
    private AnchorPane projectilePane;

    public ProjectileView(Projectile projectileModel) {
        model = projectileModel;
        tekenProjectile();
        update();
    }

    public void tekenProjectile(){
        projectilePane = new AnchorPane();
        Polygon projectile = new Polygon();
        
        projectile.setLayoutX(model.getPositieX());
        projectile.setLayoutY(model.getPositieY());
        
        projectile.getPoints().add(15.0);
        projectile.getPoints().add(0.0);
        projectile.getPoints().add(20.0);
        projectile.getPoints().add(10.0);
        projectile.getPoints().add(15.0);
        projectile.getPoints().add(20.0);
        projectile.getPoints().add(10.0);
        projectile.getPoints().add(10.0);
        
        projectile.setFill(Color.BLUE);
        
        projectilePane.getChildren().addAll();
    }
    
    public void update(){
        getChildren().clear();
        
        projectilePane.setTranslateY(this.model.getPositieY());
        
        getChildren().addAll(projectilePane);
    }

}
