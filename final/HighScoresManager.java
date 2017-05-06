import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Can on 06/05/2017.
 */
public class HighScoresManager {
    private ArrayList<ScoreInstance> ScoreInstanceList;
    private File file = new File("ScoreInstances.txt");
    FileWriter writer = new FileWriter("output.txt");
    /*try{FileOutputStream fos = new FileOutputStream("ScoreInstances.tmp")}
    catch(java.io.FileNotFoundException){}*/

    public HighScoresManager() throws IOException {
        this.ScoreInstanceList = new ArrayList<ScoreInstance>();
    }

    public HighScoresManager(ArrayList<ScoreInstance> ScoreInstanceList) throws IOException {
        this.ScoreInstanceList = ScoreInstanceList;
    }

    public void addScoreInstance(ScoreInstance ScoreInstance){
        ScoreInstanceList.add(ScoreInstance);
        Collections.sort(ScoreInstanceList, new HighScoreComparator());
    }

    public void saveScoreInstances() {
        try {
            if(!file.exists())
                file.createNewFile();
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            for(ScoreInstance ScoreInstance : ScoreInstanceList){
                bw.append(ScoreInstance.getName() + " " + ScoreInstance.getScore());
                bw.append("\n");
            }
            bw.close();
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadScoreInstances(){
        Scanner s = null;
        try {
            s = new Scanner(new File("filepath"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
    }

    /*public static void main(String[] args){
        ArrayList<ScoreInstance> ScoreInstances = new ArrayList<>();
        ScoreInstancesManager hm = new ScoreInstancesManager(ScoreInstances);
        ScoreInstance score1 = new ScoreInstance(1200, "a");
        ScoreInstance score2 = new ScoreInstance(500, "b");
        ScoreInstance score3 = new ScoreInstance(2020, "c");
        hm.addScoreInstance(score1);
        hm.addScoreInstance(score2);
        hm.addScoreInstance(score3);
        hm.saveScoreInstances();
    }*/

}