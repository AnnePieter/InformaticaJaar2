package xonix;

import java.util.Observable;

public class GameView extends javax.swing.JFrame implements java.util.Observer
{

    private final javax.swing.JPanel all;
    public final ScoreView score;
    public final MapView map;

    public GameView (MapView mv, ScoreView score)
    {
        this.setTitle ("Xonix Game");
        all = new javax.swing.JPanel ();
        all.setLayout (new javax.swing.BoxLayout (all, javax.swing.BoxLayout.Y_AXIS));
        all.setBorder(new javax.swing.border.EmptyBorder(0, 30, 0, 30));
        this.score = score;
        all.add (score);
        this.map = mv;
        map.setAlignmentX (CENTER_ALIGNMENT);
        all.add (map);
        this.add (all);
        this.pack ();
        this.setLocationRelativeTo (null);
        this.setDefaultCloseOperation (javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setSize (new java.awt.Dimension (630, 610));
        this.setResizable (false);
        this.setVisible (true);
    }

    @Override
    public void update(Observable o, Object o1) {
        if(o instanceof GameWorld){
            update();
        }
    }

    public void update ()
    {
        score.update ();
        map.update ();
    }
}
