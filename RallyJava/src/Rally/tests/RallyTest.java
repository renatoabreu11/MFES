package Rally.tests;

import Rally.*;
import Rally.quotes.*;
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
          FranceQuote.getInstance());
  private Manufacturer manufacturer2 =
      new Manufacturer(
          "Toyota",
          "Toyota is one of the world’s best-known and most successful businesses, building cars and trucks in 26 countries for sale in more than 160 markets around the globe.",
          JapanQuote.getInstance());
  private Manufacturer manufacturer3 =
      new Manufacturer(
          "Hyunday",
          "Hyundai Motor Company leads the Hyundai Motor Group, a wide-reaching business capable of processing resources from molten iron to finished cars.",
          SouthKoreaQuote.getInstance());
  private Car car1 = new Car("Hyundai i20", manufacturer3, 370L, 1250L);
  private Car car2 = new Car("Citroën C3", manufacturer1, 400L, 1300L);
  private Car car3 = new Car("Toyota Yaris", manufacturer2, 480L, 1200L);
  private Car car4 = new Car("Citroën C4", manufacturer1, 400L, 1300L);
  private Team team1 =
      new Team("CITROËN Total Abu Dhabi WRT", FranceQuote.getInstance());
  private Team team2 = new Team("Hyundai Motorsport", GermanyQuote.getInstance());
  private Team team3 =
      new Team("M-Sport World Rally Team", GreatBritainQuote.getInstance());
  private Team team4 = new Team("TOYOTA Gazoo Racing WRT", JapanQuote.getInstance());
  private Driver driver1 =
      new Driver(
          "Dan",
          MaleQuote.getInstance(),
          GreatBritainQuote.getInstance(),
          DateUtils.MakeDate(1980L, 10L, 5L));
  private Driver driver2 =
      new Driver(
          "Joana",
          FemaleQuote.getInstance(),
          SpainQuote.getInstance(),
          DateUtils.MakeDate(1987L, 2L, 22L));
  private Driver driver3 =
      new Driver(
          "Alexio",
          MaleQuote.getInstance(),
          GermanyQuote.getInstance(),
          DateUtils.MakeDate(1995L, 5L, 29L));
  private Driver driver4 =
      new Driver(
          "Another one",
          MaleQuote.getInstance(),
          GermanyQuote.getInstance(),
          DateUtils.MakeDate(1996L, 5L, 29L));
  private Stage stage1 =
      new Stage(
          1L, SpecialQuote.getInstance(), DateUtils.MakeDate(2018L, 1L, 25L), 50L);
  private Stage stage2 =
      new Stage(
          2L, SpecialQuote.getInstance(), DateUtils.MakeDate(2018L, 1L, 26L), 200L);
  private Rally rally1 =
      new Rally(
          "Rallye Monte-Carlo",
          "The Monte Carlo Rally or Rallye Monte Carlo is a rallying event organised each year by the Automobile Club de Monaco.",
          FranceQuote.getInstance(),
          AsphaltQuote.getInstance(),
          DateUtils.MakeDate(2018L, 1L, 25L),
          DateUtils.MakeDate(2018L, 1L, 28L));
  private Rally rally2 =
      new Rally(
          "Vodafone Rally de Portugal",
          "O Rali de Portugal é a maior prova de desporto motorizado que se realiza em Portugal anualmente.",
          PortugalQuote.getInstance(),
          GravelQuote.getInstance(),
          DateUtils.MakeDate(2018L, 5L, 17L),
          DateUtils.MakeDate(2018L, 5L, 20L));
  private Rally rally3 =
      new Rally(
          "Rally Italia Sardegna",
          "Held on the beautiful island of Sardinia, Rally Italy – or Rally Italia Sardegna to give it its full name – is a notoriously tricky event.",
          ItalyQuote.getInstance(),
          MountainQuote.getInstance(),
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
  /* RallyTest.vdmpp 52:9 */
  public void Run() {

    /* RallyTest.vdmpp 54:3 */
    IO.println("\nRally Tests");
    /* RallyTest.vdmpp 57:3 */
    team1.AddCar(car1);
    /* RallyTest.vdmpp 58:3 */
    team1.AddCar(car2);
    /* RallyTest.vdmpp 59:3 */
    team2.AddCar(car3);
    /* RallyTest.vdmpp 60:3 */
    team3.AddCar(car4);
    /* RallyTest.vdmpp 62:3 */
    team1.AddDriver(driver1);
    /* RallyTest.vdmpp 63:3 */
    team1.AddDriver(driver2);
    /* RallyTest.vdmpp 64:3 */
    team2.AddDriver(driver3);
    /* RallyTest.vdmpp 65:3 */
    team3.AddDriver(driver4);
    /* RallyTest.vdmpp 66:3 */
    team1.AssignCarToDriver(car1, driver1);
    /* RallyTest.vdmpp 67:3 */
    team1.AssignCarToDriver(car2, driver2);
    /* RallyTest.vdmpp 68:3 */
    team2.AssignCarToDriver(car3, driver3);
    /* RallyTest.vdmpp 69:3 */
    team3.AssignCarToDriver(car4, driver4);
    /* RallyTest.vdmpp 72:3 */
    assertEqual("Rallye Monte-Carlo", rally1.GetName());
    /* RallyTest.vdmpp 73:3 */
    assertEqual(
        "O Rali de Portugal é a maior prova de desporto motorizado que se realiza em Portugal anualmente.",
        rally2.GetDescription());
    /* RallyTest.vdmpp 74:3 */
    assertEqual(ItalyQuote.getInstance(), ((Object) rally3.GetCountry()));
    /* RallyTest.vdmpp 75:3 */
    assertEqual(GravelQuote.getInstance(), ((Object) rally2.GetSurface()));
    /* RallyTest.vdmpp 76:3 */
    assertTrue(rally1.GetStartDate().longValue() < rally1.GetEndDate().longValue());
    /* RallyTest.vdmpp 77:3 */
    assertEqual(0.0, rally2.GetDistance());
    /* RallyTest.vdmpp 80:3 */
    rally1.AddStage(stage1);
    /* RallyTest.vdmpp 81:3 */
    rally1.AddStage(stage2);
    /* RallyTest.vdmpp 82:3 */
    assertEqual(250L, rally1.GetDistance());
    /* RallyTest.vdmpp 83:3 */
    assertEqual(SeqUtil.seq(stage1, stage2), rally1.GetStages());
    /* RallyTest.vdmpp 85:3 */
    rally1.StartRally(SetUtil.set(driver1, driver2, driver3, driver4));
    /* RallyTest.vdmpp 86:3 */
    assertTrue(Utils.equals(rally1.GetRankings().size(), 4L));
    /* RallyTest.vdmpp 88:3 */
    performance1 = new Performance(driver1);
    /* RallyTest.vdmpp 89:3 */
    performance2 = new Performance(driver2);
    /* RallyTest.vdmpp 90:3 */
    performance3 = new Performance(driver3);
    /* RallyTest.vdmpp 91:3 */
    performance4 = new Performance(driver4);
    /* RallyTest.vdmpp 92:3 */
    performance1.SetTime(200L);
    /* RallyTest.vdmpp 93:3 */
    performance1.SetAverageSpeed(50L);
    /* RallyTest.vdmpp 94:3 */
    performance2.SetTime(217L);
    /* RallyTest.vdmpp 95:3 */
    performance2.SetAverageSpeed(48L);
    /* RallyTest.vdmpp 96:3 */
    performance3.SetTime(202L);
    /* RallyTest.vdmpp 97:3 */
    performance3.SetAverageSpeed(50L);
    /* RallyTest.vdmpp 98:3 */
    performance4.SetTime(250L);
    /* RallyTest.vdmpp 99:3 */
    performance4.SetAverageSpeed(46L);
    /* RallyTest.vdmpp 101:3 */
    rally1.NextStage(SetUtil.set(performance1, performance2, performance3, performance4));
    /* RallyTest.vdmpp 103:3 */
    assertEqual(stage2, rally1.GetCurrentStage());
    /* RallyTest.vdmpp 105:3 */
    rally1.NextStage(SetUtil.set(performance1, performance2, performance3, performance4));
    /* RallyTest.vdmpp 107:3 */
    assertTrue(Utils.equals(rally1.GetDriverRanking(driver1).GetDriver(), driver1));
    /* RallyTest.vdmpp 108:3 */
    assertTrue(Utils.equals(rally1.GetDriverRanking(driver1).GetPoints(), 400L));
    /* RallyTest.vdmpp 110:3 */
    assertTrue(Utils.equals(rally1.GetDriverPerformanceOnStage(1L, driver1).GetTime(), 200L));
    /* RallyTest.vdmpp 112:3 */
    assertEqual(834L, rally1.GetTeamRanking("CITROËN Total Abu Dhabi WRT"));
    /* RallyTest.vdmpp 114:3 */
    IO.println("\nFinalizing Rally Tests");
  }
  /* RallyTest.vdmpp 1:7 */
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
