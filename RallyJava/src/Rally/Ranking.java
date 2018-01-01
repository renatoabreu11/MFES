package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Ranking {
  private Driver driver = null;
  private Number points = 0L;
  /* Ranking.vdmpp 10:10 */
  public void cg_init_Ranking_1(final Driver driver0) {

    /* Ranking.vdmpp 12:4 */
    driver = driver0;
    /* Ranking.vdmpp 13:5 */
    return;
  }
  /* Ranking.vdmpp 10:10 */
  public Ranking(final Driver driver0) {

    cg_init_Ranking_1(driver0);
  }
  /* Ranking.vdmpp 17:9 */
  public void AddPoints(final Number score) {

    /* Ranking.vdmpp 19:4 */
    points = points.longValue() + score.longValue();
  }
  /* Ranking.vdmpp 23:14 */
  public Driver GetDriver() {

    /* Ranking.vdmpp 25:5 */
    return driver;
  }
  /* Ranking.vdmpp 28:14 */
  public Number GetPoints() {

    /* Ranking.vdmpp 30:5 */
    return points;
  }
  /* Ranking.vdmpp 1:7 */
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
