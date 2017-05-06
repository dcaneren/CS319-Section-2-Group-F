import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Cholpon Mambetova on 4/28/2017.
 */
public class MainMenu extends JPanel {
    private Image background;
    private ImageIcon buttonBackground;
    private JPanel buttonPanel;
    private JButton startGameButton;
    private JButton viewHighScoresButton;
    private JButton helpButton;
    private JButton creditsButton;
    private JButton exitButton;
    private JTextPane virusTextPane;
    public JPanel mainMenuPanel;
    private JLabel virusLabel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel footerPanel;

    //private Color buttonMouseOverColor = new Color (0, 0, 0);
    private Color buttonMouseOverColor = new Color (214, 214, 241);
    private Color buttonColor = new Color (159, 159, 159);
    //private Color buttonColor = new Color (159, 159, 159);

   private void createUIComponents() {
        // TODO: place custom component creation code here
       /* mainMenuPanel = new JPanel();
        buttonPanel = new JPanel();
        startGameButton = new JButton();
        viewHighScoresButton = new JButton();
        helpButton = new JButton();
        creditsButton = new JButton();
        exitButton = new JButton();
        virusTextPane = new JTextPane();*/

    }




    public MainMenu() {

        background = new ImageIcon(this.getClass().getResource("images/bkg.jpg")).getImage();
        //Image imageBtn = new ImageIcon(this.getClass().getResource("images/btn3.png")).getImage();
        //buttonBackground = new ImageIcon(imageBtn);
        setLayout(new BorderLayout ());

        mainMenuPanel.setOpaque(false);

        virusLabel.setOpaque(false);
        buttonPanel.setOpaque(false);

        startGameButton.setOpaque(false);
        startGameButton.setForeground(Color.WHITE);

        viewHighScoresButton.setOpaque(false);
        viewHighScoresButton.setForeground(Color.WHITE);

        helpButton.setOpaque(false);
        helpButton.setForeground(Color.WHITE);

        creditsButton.setOpaque(false);
        creditsButton.setForeground(Color.WHITE);

        exitButton.setOpaque(false);
        exitButton.setForeground(Color.WHITE);

        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        footerPanel.setOpaque(false);

        add(mainMenuPanel);

       // startGameButton Listeners

        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startGameButton.setOpaque(true);
                startGameButton.setForeground(Color.BLACK);
                startGameButton.setBackground(buttonColor);
            }
        });
        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                startGameButton.setOpaque(false);
                startGameButton.setForeground(Color.WHITE);
                //startGameButton.setBackground(buttonColor);
            }
        });
        // viewHighScoresButton Listeners

        viewHighScoresButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                viewHighScoresButton.setOpaque(true);
                viewHighScoresButton.setForeground(Color.BLACK);
                viewHighScoresButton.setBackground(buttonColor);
            }
        });
        viewHighScoresButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                viewHighScoresButton.setOpaque(false);
                viewHighScoresButton.setForeground(Color.WHITE);
                //viewHighScoresButton.setBackground(buttonColor);
            }
        });

        // helpButton Listeners

        helpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                helpButton.setOpaque(true);
                helpButton.setForeground(Color.BLACK);
                helpButton.setBackground(buttonColor);
            }
        });
        helpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                helpButton.setOpaque(false);
                helpButton.setForeground(Color.WHITE);
                //helpButton.setBackground(buttonColor);
            }
        });

        // creditsButton Listeners

        creditsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                creditsButton.setOpaque(true);
                creditsButton.setForeground(Color.BLACK);
                creditsButton.setBackground(buttonColor);
            }
        });
        creditsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                creditsButton.setOpaque(false);
                creditsButton.setForeground(Color.WHITE);
                //creditsButton.setBackground(buttonColor);
            }
        });

        // exitButton Listeners
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setOpaque(true);
                exitButton.setForeground(Color.BLACK);
                exitButton.setBackground(buttonColor);
            }
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setOpaque(false);
                exitButton.setForeground(Color.WHITE);
                //exitButton.setBackground(buttonColor);
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    public JButton getPlay() {
        return startGameButton;
    }
    public JButton getHighScores() {
        return viewHighScoresButton;
    }
    public JButton getCredits() {return creditsButton;}
    public JButton getHelp() {
        return helpButton;
    }
    public JButton getExit() {
        return exitButton;
    }

/*
    public static void main (String[] args){
        JFrame frame = new JFrame ("MainMenu");
        frame.setContentPane( new MainMenu().mainMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setVisible(true);
    }
*/

}
