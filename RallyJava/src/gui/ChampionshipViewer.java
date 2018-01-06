package gui;

import Rally.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

import javax.swing.*;
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
    private JTextPane globalInfoTP;
    private JTextPane ralliesInfoTP;

    public ChampionshipViewer(MainWindow mainWindow) {
        this.parent = mainWindow;
        addListeners();
    }

    private void addListeners() {
        startChampionshipButton.addActionListener(e -> {
            if(championship.GetTeams().isEmpty() || championship.GetDrivers().isEmpty() || championship.GetSeries().isEmpty())
                return;
            championship.StartChampionship();
            setGlobalInfo();
        });
        nextRallyButton.addActionListener(e -> {
            if(championship.IsCurrentRallyCompleted()) {
                championship.NextRally();
                setGlobalInfo();
                setRalliesInfo();
            }
        });
        updateRallyButton.addActionListener(e -> {
            if(championship.IsCurrentRallyCompleted())
                return;
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
            setGlobalInfo();
            setRalliesInfo();
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

    private void setGlobalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Championship: ").append(championship.GetName());

        if (!championship.GetState().equals(CompletedQuote.getInstance())) {
            sb.append("\nRally: ").append(championship.GetCurrentRally().GetName());
        } else sb.append("Championship completed!");

        if(!championship.IsCurrentRallyCompleted()){
            sb.append("\nStage: ").append(championship.GetCurrentRally().GetCurrentStage());
        } else sb.append("\nState: Completed").append("\nStart the next rally");

        Set teamNames = championship.GetTeams().keySet();
        boolean first = true;
        sb.append("\n\n\nTeam Global Rankings: {");
        for(Object tName: teamNames){
            if(first){
                sb.append(tName).append(" -> ").append(championship.GetTeamGlobalRanking((String) tName));
                first = false;
            } else sb.append(", ").append(tName).append(" -> ").append(championship.GetTeamGlobalRanking((String) tName));
        }
        sb.append("}\n");

        globalInfoTP.setText(sb.toString());
    }

    private void setRalliesInfo() {
        StringBuilder sb = new StringBuilder();
        boolean first;

        sb.append("Driver Rally and Stage Rankings:\n");
        VDMSet set_r = SeqUtil.inds(championship.GetSeries());
        for (Object aSet_r : set_r) {
            Rally rally = (Rally) Utils.get(championship.GetSeries(), aSet_r);
            sb.append("\t").append(rally.GetName()).append("\n");

            VDMSet set_s = SeqUtil.inds(rally.GetStages());
            for (Object set_ : set_s) {
                Stage stage = (Stage) Utils.get(rally.GetStages(), set_);
                sb.append("\t\t").append(stage.GetId()).append(" -> ").append("{");

                first = true;
                VDMSet set_p = SeqUtil.inds(stage.GetPerformances());
                for (Object aSet_p : set_p) {
                    Performance performance = (Performance) Utils.get(stage.GetPerformances(), aSet_p);
                    if (first) {
                        sb.append(performance.GetDriver().GetName()).append(" -> ").append(performance.GetTime());
                        first = false;
                    } else
                        sb.append(", ").append(performance.GetDriver().GetName()).append(" -> ").append(performance.GetTime());
                }
                sb.append("}\n\n");
            }
        }

        ralliesInfoTP.setText(sb.toString());
    }
}
