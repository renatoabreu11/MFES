package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SpecialQuote {
  private static int hc = 0;
  private static SpecialQuote instance = null;

  public SpecialQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SpecialQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SpecialQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SpecialQuote;
  }

  public String toString() {

    return "<Special>";
  }
}
