package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MountainQuote {
  private static int hc = 0;
  private static MountainQuote instance = null;

  public MountainQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MountainQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MountainQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MountainQuote;
  }

  public String toString() {

    return "<Mountain>";
  }
}
