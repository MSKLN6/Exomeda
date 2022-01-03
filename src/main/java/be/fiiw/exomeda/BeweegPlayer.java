/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.fiiw.exomeda;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Player;

/**
 *
 * @author vando
 */
public class BeweegPlayer extends TimerTask{
    private Player playerModel;
    private ExomedaFXMLController playerController;
    
    public BeweegPlayer(Player playerModel, ExomedaFXMLController playerController) {
        this.playerModel = playerModel;
        this.playerController = playerController;
    }
    
    public void run() {
        playerModel.tick();
        Platform.runLater(playerController::update);
    }
}
