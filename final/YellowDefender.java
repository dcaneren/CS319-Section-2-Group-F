import java.awt.Color;

/**
 * Created by Can on 30/04/2017.
 */
public class YellowDefender extends Defender {

    public YellowDefender(int posX, int posY) {
        super(posX, posY);
        this.setDamage(2);
        this.setColor(Color.yellow);
        this.setSize(16);
        this.setVelX(FAST_SPD);
        this.setVelY(FAST_SPD);
    }
}
