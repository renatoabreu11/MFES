package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ForestQuote {
  private static int hc = 0;
  private static ForestQuote instance = null;

  public ForestQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ForestQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ForestQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ForestQuote;
  }

  public String toString() {

    return "<Forest>";
  }
}
