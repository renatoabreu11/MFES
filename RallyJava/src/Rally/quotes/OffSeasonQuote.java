package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class OffSeasonQuote {
  private static int hc = 0;
  private static OffSeasonQuote instance = null;

  public OffSeasonQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static OffSeasonQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new OffSeasonQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof OffSeasonQuote;
  }

  public String toString() {

    return "<OffSeason>";
  }
}
