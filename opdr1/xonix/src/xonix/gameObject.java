package xonix;


import java.awt.*;

/**
 * Created by frank on 16-11-2016.
 */
public abstract class gameObject implements Colorable{
    java.awt.geom.Point2D.Float loc;
    java.awt.Color color;

    /**
     * this method returns the location of a gameObject
     * @return loc
     */
    java.awt.geom.Point2D.Float getLocation(){
        return loc;
    }

    /**
     * this method sets the value of loc variable
     * @param loc
     */
    void setLocation(java.awt.geom.Point2D.Float loc){
        this.loc = loc;
    }


    //interface methods implementation
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
}
