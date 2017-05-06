import java.awt.*;

/**
 * Created by Can on 30/04/2017.
 */
public abstract class GameObject {
    protected int posX, posY, velX, velY;
    protected Color color;
    protected int size;

    public GameObject(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    public GameObject ( GameObject o) {
        this.posX = o.posX;
        this.posY = o.posY;
    }

    public void updatePos(){
        posX += velX;
        posY += velY;

    }
    public boolean  isCollided(GameObject o){
        Rectangle r1 = new Rectangle((int)o.posX, (int)o.posY, o.size, o.size);
        Rectangle r2 = new Rectangle((int)this.posX, (int)this.posY, this.size, this.size);

        if(r1.intersects(r2))
            return true;
        return false;

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}