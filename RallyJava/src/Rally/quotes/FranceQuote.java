package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FranceQuote {
  private static int hc = 0;
  private static FranceQuote instance = null;

  public FranceQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FranceQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FranceQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FranceQuote;
  }

  public String toString() {

    return "<France>";
  }
}
