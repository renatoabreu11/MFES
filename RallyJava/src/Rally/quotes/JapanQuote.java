package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JapanQuote {
  private static int hc = 0;
  private static JapanQuote instance = null;

  public JapanQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static JapanQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new JapanQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof JapanQuote;
  }

  public String toString() {

    return "<Japan>";
  }
}
