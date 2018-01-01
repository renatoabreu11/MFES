package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Performance {
  private Driver driver = null;
  private Number averageSpeed = 0.0;
  private Number time = 0.0;
  private Number penalty = 0L;
  /* Performance.vdmpp 12:10 */
  public void cg_init_Performance_1(final Driver driver0) {

    /* Performance.vdmpp 14:4 */
    driver = driver0;
    /* Performance.vdmpp 15:5 */
    return;
  }
  /* Performance.vdmpp 12:10 */
  public Performance(final Driver driver0) {

    cg_init_Performance_1(driver0);
  }
  /* Performance.vdmpp 19:14 */
  public Driver GetDriver() {

    /* Performance.vdmpp 21:5 */
    return driver;
  }
  /* Performance.vdmpp 24:14 */
  public Number GetAverageSpeed() {

    /* Performance.vdmpp 26:5 */
    return averageSpeed;
  }
  /* Performance.vdmpp 29:9 */
  public void SetAverageSpeed(final Number avg) {

    /* Performance.vdmpp 31:5 */
    averageSpeed = avg;
  }
  /* Performance.vdmpp 34:14 */
  public Number GetTime() {

    /* Performance.vdmpp 36:5 */
    return time;
  }
  /* Performance.vdmpp 39:9 */
  public void SetTime(final Number t) {

    /* Performance.vdmpp 41:5 */
    time = t;
  }
  /* Performance.vdmpp 44:14 */
  public Number GetPenalty() {

    /* Performance.vdmpp 46:5 */
    return penalty;
  }
  /* Performance.vdmpp 49:9 */
  public void SetPenalty(final Number p) {

    /* Performance.vdmpp 51:5 */
    penalty = p;
  }
  /* Performance.vdmpp 1:7 */
  public Performance() {}

  public String toString() {

    return "Performance{"
        + "driver := "
        + Utils.toString(driver)
        + ", averageSpeed := "
        + Utils.toString(averageSpeed)
        + ", time := "
        + Utils.toString(time)
        + ", penalty := "
        + Utils.toString(penalty)
        + "}";
  }
}
