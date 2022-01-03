/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Player;
import model.Projectile;

/**
 *
 * @author DaanB
 */
public class BeweegProjectile extends TimerTask{
    private Projectile projectileModel;
    private ExomedaFXMLController projectileController;
    
    public BeweegProjectile(Projectile projectileModel, ExomedaFXMLController projectileController) {
        this.projectileModel = projectileModel;
        this.projectileController = projectileController;
    }
    
    public void run() {
        projectileModel.tick();
        Platform.runLater(projectileController::update);
    }
}
