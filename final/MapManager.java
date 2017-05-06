import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Can on 03/05/2017.
 */
public class MapManager extends Canvas
{
    private double timeElapsed , score ;
    private int level =1;
    private ArrayList<GameObject> mapObjectsList = new ArrayList<GameObject>();
    ArrayList<Defender> defendersToSpawn = new ArrayList<Defender>();
    private Virus virus;

    public MapManager() {
        setPreferredSize(new Dimension (1000, 650));
        setBackground(Color.BLACK);
    }
    public MapManager(int width, int height ) {
        setPreferredSize(new Dimension (width, height));
        setBackground(Color.BLACK);
    }

    public ArrayList<Defender> defendersAlive(){
        return null;
    }

    public void loadMap(){
    }

    public void paint(Graphics g){

        // draw virus
        //  g.setColor(Color.BLACK);
        for (int i = 0; i < mapObjectsList.size(); i++) {
            Color color = mapObjectsList.get(i).getColor();
            int size = mapObjectsList.get(i).getSize();
            int x = mapObjectsList.get(i).getPosX() - size / 2;
            int y = mapObjectsList.get(i).getPosY() - size / 2;
            g.setColor(color);
            g.fillRect(x, y, size, size);
        }

        g.setColor (Color.white);
        g.drawString("Time Elapsed: " + (int)timeElapsed, 50, 70);
        g.drawString("Score : " + (int)score, 50 , 86);
        g.drawString("Level : " + level, 50,102);



        g.setColor(Color.gray);
        g.fillRect(15,15,virus.getMaxHP()*2,32);
        g.setColor(Color.yellow);
        g.fillRect(15,15,virus.getCurrentHP()*2, 32);
        g.setColor(Color.white);
        g.drawRect(15,15, virus.getMaxHP()*2, 32);
        g.drawString((""+virus.getCurrentHP()),15,15);


    }


    public void add (GameObject o){
        if (o instanceof Virus)
            virus = (Virus)o;
        //else
        mapObjectsList.add(o);
        //paint(Graphics g);
    }
    public void remove(GameObject o) {
        mapObjectsList.remove(o);
    }
    public void setTimeElapsed ( double timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
    public void setScore ( double score){
        this.score = score;
    }
    public  void  setLevel(int level){
        this.level = level;
    }
    public  int getLevel(){
        return level;
    }


    public ArrayList<GameObject> ObjList(){
        return mapObjectsList;
    }

}
