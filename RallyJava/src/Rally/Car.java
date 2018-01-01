package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Car {
  private Manufacturer manufacturer;
  private String model;
  private Number horsePower;
  private Number weight;

  public void cg_init_Car_1(
      final String model0,
      final Manufacturer manufacturer0,
      final Number horsePower0,
      final Number weight0) {

    model = model0;
    manufacturer = manufacturer0;
    horsePower = horsePower0;
    weight = weight0;
    return;
  }

  public Car(
      final String model0,
      final Manufacturer manufacturer0,
      final Number horsePower0,
      final Number weight0) {

    cg_init_Car_1(model0, manufacturer0, horsePower0, weight0);
  }

  public String GetModel() {

    return model;
  }

  public Number GetHorsePower() {

    return horsePower;
  }

  public Number GetWeight() {

    return weight;
  }

  public Manufacturer GetManufacturer() {

    return manufacturer;
  }

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
