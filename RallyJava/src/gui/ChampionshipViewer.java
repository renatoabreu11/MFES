package gui;

import Rally.*;
import org.overture.codegen.runtime.MapUtil;
import org.overture.codegen.runtime.SetUtil;
import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSet;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChampionshipViewer {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;

    // Championship info
    private Championship championship;
    private JTextPane partnersTP;
    private JTextPane teamsTP;
    private JLabel dates;
    private JLabel name;
    private JButton updateRallyButton;
    private JButton startChampionshipButton;
    private JButton nextRallyButton;

    public ChampionshipViewer(MainWindow mainWindow) {
        this.parent = mainWindow;
        addListeners();
    }

    private void addListeners() {
        startChampionshipButton.addActionListener(e -> {
            championship.StartChampionship();
        });
        nextRallyButton.addActionListener(e -> {
            championship.NextRally();
        });
        updateRallyButton.addActionListener(e -> {
            VDMSet driversSet = championship.GetDrivers();
            VDMSet performancesSet = SetUtil.set();
            for (Object d: driversSet) {
                Performance p = new Performance((Driver) d);
                int avgSpeed = ThreadLocalRandom.current().nextInt(80, 140 + 1);
                int time = ThreadLocalRandom.current().nextInt(200, 1000 + 1);
                p.SetAverageSpeed(avgSpeed);
                p.SetTime(time);
                p.SetPenalty(0);
                performancesSet.add(p);
            }
            championship.UpdateCurrentRally(performancesSet);
        });
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

    public void setChampionship(Championship c){
        championship = c;
        name.setText(c.GetName() + " Championship");
        dates.setText("Starts at " + c.GetStartDate().toString() + " and ends " + c.GetEndDate().toString());
        StringBuilder sb = new StringBuilder();
        for (Object o : c.GetPartners()) {
            Partner elem = (Partner) o;
            sb.append(elem.toString()).append("\n");
        }
        partnersTP.setText(sb.toString());

        sb = new StringBuilder();
        VDMSet set = MapUtil.rng(Utils.copy(c.GetTeams()));
        for (Object aSet : set) {
            Team t = ((Team) aSet);
            sb.append(t.toString()).append("\n");
        }
        teamsTP.setText(sb.toString());
    }
}
