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
    private PlayerBeweging beweging;
    public int beweegRechts;
    
    public Player() {
        this(400,500,PlayerBeweging.STIL);
    }
    
    /**
     * 
     * @param positieX variabele waarde X positie
     * @param positieY vaste waarde 500
     */
    public Player(double positieX, double positieY, PlayerBeweging beweging) {
        this.positieX = positieX;
        this.positieY = 500;
        this.beweging = beweging;
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
    
    public void setBeweging(PlayerBeweging beweging){
        this.beweging = beweging;
    }
    
    public PlayerBeweging getBeweging(){
        return beweging;
    }

    /**
     * @return the positieY
     */
    public double getPositieY() {
        return positieY;
    }
    
    public void beweegLinks(){
        positieX--;
    }
    
    public void beweegRechts(){
        positieX++;
    }
    
    public void reset(){
        positieX = 400;
        positieY = 500;
        beweging = PlayerBeweging.STIL;
    }
    
    public void tick(){
        switch(beweging){
            case STIL:
                break;
            case LINKS:
                beweegLinks();
                break;
            case RECHTS:
                beweegRechts();
                break;
        }
        if(positieX <= -10) //collision bounds toegevoegd
            positieX = -5;
        if (positieX >= 800 - 33)
            positieX = 800 - 38;
    }
}