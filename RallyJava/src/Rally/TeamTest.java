package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TeamTest extends MyTestCase {
  private Sponsor sponsor1 =
      new Sponsor(
          "Abu Dhabi",
          "Official visitor website for Abu Dhabi travel and tourism, offering information on hotels, restaurants, things to do, culture & heritage and events.");
  private Sponsor sponsor2 =
      new Sponsor(
          "Eparco",
          "Spécialiste assainissement compact, développe et fabrique en exclusivité des solutions pour l'assainissement non collectif depuis 45 ans.");
  private Sponsor sponsor3 =
      new Sponsor(
          "Stilo",
          "Stilo helmets competition. Top functionality, everything a driver needs must be standard feature: intercom, connections, earmuffs, drinking system.");
  private Sponsor sponsor4 =
      new Sponsor(
          "Michelin",
          "Michelin, the leading tire company, is dedicated to enhancing its clients’ mobility, sustainably; designing and distributing the most suitable tires, services and solutions for its clients’ needs.");
  private Manufacturer manufacturer1 =
      new Manufacturer(
          "Citroën",
          "Citroën is one of the world's leading mainstream car manufacturers.",
          Rally.quotes.FranceQuote.getInstance());
  private Manufacturer manufacturer2 =
      new Manufacturer(
          "Toyota",
          "Toyota is one of the world’s best-known and most successful businesses, building cars and trucks in 26 countries for sale in more than 160 markets around the globe.",
          Rally.quotes.JapanQuote.getInstance());
  private Manufacturer manufacturer3 =
      new Manufacturer(
          "Hyunday",
          "Hyundai Motor Company leads the Hyundai Motor Group, a wide-reaching business capable of processing resources from molten iron to finished cars.",
          Rally.quotes.SouthKoreaQuote.getInstance());
  private Car car1 = new Car("Hyundai i20", manufacturer3, 370L, 1250L);
  private Car car2 = new Car("Citroën C3", manufacturer1, 400L, 1300L);
  private Car car3 = new Car("Toyota Yaris", manufacturer2, 480L, 1200L);
  private Car car4 = new Car("Citroën C4", manufacturer1, 400L, 1300L);
  private Team team1 =
      new Team("CITROËN Total Abu Dhabi WRT", Rally.quotes.FranceQuote.getInstance());
  private Team team2 = new Team("Hyundai Motorsport", Rally.quotes.GermanyQuote.getInstance());
  private Team team3 =
      new Team("M-Sport World Rally Team", Rally.quotes.GreatBritainQuote.getInstance());
  private Team team4 = new Team("TOYOTA Gazoo Racing WRT", Rally.quotes.JapanQuote.getInstance());
  private Driver driver1 =
      new Driver(
          "Dan",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GreatBritainQuote.getInstance(),
          DateUtils.MakeDate(1980L, 10L, 5L));
  private Driver driver2 =
      new Driver(
          "Joana",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.SpainQuote.getInstance(),
          DateUtils.MakeDate(1987L, 2L, 22L));
  private Driver driver3 =
      new Driver(
          "Alexio",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1995L, 5L, 29L));

  public void Run() {

    IO.println("\nTeam Tests");
    assertEqual("CITROËN Total Abu Dhabi WRT", team1.GetName());
    assertEqual(Rally.quotes.FranceQuote.getInstance(), ((Object) team1.GetBased()));
    assertEqual(null, team1.GetBacker());
    assertEqual(SetUtil.set(), team1.GetSponsors());
    team1.AddSponsor(sponsor1);
    assertTrue(SetUtil.inSet(sponsor1, team1.GetSponsors()));
    team1.AddSponsor(sponsor2);
    assertTrue(SetUtil.inSet(sponsor2, team1.GetSponsors()));
    team1.RemoveSponsor(sponsor1);
    assertTrue(!(SetUtil.inSet(sponsor1, team1.GetSponsors())));
    team1.AddCar(car1);
    team1.AddCar(car2);
    assertTrue(Utils.equals(SetUtil.set(car1, car2), team1.GetCars()));
    team1.RemoveCar(car1);
    assertTrue(!(SetUtil.inSet(car1, team1.GetCars())));
    assertTrue(Utils.equals(null, team1.GetBacker()));
    team1.SetBacker(manufacturer1);
    assertEqual(manufacturer1, team1.GetBacker());
    team1.AddCar(car4);
    team1.RemoveBacker();
    team1.AddCar(car3);
    team1.AddDriver(driver1);
    team1.AddDriver(driver2);
    assertTrue(Utils.equals(SetUtil.set(driver1, driver2), team1.GetDrivers()));
    team1.RemoveDriver(driver1);
    assertTrue(!(SetUtil.inSet(driver1, team1.GetDrivers())));
    team1.AssignCarToDriver(car2, driver2);
    team1.RemoveCar(car3);
    team1.UnassignCarFromDriver(driver2);
    assertEqual(driver2, team1.GetDriverByName("Joana"));
    IO.println("\nFinalizing Team Tests");
  }

  public TeamTest() {}

  public String toString() {

    return "TeamTest{"
        + "sponsor1 := "
        + Utils.toString(sponsor1)
        + ", sponsor2 := "
        + Utils.toString(sponsor2)
        + ", sponsor3 := "
        + Utils.toString(sponsor3)
        + ", sponsor4 := "
        + Utils.toString(sponsor4)
        + ", manufacturer1 := "
        + Utils.toString(manufacturer1)
        + ", manufacturer2 := "
        + Utils.toString(manufacturer2)
        + ", manufacturer3 := "
        + Utils.toString(manufacturer3)
        + ", car1 := "
        + Utils.toString(car1)
        + ", car2 := "
        + Utils.toString(car2)
        + ", car3 := "
        + Utils.toString(car3)
        + ", car4 := "
        + Utils.toString(car4)
        + ", team1 := "
        + Utils.toString(team1)
        + ", team2 := "
        + Utils.toString(team2)
        + ", team3 := "
        + Utils.toString(team3)
        + ", team4 := "
        + Utils.toString(team4)
        + ", driver1 := "
        + Utils.toString(driver1)
        + ", driver2 := "
        + Utils.toString(driver2)
        + ", driver3 := "
        + Utils.toString(driver3)
        + "}";
  }
}
