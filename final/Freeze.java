import java.util.ArrayList;

/**
 * Created by Can on 30/04/2017.
 */
public class Freeze extends Bonus {

    @Override
    public void activate(ArrayList<Defender> list) {
        for(int i = 0; i < list.size(); i++){
            list.get(i).setVelX(1);
            list.get(i).setVelY(1);
        }
    }

    @Override
    public void deactivate(ArrayList<Defender> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof BlueDefender || list.get(i) instanceof GreenDefender) {
                list.get(i).setVelX(list.get(i).getSLOW_SPD());
                list.get(i).setVelY(list.get(i).getSLOW_SPD());

            } else {
                list.get(i).setVelX(list.get(i).getFAST_SPD())  ;
                list.get(i).setVelY(list.get(i).getFAST_SPD()) ;
            }
        }
    }

    public Freeze(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void activate(Virus v) {

    }

    @Override
    public void deactivate(Virus v) {

    }
}
