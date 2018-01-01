package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DriverTest extends MyTestCase {
  private Team team1 = new Team("The Awesome Ones", Rally.quotes.GreatBritainQuote.getInstance());
  private Team team2 = new Team("The Better Ones", Rally.quotes.SpainQuote.getInstance());
  private Manufacturer manufacturer1 =
      new Manufacturer(
          "Hyunday", "Hyundai Motor Company", Rally.quotes.SouthKoreaQuote.getInstance());
  private Manufacturer manufacturer2 =
      new Manufacturer("Citroen", "Citroen", Rally.quotes.FranceQuote.getInstance());
  private Manufacturer manufacturer3 =
      new Manufacturer("Toyota", "Toyota", Rally.quotes.JapanQuote.getInstance());
  private Car car1 = new Car("Hyundai i20", manufacturer1, 370L, 1250L);
  private Driver driver1 =
      new Driver(
          "Dan",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GreatBritainQuote.getInstance(),
          DateUtils.MakeDate(1980L, 10L, 5L));
  private Car car2 = new Car("Citroen C3", manufacturer2, 400L, 1300L);
  private Driver driver2 =
      new Driver(
          "Joana",
          Rally.quotes.FemaleQuote.getInstance(),
          Rally.quotes.SpainQuote.getInstance(),
          DateUtils.MakeDate(1987L, 2L, 22L));
  private Car car3 = new Car("Toyota Yaris", manufacturer3, 480L, 1200L);
  private Driver driver3 =
      new Driver(
          "Alexio",
          Rally.quotes.MaleQuote.getInstance(),
          Rally.quotes.GermanyQuote.getInstance(),
          DateUtils.MakeDate(1995L, 5L, 29L));

  public void Run() {

    IO.println("\nDriver Tests");
    team1.SetBacker(manufacturer1);
    team1.AddDriver(driver1);
    team1.AddCar(car1);
    team1.AssignCarToDriver(car1, driver1);
    team2.AddDriver(driver2);
    team2.AddCar(car2);
    team2.AssignCarToDriver(car2, driver2);
    team2.AddDriver(driver3);
    team2.AddCar(car3);
    team2.AssignCarToDriver(car3, driver3);
    assertEqual(team1, driver1.GetTeam());
    assertEqual(team2, driver2.GetTeam());
    assertEqual(DateUtils.MakeDate(1980L, 10L, 5L), driver1.GetBirth());
    assertEqual(DateUtils.MakeDate(1995L, 5L, 29L), driver3.GetBirth());
    assertEqual(Rally.quotes.SpainQuote.getInstance(), ((Object) driver2.GetNationality()));
    assertEqual(Rally.quotes.GermanyQuote.getInstance(), ((Object) driver3.GetNationality()));
    assertEqual(Rally.quotes.FemaleQuote.getInstance(), ((Object) driver2.GetGender()));
    assertEqual(Rally.quotes.MaleQuote.getInstance(), ((Object) driver3.GetGender()));
    assertEqual("Dan", driver1.GetName());
    assertEqual("Joana", driver2.GetName());
    assertEqual(car1, driver1.GetCar());
    driver1.RemoveCar();
    assertEqual(null, driver1.GetCar());
    assertEqual(car3, driver3.GetCar());
    assertEqual(team1, driver1.GetTeam());
    assertEqual(team2, driver2.GetTeam());
    IO.println("\nFinalizing Driver Tests");
  }

  public DriverTest() {}

  public String toString() {

    return "DriverTest{"
        + "team1 := "
        + Utils.toString(team1)
        + ", team2 := "
        + Utils.toString(team2)
        + ", manufacturer1 := "
        + Utils.toString(manufacturer1)
        + ", manufacturer2 := "
        + Utils.toString(manufacturer2)
        + ", manufacturer3 := "
        + Utils.toString(manufacturer3)
        + ", car1 := "
        + Utils.toString(car1)
        + ", driver1 := "
        + Utils.toString(driver1)
        + ", car2 := "
        + Utils.toString(car2)
        + ", driver2 := "
        + Utils.toString(driver2)
        + ", car3 := "
        + Utils.toString(car3)
        + ", driver3 := "
        + Utils.toString(driver3)
        + "}";
  }
}
