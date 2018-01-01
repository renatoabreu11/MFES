package gui;

import javax.swing.*;
import java.awt.*;

public class MainOptions {
    private JPanel pane;
    private JButton championshipsButton;
    private JButton participantsButton;
    private JButton exitButton;

    public MainOptions() {
        addListeners();
    }

    private void addListeners() {
        exitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", null,
                    JOptionPane.YES_NO_OPTION);

            if(result == JOptionPane.YES_OPTION){
                Container frame = exitButton.getParent();
                do
                    frame = frame.getParent();
                while (!(frame instanceof JFrame));
                ((JFrame) frame).dispose();
                System.exit(0);
            }
        });
    }

    public void setVisible() {
        this.pane.setVisible(true);
    }

    public JPanel getPane() {
        return pane;
    }

    public JButton getChampionshipsButton() {
        return championshipsButton;
    }

    public JButton getParticipantsButton() {
        return participantsButton;
    }
}
