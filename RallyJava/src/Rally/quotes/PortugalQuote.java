package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PortugalQuote {
  private static int hc = 0;
  private static PortugalQuote instance = null;

  public PortugalQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PortugalQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PortugalQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PortugalQuote;
  }

  public String toString() {

    return "<Portugal>";
  }
}
