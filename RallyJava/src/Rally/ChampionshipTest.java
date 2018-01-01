package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ChampionshipTest extends MyTestCase {
  private Championship champ1 =
      new Championship(
          "WRC", DateUtils.MakeDate(2017L, 10L, 2L), DateUtils.MakeDate(2017L, 11L, 20L));
  private Championship champ2 =
      new Championship(
          "WRC Junior", DateUtils.MakeDate(2017L, 8L, 23L), DateUtils.MakeDate(2017L, 10L, 11L));
  private Championship champ3 =
      new Championship(
          "WRC Pro", DateUtils.MakeDate(2017L, 1L, 13L), DateUtils.MakeDate(2017L, 3L, 20L));
  private Championship champ4 =
      new Championship(
          "Amateur WRC", DateUtils.MakeDate(2017L, 2L, 2L), DateUtils.MakeDate(2017L, 5L, 15L));
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
  private Rally rally1 =
      new Rally(
          "The Dark Mountain",
          "A very dark mountain",
          Rally.quotes.GermanyQuote.getInstance(),
          Rally.quotes.MountainQuote.getInstance(),
          DateUtils.MakeDate(2017L, 10L, 5L),
          DateUtils.MakeDate(2017L, 10L, 10L));
  private Rally rally2 =
      new Rally(
          "Despair Woods",
          "Maze-like woods it the heart of Spain",
          Rally.quotes.SpainQuote.getInstance(),
          Rally.quotes.ForestQuote.getInstance(),
          DateUtils.MakeDate(2017L, 10L, 14L),
          DateUtils.MakeDate(2017L, 10L, 20L));
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
  private Partner partner1 =
      new Partner(
          "Michelin",
          "Michelin, the leading tire company, is dedicated to enhancing its clients’ mobility, sustainably; designing and distributing the most suitable tires, services and solutions for its clients’ needs.");
  private Partner partner2 =
      new Partner(
          "Certina",
          "Precision, reliability, innovation and dynamism. These are the values that have always linked Certina to sport.");
  private Partner partner3 =
      new Partner(
          "OneBet",
          "OneBet is the official sports betting partner of the FIA World Rally Championship, providing spectacular opportunities to boost the rush and experience of WRC.");
  private Stage stage1 =
      new Stage(
          1L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 6L), 50L);
  private Stage stage2 =
      new Stage(
          2L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 8L), 200L);
  private Stage stage3 =
      new Stage(
          1L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 15L), 50L);
  private Stage stage4 =
      new Stage(
          2L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 16L), 200L);
  private Performance performance1 = null;
  private Performance performance2 = null;
  private Performance performance3 = null;
  private Performance performance4 = null;

  public void Run() {

    IO.println("\nChampionship Tests");
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
    assertEqual("WRC", champ1.GetName());
    assertEqual(DateUtils.MakeDate(2017L, 10L, 2L), champ1.GetStartDate());
    assertEqual(DateUtils.MakeDate(2017L, 11L, 20L), champ1.GetEndDate());
    assertTrue(champ1.GetStartDate().longValue() < champ1.GetEndDate().longValue());
    champ1.AddPartner(partner1);
    champ1.AddPartner(partner2);
    assertTrue(SetUtil.inSet(partner2, champ1.GetPartners()));
    champ1.RemovePartner(partner2);
    assertTrue(!(SetUtil.inSet(partner2, champ1.GetPartners())));
    champ1.AddTeam(team1);
    champ1.AddTeam(team2);
    assertTrue(SetUtil.inSet(team1, MapUtil.rng(champ1.GetTeams())));
    champ1.RemoveTeam(team1);
    assertEqual(MapUtil.map(new Maplet(team2.GetName(), team2)), champ1.GetTeams());
    champ1.AddTeam(team3);
    champ1.AddTeam(team1);
    assertEqual(team2, champ1.GetTeamByName("Hyundai Motorsport"));
    rally1.AddStage(stage1);
    rally1.AddStage(stage2);
    rally2.AddStage(stage3);
    rally2.AddStage(stage4);
    champ1.AddRally(rally1);
    champ1.AddRally(rally2);
    assertEqual(rally2, champ1.GetRallyByName("Despair Woods"));
    {
      Boolean letBeStExp_2 = null;
      Number i = null;
      Boolean success_9 = false;
      VDMSet set_30 = SeqUtil.inds(champ1.GetSeries());
      for (Iterator iterator_30 = set_30.iterator(); iterator_30.hasNext() && !(success_9); ) {
        i = ((Number) iterator_30.next());
        success_9 = true;
      }
      if (!(success_9)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      letBeStExp_2 = Utils.equals(((Rally) Utils.get(champ1.GetSeries(), i)), rally1);
      assertTrue(letBeStExp_2);
    }

    assertTrue(
        SetUtil.subset(SetUtil.set(driver1, driver2, driver3, driver4), champ1.GetDrivers()));
    assertEqual(null, champ1.GetCurrentRally());
    champ1.StartChampionship();
    assertTrue(Utils.equals(champ1.IsCurrentRallyCompleted(), false));
    assertEqual(rally1, champ1.GetCurrentRally());
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
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    assertEqual(
        834L, champ1.GetTeamRallyRanking("CITROËN Total Abu Dhabi WRT", "The Dark Mountain"));
    assertEqual(834L, champ1.GetTeamGlobalRanking("CITROËN Total Abu Dhabi WRT"));
    assertTrue(Utils.equals(champ1.IsCurrentRallyCompleted(), true));
    champ1.NextRally();
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    assertEqual(1251L, champ1.GetTeamGlobalRanking("CITROËN Total Abu Dhabi WRT"));
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    assertTrue(Utils.equals(champ1.IsCurrentRallyCompleted(), true));
    champ1.NextRally();
    assertEqual(Rally.quotes.CompletedQuote.getInstance(), ((Object) champ1.GetState()));
    assertTrue(
        SetUtil.subset(
            SetUtil.set(
                "CITROËN Total Abu Dhabi WRT", "Hyundai Motorsport", "M-Sport World Rally Team"),
            MapUtil.dom(champ1.GetTeamsRanking())));
    assertTrue(
        SetUtil.subset(SetUtil.set(1668L, 808L, 1000L), MapUtil.rng(champ1.GetTeamsRanking())));
    IO.println("\nFinalizing Championship Tests");
  }

  public ChampionshipTest() {}

  public String toString() {

    return "ChampionshipTest{"
        + "champ1 := "
        + Utils.toString(champ1)
        + ", champ2 := "
        + Utils.toString(champ2)
        + ", champ3 := "
        + Utils.toString(champ3)
        + ", champ4 := "
        + Utils.toString(champ4)
        + ", sponsor1 := "
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
        + ", rally1 := "
        + Utils.toString(rally1)
        + ", rally2 := "
        + Utils.toString(rally2)
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
        + ", partner1 := "
        + Utils.toString(partner1)
        + ", partner2 := "
        + Utils.toString(partner2)
        + ", partner3 := "
        + Utils.toString(partner3)
        + ", stage1 := "
        + Utils.toString(stage1)
        + ", stage2 := "
        + Utils.toString(stage2)
        + ", stage3 := "
        + Utils.toString(stage3)
        + ", stage4 := "
        + Utils.toString(stage4)
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
