/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ramonvd
 */
public class Player {
    private double positieX; // de variabele x positie
    public static double positieY; // De Y positie is een vaste waade
    
    public Player() {
        this(400,50);
    }
    
    /**
     * 
     * @param positieX variabele waarde X positie
     * @param positieY vaste waarde 500
     */
    public Player(double positieX, double positieY) {
        this.positieX = positieX;
        this.positieY = 500;
    }

    /**
     * @return the positieX
     */
    public double getPositieX() {
        return positieX;
    }

    /**
     * @param positieX the positieX to set
     */
    public void setPositieX(double positieX) {
        this.positieX = positieX;
    }

    /**
     * @return the positieY
     */
    public double getPositieY() {
        return positieY;
    }
    
    public void beweegLinks(){
        positieX -= 30;
    }
    
    public void beweegRechts(){
        positieX += 30;
    }
    
    public void reset(){
        positieX = 400;
        positieY = 50;
    }
}
