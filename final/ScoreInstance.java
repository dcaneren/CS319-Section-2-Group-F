
import java.util.Comparator;

/**
 * Created by Can on 06/05/2017.
 */
public class ScoreInstance {
    private int score;
    private String name;

    public ScoreInstance(int score, String name){
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@Override
    public int compareTo(HighScore highScore) {
        int compareScore = highScore.getScore();
        return compareScore - this.getScore();
    }

    @Override
    public String toString(){
        return "[ score: " + getScore() + ", name: " + getName();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }*/

}
