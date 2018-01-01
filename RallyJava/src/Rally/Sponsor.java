package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Sponsor {
  private String name;
  private String description;
  /* Sponsor.vdmpp 11:10 */
  public void cg_init_Sponsor_1(final String name0, final String description0) {

    /* Sponsor.vdmpp 13:5 */
    name = name0;
    /* Sponsor.vdmpp 14:5 */
    description = description0;
    /* Sponsor.vdmpp 15:5 */
    return;
  }
  /* Sponsor.vdmpp 11:10 */
  public Sponsor(final String name0, final String description0) {

    cg_init_Sponsor_1(name0, description0);
  }
  /* Sponsor.vdmpp 20:14 */
  public String GetName() {

    /* Sponsor.vdmpp 22:5 */
    return name;
  }
  /* Sponsor.vdmpp 25:14 */
  public String GetDescription() {

    /* Sponsor.vdmpp 27:5 */
    return description;
  }
  /* Sponsor.vdmpp 1:7 */
  public Sponsor() {}

  public String toString() {

    return "Sponsor{"
        + "name := "
        + Utils.toString(name)
        + ", description := "
        + Utils.toString(description)
        + "}";
  }
}
