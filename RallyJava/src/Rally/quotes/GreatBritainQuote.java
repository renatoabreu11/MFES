package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GreatBritainQuote {
  private static int hc = 0;
  private static GreatBritainQuote instance = null;

  public GreatBritainQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GreatBritainQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GreatBritainQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GreatBritainQuote;
  }

  public String toString() {

    return "<GreatBritain>";
  }
}
