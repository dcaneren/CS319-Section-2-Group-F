import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mambetova on 4/28/2017.
 */
public class Help extends JPanel{
    private Image background;
    private JPanel helpPanel;
    private JButton backMainMenuButton;
    private JPanel helpContentPanel;
    private JPanel headerPanel;
    private JPanel footerPanel;
    private JLabel helpTitle;
    private JLabel helpContent;
    private JLabel description;
    private JLabel howToPlayTitle;
    private JLabel descriptionTitle;
    private Color buttonMouseOverColor = new Color (214, 214, 241);
    private Color buttonColor = new Color (159, 159, 159);

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public Help() {
        background = new ImageIcon(this.getClass().getResource("images/bkg.jpg")).getImage();

        setLayout(new BorderLayout ());

        helpPanel.setOpaque(false);
        helpContentPanel.setOpaque(false);
        headerPanel.setOpaque(false);
        footerPanel.setOpaque(false);

        backMainMenuButton.setOpaque(false);
        backMainMenuButton.setForeground(Color.WHITE);

        add(helpPanel);

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
        JFrame frame = new JFrame ("Help");
        frame.setContentPane( new Help());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setVisible(true);
    }*/
}
