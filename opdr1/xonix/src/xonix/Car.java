package xonix;

/**
 * @author Frank Keuning
 * claas: Car
 */

public final class Car extends playerObject
{
    private static java.awt.geom.Point2D.Float loc = new java.awt.geom.Point2D.Float (GameWorld.SQUARE_LENGTH / 2 * GameWorld.SQUARE_UNITS, (GameWorld.SQUARE_LENGTH - 1) * GameWorld.SQUARE_UNITS);
    private static java.awt.Color color =  GameWorld.CAR_COLOR;
    private static int heading = 270;
    private static int speed = 50;
    private static int width = GameWorld.SQUARE_UNITS;
    private static int height = GameWorld.SQUARE_UNITS;

    private static FieldSquare fsprev;
    private static FieldSquare fsnext;

    private static Car car  = new Car(loc,color,heading,speed,width,height);


    private Car (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, final int heading, final int speed, final int width, final int height)
    {
        this.loc = loc;
        this.color = color;
        this.heading = heading;
        this.speed = speed;
        this.width = width;
        setWidth(width);
        setHeight(height);
    }

    public static Car getInstance(){
        return car;
    }

    public void reset ()
    {
        setLocation (new java.awt.geom.Point2D.Float (GameWorld.SQUARE_LENGTH / 2 * GameWorld.SQUARE_UNITS, (GameWorld.SQUARE_LENGTH - 1) * GameWorld.SQUARE_UNITS));
        setColor (GameWorld.CAR_COLOR);
        setHeading (270);
        setSpeed (50);
        setWidth (GameWorld.SQUARE_UNITS);
        setHeight (GameWorld.SQUARE_UNITS);
    }

    public int getWidth ()
    {
        return width;
    }

    public final void setWidth (final int width)
    {
        this.width = width;
    }

    public int getHeight ()
    {
        return height;
    }

    public final void setHeight (final int height)
    {
        this.height = height;
    }


    public void changeLocation (FieldSquares fss, State state, float delta)
    {
        java.awt.geom.Point2D.Float prev = getLocation ();
        java.awt.geom.Point2D.Float next = nextLocation (delta);
        FieldSquare fsprev = fss.elementAt ((int) (prev.x / GameWorld.SQUARE_UNITS + 0.5), (int) (prev.y / GameWorld.SQUARE_UNITS + 0.5));
        FieldSquare fsnext = fss.elementAt ((int) (next.x / GameWorld.SQUARE_UNITS + 0.5), (int) (next.y / GameWorld.SQUARE_UNITS + 0.5));
        if (fsnext.getColor () == GameWorld.SQUARE_COLOR)
            fsnext.setColor (GameWorld.LINE_COLOR);
        else if (fsnext.getColor () == GameWorld.PLAYER_COLOR && fsprev.getColor () == GameWorld.LINE_COLOR)
            state.addcscore (fss.fillSquares ());
        getLocation ().setLocation (next);
    }

    @Override
    public String toString ()
    {
        return "loc=" + getLocation ().x + "," + getLocation ().y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " heading=" + heading + " speed=" + speed + " width=" + width + " height=" + height;
    }
}
