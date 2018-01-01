package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class OccurringQuote {
  private static int hc = 0;
  private static OccurringQuote instance = null;

  public OccurringQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static OccurringQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new OccurringQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof OccurringQuote;
  }

  public String toString() {

    return "<Occurring>";
  }
}
