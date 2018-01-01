package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SpainQuote {
  private static int hc = 0;
  private static SpainQuote instance = null;

  public SpainQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SpainQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SpainQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SpainQuote;
  }

  public String toString() {

    return "<Spain>";
  }
}
