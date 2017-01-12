package xonix;

class MonsterBall extends playerObject
{
    private float radius;

    public MonsterBall (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, final int heading, final float speed, final float radius)
    {
        setLocation (loc);
        setColor (color);
        setHeading (heading);
        setSpeed (speed);
        this.setRadius (radius);
    }



    public float getRadius ()
    {
        return radius;
    }

    public void setRadius (float radius)
    {
        this.radius = radius;
    }


    public boolean changeLocation (FieldSquares fss, State state, float delta)
    {
        java.awt.geom.Point2D.Float prev = getLocation ();
        java.awt.geom.Point2D.Float next = nextLocation (delta);
        FieldSquare fsprev = fss.elementAt ((int) (prev.x / GameWorld.SQUARE_UNITS + 0.5), (int) (prev.y / GameWorld.SQUARE_UNITS + 0.5));
        FieldSquare fsnext = fss.elementAt ((int) (next.x / GameWorld.SQUARE_UNITS + 0.5), (int) (next.y / GameWorld.SQUARE_UNITS + 0.5));

        if (fsprev.getColor () == GameWorld.LINE_COLOR || fsnext.getColor () == GameWorld.LINE_COLOR)
            return true;

        if (fsprev.getColor () != fsnext.getColor ())
        {
            if (fss.elementAt ((int) (prev.x / GameWorld.SQUARE_UNITS + 0.5), (int) (prev.y / GameWorld.SQUARE_UNITS + 0.5)).getColor () != fss.elementAt ((int) (next.x / GameWorld.SQUARE_UNITS + 0.5), (int) (prev.y / GameWorld.SQUARE_UNITS + 0.5)).getColor ())
                if (getHeading () < 180)
                    setHeading (180 - getHeading ());
                else
                    setHeading (540 - getHeading ());
            if (fss.elementAt ((int) (prev.x / GameWorld.SQUARE_UNITS + 0.5), (int) (prev.y / GameWorld.SQUARE_UNITS + 0.5)).getColor () != fss.elementAt ((int) (prev.x / GameWorld.SQUARE_UNITS + 0.5), (int) (next.y / GameWorld.SQUARE_UNITS + 0.5)).getColor ())
                setHeading (360 - getHeading ());
        }
        getLocation ().setLocation (nextLocation (delta));
        return false;
    }

    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " heading=" + heading + " speed=" + speed + " radius=" + radius;
    }
}
