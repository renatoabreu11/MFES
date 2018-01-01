package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PerformanceTest extends MyTestCase {
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
  private Ranking ranking1 = null;
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

    throw new UnsupportedOperationException();
  }

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
