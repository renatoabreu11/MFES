package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Performance {
  private Driver driver = null;
  private Number averageSpeed = 0.0;
  private Number time = 0.0;
  private Number penalty = 0L;

  public void cg_init_Performance_1(final Driver driver0) {

    driver = driver0;
    return;
  }

  public Performance(final Driver driver0) {

    cg_init_Performance_1(driver0);
  }

  public Driver GetDriver() {

    return driver;
  }

  public Number GetAverageSpeed() {

    return averageSpeed;
  }

  public void SetAverageSpeed(final Number avg) {

    averageSpeed = avg;
  }

  public Number GetTime() {

    return time;
  }

  public void SetTime(final Number t) {

    time = t;
  }

  public Number GetPenalty() {

    return penalty;
  }

  public void SetPenalty(final Number p) {

    penalty = p;
  }

  public Performance() {}

  public static Number Compare(final Performance p1, final Performance p2) {

    if (p1.time.doubleValue() > p2.time.doubleValue()) {
      return 1L;

    } else {
      return -1L;
    }
  }

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
