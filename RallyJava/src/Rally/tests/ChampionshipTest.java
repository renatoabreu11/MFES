package Rally.tests;

import java.util.*;

import Rally.*;
import Rally.quotes.*;
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
  private Rally rally1 =
      new Rally(
          "The Dark Mountain",
          "A very dark mountain",
          GermanyQuote.getInstance(),
          MountainQuote.getInstance(),
          DateUtils.MakeDate(2017L, 10L, 5L),
          DateUtils.MakeDate(2017L, 10L, 10L));
  private Rally rally2 =
      new Rally(
          "Despair Woods",
          "Maze-like woods it the heart of Spain",
          SpainQuote.getInstance(),
          ForestQuote.getInstance(),
          DateUtils.MakeDate(2017L, 10L, 14L),
          DateUtils.MakeDate(2017L, 10L, 20L));
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
          1L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 6L), 50L);
  private Stage stage2 =
      new Stage(
          2L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 8L), 200L);
  private Stage stage3 =
      new Stage(
          1L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 15L), 50L);
  private Stage stage4 =
      new Stage(
          2L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 10L, 16L), 200L);
  private Performance performance1 = null;
  private Performance performance2 = null;
  private Performance performance3 = null;
  private Performance performance4 = null;
  /* ChampionshipTest.vdmpp 57:9 */
  public void Run() {

    /* ChampionshipTest.vdmpp 59:3 */
    IO.println("\nChampionship Tests");
    /* ChampionshipTest.vdmpp 62:3 */
    team1.AddCar(car1);
    /* ChampionshipTest.vdmpp 63:3 */
    team1.AddCar(car2);
    /* ChampionshipTest.vdmpp 64:3 */
    team2.AddCar(car3);
    /* ChampionshipTest.vdmpp 65:3 */
    team3.AddCar(car4);
    /* ChampionshipTest.vdmpp 67:3 */
    team1.AddDriver(driver1);
    /* ChampionshipTest.vdmpp 68:3 */
    team1.AddDriver(driver2);
    /* ChampionshipTest.vdmpp 69:3 */
    team2.AddDriver(driver3);
    /* ChampionshipTest.vdmpp 70:3 */
    team3.AddDriver(driver4);
    /* ChampionshipTest.vdmpp 71:3 */
    team1.AssignCarToDriver(car1, driver1);
    /* ChampionshipTest.vdmpp 72:3 */
    team1.AssignCarToDriver(car2, driver2);
    /* ChampionshipTest.vdmpp 73:3 */
    team2.AssignCarToDriver(car3, driver3);
    /* ChampionshipTest.vdmpp 74:3 */
    team3.AssignCarToDriver(car4, driver4);
    /* ChampionshipTest.vdmpp 77:3 */
    assertEqual("WRC", champ1.GetName());
    /* ChampionshipTest.vdmpp 78:3 */
    assertEqual(DateUtils.MakeDate(2017L, 10L, 2L), champ1.GetStartDate());
    /* ChampionshipTest.vdmpp 79:3 */
    assertEqual(DateUtils.MakeDate(2017L, 11L, 20L), champ1.GetEndDate());
    /* ChampionshipTest.vdmpp 80:3 */
    assertTrue(champ1.GetStartDate().longValue() < champ1.GetEndDate().longValue());
    /* ChampionshipTest.vdmpp 83:3 */
    champ1.AddPartner(partner1);
    /* ChampionshipTest.vdmpp 84:3 */
    champ1.AddPartner(partner2);
    /* ChampionshipTest.vdmpp 85:3 */
    assertTrue(SetUtil.inSet(partner2, champ1.GetPartners()));
    /* ChampionshipTest.vdmpp 86:3 */
    champ1.RemovePartner(partner2);
    /* ChampionshipTest.vdmpp 87:3 */
    assertTrue(!(SetUtil.inSet(partner2, champ1.GetPartners())));
    /* ChampionshipTest.vdmpp 90:3 */
    champ1.AddTeam(team1);
    /* ChampionshipTest.vdmpp 91:3 */
    champ1.AddTeam(team2);
    /* ChampionshipTest.vdmpp 92:3 */
    assertTrue(SetUtil.inSet(team1, MapUtil.rng(champ1.GetTeams())));
    /* ChampionshipTest.vdmpp 93:3 */
    champ1.RemoveTeam(team1);
    /* ChampionshipTest.vdmpp 94:3 */
    assertEqual(MapUtil.map(new Maplet(team2.GetName(), team2)), champ1.GetTeams());
    /* ChampionshipTest.vdmpp 95:3 */
    champ1.AddTeam(team3);
    /* ChampionshipTest.vdmpp 96:3 */
    champ1.AddTeam(team1);
    /* ChampionshipTest.vdmpp 98:3 */
    assertEqual(team2, champ1.GetTeamByName("Hyundai Motorsport"));
    /* ChampionshipTest.vdmpp 101:3 */
    rally1.AddStage(stage1);
    /* ChampionshipTest.vdmpp 102:3 */
    rally1.AddStage(stage2);
    /* ChampionshipTest.vdmpp 103:3 */
    rally2.AddStage(stage3);
    /* ChampionshipTest.vdmpp 104:3 */
    rally2.AddStage(stage4);
    /* ChampionshipTest.vdmpp 105:3 */
    champ1.AddRally(rally1);
    /* ChampionshipTest.vdmpp 106:3 */
    champ1.AddRally(rally2);
    /* ChampionshipTest.vdmpp 107:3 */
    assertEqual(rally2, champ1.GetRallyByName("Despair Woods"));
    {
      Boolean letBeStExp_2 = null;
      Number i = null;
      Boolean success_9 = false;
      /* ChampionshipTest.vdmpp 108:27 */
      VDMSet set_35 = SeqUtil.inds(champ1.GetSeries());
      for (Iterator iterator_35 = set_35.iterator(); iterator_35.hasNext() && !(success_9); ) {
        i = ((Number) iterator_35.next());
        success_9 = true;
      }
      if (!(success_9)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      letBeStExp_2 = Utils.equals(((Rally) Utils.get(champ1.GetSeries(), i)), rally1);
      /* ChampionshipTest.vdmpp 108:3 */
      assertTrue(letBeStExp_2);
    }

    /* ChampionshipTest.vdmpp 110:3 */
    assertTrue(
        SetUtil.subset(SetUtil.set(driver1, driver2, driver3, driver4), champ1.GetDrivers()));
    /* ChampionshipTest.vdmpp 112:3 */
    assertEqual(null, champ1.GetCurrentRally());
    /* ChampionshipTest.vdmpp 113:3 */
    champ1.StartChampionship();
    /* ChampionshipTest.vdmpp 114:3 */
    assertTrue(Utils.equals(champ1.IsCurrentRallyCompleted(), false));
    /* ChampionshipTest.vdmpp 115:3 */
    assertEqual(rally1, champ1.GetCurrentRally());
    /* ChampionshipTest.vdmpp 117:3 */
    performance1 = new Performance(driver1);
    /* ChampionshipTest.vdmpp 118:3 */
    performance2 = new Performance(driver2);
    /* ChampionshipTest.vdmpp 119:3 */
    performance3 = new Performance(driver3);
    /* ChampionshipTest.vdmpp 120:3 */
    performance4 = new Performance(driver4);
    /* ChampionshipTest.vdmpp 121:3 */
    performance1.SetTime(200L);
    /* ChampionshipTest.vdmpp 122:3 */
    performance1.SetAverageSpeed(50L);
    /* ChampionshipTest.vdmpp 123:3 */
    performance2.SetTime(217L);
    /* ChampionshipTest.vdmpp 124:3 */
    performance2.SetAverageSpeed(48L);
    /* ChampionshipTest.vdmpp 125:3 */
    performance3.SetTime(202L);
    /* ChampionshipTest.vdmpp 126:3 */
    performance3.SetAverageSpeed(50L);
    /* ChampionshipTest.vdmpp 127:3 */
    performance4.SetTime(250L);
    /* ChampionshipTest.vdmpp 128:3 */
    performance4.SetAverageSpeed(46L);
    /* ChampionshipTest.vdmpp 130:3 */
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    /* ChampionshipTest.vdmpp 131:3 */
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    /* ChampionshipTest.vdmpp 133:3 */
    assertEqual(
        834L, champ1.GetTeamRallyRanking("CITROËN Total Abu Dhabi WRT", "The Dark Mountain"));
    /* ChampionshipTest.vdmpp 134:3 */
    assertEqual(834L, champ1.GetTeamGlobalRanking("CITROËN Total Abu Dhabi WRT"));
    /* ChampionshipTest.vdmpp 136:3 */
    assertTrue(Utils.equals(champ1.IsCurrentRallyCompleted(), true));
    /* ChampionshipTest.vdmpp 137:3 */
    champ1.NextRally();
    /* ChampionshipTest.vdmpp 138:3 */
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    /* ChampionshipTest.vdmpp 140:3 */
    assertEqual(1251L, champ1.GetTeamGlobalRanking("CITROËN Total Abu Dhabi WRT"));
    /* ChampionshipTest.vdmpp 142:3 */
    champ1.UpdateCurrentRally(SetUtil.set(performance1, performance2, performance3, performance4));
    /* ChampionshipTest.vdmpp 143:3 */
    assertTrue(Utils.equals(champ1.IsCurrentRallyCompleted(), true));
    /* ChampionshipTest.vdmpp 144:3 */
    champ1.NextRally();
    /* ChampionshipTest.vdmpp 145:3 */
    assertEqual(CompletedQuote.getInstance(), ((Object) champ1.GetState()));
    /* ChampionshipTest.vdmpp 147:3 */
    assertTrue(
        SetUtil.subset(
            SetUtil.set(
                "CITROËN Total Abu Dhabi WRT", "Hyundai Motorsport", "M-Sport World Rally Team"),
            MapUtil.dom(champ1.GetTeamsRanking())));
    /* ChampionshipTest.vdmpp 148:3 */
    assertTrue(
        SetUtil.subset(SetUtil.set(1668L, 808L, 1000L), MapUtil.rng(champ1.GetTeamsRanking())));
    /* ChampionshipTest.vdmpp 149:3 */
    IO.println("\nFinalizing Championship Tests");
  }
  /* ChampionshipTest.vdmpp 1:7 */
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
