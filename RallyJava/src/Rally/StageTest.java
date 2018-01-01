package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StageTest extends MyTestCase {
  private Stage stage1 =
      new Stage(
          1L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 1L), 10L);
  private Stage stage2 =
      new Stage(
          2L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 2L), 50L);
  private Stage stage3 =
      new Stage(
          3L, Rally.quotes.SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 3L), 3L);
  private Stage stage4 =
      new Stage(
          4L, Rally.quotes.TransportQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 5L), 100L);
  private Team team0 = new Team("Test Team", Rally.quotes.GermanyQuote.getInstance());
  private Driver driver1 =
      new Driver(
          "Anne",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Driver driver2 =
      new Driver(
          "Anna",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Driver driver3 =
      new Driver(
          "Annie",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1990L, 8L, 7L));
  private Performance performance1 = null;
  private Performance performance2 = null;
  private Performance performance3 = null;
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

  public void Run() {

    IO.println("\nStage Tests");
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
    performance3.SetAverageSpeed(52L);
    assertEqual(1L, stage1.GetId());
    assertEqual(2L, stage2.GetId());
    assertEqual(Rally.quotes.OffSeasonQuote.getInstance(), ((Object) stage1.GetState()));
    stage1.Init();
    assertEqual(Rally.quotes.OccurringQuote.getInstance(), ((Object) stage1.GetState()));
    stage1.Finalize();
    assertEqual(Rally.quotes.CompletedQuote.getInstance(), ((Object) stage1.GetState()));
    assertEqual(Rally.quotes.SpecialQuote.getInstance(), ((Object) stage1.GetType()));
    assertEqual(Rally.quotes.TransportQuote.getInstance(), ((Object) stage4.GetType()));
    stage1.AddPerformance(performance1);
    stage1.AddPerformance(performance2);
    stage1.AddPerformance(performance3);
    assertEqual(DateUtils.MakeDate(2017L, 12L, 3L), stage3.GetDate());
    assertEqual(DateUtils.MakeDate(2017L, 12L, 5L), stage4.GetDate());
    assertEqual(10L, stage1.GetDistance());
    assertEqual(100L, stage4.GetDistance());
    assertEqual(performance1, stage1.GetDriverPerformance(driver1));
    assertEqual(null, stage2.GetDriverPerformance(driver1));
    assertEqual(performance3, stage1.GetDriverPerformance(driver3));
    assertEqual(performance2, stage1.GetDriverPerformance(driver2.GetName()));
    assertEqual(null, stage2.GetDriverPerformance(driver1.GetName()));
    assertEqual(SeqUtil.seq(performance1, performance3, performance2), stage1.GetPerformances());
    assertEqual(
        SeqUtil.seq(performance3, performance1, performance2),
        stage1.GetPerformancesSortedByAverageSpeed());
    IO.println("\nFinalizing Stage Tests");
  }

  public StageTest() {}

  public String toString() {

    return "StageTest{"
        + "stage1 := "
        + Utils.toString(stage1)
        + ", stage2 := "
        + Utils.toString(stage2)
        + ", stage3 := "
        + Utils.toString(stage3)
        + ", stage4 := "
        + Utils.toString(stage4)
        + ", team0 := "
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
