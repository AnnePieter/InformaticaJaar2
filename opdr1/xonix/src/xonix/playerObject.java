package xonix;

/**
 * Created by frank on 16-11-2016.
 */
public abstract class playerObject extends gameObject implements Moveable, Steerable {
    int heading;
    float speed;

    /**
     * this method calculates the next location of an object based on the delta, heading and speed.
     * @param delta
     * @return java.awt.geom.Point2D.Float
     */
    java.awt.geom.Point2D.Float nextLocation (float delta){
        double radians = Math.toRadians (getHeading ());
        float newx = getLocation ().x + delta * getSpeed () * (float) Math.cos (radians);
        if (newx < 0)
            newx = 0;
        else if (newx > GameWorld.SQUARE_LENGTH * GameWorld.SQUARE_UNITS - (GameWorld.SQUARE_UNITS - 1))
            newx = GameWorld.SQUARE_LENGTH * GameWorld.SQUARE_UNITS - (GameWorld.SQUARE_UNITS - 1);
        float newy = getLocation ().y - delta * getSpeed () * (float) Math.sin (radians);
        if (newy < 0)
            newy = 0;
        else if (newy > GameWorld.SQUARE_LENGTH * GameWorld.SQUARE_UNITS - (GameWorld.SQUARE_UNITS - 1))
            newy = GameWorld.SQUARE_LENGTH * GameWorld.SQUARE_UNITS - (GameWorld.SQUARE_UNITS - 1);
        return new java.awt.geom.Point2D.Float (newx, newy);
    }

    //interface method implementation

    @Override
    public int getHeading() {
        return heading;
    }

    @Override
    public void setHeading(int heading) {
        this.heading = heading;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
