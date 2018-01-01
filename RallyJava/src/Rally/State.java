package Rally;

import java.util.*;
import Rally.quotes.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class State {
  protected Object state = OffSeasonQuote.getInstance();
  /* State.vdmpp 10:9 */
  public void Init() {

    /* State.vdmpp 12:4 */
    state = OccurringQuote.getInstance();
  }
  /* State.vdmpp 16:9 */
  public void Finalize() {

    /* State.vdmpp 18:4 */
    state = CompletedQuote.getInstance();
  }
  /* State.vdmpp 22:14 */
  public Object GetState() {

    /* State.vdmpp 24:5 */
    return state;
  }
  /* State.vdmpp 1:7 */
  public State() {}

  public String toString() {

    return "State{" + "state := " + Utils.toString(state) + "}";
  }
}
