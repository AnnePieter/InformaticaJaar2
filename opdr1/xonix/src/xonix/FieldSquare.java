package xonix;

class FieldSquare extends gameObject
{
    private float size;

    public FieldSquare (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, float size)
    {
        setLocation (loc);
        setColor (color);
        setSize (size);
    }

    public float getSize ()
    {
        return size;
    }

    public void setSize (float size)
    {
        this.size = size;
    }

    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " size=" + size;
    }
}
