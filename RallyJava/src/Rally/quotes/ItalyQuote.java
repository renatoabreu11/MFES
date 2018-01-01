package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ItalyQuote {
  private static int hc = 0;
  private static ItalyQuote instance = null;

  public ItalyQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ItalyQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ItalyQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ItalyQuote;
  }

  public String toString() {

    return "<Italy>";
  }
}
