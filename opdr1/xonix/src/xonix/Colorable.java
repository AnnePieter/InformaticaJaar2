/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xonix;

/**
 * this is the Colorable interface and should be used by each colorable object
 * @author frank
 */
public interface Colorable {

    /**
     * this method should return the color of an object
     * @return java.awt.Color
     */
    java.awt.Color getColor();

    /**
     * this method should be used to set the color of an object.
     * @param color
     */
    void setColor(final java.awt.Color color);

}
