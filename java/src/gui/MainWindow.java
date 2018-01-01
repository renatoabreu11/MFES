package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private MainOptions mainOptions;
    private ParticipantsManager participantsManager;
    private ChampionshipManager championshipManager;
    private ChampionshipViewer championshipViewer;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainWindow frame = new MainWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainWindow() {
        setTitle("Rally Championships");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel(new CardLayout());
        setContentPane(contentPane);
        initialize();
        setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        mainOptions = new MainOptions();
        mainOptions.setVisible();

        participantsManager = new ParticipantsManager(this);
        participantsManager.setVisible();

        championshipManager = new ChampionshipManager(this);
        championshipManager.setVisible();

        championshipViewer = new ChampionshipViewer(this);
        championshipViewer.setVisible();

        contentPane.add(mainOptions.getPane(), "Main Options");
        contentPane.add(participantsManager.getPane(), "Participants Manager");
        contentPane.add(championshipManager.getPane(), "Championship Manager");
        contentPane.add(championshipViewer.getPane(), "Championship Viewer");

        addListeners();

        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Main Options");
    }

    private void addListeners(){
        mainOptions.getChampionshipsButton().addActionListener(e -> showLayout("Championship Manager"));
        mainOptions.getParticipantsButton().addActionListener(e -> showLayout("Participants Manager"));
        participantsManager.getBackButton().addActionListener(e -> showLayout("Main Options"));
        championshipManager.getBackButton().addActionListener(e -> showLayout("Main Options"));
    }

    public void showLayout(String layout){
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, layout);
    }
}