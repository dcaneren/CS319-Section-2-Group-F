/**
 * Created by Can on 30/04/2017.
 */
public abstract class Defender extends GameObject{
    protected int damage;
    protected final int FAST_SPD = 10;
    // protected final int MEDIUM_SPD = 7;
    protected final int SLOW_SPD = 5;

    public Defender(int posX, int posY) {
        super(posX, posY);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public int getFAST_SPD(){
        return FAST_SPD;
    }
    public int getSLOW_SPD(){
        return SLOW_SPD;

    }
}
