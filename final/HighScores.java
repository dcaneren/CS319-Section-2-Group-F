import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mambetova on 4/28/2017.
 */
public class HighScores extends JPanel {
    private Image background;
    private JPanel highScoresPanel;
    private JLabel name15Label;
    private JLabel score15Label;
    private JLabel highestScoresTitle;
    private JPanel scores;
    private JLabel score5Label;
    private JLabel score6Label;
    private JLabel score7Label;
    private JLabel score8Label;
    private JLabel score9Label;
    private JLabel score10Label;
    private JLabel score11Label;
    private JLabel score12Label;
    private JLabel score13Label;
    private JLabel score14Label;
    private JLabel score4Label;
    private JLabel score3Label;
    private JLabel score2Label;
    private JLabel score1Label;
    private JPanel names;
    private JLabel name1Label;
    private JLabel name2Label;
    private JLabel name3Label;
    private JLabel name4Label;
    private JLabel name5Label;
    private JLabel name6Label;
    private JLabel name7Label;
    private JLabel name8Label;
    private JLabel name9Label;
    private JLabel name10Label;
    private JLabel name11Label;
    private JLabel name12Label;
    private JLabel name13Label;
    private JLabel name14Label;
    private JPanel highScoresContent;
    private JButton backMainMenuButton;
    private JPanel footerPanel;
    private JPanel headerPanel;
    private JPanel midPanel;
    private Color buttonMouseOverColor = new Color (214, 214, 241);
    private Color buttonColor = new Color (159, 159, 159);



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public HighScores() {

        background = new ImageIcon(this.getClass().getResource("images/bkg.jpg")).getImage();

        setLayout(new BorderLayout ());

        highScoresPanel.setOpaque(false);
        highScoresContent.setOpaque(false);
        names.setOpaque(false);
        scores.setOpaque(false);
        footerPanel.setOpaque(false);
        headerPanel.setOpaque(false);
        midPanel.setOpaque(false);

        backMainMenuButton.setOpaque(false);
        backMainMenuButton.setForeground(Color.WHITE);

        add(highScoresPanel);

        // backMainMenuButton Listeners
        /*backMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Back to Main Menu!");
            }
        });*/
        backMainMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backMainMenuButton.setOpaque(true);
                backMainMenuButton.setForeground(Color.BLACK);
                backMainMenuButton.setBackground(buttonColor);
            }
        });
        backMainMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                backMainMenuButton.setOpaque(false);
                backMainMenuButton.setForeground(Color.WHITE);
            }
        });
    }

    public JButton getBack() {
        return backMainMenuButton;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
/*
    public static void main (String[] args){
        JFrame frame = new JFrame ("HighScores");
        frame.setContentPane( new HighScores());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setVisible(true);
    }*/
}
