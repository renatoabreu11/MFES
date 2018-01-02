package gui;

import Rally.*;
import Rally.quotes.*;

import javax.swing.*;
import java.util.ArrayList;

public class ChampionshipManager {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;

    // Stage
    private JSpinner stageId;
    private JSpinner stageDistance;
    private JTextField stageDate;
    private JComboBox<Object> stageType;
    private JButton addStageButton;
    private JTextPane stagesTP;

    // Partner
    private JButton addPartnerButton;
    private JTextField partnerName;
    private JTextField partnerDescription;
    private JTextPane partnersTP;

    // Rally
    private JButton addRallyButton;
    private JTextPane ralliesTP;
    private JTextField rallyName;
    private JTextField rallyDescription;
    private JComboBox<Object> rallyCountry;
    private JComboBox<Object> rallySurface;
    private JTextField rallyStartDate;
    private JTextField rallyEndDate;

    // Championship
    private JButton addChampionshipButton;
    private JTextPane championshipsTP;
    private JTextField championshipName;
    private JTextField championshipStartDate;
    private JTextField championshipEndDate;
    private JComboBox<String> championshipPicker;

    // Rally - Stage
    private JComboBox<String> rallyPicker;
    private JButton addStageToRallyButton;
    private JComboBox<Object> rallyStagePicker;

    // Partner - Championship
    private JComboBox<String> championshipPartnerPicker;
    private JButton removePartnerFromChampionshipButton;
    private JButton addPartnerToChampionshipButton;

    // Team - Championship
    private JComboBox championshipTeamPicker;
    private JButton addTeamToChampionshipButton;
    private JButton removeTeamFromChampionshipButton;

    // Rally - Championship
    private JComboBox<String> championshipRallyPicker;
    private JButton addRallyToChampionshipButton;

    private ArrayList<Partner> partners = new ArrayList<>();
    private ArrayList<Stage> stages = new ArrayList<>();
    private ArrayList<Rally> rallies = new ArrayList<>();
    private ArrayList<Championship> championships = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();

    ChampionshipManager(MainWindow mainWindow) {
        this.parent = mainWindow;
        teams = parent.GetParticipants();
        stageDate.setText("2017-10-01");
        rallyStartDate.setText("2017-10-01");
        rallyEndDate.setText("2017-10-01");
        championshipStartDate.setText("2017-10-01");
        championshipEndDate.setText("2017-10-01");
        stageType.addItem(SpecialQuote.getInstance());
        stageType.addItem(TransportQuote.getInstance());
        rallySurface.addItem(AsphaltQuote.getInstance());
        rallySurface.addItem(ForestQuote.getInstance());
        rallySurface.addItem(GravelQuote.getInstance());
        rallySurface.addItem(MountainQuote.getInstance());
        rallySurface.addItem(SandQuote.getInstance());
        rallySurface.addItem(SnowQuote.getInstance());
        rallyCountry.addItem(GermanyQuote.getInstance());
        rallyCountry.addItem(GreatBritainQuote.getInstance());
        rallyCountry.addItem(ItalyQuote.getInstance());
        rallyCountry.addItem(JapanQuote.getInstance());
        rallyCountry.addItem(FranceQuote.getInstance());
        rallyCountry.addItem(PortugalQuote.getInstance());
        rallyCountry.addItem(SouthKoreaQuote.getInstance());
        rallyCountry.addItem(SpainQuote.getInstance());
        addListeners();
    }

    private void addListeners() {
        addStageButton.addActionListener(e -> {
            String date = stageDate.getText();
            String[] values = date.split("-");
            stages.add(new Stage((int) stageId.getValue(), stageType.getSelectedItem(), DateUtils.MakeDate(Integer.valueOf(values[0]), Integer.valueOf(values[1]), Integer.valueOf(values[2])), (int)stageDistance.getValue()));
            setStagesArea();
            rallyStagePicker.addItem(stageId.getValue());
        });
        addPartnerButton.addActionListener(e -> {
            partners.add(new Partner(partnerName.getText(), partnerDescription.getText()));
            setPartnersArea();
            championshipPartnerPicker.addItem(partnerName.getText());
        });
        addRallyButton.addActionListener(e -> {
            String startDate = rallyStartDate.getText();
            String endDate = rallyEndDate.getText();
            String[] startValues = startDate.split("-");
            String[] endValues = endDate.split("-");
            rallies.add(new Rally(rallyName.getText(),
                    rallyDescription.getText(),
                    rallyCountry.getSelectedItem(),
                    rallySurface.getSelectedItem(),
                    DateUtils.MakeDate(Integer.valueOf(startValues[0]), Integer.valueOf(startValues[1]), Integer.valueOf(startValues[2])),
                    DateUtils.MakeDate(Integer.valueOf(endValues[0]), Integer.valueOf(endValues[1]), Integer.valueOf(endValues[2]))));
            setRalliesArea();
            rallyPicker.addItem(rallyName.getText());
            championshipRallyPicker.addItem(rallyName.getText());
        });
        addChampionshipButton.addActionListener(e -> {
            String startDate = championshipStartDate.getText();
            String endDate = championshipEndDate.getText();
            String[] startValues = startDate.split("-");
            String[] endValues = endDate.split("-");
            championships.add(new Championship(championshipName.getText(),
                    DateUtils.MakeDate(Integer.valueOf(startValues[0]), Integer.valueOf(startValues[1]), Integer.valueOf(startValues[2])),
                    DateUtils.MakeDate(Integer.valueOf(endValues[0]), Integer.valueOf(endValues[1]), Integer.valueOf(endValues[2]))));
            setChampionshipsArea();
            championshipPicker.addItem(championshipName.getText());
        });

        addStageToRallyButton.addActionListener(e -> {
            int stageId = (int) rallyStagePicker.getSelectedItem();
            Stage s = findStage(stageId);

            if(s != null) {
                Integer rallyIndex = rallyPicker.getSelectedIndex();
                rallies.get(rallyIndex).AddStage(s);
                setRalliesArea();
            }
        });
        addPartnerToChampionshipButton.addActionListener(e -> {
            String partnerName = (String) championshipPartnerPicker.getSelectedItem();
            Partner p = findPartner(partnerName);

            if(p != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).AddPartner(p);
                setChampionshipsArea();
            }
        });
        removePartnerFromChampionshipButton.addActionListener(e -> {
            String partnerName = (String) championshipPartnerPicker.getSelectedItem();
            Partner p = findPartner(partnerName);

            if(p != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).RemovePartner(p);
                setChampionshipsArea();
            }
        });
        addRallyToChampionshipButton.addActionListener(e -> {
            String rallyName = (String) championshipRallyPicker.getSelectedItem();
            Rally r = findRally(rallyName);

            if(r != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).AddRally(r);
                setChampionshipsArea();
            }
        });
        addTeamToChampionshipButton.addActionListener(e -> {
            String teamName = (String) championshipTeamPicker.getSelectedItem();
            Team t = findTeam(teamName);

            if(t != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).AddTeam(t);
                setChampionshipsArea();
            }
        });
        removeTeamFromChampionshipButton.addActionListener(e -> {
            String teamName = (String) championshipTeamPicker.getSelectedItem();
            Team t = findTeam(teamName);

            if(t != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).RemoveTeam(t);
                setChampionshipsArea();
            }
        });
    }

    private void setChampionshipsArea() {
        StringBuilder sb = new StringBuilder();
        for (Championship c: championships) {
            sb.append(c.toString()).append("\n");
        }
        championshipsTP.setText(sb.toString());
    }

    private void setRalliesArea(){
        StringBuilder sb = new StringBuilder();
        for (Rally r: rallies) {
            sb.append(r.toString()).append("\n");
        }
        ralliesTP.setText(sb.toString());
    }

    private void setStagesArea() {
        StringBuilder sb = new StringBuilder();
        for (Stage s: stages) {
            sb.append(s.toString()).append("\n");
        }
        stagesTP.setText(sb.toString());
    }

    private void setPartnersArea(){
        StringBuilder sb = new StringBuilder();
        for (Partner p: partners) {
            sb.append(p.toString()).append("\n");
        }
        partnersTP.setText(sb.toString());
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

    private Stage findStage(int id) {
        return stages.stream()
                .filter(obj -> obj.GetId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Partner findPartner(String partnerName) {
        return partners.stream()
                .filter(obj -> obj.GetName().equals(partnerName))
                .findFirst()
                .orElse(null);
    }

    private Rally findRally(String rallyName) {
        return rallies.stream()
                .filter(obj -> obj.GetName().equals(rallyName))
                .findFirst()
                .orElse(null);
    }

    private Team findTeam(String teamName) {
        return teams.stream()
                .filter(obj -> obj.GetName().equals(teamName))
                .findFirst()
                .orElse(null);
    }
}
