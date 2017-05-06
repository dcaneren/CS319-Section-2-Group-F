import java.util.Comparator;

/**
 * Created by Can on 06/05/2017.
 */
public class HighScoreComparator implements Comparator<ScoreInstance> {
    public int compare(ScoreInstance h1, ScoreInstance h2){
        return h2.getScore() - h1.getScore();
    }
}
