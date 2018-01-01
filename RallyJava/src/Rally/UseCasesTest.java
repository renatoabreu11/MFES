package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UseCasesTest extends MyTestCase {
  private Championship champ1 =
      new Championship(
          "European Championship",
          DateUtils.MakeDate(2017L, 10L, 29L),
          DateUtils.MakeDate(2017L, 12L, 5L));
  private Rally rally1 =
      new Rally(
          "Rally da Costa",
          "Rally in Portugal",
          Rally.quotes.PortugalQuote.getInstance(),
          Rally.quotes.SandQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 1L),
          DateUtils.MakeDate(2017L, 11L, 3L));
  private Rally rally2 =
      new Rally(
          "Rally de la Coru�a",
          "Rally in Spain",
          Rally.quotes.SpainQuote.getInstance(),
          Rally.quotes.AsphaltQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 5L),
          DateUtils.MakeDate(2017L, 11L, 15L));
  private Rally rally3 =
      new Rally(
          "Mont-Blanc Rally",
          "Rally in France",
          Rally.quotes.FranceQuote.getInstance(),
          Rally.quotes.MountainQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 19L),
          DateUtils.MakeDate(2017L, 11L, 25L));
  private Rally rally4 =
      new Rally(
          "SnowHell Rally",
          "Rally in GB",
          Rally.quotes.GreatBritainQuote.getInstance(),
          Rally.quotes.SnowQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 26L),
          DateUtils.MakeDate(2017L, 11L, 27L));
  private Rally rally5 =
      new Rally(
          "Ulme Rally",
          "Rally in Germany",
          Rally.quotes.GermanyQuote.getInstance(),
          Rally.quotes.GravelQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 30L),
          DateUtils.MakeDate(2017L, 12L, 4L));
  private Stage stage1r1 =
      new Stage(
          201711L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 1L),
          350L);
  private Stage stage2r1 =
      new Stage(
          201712L,
          Rally.quotes.SpecialQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 3L),
          50L);
  private Stage stage1r2 =
      new Stage(
          201721L,
          Rally.quotes.SpecialQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 5L),
          10L);
  private Stage stage2r2 =
      new Stage(
          201722L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 8L),
          300L);
  private Stage stage3r2 =
      new Stage(
          201723L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 10L),
          1200L);
  private Stage stage4r2 =
      new Stage(
          201724L,
          Rally.quotes.SpecialQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 14L),
          35L);
  private Stage stage1r3 =
      new Stage(
          201731L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 19L),
          650L);
  private Stage stage2r3 =
      new Stage(
          201732L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 22L),
          60L);
  private Stage stage3r3 =
      new Stage(
          201733L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 24L),
          380L);
  private Stage stage1r4 =
      new Stage(
          201741L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 26L),
          500L);
  private Stage stage1r5 =
      new Stage(
          201751L,
          Rally.quotes.SpecialQuote.getInstance(),
          DateUtils.MakeDate(2017L, 11L, 30L),
          55L);
  private Stage stage2r5 =
      new Stage(
          201752L,
          Rally.quotes.TransportQuote.getInstance(),
          DateUtils.MakeDate(2017L, 12L, 2L),
          450L);
  private Stage stage3r5 =
      new Stage(
          201753L,
          Rally.quotes.SpecialQuote.getInstance(),
          DateUtils.MakeDate(2017L, 12L, 4L),
          10L);
  private Manufacturer manufacturer1 =
      new Manufacturer("Citroen", "Citroen", Rally.quotes.FranceQuote.getInstance());
  private Manufacturer manufacturer2 =
      new Manufacturer("Toyota", "Toyota", Rally.quotes.JapanQuote.getInstance());
  private Manufacturer manufacturer3 =
      new Manufacturer("Hyunday", "Hyundai Motors", Rally.quotes.SouthKoreaQuote.getInstance());
  private Manufacturer manufacturer4 =
      new Manufacturer("Mitsubishi", "Mitsubishi", Rally.quotes.JapanQuote.getInstance());
  private Team team1 = new Team("Team1", Rally.quotes.GermanyQuote.getInstance());
  private Team team2 = new Team("Team2", Rally.quotes.SouthKoreaQuote.getInstance());
  private Car car1t1 = new Car("Toyota Yaris", manufacturer2, 480L, 1200L);
  private Car car2t1 = new Car("Citroen C3", manufacturer1, 400L, 1300L);
  private Car car3t1 = new Car("Hyundai i20", manufacturer3, 370L, 1250L);
  private Car car1t2 = new Car("Citroen C4", manufacturer1, 400L, 1300L);
  private Car car2t2 = new Car("Mitsubishi Mirage R5", manufacturer4, 450L, 1310L);
  private Car car3t2 = new Car("Mitsubishi Lancer Evo X R4", manufacturer4, 420L, 1290L);
  private Driver driver1t1 =
      new Driver(
          "Dan",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GreatBritainQuote.getInstance(),
          DateUtils.MakeDate(1980L, 10L, 5L));
  private Driver driver2t1 =
      new Driver(
          "Joana",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.SpainQuote.getInstance(),
          DateUtils.MakeDate(1987L, 2L, 22L));
  private Driver driver3t1 =
      new Driver(
          "Alexio",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1995L, 5L, 29L));
  private Driver driver1t2 =
      new Driver(
          "Anne",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Driver driver2t2 =
      new Driver(
          "Anna",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Driver driver3t2 =
      new Driver(
          "Annie",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));

  public void Run() {

    IO.println("\nUse Cases Tests");
    champ1.AddTeam(team1);
    champ1.AddTeam(team2);
    rally1.AddStage(stage1r1);
    rally1.AddStage(stage2r1);
    rally2.AddStage(stage1r2);
    rally2.AddStage(stage2r2);
    rally2.AddStage(stage3r2);
    rally2.AddStage(stage4r2);
    rally3.AddStage(stage1r3);
    rally3.AddStage(stage2r3);
    rally3.AddStage(stage3r3);
    rally4.AddStage(stage1r4);
    rally5.AddStage(stage1r5);
    rally5.AddStage(stage2r5);
    rally5.AddStage(stage3r5);
    champ1.AddRally(rally1);
    champ1.AddRally(rally2);
    champ1.AddRally(rally3);
    champ1.AddRally(rally4);
    champ1.AddRally(rally5);
    team1.AddCar(car1t1);
    team1.AddCar(car2t1);
    team1.AddCar(car3t1);
    team2.AddCar(car1t2);
    team2.AddCar(car2t2);
    team2.AddCar(car3t2);
    team1.AddDriver(driver1t1);
    team1.AddDriver(driver2t1);
    team1.AddDriver(driver3t1);
    team2.AddDriver(driver1t2);
    team2.AddDriver(driver2t2);
    team2.AddDriver(driver3t2);
    team1.AssignCarToDriver(car1t1, driver1t1);
    team1.AssignCarToDriver(car2t1, driver2t1);
    team1.AssignCarToDriver(car3t1, driver3t1);
    team2.AssignCarToDriver(car1t2, driver1t2);
    team2.AssignCarToDriver(car2t2, driver2t2);
    team2.AssignCarToDriver(car3t2, driver3t2);
    IO.println("\nFinalizing Use Cases Tests");
  }

  public UseCasesTest() {}

  public String toString() {

    return "UseCasesTest{"
        + "champ1 := "
        + Utils.toString(champ1)
        + ", rally1 := "
        + Utils.toString(rally1)
        + ", rally2 := "
        + Utils.toString(rally2)
        + ", rally3 := "
        + Utils.toString(rally3)
        + ", rally4 := "
        + Utils.toString(rally4)
        + ", rally5 := "
        + Utils.toString(rally5)
        + ", stage1r1 := "
        + Utils.toString(stage1r1)
        + ", stage2r1 := "
        + Utils.toString(stage2r1)
        + ", stage1r2 := "
        + Utils.toString(stage1r2)
        + ", stage2r2 := "
        + Utils.toString(stage2r2)
        + ", stage3r2 := "
        + Utils.toString(stage3r2)
        + ", stage4r2 := "
        + Utils.toString(stage4r2)
        + ", stage1r3 := "
        + Utils.toString(stage1r3)
        + ", stage2r3 := "
        + Utils.toString(stage2r3)
        + ", stage3r3 := "
        + Utils.toString(stage3r3)
        + ", stage1r4 := "
        + Utils.toString(stage1r4)
        + ", stage1r5 := "
        + Utils.toString(stage1r5)
        + ", stage2r5 := "
        + Utils.toString(stage2r5)
        + ", stage3r5 := "
        + Utils.toString(stage3r5)
        + ", manufacturer1 := "
        + Utils.toString(manufacturer1)
        + ", manufacturer2 := "
        + Utils.toString(manufacturer2)
        + ", manufacturer3 := "
        + Utils.toString(manufacturer3)
        + ", manufacturer4 := "
        + Utils.toString(manufacturer4)
        + ", team1 := "
        + Utils.toString(team1)
        + ", team2 := "
        + Utils.toString(team2)
        + ", car1t1 := "
        + Utils.toString(car1t1)
        + ", car2t1 := "
        + Utils.toString(car2t1)
        + ", car3t1 := "
        + Utils.toString(car3t1)
        + ", car1t2 := "
        + Utils.toString(car1t2)
        + ", car2t2 := "
        + Utils.toString(car2t2)
        + ", car3t2 := "
        + Utils.toString(car3t2)
        + ", driver1t1 := "
        + Utils.toString(driver1t1)
        + ", driver2t1 := "
        + Utils.toString(driver2t1)
        + ", driver3t1 := "
        + Utils.toString(driver3t1)
        + ", driver1t2 := "
        + Utils.toString(driver1t2)
        + ", driver2t2 := "
        + Utils.toString(driver2t2)
        + ", driver3t2 := "
        + Utils.toString(driver3t2)
        + "}";
  }
}
