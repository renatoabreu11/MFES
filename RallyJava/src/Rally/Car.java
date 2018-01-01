package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Car {
  private Manufacturer manufacturer;
  private String model;
  private Number horsePower;
  private Number weight;
  /* Car.vdmpp 13:9 */
  public void cg_init_Car_1(
      final String model0,
      final Manufacturer manufacturer0,
      final Number horsePower0,
      final Number weight0) {

    /* Car.vdmpp 15:5 */
    model = model0;
    /* Car.vdmpp 16:5 */
    manufacturer = manufacturer0;
    /* Car.vdmpp 17:5 */
    horsePower = horsePower0;
    /* Car.vdmpp 18:5 */
    weight = weight0;
    /* Car.vdmpp 19:5 */
    return;
  }
  /* Car.vdmpp 13:9 */
  public Car(
      final String model0,
      final Manufacturer manufacturer0,
      final Number horsePower0,
      final Number weight0) {

    cg_init_Car_1(model0, manufacturer0, horsePower0, weight0);
  }
  /* Car.vdmpp 24:14 */
  public String GetModel() {

    /* Car.vdmpp 26:5 */
    return model;
  }
  /* Car.vdmpp 29:14 */
  public Number GetHorsePower() {

    /* Car.vdmpp 31:5 */
    return horsePower;
  }
  /* Car.vdmpp 34:14 */
  public Number GetWeight() {

    /* Car.vdmpp 36:5 */
    return weight;
  }
  /* Car.vdmpp 39:14 */
  public Manufacturer GetManufacturer() {

    /* Car.vdmpp 41:5 */
    return manufacturer;
  }
  /* Car.vdmpp 1:7 */
  public Car() {}

  public String toString() {

    return "Car{"
        + "manufacturer := "
        + Utils.toString(manufacturer)
        + ", model := "
        + Utils.toString(model)
        + ", horsePower := "
        + Utils.toString(horsePower)
        + ", weight := "
        + Utils.toString(weight)
        + "}";
  }
}
