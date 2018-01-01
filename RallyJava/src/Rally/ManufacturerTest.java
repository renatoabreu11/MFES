package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ManufacturerTest extends MyTestCase {
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

  public void Run() {

    IO.println("\nManufacturer Tests");
    assertEqual("Citroën", manufacturer1.GetName());
    assertEqual(
        "Toyota is one of the world’s best-known and most successful businesses, building cars and trucks in 26 countries for sale in more than 160 markets around the globe.",
        manufacturer2.GetDescription());
    assertEqual(Rally.quotes.SouthKoreaQuote.getInstance(), ((Object) manufacturer3.GetCountry()));
    IO.println("\nFinalizing Manufacturer Tests");
  }

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
