import java.awt.*;

/**
 * Created by Can on 30/04/2017.
 */
public class Virus extends GameObject {
    protected int maxHP, currentHP;
    protected boolean invincibility;

    public Virus(int posX, int posY) {
        super(posX, posY);
        this.setMaxHP(100);
        this.setCurrentHP(100);
        this.setInvincibility(false);
        this.setVelX(0);
        this.setVelY(0);
        this.setColor(new Color (250, 250, 250));
        this.setSize(32);
    }
    public Virus ( Virus vir){
        super(vir);
        this.setMaxHP(100);
        this.setCurrentHP(vir.getCurrentHP());
        this.setInvincibility(vir.isInvincibility());
        this.setVelX(vir.getVelX());
        this.setVelY(vir.getVelY());
        this.setColor(new Color (250, 250, 250));
        this.setSize(vir.getSize());
    }

    public void takeDamage(Defender d){
        currentHP -= d.getDamage();
    }

    public boolean isDead(){
        if(currentHP <= 0) return true;
        else return false;
    }

    public boolean isInvincible(){
        if(invincibility) return true;
        else return false;
    }



    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public boolean isInvincibility() {
        return invincibility;
    }

    public void setInvincibility(boolean invincibility) {
        this.invincibility = invincibility;
    }
}
