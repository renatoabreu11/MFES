package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SouthKoreaQuote {
  private static int hc = 0;
  private static SouthKoreaQuote instance = null;

  public SouthKoreaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SouthKoreaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SouthKoreaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SouthKoreaQuote;
  }

  public String toString() {

    return "<SouthKorea>";
  }
}
