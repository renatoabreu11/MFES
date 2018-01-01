package Rally.tests;

import Rally.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DriverTest extends MyTestCase {
  private Team team1 = new Team("The Awesome Ones", GreatBritainQuote.getInstance());
  private Team team2 = new Team("The Better Ones", SpainQuote.getInstance());
  private Manufacturer manufacturer1 =
      new Manufacturer(
          "Hyunday", "Hyundai Motor Company", SouthKoreaQuote.getInstance());
  private Manufacturer manufacturer2 =
      new Manufacturer("Citroen", "Citroen", FranceQuote.getInstance());
  private Manufacturer manufacturer3 =
      new Manufacturer("Toyota", "Toyota", JapanQuote.getInstance());
  private Car car1 = new Car("Hyundai i20", manufacturer1, 370L, 1250L);
  private Driver driver1 =
      new Driver(
          "Dan",
          MaleQuote.getInstance(),
          GreatBritainQuote.getInstance(),
          DateUtils.MakeDate(1980L, 10L, 5L));
  private Car car2 = new Car("Citroen C3", manufacturer2, 400L, 1300L);
  private Driver driver2 =
      new Driver(
          "Joana",
          FemaleQuote.getInstance(),
          SpainQuote.getInstance(),
          DateUtils.MakeDate(1987L, 2L, 22L));
  private Car car3 = new Car("Toyota Yaris", manufacturer3, 480L, 1200L);
  private Driver driver3 =
      new Driver(
          "Alexio",
          MaleQuote.getInstance(),
          GermanyQuote.getInstance(),
          DateUtils.MakeDate(1995L, 5L, 29L));
  /* DriverTest.vdmpp 21:9 */
  public void Run() {

    /* DriverTest.vdmpp 23:3 */
    IO.println("\nDriver Tests");
    /* DriverTest.vdmpp 26:3 */
    team1.SetBacker(manufacturer1);
    /* DriverTest.vdmpp 27:3 */
    team1.AddDriver(driver1);
    /* DriverTest.vdmpp 28:3 */
    team1.AddCar(car1);
    /* DriverTest.vdmpp 29:3 */
    team1.AssignCarToDriver(car1, driver1);
    /* DriverTest.vdmpp 31:3 */
    team2.AddDriver(driver2);
    /* DriverTest.vdmpp 32:3 */
    team2.AddCar(car2);
    /* DriverTest.vdmpp 33:3 */
    team2.AssignCarToDriver(car2, driver2);
    /* DriverTest.vdmpp 35:3 */
    team2.AddDriver(driver3);
    /* DriverTest.vdmpp 36:3 */
    team2.AddCar(car3);
    /* DriverTest.vdmpp 37:3 */
    team2.AssignCarToDriver(car3, driver3);
    /* DriverTest.vdmpp 40:3 */
    assertEqual(team1, driver1.GetTeam());
    /* DriverTest.vdmpp 41:3 */
    assertEqual(team2, driver2.GetTeam());
    /* DriverTest.vdmpp 44:3 */
    assertEqual(DateUtils.MakeDate(1980L, 10L, 5L), driver1.GetBirth());
    /* DriverTest.vdmpp 45:3 */
    assertEqual(DateUtils.MakeDate(1995L, 5L, 29L), driver3.GetBirth());
    /* DriverTest.vdmpp 48:3 */
    assertEqual(SpainQuote.getInstance(), ((Object) driver2.GetNationality()));
    /* DriverTest.vdmpp 49:3 */
    assertEqual(GermanyQuote.getInstance(), ((Object) driver3.GetNationality()));
    /* DriverTest.vdmpp 52:3 */
    assertEqual(FemaleQuote.getInstance(), ((Object) driver2.GetGender()));
    /* DriverTest.vdmpp 53:3 */
    assertEqual(MaleQuote.getInstance(), ((Object) driver3.GetGender()));
    /* DriverTest.vdmpp 56:3 */
    assertEqual("Dan", driver1.GetName());
    /* DriverTest.vdmpp 57:3 */
    assertEqual("Joana", driver2.GetName());
    /* DriverTest.vdmpp 60:3 */
    assertEqual(car1, driver1.GetCar());
    /* DriverTest.vdmpp 61:3 */
    driver1.RemoveCar();
    /* DriverTest.vdmpp 62:3 */
    assertEqual(null, driver1.GetCar());
    /* DriverTest.vdmpp 63:3 */
    assertEqual(car3, driver3.GetCar());
    /* DriverTest.vdmpp 66:3 */
    assertEqual(team1, driver1.GetTeam());
    /* DriverTest.vdmpp 67:3 */
    assertEqual(team2, driver2.GetTeam());
    /* DriverTest.vdmpp 69:3 */
    IO.println("\nFinalizing Driver Tests");
  }
  /* DriverTest.vdmpp 1:7 */
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
