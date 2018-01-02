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
        manufacturerCountry.addItem(GermanyQuote.getInstance());
        manufacturerCountry.addItem(GreatBritainQuote.getInstance());
        manufacturerCountry.addItem(ItalyQuote.getInstance());
        manufacturerCountry.addItem(JapanQuote.getInstance());
        manufacturerCountry.addItem(FranceQuote.getInstance());
        manufacturerCountry.addItem(PortugalQuote.getInstance());
        manufacturerCountry.addItem(SouthKoreaQuote.getInstance());
        manufacturerCountry.addItem(SpainQuote.getInstance());

        carManufacturer.addItem("None");

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

        teamBased.addItem(GermanyQuote.getInstance());
        teamBased.addItem(GreatBritainQuote.getInstance());
        teamBased.addItem(ItalyQuote.getInstance());
        teamBased.addItem(JapanQuote.getInstance());
        teamBased.addItem(FranceQuote.getInstance());
        teamBased.addItem(PortugalQuote.getInstance());
        teamBased.addItem(SouthKoreaQuote.getInstance());
        teamBased.addItem(SpainQuote.getInstance());

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
            Manufacturer m = manufacturers.stream()
                    .filter(obj -> obj.GetName().equals(manName))
                    .findFirst()
                    .orElse(null);

            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).SetBacker(m);
            setTeamsArea();
        });

        removeTeamBackerButton.addActionListener(e -> {
            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).RemoveBacker();
            setTeamsArea();
        });

        addTeamSponsorButton.addActionListener(e -> {
            String sponsorName = (String) teamSponsors.getSelectedItem();
            Sponsor s = sponsors.stream()
                    .filter(obj -> obj.GetName().equals(sponsorName))
                    .findFirst()
                    .orElse(null);

            if(s != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).AddSponsor(s);
                setTeamsArea();
            }
        });

        removeTeamSponsorButton.addActionListener(e -> {
            String sponsorName = (String) teamSponsors.getSelectedItem();
            Sponsor s = sponsors.stream()
                    .filter(obj -> obj.GetName().equals(sponsorName))
                    .findFirst()
                    .orElse(null);

            if(s != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).RemoveSponsor(s);
                setTeamsArea();
            }
        });

        addTeamCarButton.addActionListener(e -> {
            String carName = (String) teamCars.getSelectedItem();
            Car c = cars.stream()
                    .filter(obj -> obj.GetModel().equals(carName))
                    .findFirst()
                    .orElse(null);

            if(c != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).AddCar(c);
                setTeamsArea();
                teamAssignCar.addItem(c.GetModel());
            }
        });

        removeTeamCarButton.addActionListener(e -> {
            String carName = (String) teamCars.getSelectedItem();
            Car c = cars.stream()
                    .filter(obj -> obj.GetModel().equals(carName))
                    .findFirst()
                    .orElse(null);

            if(c != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).RemoveCar(c);
                setTeamsArea();
                teamAssignCar.removeItem(c.GetModel());
            }
        });

        addTeamDriverButton.addActionListener(e -> {
            String driverName = (String) teamDrivers.getSelectedItem();
            Driver d = drivers.stream()
                    .filter(obj -> obj.GetName().equals(driverName))
                    .findFirst()
                    .orElse(null);

            if(d != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).AddDriver(d);
                teamAssignDriver.addItem(d.GetName());
                setTeamsArea();
            }
        });

        removeTeamDriverButton.addActionListener(e -> {
            String driverName = (String) teamDrivers.getSelectedItem();
            Driver d = drivers.stream()
                    .filter(obj -> obj.GetName().equals(driverName))
                    .findFirst()
                    .orElse(null);

            if(d != null) {
                Integer teamIndex = teamPicker.getSelectedIndex();
                teams.get(teamIndex).RemoveDriver(d);
                setTeamsArea();
                teamAssignDriver.removeItem(d.GetName());
            }
        });

        addCarButton.addActionListener(e -> {
            String name = (String) carModel.getText();
            Manufacturer m = manufacturers.stream()
                    .filter(obj -> obj.GetName().equals(name))
                    .findFirst()
                    .orElse(null);
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

            Driver d = drivers.stream()
                    .filter(obj -> obj.GetName().equals(driverName))
                    .findFirst()
                    .orElse(null);

            Car c = cars.stream()
                    .filter(obj -> obj.GetModel().equals(carName))
                    .findFirst()
                    .orElse(null);

            if(c == null || d == null)
                return;

            Integer teamIndex = teamPicker.getSelectedIndex();
            teams.get(teamIndex).AssignCarToDriver(c, d);
            setTeamsArea();
        });

        unassignCarFromDriverButton.addActionListener(e -> {
            String driverName = (String) teamAssignDriver.getSelectedItem();

            Driver d = drivers.stream()
                    .filter(obj -> obj.GetName().equals(driverName))
                    .findFirst()
                    .orElse(null);

            if(d == null)
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
