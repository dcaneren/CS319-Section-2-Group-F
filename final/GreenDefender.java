import java.awt.Color;

/**
 * Created by Can on 30/04/2017.
 */
public class GreenDefender extends Defender {
    public GreenDefender(int posX, int posY) {
        super(posX, posY);
        this.setDamage(5);
        this.setColor(Color.green);
        this.setSize(16);
        this.setVelX(SLOW_SPD);
        this.setVelY(SLOW_SPD);
    }
}
