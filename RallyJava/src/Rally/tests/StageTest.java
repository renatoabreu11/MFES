package Rally.tests;

import Rally.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StageTest extends MyTestCase {
  private Stage stage1 =
      new Stage(
          1L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 1L), 10L);
  private Stage stage2 =
      new Stage(
          2L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 2L), 50L);
  private Stage stage3 =
      new Stage(
          3L, SpecialQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 3L), 3L);
  private Stage stage4 =
      new Stage(
          4L, TransportQuote.getInstance(), DateUtils.MakeDate(2017L, 12L, 5L), 100L);
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
  /* StageTest.vdmpp 33:9 */
  public void Run() {

    /* StageTest.vdmpp 35:3 */
    IO.println("\nStage Tests");
    /* StageTest.vdmpp 38:3 */
    team0.AddDriver(driver1);
    /* StageTest.vdmpp 39:3 */
    team0.AddDriver(driver2);
    /* StageTest.vdmpp 40:3 */
    team0.AddDriver(driver3);
    /* StageTest.vdmpp 41:3 */
    team0.AddCar(car1);
    /* StageTest.vdmpp 42:3 */
    team0.AddCar(car2);
    /* StageTest.vdmpp 43:3 */
    team0.AddCar(car3);
    /* StageTest.vdmpp 44:3 */
    team0.AssignCarToDriver(car1, driver1);
    /* StageTest.vdmpp 45:3 */
    team0.AssignCarToDriver(car2, driver2);
    /* StageTest.vdmpp 46:3 */
    team0.AssignCarToDriver(car3, driver3);
    /* StageTest.vdmpp 47:3 */
    performance1 = new Performance(driver1);
    /* StageTest.vdmpp 48:3 */
    performance2 = new Performance(driver2);
    /* StageTest.vdmpp 49:3 */
    performance3 = new Performance(driver3);
    /* StageTest.vdmpp 51:3 */
    performance1.SetTime(200L);
    /* StageTest.vdmpp 52:3 */
    performance1.SetAverageSpeed(50L);
    /* StageTest.vdmpp 54:3 */
    performance2.SetTime(217L);
    /* StageTest.vdmpp 55:3 */
    performance2.SetAverageSpeed(48L);
    /* StageTest.vdmpp 56:3 */
    performance2.SetPenalty(1L);
    /* StageTest.vdmpp 58:3 */
    performance3.SetTime(202L);
    /* StageTest.vdmpp 59:3 */
    performance3.SetAverageSpeed(52L);
    /* StageTest.vdmpp 62:3 */
    assertEqual(1L, stage1.GetId());
    /* StageTest.vdmpp 63:3 */
    assertEqual(2L, stage2.GetId());
    /* StageTest.vdmpp 66:3 */
    assertEqual(OffSeasonQuote.getInstance(), ((Object) stage1.GetState()));
    /* StageTest.vdmpp 67:3 */
    stage1.Init();
    /* StageTest.vdmpp 68:3 */
    assertEqual(OccurringQuote.getInstance(), ((Object) stage1.GetState()));
    /* StageTest.vdmpp 69:3 */
    stage1.Finalize();
    /* StageTest.vdmpp 70:3 */
    assertEqual(CompletedQuote.getInstance(), ((Object) stage1.GetState()));
    /* StageTest.vdmpp 73:3 */
    assertEqual(SpecialQuote.getInstance(), ((Object) stage1.GetType()));
    /* StageTest.vdmpp 74:3 */
    assertEqual(TransportQuote.getInstance(), ((Object) stage4.GetType()));
    /* StageTest.vdmpp 76:3 */
    stage1.AddPerformance(performance1);
    /* StageTest.vdmpp 77:3 */
    stage1.AddPerformance(performance2);
    /* StageTest.vdmpp 78:3 */
    stage1.AddPerformance(performance3);
    /* StageTest.vdmpp 81:3 */
    assertEqual(DateUtils.MakeDate(2017L, 12L, 3L), stage3.GetDate());
    /* StageTest.vdmpp 82:3 */
    assertEqual(DateUtils.MakeDate(2017L, 12L, 5L), stage4.GetDate());
    /* StageTest.vdmpp 85:3 */
    assertEqual(10L, stage1.GetDistance());
    /* StageTest.vdmpp 86:3 */
    assertEqual(100L, stage4.GetDistance());
    /* StageTest.vdmpp 89:3 */
    assertEqual(performance1, stage1.GetDriverPerformance(driver1));
    /* StageTest.vdmpp 90:3 */
    assertEqual(null, stage2.GetDriverPerformance(driver1));
    /* StageTest.vdmpp 91:5 */
    assertEqual(performance3, stage1.GetDriverPerformance(driver3));
    /* StageTest.vdmpp 92:5 */
    assertEqual(performance2, stage1.GetDriverPerformance(driver2.GetName()));
    /* StageTest.vdmpp 93:5 */
    assertEqual(null, stage2.GetDriverPerformance(driver1.GetName()));
    /* StageTest.vdmpp 96:3 */
    assertEqual(SeqUtil.seq(performance1, performance3, performance2), stage1.GetPerformances());
    /* StageTest.vdmpp 98:3 */
    IO.println("\nFinalizing Stage Tests");
  }
  /* StageTest.vdmpp 1:7 */
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
