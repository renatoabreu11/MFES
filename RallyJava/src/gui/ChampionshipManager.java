package gui;

import javax.swing.*;

public class ChampionshipManager {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;

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
