package xonix;

/**
 * Created by annepieter on 12/01/2017.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D.Float;
import javax.swing.AbstractAction;

/**
 * this is the Command class which is used to define and implement all commands used in the game
 * @author annepieter
 */
abstract class Command extends AbstractAction implements ActionListener {
    Command() {
    }

    /**
     * this is the NewTimeTicket class which is used to spawn more timeticket power-ups
     */
    public class NewTimeticket extends Command {
        public NewTimeticket() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().tts.add(new TimeTicket(new Float((float)(GameWorld.getInstance().random.nextInt(480) + 15), (float)(GameWorld.getInstance().random.nextInt(480) + 15)), GameWorld.TICKET_COLOR, GameWorld.TTIME_START, 7.0F, 7.0F));
        }
    }

    public class AddMonsterball extends Command {
        public AddMonsterball() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().mbs.add(new MonsterBall(new Float((float)(GameWorld.getInstance().random.nextInt(480) + 15), (float)(GameWorld.getInstance().random.nextInt(480) + 15)), GameWorld.MONSTER_COLOR, GameWorld.getInstance().random.nextInt(360), GameWorld.getInstance().random.nextFloat() * 100.0F + 10.0F, 6.0F));
        }
    }

    public class DecreasCarspeed extends Command {
        public DecreasCarspeed() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().car.setSpeed(GameWorld.getInstance().car.getSpeed() - 5.0F);
        }
    }

    public class IncreaseCarspeed extends Command {
        public IncreaseCarspeed() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().car.setSpeed(GameWorld.getInstance().car.getSpeed() + 5.0F);
        }
    }

    public class GoWest extends Command {
        public GoWest() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().car.setHeading(180);
        }
    }

    public class GoEast extends Command {
        public GoEast() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().car.setHeading(0);
        }
    }

    public class GoSouth extends Command {
        public GoSouth() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().car.setHeading(270);
        }
    }

    public class GoNorth extends Command {
        public GoNorth() {
        }

        public void actionPerformed(ActionEvent e) {
            GameWorld.getInstance().car.setHeading(90);
        }
    }
}