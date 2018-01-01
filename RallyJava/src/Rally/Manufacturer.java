package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Manufacturer {
  private String name;
  private String description;
  private Object country;

  public void cg_init_Manufacturer_1(
      final String name0, final String description0, final Object country0) {

    name = name0;
    description = description0;
    country = country0;
    return;
  }

  public Manufacturer(final String name0, final String description0, final Object country0) {

    cg_init_Manufacturer_1(name0, description0, country0);
  }

  public String GetName() {

    return name;
  }

  public String GetDescription() {

    return description;
  }

  public Object GetCountry() {

    return country;
  }

  public Manufacturer() {}

  public String toString() {

    return "Manufacturer{"
        + "name := "
        + Utils.toString(name)
        + ", description := "
        + Utils.toString(description)
        + ", country := "
        + Utils.toString(country)
        + "}";
  }
}
