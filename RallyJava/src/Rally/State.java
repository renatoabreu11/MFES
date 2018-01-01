package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class State {
  protected Object state = Rally.quotes.OffSeasonQuote.getInstance();

  public void Init() {

    state = Rally.quotes.OccurringQuote.getInstance();
  }

  public void Finalize() {

    state = Rally.quotes.CompletedQuote.getInstance();
  }

  public Object GetState() {

    return state;
  }

  public State() {}

  public String toString() {

    return "State{" + "state := " + Utils.toString(state) + "}";
  }
}
