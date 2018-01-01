package Rally.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CompletedQuote {
  private static int hc = 0;
  private static CompletedQuote instance = null;

  public CompletedQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CompletedQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CompletedQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CompletedQuote;
  }

  public String toString() {

    return "<Completed>";
  }
}
