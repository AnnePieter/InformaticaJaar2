package xonix;


class TimeTicket extends gameObject
{
    private float width;
    private float height;
    private int seconds;

    public TimeTicket (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, int seconds, final float width, final float height)
    {
        setLocation (loc);
        setColor (color);
        setWidth (width);
        setHeight (height);
        setSeconds (seconds);
    }

    public float getWidth ()
    {
        return width;
    }

    public void setWidth (final float width)
    {
        this.width = width;
    }

    public float getHeight ()
    {
        return height;
    }

    public void setHeight (final float height)
    {
        this.height = height;
    }

    public boolean contains (final java.awt.geom.Point2D.Float that)
    {
        java.awt.geom.Point2D.Float thisLoc = this.getLocation ();
        return that.x >= thisLoc.x && that.x <= thisLoc.x + this.getWidth () && that.y >= thisLoc.y && that.y <= thisLoc.y + this.getHeight ();
    }

    public int getSeconds ()
    {
        return seconds;
    }

    public void setSeconds (int seconds)
    {
        this.seconds = seconds;
    }

    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " width=" + width + " height=" + height + " seconds=" + seconds;
    }
}
