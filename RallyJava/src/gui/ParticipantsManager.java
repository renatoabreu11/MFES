package gui;

import Rally.*;
import Rally.quotes.*;

import javax.swing.*;
import java.util.ArrayList;

public class ParticipantsManager {
    private MainWindow parent;
    private JPanel pane;
    private JButton backButton;

    // Sponsor
    private JButton addSponsorButton;
    private JTextField sponsorDescription;
    private JTextField sponsorName;
    private JTextPane sponsorsTP;

    // Manufacturer
    private JTextField manufacturerDescription;
    private JTextField manufacturerName;
    private JComboBox<Object> manufacturerCountry;
    private JTextPane manufacturersTP;
    private JButton addManufacturerButton;

    // Car
    private JButton addCarButton;
    private JTextField carModel;
    private JSlider carHorsePower;
    private JComboBox<String> carManufacturer;
    private JTextPane carsTP;
    private JSlider carWeight;

    // Driver
    private JButton addDriverButton;
    private JTextField driverName;
    private JComboBox<Object> driverGender;
    private JComboBox<Object> driverNationality;
    private JTextField driverBirth;
    private JTextPane driversTP;

    // Team
    private JButton addTeamButton;
    private JTextPane teamsTP;
    private JTextField teamName;
    private JComboBox<Object> teamBased;
    private JComboBox<String> teamSponsors;

    // Team objects
    private JComboBox<String> teamPicker;
    private JComboBox<String> teamBacker;
    private JButton removeTeamBackerButton;
    private JButton addTeamBackerButton;
    private JButton addTeamSponsorButton;
    private JButton removeTeamSponsorButton;
    private JButton addTeamCarButton;
    private JButton removeTeamCarButton;
    private JButton addTeamDriverButton;
    private JButton removeTeamDriverButton;
    private JComboBox<String> teamCars;
    private JComboBox<String> teamDrivers;
    private JButton assignCarToDriverButton;
    private JButton unassignCarFromDriverButton;
    private JComboBox<String> teamAssignDriver;
    private JComboBox<String> teamAssignCar;

    private ArrayList<Sponsor> sponsors = new ArrayList<>();
    private ArrayList<Manufacturer> manufacturers = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();

    ParticipantsManager(MainWindow mainWindow) {
        this.parent = mainWindow;
        initSponsors();
        initManufacturers();
        initCars();
        carManufacturer.addItem("None");
        initDrivers();
        initTeams();

        addListeners();
    }

    private void addListeners() {
        addSponsorButton.addActionListener(e -> {
            sponsors.add(new Sponsor(sponsorName.getText(), sponsorDescription.getText()));
            setSponsorsArea();
            teamSponsors.addItem(sponsorName.getText());
        });

        addManufacturerButton.addActionListener(e -> {
            manufacturers.add(new Manufacturer(manufacturerName.getText(), manufacturerDescription.getText(), manufacturerCountry.getSelectedItem()));
            setManufacturersArea();
            carManufacturer.addItem(manufacturerName.getText());
            teamBacker.addItem(manufacturerName.getText());
        });

        addTeamBackerButton.addActionListener(e -> {
            String manName = (String) teamBacker.getSelectedItem();
            Manufacturer m = findManufacturer(manName);

            if(m == null || teamPicker.getSelectedItem() == null)
                return;
            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).SetBacker(m);
            setTeamsArea();
        });

        removeTeamBackerButton.addActionListener(e -> {
            if(teamPicker.getSelectedItem() == null)
                return;
            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).RemoveBacker();
            setTeamsArea();
        });

        addTeamSponsorButton.addActionListener(e -> {
            String sponsorName = (String) teamSponsors.getSelectedItem();
            Sponsor s = findSponsor(sponsorName);

            if(teamPicker.getSelectedItem() == null)
                return;
            if(s != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).AddSponsor(s);
                setTeamsArea();
            }
        });

        removeTeamSponsorButton.addActionListener(e -> {
            String sponsorName = (String) teamSponsors.getSelectedItem();
            Sponsor s = findSponsor(sponsorName);

            if(teamPicker.getSelectedItem() == null)
                return;
            if(s != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).RemoveSponsor(s);
                setTeamsArea();
            }
        });

        addTeamCarButton.addActionListener(e -> {
            String carName = (String) teamCars.getSelectedItem();
            Car c = findCar(carName);

            if(teamPicker.getSelectedItem() == null)
                return;
            if(c != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).AddCar(c);
                setTeamsArea();
                teamAssignCar.addItem(c.GetModel());
            }
        });

        removeTeamCarButton.addActionListener(e -> {
            String carName = (String) teamCars.getSelectedItem();
            Car c = findCar(carName);

            if(teamPicker.getSelectedItem() == null)
                return;
            if(c != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).RemoveCar(c);
                setTeamsArea();
                teamAssignCar.removeItem(c.GetModel());
            }
        });

        addTeamDriverButton.addActionListener(e -> {
            String driverName = (String) teamDrivers.getSelectedItem();
            Driver d = findDriver(driverName);

            if(teamPicker.getSelectedItem() == null)
                return;
            if(d != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).AddDriver(d);
                teamAssignDriver.addItem(d.GetName());
                setTeamsArea();
            }
        });

        removeTeamDriverButton.addActionListener(e -> {
            String driverName = (String) teamDrivers.getSelectedItem();
            Driver d = findDriver(driverName);

            if(teamPicker.getSelectedItem() == null)
                return;
            if(d != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).RemoveDriver(d);
                setTeamsArea();
                teamAssignDriver.removeItem(d.GetName());
            }
        });

        addCarButton.addActionListener(e -> {
            String name = (String) carManufacturer.getSelectedItem();
            Manufacturer m = findManufacturer(name);
            cars.add(new Car(carModel.getText(),
                    m,
                    carHorsePower.getValue(),
                    carWeight.getValue()));
            setCarsArea();
            teamCars.addItem(name);
        });

        assignCarToDriverButton.addActionListener(e -> {
            String carName = (String) teamAssignCar.getSelectedItem();
            String driverName = (String) teamAssignDriver.getSelectedItem();
            Driver d = findDriver(driverName);
            Car c = findCar(carName);

            if(c == null || d == null)
                return;
            if(teamPicker.getSelectedItem() == null)
                return;

            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).AssignCarToDriver(c, d);
            setTeamsArea();
        });

        unassignCarFromDriverButton.addActionListener(e -> {
            String driverName = (String) teamAssignDriver.getSelectedItem();
            Driver d = findDriver(driverName);

            if(d == null)
                return;
            if(teamPicker.getSelectedItem() == null)
                return;

            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).UnassignCarFromDriver(d);
            setTeamsArea();
        });

        addDriverButton.addActionListener(e -> {
            String date = driverBirth.getText();
            String[] values = date.split("-");
            drivers.add(new Driver(driverName.getText(),
                    driverGender.getSelectedItem(),
                    driverNationality.getSelectedItem(),
                    DateUtils.MakeDate(Integer.valueOf(values[0]), Integer.valueOf(values[1]), Integer.valueOf(values[2]))));
            setDriversArea();
            teamDrivers.addItem(driverName.getText());
        });

        addTeamButton.addActionListener(e -> {
            teams.add(new Team(teamName.getText(),
                    teamBased.getSelectedItem()));
            setTeamsArea();
            teamPicker.addItem(teamName.getText());
        });
    }

    private void setTeamsArea(){
        StringBuilder sb = new StringBuilder();
        for (Team t: teams) {
            sb.append(t.toString()).append("\n");
        }
        teamsTP.setText(sb.toString());
    }

    private void setCarsArea(){
        StringBuilder sb = new StringBuilder();
        for (Car c: cars) {
            sb.append(c.toString()).append("\n");
        }
        carsTP.setText(sb.toString());
    }

    private void setDriversArea(){
        StringBuilder sb = new StringBuilder();
        for (Driver d: drivers) {
            sb.append(d.toString()).append("\n");
        }
        driversTP.setText(sb.toString());
    }

    private void setSponsorsArea(){
        StringBuilder sb = new StringBuilder();
        for (Sponsor s: sponsors) {
            sb.append(s.toString()).append("\n");
        }
        sponsorsTP.setText(sb.toString());
    }

    private void setManufacturersArea(){
        StringBuilder sb = new StringBuilder();
        for (Manufacturer m: manufacturers) {
            sb.append(m.toString()).append("\n");
        }
        manufacturersTP.setText(sb.toString());
    }

    private Manufacturer findManufacturer(String name) {
        return manufacturers.stream()
                .filter(obj -> obj.GetName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private Sponsor findSponsor(String name) {
        return sponsors.stream()
                .filter(obj -> obj.GetName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private Car findCar(String model) {
        return cars.stream()
                .filter(obj -> obj.GetModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    private Driver findDriver(String name) {
        return drivers.stream()
                .filter(obj -> obj.GetName().equals(name))
                .findFirst()
                .orElse(null);
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

    public ArrayList<Team> getTeams() {
        return teams;
    }

    private void initDrivers() {
        driverNationality.addItem(GermanyQuote.getInstance());
        driverNationality.addItem(GreatBritainQuote.getInstance());
        driverNationality.addItem(ItalyQuote.getInstance());
        driverNationality.addItem(JapanQuote.getInstance());
        driverNationality.addItem(FranceQuote.getInstance());
        driverNationality.addItem(PortugalQuote.getInstance());
        driverNationality.addItem(SouthKoreaQuote.getInstance());
        driverNationality.addItem(SpainQuote.getInstance());
        driverGender.addItem(MaleQuote.getInstance());
        driverGender.addItem(FemaleQuote.getInstance());
        driverBirth.setText("2017-10-01");

        drivers.add(new Driver(
                "Dan",
                MaleQuote.getInstance(),
                GreatBritainQuote.getInstance(),
                DateUtils.MakeDate(1980L, 10L, 5L)));
        drivers.add(new Driver(
                "Steven",
                FemaleQuote.getInstance(),
                SpainQuote.getInstance(),
                DateUtils.MakeDate(1987L, 2L, 22L)));
        drivers.add(new Driver(
                "Peter",
                MaleQuote.getInstance(),
                GermanyQuote.getInstance(),
                DateUtils.MakeDate(1995L, 5L, 29L)));
        drivers.add(new Driver(
                "John",
                MaleQuote.getInstance(),
                GreatBritainQuote.getInstance(),
                DateUtils.MakeDate(1980L, 10L, 5L)));
        drivers.add(new Driver(
                "Mark",
                FemaleQuote.getInstance(),
                SpainQuote.getInstance(),
                DateUtils.MakeDate(1987L, 2L, 22L)));
        drivers.add(new Driver(
                "Alonso",
                MaleQuote.getInstance(),
                GermanyQuote.getInstance(),
                DateUtils.MakeDate(1995L, 5L, 29L)));
        drivers.add(new Driver(
                "Thomas",
                MaleQuote.getInstance(),
                GreatBritainQuote.getInstance(),
                DateUtils.MakeDate(1980L, 10L, 5L)));
        drivers.add(new Driver(
                "Smalling",
                FemaleQuote.getInstance(),
                SpainQuote.getInstance(),
                DateUtils.MakeDate(1987L, 2L, 22L)));
        drivers.add(new Driver(
                "Marco",
                MaleQuote.getInstance(),
                GermanyQuote.getInstance(),
                DateUtils.MakeDate(1995L, 5L, 29L)));

        setDriversArea();

        teamDrivers.addItem("Dan");
        teamDrivers.addItem("Steven");
        teamDrivers.addItem("Peter");
        teamDrivers.addItem("John");
        teamDrivers.addItem("Mark");
        teamDrivers.addItem("Alonso");
        teamDrivers.addItem("Thomas");
        teamDrivers.addItem("Smalling");
        teamDrivers.addItem("Marco");
    }

    private void initCars() {
        cars.add(new Car("Hyundai i20",
                findManufacturer("Hyunday"),
                370L,
                1250L));

        cars.add(new Car("Citroën C3",
                findManufacturer("Citroën"),
                400L,
                1300L));

        cars.add(new Car("Toyota Yaris",
                findManufacturer("Toyota"),
                480L,
                1200L));


        cars.add(new Car("Citroën C4",
                findManufacturer("Citroën"),
                400L,
                1280));

        cars.add(new Car("Ford Fiesta",
                null,
                480L,
                1200L));

        setCarsArea();
        teamCars.addItem("Hyundai i20");
        teamCars.addItem("Citroën C3");
        teamCars.addItem("Toyota Yaris");
        teamCars.addItem("Citroën C4");
        teamCars.addItem("Ford Fiesta");
    }

    private void initTeams() {
        teamBased.addItem(GermanyQuote.getInstance());
        teamBased.addItem(GreatBritainQuote.getInstance());
        teamBased.addItem(ItalyQuote.getInstance());
        teamBased.addItem(JapanQuote.getInstance());
        teamBased.addItem(FranceQuote.getInstance());
        teamBased.addItem(PortugalQuote.getInstance());
        teamBased.addItem(SouthKoreaQuote.getInstance());
        teamBased.addItem(SpainQuote.getInstance());

        teams.add(new Team("CITROËN Total Abu Dhabi WRT", FranceQuote.getInstance()));
        teams.add(new Team("Hyundai Motorsport", GermanyQuote.getInstance()));
        teams.add(new Team("M-Sport World Rally Team", GreatBritainQuote.getInstance()));
        teams.add(new Team("TOYOTA Gazoo Racing WRT", JapanQuote.getInstance()));

        setTeamsArea();
        teamPicker.addItem("CITROËN Total Abu Dhabi WRT");
        teamPicker.addItem("Hyundai Motorsport");
        teamPicker.addItem("M-Sport World Rally Team");
        teamPicker.addItem("TOYOTA Gazoo Racing WRT");
    }

    private void initSponsors() {
        sponsors.add(new Sponsor(
                "Abu Dhabi",
                "Official visitor website for Abu Dhabi travel and tourism, offering information on hotels, restaurants, things to do, culture & heritage and events."));
        sponsors.add(new Sponsor(
                "Eparco",
                "Spécialiste assainissement compact, développe et fabrique en exclusivité des solutions pour l'assainissement non collectif depuis 45 ans."));
        sponsors.add(new Sponsor(
                "Stilo",
                "Stilo helmets competition. Top functionality, everything a driver needs must be standard feature: intercom, connections, earmuffs, drinking system."));
        sponsors.add(new Sponsor(
                "Michelin",
                "Michelin, the leading tire company, is dedicated to enhancing its clients’ mobility, sustainably; designing and distributing the most suitable tires, services and solutions for its clients’ needs."));

        setSponsorsArea();
        teamSponsors.addItem("Abu Dhabi");
        teamSponsors.addItem("Eparco");
        teamSponsors.addItem("Stilo");
        teamSponsors.addItem("Michelin");
    }

    private void initManufacturers() {
        manufacturerCountry.addItem(GermanyQuote.getInstance());
        manufacturerCountry.addItem(GreatBritainQuote.getInstance());
        manufacturerCountry.addItem(ItalyQuote.getInstance());
        manufacturerCountry.addItem(JapanQuote.getInstance());
        manufacturerCountry.addItem(FranceQuote.getInstance());
        manufacturerCountry.addItem(PortugalQuote.getInstance());
        manufacturerCountry.addItem(SouthKoreaQuote.getInstance());
        manufacturerCountry.addItem(SpainQuote.getInstance());

        manufacturers.add(new Manufacturer(
                "Citroën",
                "Citroën is one of the world's leading mainstream car manufacturers.",
                FranceQuote.getInstance()));
        manufacturers.add(new Manufacturer(
                "Toyota",
                "Toyota is one of the world’s best-known and most successful businesses, building cars and trucks in 26 countries for sale in more than 160 markets around the globe.",
                JapanQuote.getInstance()));
        manufacturers.add(new Manufacturer(
                "Hyunday",
                "Hyundai Motor Company leads the Hyundai Motor Group, a wide-reaching business capable of processing resources from molten iron to finished cars.",
                SouthKoreaQuote.getInstance()));

        setManufacturersArea();
        carManufacturer.addItem("Citroën");
        teamBacker.addItem("Citroën");
        carManufacturer.addItem("Toyota");
        teamBacker.addItem("Toyota");
        carManufacturer.addItem("Hyunday");
        teamBacker.addItem("Hyunday");
    }

}
