package gui;

import Rally.*;
import org.overture.codegen.runtime.*;
import sun.misc.Perf;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
    private JTextPane ralliesTP;

    public ChampionshipViewer(MainWindow mainWindow) {
        this.parent = mainWindow;
        addListeners();
    }

    private void addListeners() {
        startChampionshipButton.addActionListener(e -> {
            championship.StartChampionship();
            setRalliesArea();
        });
        nextRallyButton.addActionListener(e -> {
            championship.NextRally();
            setRalliesArea();
            setTeamsArea();
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
            setRalliesArea();
            setTeamsArea();
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

    private void setRalliesArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Championship: ").append(championship.GetName()).append("\nRally: ").append(championship.GetCurrentRally().GetName()).append("\nStage: ").append(championship.GetCurrentRally().GetCurrentStage()).append("\n");
        ralliesTP.setText(sb.toString());
    }

    private void setTeamsArea() {
        StringBuilder sb = new StringBuilder();
        Set<String> teamNames = championship.GetTeams().keySet();

        boolean first = true;
        sb.append("Team Global Rankings: {");
        for(String tName: teamNames){
            if(first){
                sb.append(tName).append(" -> ").append(championship.GetTeamGlobalRanking(tName));
                first = false;
            } else sb.append(", ").append(tName).append(" -> ").append(championship.GetTeamGlobalRanking(tName));
        }
        sb.append("}\n");

        sb.append("\nDriver Rally and Stage Rankings:\n");
        VDMSet set_r = SeqUtil.inds(championship.GetSeries());
        for (Iterator iterator_r = set_r.iterator(); iterator_r.hasNext(); ) {
            Rally rally = (Rally) Utils.get(championship.GetSeries(), iterator_r.next());
            sb.append("\t").append(rally.GetName()).append("\n");

            VDMSet set_s = SeqUtil.inds(rally.GetStages());
            for(Iterator iterator_s = set_s.iterator(); iterator_s.hasNext(); ){
                Stage stage = (Stage) Utils.get(rally.GetStages(), iterator_s.next());
                sb.append("\t\t").append(stage.GetId()).append(" -> ").append("{");

                first = true;
                VDMSet set_p = SeqUtil.inds(stage.GetPerformances());
                for(Iterator iterator_p = set_p.iterator(); iterator_p.hasNext(); ){
                    Performance performance = (Performance) Utils.get(stage.GetPerformances(), iterator_p.next());
                    if(first) {
                        sb.append(performance.GetDriver().GetName()).append(" -> ").append(performance.GetAverageSpeed());
                        first=false;
                    }
                    else sb.append(", ").append(performance.GetDriver().GetName()).append(" -> ").append(performance.GetAverageSpeed());
                }
                sb.append("}\n");
            }
        }

        teamsTP.setText(sb.toString());
    }
}
