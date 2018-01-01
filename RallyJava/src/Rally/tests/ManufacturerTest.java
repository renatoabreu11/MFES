package Rally.tests;

import Rally.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ManufacturerTest extends MyTestCase {
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
  /* ManufacturerTest.vdmpp 15:9 */
  public void Run() {

    /* ManufacturerTest.vdmpp 17:3 */
    IO.println("\nManufacturer Tests");
    /* ManufacturerTest.vdmpp 19:3 */
    assertEqual("Citroën", manufacturer1.GetName());
    /* ManufacturerTest.vdmpp 20:3 */
    assertEqual(
        "Toyota is one of the world’s best-known and most successful businesses, building cars and trucks in 26 countries for sale in more than 160 markets around the globe.",
        manufacturer2.GetDescription());
    /* ManufacturerTest.vdmpp 21:3 */
    assertEqual(SouthKoreaQuote.getInstance(), ((Object) manufacturer3.GetCountry()));
    /* ManufacturerTest.vdmpp 23:3 */
    IO.println("\nFinalizing Manufacturer Tests");
  }
  /* ManufacturerTest.vdmpp 1:7 */
  public ManufacturerTest() {}

  public String toString() {

    return "ManufacturerTest{"
        + "manufacturer1 := "
        + Utils.toString(manufacturer1)
        + ", manufacturer2 := "
        + Utils.toString(manufacturer2)
        + ", manufacturer3 := "
        + Utils.toString(manufacturer3)
        + "}";
  }
}
