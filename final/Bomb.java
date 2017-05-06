import java.awt.*;
import java.util.ArrayList;

/**
 * Created by samsunggg on 6.5.2017.
 */
public class Bomb extends Bonus {

    ArrayList<Defender> listToDetonate;
    public Bomb ( int posX, int posY){
        super(posX,posY);
    }
    @Override
    public void activate(ArrayList<Defender> list) {
        listToDetonate = new ArrayList<Defender>();
        detonate( list, listToDetonate);

    }

    @Override
    public void deactivate(ArrayList<Defender> list) {

    }
    @Override
    public void activate(Virus v) {

    }

    @Override
    public void deactivate(Virus v) {

    }
    public void detonate (ArrayList<Defender> list, ArrayList<Defender> listToDetonate){
        for(int i = 0; i< list.size(); i++) {
            if (Math.sqrt(Math.pow((posX - list.get(i).getPosX()),2) + Math.pow((posY - list.get(i).getPosY()),2)) <=150 ){
                listToDetonate.add(list.get(i));
            }
        }

    }
    public ArrayList<Defender> getListToDetonate (){
        return listToDetonate;
    }
}
