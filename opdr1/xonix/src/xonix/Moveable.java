/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xonix;

/**
 * this is the Movable interface, and should be implemented by each moveable object.
 * @author frank
 */
public interface Moveable {
    /**
     * this method should return the speed of an object
     * @return speed
     */
    float getSpeed();

    /**
     * this method should be used to set the speed of an object.
     * @param speed
     */
    void setSpeed(float speed);

}
