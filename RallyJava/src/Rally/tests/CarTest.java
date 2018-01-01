package Rally.tests;

import Rally.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CarTest extends MyTestCase {
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
  /* CarTest.vdmpp 19:9 */
  public void Run() {

    /* CarTest.vdmpp 21:3 */
    IO.println("\nCar Tests");
    /* CarTest.vdmpp 23:3 */
    assertEqual("Hyundai i20", car1.GetModel());
    /* CarTest.vdmpp 24:3 */
    assertEqual(manufacturer1, car2.GetManufacturer());
    /* CarTest.vdmpp 25:3 */
    assertEqual(480L, car3.GetHorsePower());
    /* CarTest.vdmpp 26:3 */
    assertEqual(1300L, car2.GetWeight());
    /* CarTest.vdmpp 28:3 */
    IO.println("\nFinalizing Car Tests");
  }
  /* CarTest.vdmpp 1:7 */
  public CarTest() {}

  public String toString() {

    return "CarTest{"
        + "manufacturer1 := "
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
