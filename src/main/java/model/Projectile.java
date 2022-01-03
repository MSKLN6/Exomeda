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
    private Player playerModel;

    public Projectile(Player playerModel) {
        this.positieX = playerModel.getPositieX();
        this.positieY = playerModel.getPositieY();
    }

    public double getPositieX() {
        return positieX;
    }

    public double getPositieY() {
        return positieY;
    }
    
    public void schiet(){
        projectileView.tekenProjectile();
    }
    
}
