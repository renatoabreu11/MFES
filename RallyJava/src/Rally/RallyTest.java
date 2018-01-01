package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RallyTest extends MyTestCase {
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
  private Driver driver4 =
      new Driver(
          "Another one",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1996L, 5L, 29L));
  private Stage stage1 =
      new Stage(
          1L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2018L, 1L, 25L), 50L);
  private Stage stage2 =
      new Stage(
          2L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2018L, 1L, 26L), 200L);
  private Rally rally1 =
      new Rally(
          "Rallye Monte-Carlo",
          "The Monte Carlo Rally or Rallye Monte Carlo is a rallying event organised each year by the Automobile Club de Monaco.",
          Rally.quotes.FranceQuote.getInstance(),
          Rally.quotes.AsphaltQuote.getInstance(),
          DateUtils.MakeDate(2018L, 1L, 25L),
          DateUtils.MakeDate(2018L, 1L, 28L));
  private Rally rally2 =
      new Rally(
          "Vodafone Rally de Portugal",
          "O Rali de Portugal é a maior prova de desporto motorizado que se realiza em Portugal anualmente.",
          Rally.quotes.PortugalQuote.getInstance(),
          Rally.quotes.GravelQuote.getInstance(),
          DateUtils.MakeDate(2018L, 5L, 17L),
          DateUtils.MakeDate(2018L, 5L, 20L));
  private Rally rally3 =
      new Rally(
          "Rally Italia Sardegna",
          "Held on the beautiful island of Sardinia, Rally Italy – or Rally Italia Sardegna to give it its full name – is a notoriously tricky event.",
          Rally.quotes.ItalyQuote.getInstance(),
          Rally.quotes.MountainQuote.getInstance(),
          DateUtils.MakeDate(2018L, 6L, 7L),
          DateUtils.MakeDate(2018L, 6L, 10L));
  private Ranking ranking1 = null;
  private Ranking ranking2 = null;
  private Ranking ranking3 = null;
  private Ranking ranking4 = null;
  private Performance performance1 = null;
  private Performance performance2 = null;
  private Performance performance3 = null;
  private Performance performance4 = null;

  public void Run() {

    IO.println("\nRally Tests");
    team1.AddCar(car1);
    team1.AddCar(car2);
    team2.AddCar(car3);
    team3.AddCar(car4);
    team1.AddDriver(driver1);
    team1.AddDriver(driver2);
    team2.AddDriver(driver3);
    team3.AddDriver(driver4);
    team1.AssignCarToDriver(car1, driver1);
    team1.AssignCarToDriver(car2, driver2);
    team2.AssignCarToDriver(car3, driver3);
    team3.AssignCarToDriver(car4, driver4);
    assertEqual("Rallye Monte-Carlo", rally1.GetName());
    assertEqual(
        "O Rali de Portugal é a maior prova de desporto motorizado que se realiza em Portugal anualmente.",
        rally2.GetDescription());
    assertEqual(Rally.quotes.ItalyQuote.getInstance(), ((Object) rally3.GetCountry()));
    assertEqual(Rally.quotes.GravelQuote.getInstance(), ((Object) rally2.GetSurface()));
    assertTrue(rally1.GetStartDate().longValue() < rally1.GetEndDate().longValue());
    assertEqual(0.0, rally2.GetDistance());
    rally1.AddStage(stage1);
    rally1.AddStage(stage2);
    assertEqual(250L, rally1.GetDistance());
    assertEqual(SeqUtil.seq(stage1, stage2), rally1.GetStages());
    rally1.StartRally(SetUtil.set(driver1, driver2, driver3, driver4));
    assertTrue(Utils.equals(rally1.GetRankings().size(), 4L));
    performance1 = new Performance(driver1);
    performance2 = new Performance(driver2);
    performance3 = new Performance(driver3);
    performance4 = new Performance(driver4);
    performance1.SetTime(200L);
    performance1.SetAverageSpeed(50L);
    performance2.SetTime(217L);
    performance2.SetAverageSpeed(48L);
    performance3.SetTime(202L);
    performance3.SetAverageSpeed(50L);
    performance4.SetTime(250L);
    performance4.SetAverageSpeed(46L);
    rally1.NextStage(SetUtil.set(performance1, performance2, performance3, performance4));
    assertEqual(stage2, rally1.GetCurrentStage());
    rally1.NextStage(SetUtil.set(performance1, performance2, performance3, performance4));
    assertTrue(Utils.equals(rally1.GetDriverRanking(driver1).GetDriver(), driver1));
    assertTrue(Utils.equals(rally1.GetDriverRanking(driver1).GetPoints(), 400L));
    assertTrue(Utils.equals(rally1.GetDriverPerformanceOnStage(1L, driver1).GetTime(), 200L));
    assertEqual(834L, rally1.GetTeamRanking("CITROËN Total Abu Dhabi WRT"));
    IO.println("\nFinalizing Rally Tests");
  }

  public RallyTest() {}

  public String toString() {

    return "RallyTest{"
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
        + ", driver4 := "
        + Utils.toString(driver4)
        + ", stage1 := "
        + Utils.toString(stage1)
        + ", stage2 := "
        + Utils.toString(stage2)
        + ", rally1 := "
        + Utils.toString(rally1)
        + ", rally2 := "
        + Utils.toString(rally2)
        + ", rally3 := "
        + Utils.toString(rally3)
        + ", ranking1 := "
        + Utils.toString(ranking1)
        + ", ranking2 := "
        + Utils.toString(ranking2)
        + ", ranking3 := "
        + Utils.toString(ranking3)
        + ", ranking4 := "
        + Utils.toString(ranking4)
        + ", performance1 := "
        + Utils.toString(performance1)
        + ", performance2 := "
        + Utils.toString(performance2)
        + ", performance3 := "
        + Utils.toString(performance3)
        + ", performance4 := "
        + Utils.toString(performance4)
        + "}";
  }
}
