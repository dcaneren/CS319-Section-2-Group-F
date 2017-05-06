import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mambetova on 4/28/2017.
 */
public class PauseMenu extends JPanel {
    private Image background;
    private JPanel pauseMenuPanel;
    private JPanel buttonPanel;
    private JButton exitGameButton;
    private JButton continueButton;
    private JLabel pauseMenuTitle;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel upMidPanel;
    private JPanel midMidPanel;
    private JPanel lowMidPanel;

    private Color buttonBackgroundColor = new Color (214, 214, 241);
    private Color buttonMouseOverColor = new Color (114, 114, 141);
    private Color buttonColor = new Color (255, 255, 255);

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public PauseMenu() {

        background = new ImageIcon(this.getClass().getResource("images/pause2.jpg")).getImage();

        setLayout(new BorderLayout ());

        pauseMenuPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        continueButton.setOpaque(false);
        continueButton.setForeground(Color.darkGray);

        exitGameButton.setOpaque(false);
        exitGameButton.setForeground(Color.darkGray);

        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        upMidPanel.setOpaque(false);
        midMidPanel.setOpaque(false);
        lowMidPanel.setOpaque(false);

        add(pauseMenuPanel);

        // continueButton Listeners

        continueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                continueButton.setOpaque(true);
                continueButton.setForeground(Color.BLACK);
                continueButton.setBackground(buttonBackgroundColor);
            }
        });
        continueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                continueButton.setOpaque(false);
                continueButton.setForeground(Color.darkGray);
                //continueButton.setBackground(buttonColor);
            }
        });

        // exitGameButton Listeners

        exitGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitGameButton.setOpaque(true);
                exitGameButton.setForeground(Color.BLACK);
                exitGameButton.setBackground(buttonBackgroundColor);
            }
        });
        exitGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                exitGameButton.setOpaque(false);
                exitGameButton.setForeground(Color.darkGray);
                //exitGameButton.setBackground(buttonColor);
            }
        });
    }
    public JButton getContinue() {
        return continueButton;
    }
    public JButton getExit() {
        return exitGameButton;
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    public static void main (String[] args){
        JFrame frame = new JFrame ("PauseMenu");
        frame.setContentPane( new PauseMenu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setVisible(true);
    }
}
