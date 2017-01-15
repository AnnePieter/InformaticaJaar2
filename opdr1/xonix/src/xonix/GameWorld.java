package xonix;

public class GameWorld extends java.util.Observable
{

    static final int SQUARE_LENGTH = 102;
    static final int SQUARE_UNITS = 5;
    static final int GAME_TICK_DELAY = 40;
    static final java.awt.Color NO_COLOR = java.awt.Color.white;
    static final java.awt.Color CAR_COLOR = java.awt.Color.red;
    static final java.awt.Color SQUARE_COLOR = java.awt.Color.black;
    static final java.awt.Color LINE_COLOR = java.awt.Color.red.darker ().darker ();
    static final java.awt.Color PLAYER_COLOR = java.awt.Color.cyan;
    static final java.awt.Color MONSTER_COLOR = java.awt.Color.orange;
    static final java.awt.Color TICKET_COLOR = java.awt.Color.green;
    static private int LEVEL_START = 1;
    static final int CLOCK_START = (6 - LEVEL_START) * 2;
    static final int LIVES_START = 3;
    static final int CSCORE_START = 0;
    static final int RSCORE_START = (40 + LEVEL_START * 10) * 100;
    static final int TTIME_START = 6 - LEVEL_START;


    //public final GameView gv;
    public final FieldSquares fss;
    public java.util.ArrayList<MonsterBall> mbs;
    public java.util.ArrayList<TimeTicket> tts;
    public final Car car;
    public State state;
    public final java.util.Random random;

    private static GameWorld gameWorld = new GameWorld();

    private GameWorld(){
        this.random = new java.util.Random();
        this.fss = FieldSquares.getInstance();
        createMonsterballs();
        createTimeTickets();
        this.car = Car.getInstance();
        this.state = new State();
    }
    public static GameWorld getInstance(){
        return gameWorld;
    }

    public void createMonsterballs ()
    {
        this.mbs = new java.util.ArrayList<> ();
        int number = random.nextInt (10) + 1;
        for (int i = 0; i < number; i ++)
            mbs.add (new MonsterBall (new java.awt.geom.Point2D.Float (random.nextInt (SQUARE_LENGTH * SQUARE_UNITS - 30) + 15, random.nextInt (SQUARE_LENGTH * SQUARE_UNITS - 30) + 15), MONSTER_COLOR, random.nextInt (360), random.nextFloat () * 100 + 10, 6));
    }

    public void createTimeTickets ()
    {
        this.tts = new java.util.ArrayList<> ();
        int number = random.nextInt (SQUARE_UNITS) + 1;
        for (int i = 0; i < number; i ++)
            tts.add (new TimeTicket (new java.awt.geom.Point2D.Float (random.nextInt (SQUARE_LENGTH * SQUARE_UNITS - 30) + 15, random.nextInt (SQUARE_LENGTH * SQUARE_UNITS - 30) + 15), TICKET_COLOR, TTIME_START, 7, 7));
    }


    public void update (float delta)
    {
        if ( ! state.isGameOver ())
        {
            state.addClock ( - delta);
            for (MonsterBall mb : mbs)
                if (mb.changeLocation (fss, state, delta))
                {
                    state.decLives ();
                    mbs.remove (mb);
                    break;
                }
            car.changeLocation (fss, state, delta);
            //check time ticket collision
            GameController.getInstance().new CollisionTimeticket().actionPerformed(null);

        }
        this.setChanged();
        this.notifyObservers();
    }

    public boolean TimeTicketCollision(){
        for (TimeTicket tt : tts)
            if (tt.contains (car.getLocation ()))
            {
                state.setClock (state.getClock () + tt.getSeconds ());
                tts.remove (tt);
                return true;
            }
        return false;
    }

    public void addScore(int squares){
        state.addcscore(squares);
    }

    public void reset ()
    {
        this.fss.reset ();
        createMonsterballs ();
        createTimeTickets ();
        this.car.reset ();
        this.state.reset ();
    }

    public FieldSquares getFieldSquares(){
        return fss;
    }

}
