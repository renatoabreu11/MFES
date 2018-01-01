package Rally.tests;

import Rally.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PerformanceTest extends MyTestCase {
  private Team team0 = new Team("Test Team", GermanyQuote.getInstance());
  private Driver driver1 =
      new Driver(
          "Anne",
          FemaleQuote.getInstance(),
          GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Driver driver2 =
      new Driver(
          "Anna",
          FemaleQuote.getInstance(),
          GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Driver driver3 =
      new Driver(
          "Annie",
          FemaleQuote.getInstance(),
          GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Performance performance1 = null;
  private Performance performance2 = null;
  private Performance performance3 = null;
  private Ranking ranking1 = null;
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
  /* PerformanceTest.vdmpp 30:9 */
  public void Run() {

    IO.println("\nPerformance and Ranking Tests");
    team0.AddDriver(driver1);
    team0.AddDriver(driver2);
    team0.AddDriver(driver3);
    team0.AddCar(car1);
    team0.AddCar(car2);
    team0.AddCar(car3);
    team0.AssignCarToDriver(car1, driver1);
    team0.AssignCarToDriver(car2, driver2);
    team0.AssignCarToDriver(car3, driver3);
    performance1 = new Performance(driver1);
    performance2 = new Performance(driver2);
    performance3 = new Performance(driver3);
    performance1.SetTime(200L);
    performance1.SetAverageSpeed(50L);
    performance2.SetTime(217L);
    performance2.SetAverageSpeed(48L);
    performance2.SetPenalty(1L);
    performance3.SetTime(202L);
    performance3.SetAverageSpeed(50L);
    assertEqual(50L, performance1.GetAverageSpeed());
    assertEqual(48L, performance2.GetAverageSpeed());
    assertEqual(1L, performance2.GetPenalty());
    assertEqual(0L, performance3.GetPenalty());
    assertEqual(driver1, performance1.GetDriver());
    assertEqual(driver3, performance3.GetDriver());
    assertEqual(200L, performance1.GetTime());
    assertEqual(217L, performance2.GetTime());
    ranking1 = new Ranking(driver1);
    assertEqual(driver1, ranking1.GetDriver());
    assertEqual(0L, ranking1.GetPoints());
    ranking1.AddPoints(50L);
    assertEqual(50L, ranking1.GetPoints());
    ranking1.AddPoints(-20L);
    assertEqual(30L, ranking1.GetPoints());
    IO.println("\nFinalizing Performance and Ranking Tests");
  }
  /* PerformanceTest.vdmpp 1:7 */
  public PerformanceTest() {}

  public String toString() {

    return "PerformanceTest{"
        + "team0 := "
        + Utils.toString(team0)
        + ", driver1 := "
        + Utils.toString(driver1)
        + ", driver2 := "
        + Utils.toString(driver2)
        + ", driver3 := "
        + Utils.toString(driver3)
        + ", performance1 := "
        + Utils.toString(performance1)
        + ", performance2 := "
        + Utils.toString(performance2)
        + ", performance3 := "
        + Utils.toString(performance3)
        + ", ranking1 := "
        + Utils.toString(ranking1)
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
        + "}";
  }
}
