package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SnowQuote {
  private static int hc = 0;
  private static SnowQuote instance = null;

  public SnowQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SnowQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SnowQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SnowQuote;
  }

  public String toString() {

    return "<Snow>";
  }
}
