package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AsphaltQuote {
  private static int hc = 0;
  private static AsphaltQuote instance = null;

  public AsphaltQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AsphaltQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AsphaltQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AsphaltQuote;
  }

  public String toString() {

    return "<Asphalt>";
  }
}
