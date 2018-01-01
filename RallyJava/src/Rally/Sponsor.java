package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Sponsor {
  private String name;
  private String description;

  public void cg_init_Sponsor_1(final String name0, final String description0) {

    name = name0;
    description = description0;
    return;
  }

  public Sponsor(final String name0, final String description0) {

    cg_init_Sponsor_1(name0, description0);
  }

  public String GetName() {

    return name;
  }

  public String GetDescription() {

    return description;
  }

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
