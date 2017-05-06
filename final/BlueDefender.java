import java.awt.Color;

/**
 * Created by Can on 30/04/2017.
 */
public class BlueDefender extends Defender {

    public BlueDefender(int posX, int posY) {
        super(posX, posY);
        this.setDamage(2);
        this.setColor(Color.blue);
        this.setSize(32);
        this.setVelX(SLOW_SPD);
        this.setVelY(SLOW_SPD);
    }
}
