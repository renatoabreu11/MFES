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
    private JComboBox<String> championshipTeamPicker;
    private JButton addTeamToChampionshipButton;
    private JButton removeTeamFromChampionshipButton;

    // Rally - Championship
    private JComboBox<String> championshipRallyPicker;
    private JButton addRallyToChampionshipButton;
    private JButton viewChampionshipButton;

    private ArrayList<Partner> partners = new ArrayList<>();
    private ArrayList<Stage> stages = new ArrayList<>();
    private ArrayList<Rally> rallies = new ArrayList<>();
    private ArrayList<Championship> championships = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();

    ChampionshipManager(MainWindow mainWindow) {
        this.parent = mainWindow;
        initTeams();
        initPartners();
        initStages();
        initRallies();
        initChampionships();
        addListeners();
    }

    private void initChampionships() {
        championships.add(new Championship("WRC", DateUtils.MakeDate(2017L, 10L, 1L), DateUtils.MakeDate(2017L, 12L, 18L)));
        setChampionshipsArea();
        championshipPicker.addItem("WRC");
        championshipStartDate.setText("2017-10-01");
        championshipEndDate.setText("2017-12-18");
    }

    private void initStages() {
        stageDate.setText("2017-10-03");
        stageType.addItem(SpecialQuote.getInstance());
        stageType.addItem(TransportQuote.getInstance());

        stages.add(new Stage(
                1L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 5L), 10L));
        stages.add(new Stage(
                2L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 7L), 50L));
        stages.add(new Stage(
                3L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 8L), 3L));
        stages.add(new Stage(
                4L, TransportQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 9L), 100L));
        stages.add(new Stage(
                5L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 11L), 10L));
        stages.add(new Stage(
                6L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 11L, 5L), 50L));
        stages.add(new Stage(
                7L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 11L, 6L), 3L));
        stages.add(new Stage(
                8L, TransportQuote.getInstance(), DateUtils.MakeDate(2017L, 11L, 7L), 100L));
        stages.add(new Stage(
                9L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 11L, 9L), 10L));
        stages.add(new Stage(
                10L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 14L), 50L));
        stages.add(new Stage(
                11L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 15L), 3L));
        stages.add(new Stage(
                12L, TransportQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 16L), 100L));

        setStagesArea();
        stages.forEach(s -> rallyStagePicker.addItem(s.GetId()));
    }

    private void initRallies() {
        rallyStartDate.setText("2017-10-03");
        rallyEndDate.setText("2017-10-08");
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

        rallies.add(new Rally("Rallye Monte-Carlo",
                "The Monte Carlo Rally or Rallye Monte Carlo is a rallying event organised each year by the Automobile Club de Monaco.",
                FranceQuote.getInstance(),
                AsphaltQuote.getInstance(),
                DateUtils.MakeDate(2017L, 10L, 4L),
                DateUtils.MakeDate(2017L, 10L, 12L)));
        rallies.add(new Rally("Vodafone Rally de Portugal",
                "O Rali de Portugal é a maior prova de desporto motorizado que se realiza em Portugal anualmente.",
                PortugalQuote.getInstance(),
                GravelQuote.getInstance(),
                DateUtils.MakeDate(2017L, 11L, 4L),
                DateUtils.MakeDate(2017L, 11L, 10L)));
        rallies.add(new Rally("Rally Italia Sardegna",
                "Held on the beautiful island of Sardinia, Rally Italy – or Rally Italia Sardegna to give it its full name – is a notoriously tricky event.",
                ItalyQuote.getInstance(),
                MountainQuote.getInstance(),
                DateUtils.MakeDate(2017L, 12L, 13L),
                DateUtils.MakeDate(2017L, 12L, 17L)));

        setRalliesArea();
        rallyPicker.addItem("Rallye Monte-Carlo");
        rallyPicker.addItem("Vodafone Rally de Portugal");
        rallyPicker.addItem("Rally Italia Sardegna");
        championshipRallyPicker.addItem("Rallye Monte-Carlo");
        championshipRallyPicker.addItem("Vodafone Rally de Portugal");
        championshipRallyPicker.addItem("Rally Italia Sardegna");
    }

    private void initPartners() {
        partners.add(new Partner(
                "Michelin",
                "Michelin, the leading tire company, is dedicated to enhancing its clients’ mobility, sustainably; designing and distributing the most suitable tires, services and solutions for its clients’ needs."));
        partners.add(new Partner(
                "Certina",
                "Precision, reliability, innovation and dynamism. These are the values that have always linked Certina to sport."));
        partners.add(new Partner(
                "OneBet",
                "OneBet is the official sports betting partner of the FIA World Rally Championship, providing spectacular opportunities to boost the rush and experience of WRC."));

        setPartnersArea();
        championshipPartnerPicker.addItem("Michelin");
        championshipPartnerPicker.addItem("Certina");
        championshipPartnerPicker.addItem("OneBet");
    }

    private void initTeams() {
        teams = parent.GetParticipants();
        teams.forEach(t -> championshipTeamPicker.addItem(t.GetName()));
    }

    private void addListeners() {
        viewChampionshipButton.addActionListener(e -> {
            if(championshipPicker.getSelectedItem() != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                parent.getChampionshipViewer().setChampionship(championships.get(champIndex));
                parent.showLayout("Championship Viewer");
            }
        });
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
            long stageId = (long) rallyStagePicker.getSelectedItem();
            Stage s = findStage(stageId);

            if(s != null && rallyPicker.getSelectedItem() != null) {
                Integer rallyIndex = rallyPicker.getSelectedIndex();
                rallies.get(rallyIndex).AddStage(s);
                setRalliesArea();
            }
        });
        addPartnerToChampionshipButton.addActionListener(e -> {
            String partnerName = (String) championshipPartnerPicker.getSelectedItem();
            Partner p = findPartner(partnerName);

            if(p != null && championshipPicker.getSelectedItem() != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).AddPartner(p);
                setChampionshipsArea();
            }
        });
        removePartnerFromChampionshipButton.addActionListener(e -> {
            if(championshipPicker.getSelectedItem() == null)
                return;
            String partnerName = (String) championshipPartnerPicker.getSelectedItem();
            Partner p = findPartner(partnerName);

            if(p != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).RemovePartner(p);
                setChampionshipsArea();
            }
        });
        addRallyToChampionshipButton.addActionListener(e -> {
            if(championshipPicker.getSelectedItem() == null)
                return;
            String rallyName = (String) championshipRallyPicker.getSelectedItem();
            Rally r = findRally(rallyName);

            if(r != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).AddRally(r);
                setChampionshipsArea();
            }
        });
        addTeamToChampionshipButton.addActionListener(e -> {
            if(championshipPicker.getSelectedItem() == null)
                return;
            String teamName = (String) championshipTeamPicker.getSelectedItem();
            Team t = findTeam(teamName);

            if(t != null) {
                Integer champIndex = championshipPicker.getSelectedIndex();
                championships.get(champIndex).AddTeam(t);
                setChampionshipsArea();
            }
        });
        removeTeamFromChampionshipButton.addActionListener(e -> {
            if(championshipPicker.getSelectedItem() == null)
                return;
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

    private Stage findStage(long id) {
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
