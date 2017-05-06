import java.awt.Color;

/**
 * Created by Can on 30/04/2017.
 */
public class RedDefender extends Defender {

    public RedDefender(int posX, int posY) {
        super(posX, posY);
        this.setDamage(8);
        this.setColor(Color.red);
        this.setSize(8);
        this.setVelX(FAST_SPD);
        this.setVelY(FAST_SPD);
    }
}
