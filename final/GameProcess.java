import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mambetova on 4/28/2017.
 */
public class GameProcess extends JPanel{
    private Image background;
    private JPanel gameProcessPanel;
    private JPanel middlePanel;
    private JPanel processPanel;
    private JButton pauseGameButton;

    private JPanel headerPanel;
    private JLabel virusLabel;
    private JPanel buttonPanel;
    private JPanel footerPanel;
    private GameEngine game;
    private TempPanel tempPanel;
    private Color buttonMouseOverColor = new Color (214, 214, 241);
    private Color buttonColor = new Color (159, 159, 159);


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public GameProcess() {
        background = new ImageIcon(this.getClass().getResource("images/process1.jpg")).getImage();

        setLayout(new BorderLayout ());

        gameProcessPanel.setOpaque(false);

        middlePanel.setOpaque(false);

        pauseGameButton.setOpaque(true);
        pauseGameButton.setForeground(Color.BLACK);
        pauseGameButton.setBackground(buttonMouseOverColor);

        buttonPanel.setOpaque(false);
        headerPanel.setOpaque(false);
        footerPanel.setOpaque(false);

        processPanel.setOpaque(true);

        add(gameProcessPanel);

        // pause menu
        pauseGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //pauseGameButton.setOpaque(true);
                pauseGameButton.setForeground(Color.BLACK);
                pauseGameButton.setBackground(buttonColor);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                //pauseGameButton.setOpaque(false);
                pauseGameButton.setForeground(Color.BLACK);
                pauseGameButton.setBackground(buttonMouseOverColor);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonClickedSound();
                game.pauseGame();
            }
        });

    }
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                game.startGame();
            }
        });
    }
    public JButton getPause() {
        return pauseGameButton;
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
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

    public static void main (String[] args){
        JFrame frame = new JFrame ("Game Process");
        final GameProcess game1 = new GameProcess();
        frame.setContentPane( game1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game1.setFocusable(true);
        game1.requestFocus();
        game1.start();

    }

}
