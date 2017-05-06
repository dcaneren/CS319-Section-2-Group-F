import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

/**
 * Created by Can on 03/05/2017.
 */
public class GameEngine extends JPanel implements KeyListener {
    private int WIDTH, HEIGHT;
    private long timeAtStart, timeLap;
    private int timeElapsed, score, freezeTime, invincibleTime, damageAmount;
    private  int timeKeep = 0;
    private int Health = 15;

    private MapManager gameMap;
    private Virus virus;
    private ArrayList<Defender> defenders = new ArrayList<Defender>();
    private ArrayList<Bonus> bonuses = new ArrayList<Bonus>();
    private int cycle = 70;
    private Random rand;
    private int level =2;
    private double n;
    private HighScoresManager scoreManager = new HighScoresManager();
    //input??
    private boolean running, freeze, invincibility;

    // Key Listeners
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        virus.setVelX(0);
        virus.setVelY(0);
    }

    @Override
    public void keyPressed (KeyEvent e) {

        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_W: virus.setVelX(0);
                virus.setVelY(-7);
                //System.out.println("UP\n");
                break;
            case KeyEvent.VK_S: virus.setVelX(0);
                virus.setVelY(7);
                //System.out.println("DOWN\n");
                break;
            case KeyEvent.VK_A: virus.setVelX(-7);
                virus.setVelY(0);
                //System.out.println("LEFT\n");
                break;
            case KeyEvent.VK_D: virus.setVelX(7);
                virus.setVelY(0);
                //System.out.println("RIGHT\n");
                break;

            case KeyEvent.VK_UP: virus.setVelX(0);
                virus.setVelY(-7);
                //System.out.println("UP\n");
                break;
            case KeyEvent.VK_DOWN: virus.setVelX(0);
                virus.setVelY(7);
                //System.out.println("DOWN\n");
                break;
            case KeyEvent.VK_LEFT: virus.setVelX(-7);
                virus.setVelY(0);
                //System.out.println("LEFT\n");
                break;
            case KeyEvent.VK_RIGHT: virus.setVelX(7);
                virus.setVelY(0);
                //System.out.println("RIGHT\n");
                break;

            case KeyEvent.VK_ESCAPE: running = false;

            default: ;
        }
    }


    private void createUIComponents (){

    }

    // constructors
    public GameEngine () throws IOException {
        WIDTH = 800;
        HEIGHT = 550;
        level = 2;
        gameMap = new MapManager(WIDTH,HEIGHT);

        add(gameMap);
        addKeyListener(this);
        rand = new Random();


        Defender d1 =  new BlueDefender(100,500);
        Defender d2 =  new YellowDefender(500,300);
        Defender d3 =  new YellowDefender(200,400);
        Defender d4 = new BlueDefender(300,400);
        Defender d5 = new GreenDefender(400,650);
        Defender d6 = new GreenDefender ( 150,250);
        Defender d7 = new RedDefender(350,430);
        Defender d8 = new RedDefender( 122,455);
        Defender d9 = new PurpleDefender(411,504);
        Defender d10 = new PurpleDefender(200,250);
        Defender d11 = new BlueDefender( 120,420);
        Defender d12 = new BlueDefender(150,140);
        Defender d13 = new PurpleDefender(600,87);
        Defender d14 = new YellowDefender(70, 50);
        Defender d15 = new RedDefender(85,40);
        Defender d16 = new PurpleDefender( 79,45);

        Bonus b = new Invincibility(100,200);
        Bonus b2 = new Freeze(300,250);
        Bonus b3 = new Bomb(300,350);

        addDefender(d1);
        addDefender(d2);
        addDefender(d3);
        addDefender(d4);
        addDefender(d5);
        addDefender(d6);
        addDefender(d7);
        addDefender(d8);
        addDefender(d9);
        addDefender(d10);
        addDefender(d11);
        addDefender(d12);
        addDefender(d13);
        addDefender(d14);
        addDefender(d15);
        addDefender(d16);

        bonuses.add(b);
        bonuses.add(b2);
        bonuses.add(b3);


    }

    public GameEngine (int w, int h) throws IOException {
        WIDTH = w;
        HEIGHT = h;

        gameMap = new MapManager(WIDTH,HEIGHT);

        add(gameMap);
        addKeyListener(this);
        rand = new Random();


    }


    // Logic methods
    public void startGame(){

        setFocusable(true);
        requestFocus();
        virus = new Virus (600,380);
        gameMap.add(virus);
        for(int i = 0; i<9 ; i++)
            gameMap.add(defenders.get(i));


        running = true;
        timeAtStart = System.currentTimeMillis();
        timeLap = timeAtStart;
        gameLoop();

    }



    private void addDefender (Defender d){

        double totalV = sqrt( pow(d.getVelX(),2)*2);
        int  x = rand.nextInt((int)totalV*100)/100;
        int y = (int) sqrt( pow(totalV,2)-pow(x,2));

        System.out.println("Total " + totalV + "\nx " + x);

        d.setVelX (x);
        d.setVelY(y);

        defenders.add(d);

    }

    private void removeDefender( Defender d){
        defenders.remove(d);
        gameMap.remove(d);
    }
    private void removeBonus(Bonus b) {
        bonuses.remove(b);
        gameMap.remove(b);
    }
    private void addBonus (Bonus b){
        bonuses.add(b);
        gameMap.add(b);
    }

    private void updateDefendersPosition (){
        for (int i = 0; i < defenders.size(); i ++) {
            defenders.get(i).updatePos();
            // boundary check
            if (defenders.get(i).getPosX() <= defenders.get(i).getSize()/2){
                defenders.get(i).setPosX(defenders.get(i).getSize()/2+1);
                defenders.get(i).setVelX(-1*defenders.get(i).getVelX());

            }
            if (defenders.get(i).getPosX() >= WIDTH - defenders.get(i).getSize()/2) {
                defenders.get(i).setPosX( WIDTH - defenders.get(i).getSize()/2-1);
                defenders.get(i).setVelX(-1 * defenders.get(i).getVelX());
            }
            if (defenders.get(i).getPosY() <= defenders.get(i).getSize()/2){
                defenders.get(i).setPosY( defenders.get(i).getSize()/2 +1);
                defenders.get(i).setVelY(-1*defenders.get(i).getVelY());
            }

            if (defenders.get(i).getPosY() >= HEIGHT - defenders.get(i).getSize()/2) {
                defenders.get(i).setPosY(HEIGHT - defenders.get(i).getSize() / 2 - 1);
                defenders.get(i).setVelY(-1 * defenders.get(i).getVelY());
            }
        }
    }

    public void pauseGame(){
        running = false;
    }

    public void endGame(){
        running = false;
        int score = virus.getCurrentHP();
        ScoreInstance temp = new ScoreInstance(score, "");
        scoreManager.addScoreInstance(temp);
    }


    public void gameLoop(){
        n = Math.random()*30;
        while (running) {
            try {
                Thread.sleep(cycle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                    virus.updatePos();
                    checkCollision();
                    updateDefendersPosition();
                    updateTimeElapsed(gameMap);
                    updateScore(gameMap);
                    updateLevel(gameMap);
                    //updateWave(gameMap);
                    while(n == timeElapsed && n <= timeElapsed +10) {
                        gameMap.add(bonuses.get(0));
                        gameMap.add(bonuses.get(1));
                        gameMap.add(bonuses.get(2));
                    }
                    gameMap.repaint();
                }
            });
        }
    }

    private void updateTimeElapsed(MapManager gameMap){
        long timeNow = System.currentTimeMillis();
        long timeDiff = timeNow - timeAtStart;
        timeElapsed = (int)(timeDiff /1000.0);
        gameMap.setTimeElapsed(timeElapsed);

    }
    public  double getTimeElapsed() {
        return timeElapsed;
    }


    public boolean checkCollision(){
        if(!virus.isInvincibility()) {
            for (int i = 0; i < defenders.size(); i++) {
                if (virus.isCollided(defenders.get(i))) {
                    Defender d = defenders.get(i);

                    virus.setCurrentHP(virus.getCurrentHP() - d.getDamage());

                    for(int j = 0; j<bonuses.size(); j++ ) {
                        bonuses.get(j).deactivate(defenders);
                        bonuses.get(j).deactivate(virus);
                    }

                    // when they collide on edge there is a problem we should manage
                    //  d.setPosX(d.getPosX() - 2 * d.getVelX());
                    //  d.setPosY(d.getPosY() - 2 * d.getVelY());
                    //  d.setVelX(-1 * d.getVelX());
                    //   d.setVelY(-1 * d.getVelY());

                    d.setPosX(d.getPosX() -6*d.getVelX());
                    d.setPosY(d.getPosY() -6*d.getVelY());
                    d.setVelX(-1 * d.getVelX());
                    d.setVelY(-1 * d.getVelY());
                    updateDefendersPosition();
                }

            }
        }
        System.out.println(virus.isInvincibility());



        for(int i = 0; i<bonuses.size(); i++ ) {
            if (virus.isCollided(bonuses.get(i))) {

                bonuses.get(i).activate(virus);
                bonuses.get(i).activate(defenders);
                gameMap.remove(bonuses.get(i));

                if(bonuses.get(i) instanceof Bomb){
                    ArrayList<Defender> list2 = ((Bomb) bonuses.get(i)).getListToDetonate();
                    for(int k = 0; k < list2.size(); k++){
                        gameMap.ObjList().remove(list2.get(k));
                    }
                }
            }

        }


        return false;

    }

    public void updateLevel(MapManager gameMap) {
        timeKeep++;
        if (timeKeep >= 571 && gameMap.getLevel() < 3 && virus.currentHP>=0) {
            timeKeep = 0;
            gameMap.setLevel(gameMap.getLevel() + 1);
            for (int i = 0; i < gameMap.ObjList().size(); i++) {

                if (gameMap.ObjList().get(i) instanceof Defender)
                    removeDefender((Defender) gameMap.ObjList().get(i));


                if (gameMap.ObjList().get(i) instanceof Bonus)
                    removeBonus((Bonus) gameMap.ObjList().get(i));

                if (gameMap.getLevel() == 2) {
                    for(int b = 9 ; b<12 ; b++)
                        gameMap.add(defenders.get(b));
                    gameMap.add(bonuses.get(0));
                    gameMap.add(bonuses.get(1));
                    gameMap.add(bonuses.get(2));


                }
                if (gameMap.getLevel() == 3) {
                    for(int b = 12; b<16 ; b++)
                        gameMap.add(defenders.get(b));
                    gameMap.add(bonuses.get(0));
                    gameMap.add(bonuses.get(1));
                    gameMap.add(bonuses.get(2));
                }

            }
            if (timeKeep >= 571&& gameMap.getLevel() >= 3 && virus.currentHP>=0)
                endGame();
        }
    }



    public void updateScore(MapManager gameMap){
        score ++;
        gameMap.setScore(score);

    }
    public double getScore(){
        return score;
    }
    public void setScore (int score){
        this.score = score;
    }





/*    public static void main (String[] args) throws IOException {

        JFrame frame = new JFrame ("Virus Attack");

        GameEngine game = new GameEngine();

        frame.setContentPane(game);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        game.startGame();
        System.out.println("at end of main\n");
    }
*/
}
