package gui;

import javax.swing.*;

public class ParticipantsManager {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;

    public ParticipantsManager(MainWindow mainWindow) {
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
