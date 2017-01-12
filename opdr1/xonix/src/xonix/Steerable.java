/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xonix;

/**
 * the steerable interface contains methods that should be implemented by each steerable object
 * @author frank
 *
 */
public interface Steerable {

    /**
     * a method that should return the heading of an object
     * @return heading
     */
    int getHeading();

    /**
     * this method should be used to set the heading variable
     * @param heading
     */
    void setHeading(int heading);
}
