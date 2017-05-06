import java.awt.*;
import javax.swing.*;

/**
 * Created by Shiha on 12/14/2016.
 */
public class MainMenuPanel extends JPanel {
    Image background;
    private JButton play;
    private JButton settings;
    private JButton tutorial;
    private JButton hscores;
    private JButton credits;
    private JButton quit;
    //private GameEngine gm;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public MainMenuPanel() {
        setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
        background = new ImageIcon(this.getClass().getResource("images/Menu_main_no_buttons.png")).getImage();
        //this.gm = gm;
        //play
        play = new JButton();
        play.setOpaque(false);
        play.setBorderPainted(false);
        play.setContentAreaFilled(false);
        play.setIcon(new ImageIcon(this.getClass().getResource("images/play.png")));
        play.setRolloverIcon(new ImageIcon(this.getClass().getResource("images/play_hover.png")));
        play.setAlignmentX(Component.CENTER_ALIGNMENT);

        //settings
        settings = new JButton();
        settings.setIcon(new ImageIcon(this.getClass().getResource("images/settings_button.png")));
        settings.setOpaque(false);
        settings.setRolloverIcon(new ImageIcon(this.getClass().getResource("images/settings_button_hover.png")));
        settings.setBorderPainted(false);
        settings.setContentAreaFilled(false);
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        //tutorial
        tutorial = new JButton();
        tutorial.setIcon(new ImageIcon(this.getClass().getResource("images/tutorialbutton.png")));
        tutorial.setOpaque(false);
        tutorial.setRolloverIcon(new ImageIcon(this.getClass().getResource("images/tutorialbutton_hover.png")));
        tutorial.setBorderPainted(false);
        tutorial.setContentAreaFilled(false);
        tutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
        //highscores
        hscores = new JButton();
        hscores.setIcon(new ImageIcon(this.getClass().getResource("images/highscoresbutton.png")));
        hscores.setOpaque(false);
        hscores.setRolloverIcon(new ImageIcon(this.getClass().getResource("images/highscoresbutton_hover.png")));
        hscores.setBorderPainted(false);
        hscores.setContentAreaFilled(false);
        hscores.setAlignmentX(Component.CENTER_ALIGNMENT);
        //credits
        credits = new JButton();
        credits.setIcon(new ImageIcon(this.getClass().getResource("images/credits_button.png")));
        credits.setOpaque(false);
        credits.setRolloverIcon(new ImageIcon(this.getClass().getResource("images/credits_button_hover.png")));
        credits.setBorderPainted(false);
        credits.setContentAreaFilled(false);
        credits.setAlignmentX(Component.CENTER_ALIGNMENT);
        //quit
        quit = new JButton();
        quit.setIcon(new ImageIcon(this.getClass().getResource("images/quit_button.png")));
        quit.setOpaque(false);
        quit.setRolloverIcon(new ImageIcon(this.getClass().getResource("images/quit_button_hover.png")));
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add the buttons
        add(Box.createRigidArea(new Dimension(0,150)));
        add( play);
        add(Box.createRigidArea(new Dimension(0,15)));
        add( settings);
        add( tutorial);
        add( hscores);
        add( credits);
        add( quit);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
    public JButton getPlay() {
        return play;
    }
    public JButton getCredits() {return credits;}
    public JButton getHighScores() {
        return hscores;
    }
    public JButton getQuit() {
        return quit;
    }
    public JButton getTutorial() {
        return tutorial;
    }
    public JButton getSettings() {
        return settings;
    }

    public static void main (String[] args){
        JFrame frame = new JFrame ("MainMenuPanel");
        frame.setContentPane( new MainMenuPanel ());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(700,500);
        frame.pack();
        frame.setVisible(true);
    }
}