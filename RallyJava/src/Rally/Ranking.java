package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Ranking {
  private Driver driver = null;
  private Number points = 0L;

  public void cg_init_Ranking_1(final Driver driver0) {

    driver = driver0;
    return;
  }

  public Ranking(final Driver driver0) {

    cg_init_Ranking_1(driver0);
  }

  public void AddPoints(final Number score) {

    points = points.longValue() + score.longValue();
  }

  public Driver GetDriver() {

    return driver;
  }

  public Number GetPoints() {

    return points;
  }

  public Ranking() {}

  public String toString() {

    return "Ranking{"
        + "driver := "
        + Utils.toString(driver)
        + ", points := "
        + Utils.toString(points)
        + "}";
  }
}
