package gui;

import javax.swing.*;

public class ChampionshipManager {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;
    private JSpinner stageId;
    private JSpinner stageDistance;
    private JTextField stageDate;
    private JComboBox stageType;
    private JButton addStageButton;
    private JButton addPartnerButton;
    private JTextField partnerName;
    private JTextField partnerDescription;
    private JTextPane stagesTP;
    private JTextPane partnersTP;
    private JButton addRallyButton;
    private JTextPane ralliesTP;
    private JTextField rallyName;
    private JTextField rallyDescription;
    private JComboBox rallyCountry;
    private JComboBox rallySurface;
    private JTextField rallyStartDate;
    private JTextField rallyEndDate;
    private JButton addChampionshipButton;
    private JTextPane championshipsTP;
    private JTextField championshipName;
    private JTextField championshipStartDate;
    private JTextField championshipEndDate;
    private JComboBox rallyStage;
    private JButton addStageToRallyButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton addTeamToChampionshipButton;
    private JButton addRallyToChampionshipButton;
    private JButton addPartnerToChampionshipButton;
    private JComboBox comboBox4;
    private JComboBox comboBox5;

    public ChampionshipManager(MainWindow mainWindow) {
        this.parent = mainWindow;
        addListeners();
    }

    private void addListeners() {

    }

    public void setVisible() {
        this.pane.setVisible(true);
    }

    public JPanel getPane() {
        return pane;
    }

    public JButton getBackButton() {
        return backButton;
    }

}
