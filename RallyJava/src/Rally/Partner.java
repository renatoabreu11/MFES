package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Partner {
  private String name;
  private String description;
  /* Partner.vdmpp 11:10 */
  public void cg_init_Partner_1(final String name0, final String description0) {

    /* Partner.vdmpp 13:5 */
    name = name0;
    /* Partner.vdmpp 14:5 */
    description = description0;
    /* Partner.vdmpp 15:5 */
    return;
  }
  /* Partner.vdmpp 11:10 */
  public Partner(final String name0, final String description0) {

    cg_init_Partner_1(name0, description0);
  }
  /* Partner.vdmpp 20:14 */
  public String GetName() {

    /* Partner.vdmpp 22:5 */
    return name;
  }
  /* Partner.vdmpp 25:14 */
  public String GetDescription() {

    /* Partner.vdmpp 27:5 */
    return description;
  }
  /* Partner.vdmpp 1:7 */
  public Partner() {}

  public String toString() {

    return "Partner{"
        + "name := "
        + Utils.toString(name)
        + ", description := "
        + Utils.toString(description)
        + "}";
  }
}
