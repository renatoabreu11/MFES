package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Manufacturer {
  private String name;
  private String description;
  private Object country;
  /* Manufacturer.vdmpp 13:10 */
  public void cg_init_Manufacturer_1(
      final String name0, final String description0, final Object country0) {

    /* Manufacturer.vdmpp 15:5 */
    name = name0;
    /* Manufacturer.vdmpp 16:5 */
    description = description0;
    /* Manufacturer.vdmpp 17:5 */
    country = country0;
    /* Manufacturer.vdmpp 18:5 */
    return;
  }
  /* Manufacturer.vdmpp 13:10 */
  public Manufacturer(final String name0, final String description0, final Object country0) {

    cg_init_Manufacturer_1(name0, description0, country0);
  }
  /* Manufacturer.vdmpp 23:14 */
  public String GetName() {

    /* Manufacturer.vdmpp 25:5 */
    return name;
  }
  /* Manufacturer.vdmpp 28:14 */
  public String GetDescription() {

    /* Manufacturer.vdmpp 30:5 */
    return description;
  }
  /* Manufacturer.vdmpp 33:14 */
  public Object GetCountry() {

    /* Manufacturer.vdmpp 35:5 */
    return country;
  }
  /* Manufacturer.vdmpp 1:7 */
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
