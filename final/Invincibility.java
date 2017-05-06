import java.util.ArrayList;

/**
 * Created by Can on 30/04/2017.
 */
public class Invincibility extends Bonus {
    public Invincibility(int posX, int posY) {super(posX, posY);
    }

    @Override
    public void activate(Virus v) {
        v.setInvincibility(true);
    }

    @Override
    public void deactivate(Virus v) {
        v.setInvincibility(false);
    }

    @Override
    public void activate(ArrayList<Defender> list) {

    }

    @Override
    public void deactivate(ArrayList<Defender> list) {

    }
}
