package xonix;

/**
 * Created by frank on 15-1-2017.
 */
public class MapView extends javax.swing.JPanel
{


    public MapView ()
    {
        super ();
    }

    public void update ()
    {
        this.repaint ();
    }

    @Override
    public void paint (java.awt.Graphics g)
    {
        super.paint (g);

        for (FieldSquare[] fss : GameWorld.getInstance().getFieldSquares()) {
            for (FieldSquare fs: fss)
            {
                g.setColor (fs.getColor ());
                g.fillRect ((int) fs.getLocation ().x, (int) fs.getLocation ().y, (int) fs.getSize (), (int) fs.getSize ());
            }
        }
        if (GameWorld.getInstance().state.isGameOver ())
        {
            java.awt.Font font = new java.awt.Font ("Helvetica", java.awt.Font.BOLD, 18);
            java.awt.FontMetrics metrics = g.getFontMetrics (font);
            g.setColor (java.awt.Color.RED);
            g.setFont (font);
            g.drawString ("GAME OVER", (GameWorld.SQUARE_LENGTH * GameWorld.SQUARE_UNITS - metrics.stringWidth ("GAME OVER")) / 2, (GameWorld.SQUARE_LENGTH * GameWorld.SQUARE_UNITS - metrics.getHeight ()) / 2);
            return;
        }

        for (MonsterBall mb : GameWorld.getInstance().mbs)
        {
            g.setColor (mb.getColor ());
            g.fillArc ((int) mb.getLocation ().x, (int) (int) mb.getLocation ().y, (int) mb.getRadius (), (int) mb.getRadius (), 0, 360);
        }

        for (TimeTicket tt : GameWorld.getInstance().tts)
        {
            g.setColor (tt.getColor ());
            g.fillRect ((int) tt.getLocation ().x, (int) tt.getLocation ().y, (int) tt.getWidth (), (int) tt.getHeight ());
        }

        g.setColor (GameWorld.getInstance().car.getColor ());
        g.fillRect ((int) GameWorld.getInstance().car.getLocation ().x, (int) GameWorld.getInstance().car.getLocation ().y, GameWorld.getInstance().car.getWidth (), GameWorld.getInstance().car.getHeight ());
    }
}