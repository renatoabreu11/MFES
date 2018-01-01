package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GermanyQuote {
  private static int hc = 0;
  private static GermanyQuote instance = null;

  public GermanyQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GermanyQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GermanyQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GermanyQuote;
  }

  public String toString() {

    return "<Germany>";
  }
}
