package gui;

import javax.swing.*;

public class ChampionshipManager {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JButton button3;
    private JTextPane textPane3;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField6;
    private JTextField textField7;
    private JButton button4;
    private JTextPane textPane4;

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
