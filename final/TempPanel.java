import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mambetova on 5/6/2017.
 */
public class TempPanel extends JPanel implements KeyListener{
    private Color color1 = new Color (150, 0 ,0);
    private Color color2 = new Color (0, 150 ,0);
    private JButton start;
    private JButton pause;
    private JButton col1;
    private JButton col2;
    private boolean running;

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_SPACE: //virus.setVelX(0);
                //virus.setVelY(-5);
                //System.out.println("UP\n");
                setBackground(Color.blue);
                break;

            case KeyEvent.VK_ESCAPE:
                System.exit(1);

            default:
                ;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public TempPanel() {
        setFocusable(true);
        requestFocus();
        setBackground(color1);
        setPreferredSize(new Dimension(500,500));
        start = new JButton("Start");
        pause = new JButton("Pause");
        col1 = new JButton("Color 1");
        col2 = new JButton("Color 2");
        add (start);
        add (pause);
        add (col1);
        add (col2);
        running = false;
        //running = true;
        //start();

        col1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonClickedSound();
                setBackground(color1);
            }
        });

        col2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonClickedSound();
                setBackground(color2);
            }
        });

        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonClickedSound();
                running = true;
                start();
            }
        });
        pause.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonClickedSound();
                stop();
            }
        });

    }

    public void buttonClickedSound (){
        try{
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(
                            this.getClass().getResource("sounds/click2.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
        }
    }

    public void start (){
        //running = true;
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                    if (getBackground() == color1)
                        setBackground(color2);
                    if (getBackground() == color2)
                        setBackground(color1);
                }
            });
        }
    }

    public void stop (){
        running = false;
    }


}
