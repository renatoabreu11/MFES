package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GravelQuote {
  private static int hc = 0;
  private static GravelQuote instance = null;

  public GravelQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GravelQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GravelQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GravelQuote;
  }

  public String toString() {

    return "<Gravel>";
  }
}
