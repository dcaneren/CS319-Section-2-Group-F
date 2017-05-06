import java.awt.Color;

/**
 * Created by Can on 30/04/2017.
 */
public class PurpleDefender extends Defender {
    Color purple = new Color (110, 0, 220);
    public PurpleDefender(int posX, int posY) {
        super(posX, posY);
        this.setDamage(8);
        this.setColor(purple);
        this.setSize(32);
        this.setVelX(SLOW_SPD);
        this.setVelY(SLOW_SPD);
        this.setSize(64);
    }

}
