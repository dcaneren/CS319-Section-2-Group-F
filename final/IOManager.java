/*
 * PanelRunning.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class IOManager implements ItemListener {
    private JPanel cards; //a panel that uses CardLayout

    private final static String MAINMENU = "MainMenu";
    private final static String SCORES = "Scores";
    private final static String HELP = "Help";
    private final static String CREDITS = "Credits";
    private final static String PAUSE = "PauseMenu";
    private final static String PROCESS = "Process";


    private MainMenu card1 = new MainMenu();
    private HighScores card2 = new HighScores();
    private Help card3 = new Help();
    private Credits card4 = new Credits();
    private GameProcess card5 = new GameProcess();
    private PauseMenu card6 = new PauseMenu();

    private Clip menuSound;
    private Clip playingSound;

    public void addComponentToPane(Container pane) {

        //Buttons
        JButton playButton = card1.getPlay();
        JButton scoresButton = card1.getHighScores();
        JButton helpButton = card1.getHelp();
        JButton creditsButton = card1.getCredits();
        JButton exit = card1.getExit();
        JButton backScores = card2.getBack();
        JButton backHelp = card3.getBack();
        JButton backCredits = card4.getBack();
        JButton pauseButton = card5.getPause();
        JButton continueButton = card6.getContinue();
        JButton quitGameButton = card6.getExit();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, MAINMENU);
        cards.add(card2, SCORES);
        cards.add(card3, HELP);
        cards.add(card4, CREDITS);
        cards.add(card5, PROCESS);
        cards.add (card6, PAUSE);

        pane.add(cards, BorderLayout.CENTER);

        // Background Music
        try{
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(
                            this.getClass().getResource("sounds/PlayingBackgroundLoop.wav"));
            menuSound = AudioSystem.getClip();
            menuSound.open(audioInputStream);
            menuSound.start();
            menuSound.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception ex)
        {
        }

        try{
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(
                            this.getClass().getResource("sounds/playing2.wav"));
            playingSound = AudioSystem.getClip();
            playingSound.open(audioInputStream);
        }
        catch(Exception ex)
        {
        }

        // BUTTON LISTENERS

        // In Main Menu
        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, PROCESS);
                buttonClickedSound ();
                menuSound.stop();
                playingSound.start();
                playingSound.loop(Clip.LOOP_CONTINUOUSLY);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        scoresButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SCORES);
                buttonClickedSound();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        helpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, HELP);
                buttonClickedSound ();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        creditsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREDITS);
                buttonClickedSound ();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonClickedSound ();
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        // Back to Main Menu
        backCredits.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, MAINMENU);
                buttonClickedSound ();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        backHelp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, MAINMENU);
                buttonClickedSound ();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        backScores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, MAINMENU);
                buttonClickedSound ();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        // In process
        pauseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, PAUSE);
                buttonClickedSound ();
                playingSound.stop();;
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        // In Pause Menu
        continueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, PROCESS);
                buttonClickedSound ();
                playingSound.start();
                playingSound.loop(Clip.LOOP_CONTINUOUSLY);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

        quitGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, MAINMENU);
                buttonClickedSound ();
                playingSound.stop();
                menuSound.start();
                menuSound.loop(Clip.LOOP_CONTINUOUSLY);

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonMouseOverSound ();
            }
        });

    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
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

    public void buttonMouseOverSound (){
        try{
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(
                            this.getClass().getResource("sounds/MouseOver.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Virus Attack");
        ImageIcon virusIcon = new ImageIcon("images/virusIcon.png");
        frame.setIconImage(virusIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        IOManager virusGUI = new IOManager();
        virusGUI.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
