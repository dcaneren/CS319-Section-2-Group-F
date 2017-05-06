import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mambetova on 4/28/2017.
 */
public class Credits extends JPanel {
    private Image background;
    //private JLabel highestScoresTitle;
    private JPanel headerPanel;
    private JPanel creditsContentPanel;
    //private JLabel helpContent;
    private JButton backMainMenuButton;
    public JPanel creditsPanel;
    private JPanel footerPanel;
    private JLabel creditsContent;
    private JLabel creditsTitle;
    private Color buttonMouseOverColor = new Color (214, 214, 241);
    private Color buttonColor = new Color (159, 159, 159);

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
    public Credits() {
        background = new ImageIcon(this.getClass().getResource("images/bkg.jpg")).getImage();

        setLayout(new BorderLayout ());

        creditsPanel.setOpaque(false);
        creditsTitle.setOpaque(false);
        headerPanel.setOpaque(false);
        creditsContentPanel.setOpaque(false);
        creditsContent.setOpaque(false);
        //creditsContent.setSize(350, 300);
        footerPanel.setOpaque(false);



        backMainMenuButton.setOpaque(false);
        backMainMenuButton.setForeground(Color.WHITE);
        //backMainMenuButton.setBackground(buttonMouseOverColor);

        add(creditsPanel);

        // backMainMenuButton Listeners
       /* backMainMenuButton.addActionListener(new ActionListener() {
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
}
