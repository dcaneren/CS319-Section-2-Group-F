import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Can on 30/04/2017.
 */
public abstract class Bonus extends GameObject{
    Color purple = new Color (100, 0, 200);
    int duration, lifetime;
    public Bonus(int posX, int posY) {
        super(posX, posY);
        this.setColor(purple);
        this.setSize(8);
        this.setVelX(0);
        this.setVelY(0);
    }

    public abstract void activate(Virus v);
    public abstract void deactivate(Virus v);
    public abstract void activate(ArrayList<Defender> list);
    public abstract void deactivate(ArrayList<Defender> list);
}
