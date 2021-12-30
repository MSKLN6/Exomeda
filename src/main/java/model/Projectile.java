/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.ProjectileView;

/**
 *
 * @author DaanB
 */
public class Projectile {
    private double positieX;
    private double positieY;
    private ProjectileView projectileView;

    public Projectile() {
        this.positieX = 0;
        this.positieY = 0;
    }
    
    public void schiet(){
        projectileView.tekenProjectile();
    }

    public double getPositieX() {
        return positieX;
    }

    public double getPositieY() {
        return positieY;
    }
    
    
    
    
}
