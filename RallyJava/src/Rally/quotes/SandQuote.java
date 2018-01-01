package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SandQuote {
  private static int hc = 0;
  private static SandQuote instance = null;

  public SandQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SandQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SandQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SandQuote;
  }

  public String toString() {

    return "<Sand>";
  }
}
