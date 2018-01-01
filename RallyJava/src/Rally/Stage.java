package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Stage extends State {
  private VDMSeq performances = SeqUtil.seq();
  private Object type;
  private Number date;
  private Number distance;
  private Number id;
  /* Stage.vdmpp 22:10 */
  public void cg_init_Stage_1(
      final Number id0, final Object type0, final Number date0, final Number distance0) {

    /* Stage.vdmpp 24:4 */
    id = id0;
    /* Stage.vdmpp 25:4 */
    type = type0;
    /* Stage.vdmpp 26:4 */
    date = date0;
    /* Stage.vdmpp 27:4 */
    distance = distance0;
    /* Stage.vdmpp 28:5 */
    return;
  }
  /* Stage.vdmpp 22:10 */
  public Stage(final Number id0, final Object type0, final Number date0, final Number distance0) {

    cg_init_Stage_1(id0, type0, date0, distance0);
  }
  /* Stage.vdmpp 35:9 */
  public void AddPerformance(final Performance perf) {

    /* Stage.vdmpp 37:4 */
    performances = InsertSorted(perf, Utils.copy(performances), Stage::Compare);
  }
  /* Stage.vdmpp 41:9 */
  public Performance GetDriverPerformance(final String driverName) {

    Boolean existsExpResult_16 = false;
    /* Stage.vdmpp 44:24 */
    VDMSeq set_25 = Utils.copy(performances);
    for (Iterator iterator_25 = set_25.iterator();
        iterator_25.hasNext() && !(existsExpResult_16);
        ) {
      Performance p = ((Performance) iterator_25.next());
      existsExpResult_16 = Utils.equals(p.GetDriver().GetName(), driverName);
    }
    /* Stage.vdmpp 44:5 */
    if (existsExpResult_16) {
      Performance iotaExp_1 = null;
      Long iotaCounter_1 = 0L;
      /* Stage.vdmpp 45:31 */
      VDMSeq set_26 = Utils.copy(performances);
      for (Iterator iterator_26 = set_26.iterator(); iterator_26.hasNext(); ) {
        Performance p = ((Performance) iterator_26.next());
        if (Utils.equals(p.GetDriver().GetName(), driverName)) {
          iotaCounter_1++;
          if (iotaCounter_1.longValue() > 1L) {
            throw new RuntimeException("Iota selects more than one result");
          } else {
            iotaExp_1 = p;
          }
        }
      }
      if (Utils.equals(iotaCounter_1, 0L)) {
        throw new RuntimeException("Iota selects more than one result");
      }

      return iotaExp_1;

    } else {
      return null;
    }
  }
  /* Stage.vdmpp 49:9 */
  public Performance GetDriverPerformance(final Driver d) {

    Boolean existsExpResult_17 = false;
    /* Stage.vdmpp 52:24 */
    VDMSeq set_27 = Utils.copy(performances);
    for (Iterator iterator_27 = set_27.iterator();
        iterator_27.hasNext() && !(existsExpResult_17);
        ) {
      Performance p = ((Performance) iterator_27.next());
      existsExpResult_17 = Utils.equals(p.GetDriver(), d);
    }
    /* Stage.vdmpp 52:5 */
    if (existsExpResult_17) {
      Performance iotaExp_2 = null;
      Long iotaCounter_2 = 0L;
      /* Stage.vdmpp 53:31 */
      VDMSeq set_28 = Utils.copy(performances);
      for (Iterator iterator_28 = set_28.iterator(); iterator_28.hasNext(); ) {
        Performance p = ((Performance) iterator_28.next());
        if (Utils.equals(p.GetDriver(), d)) {
          iotaCounter_2++;
          if (iotaCounter_2.longValue() > 1L) {
            throw new RuntimeException("Iota selects more than one result");
          } else {
            iotaExp_2 = p;
          }
        }
      }
      if (Utils.equals(iotaCounter_2, 0L)) {
        throw new RuntimeException("Iota selects more than one result");
      }

      return iotaExp_2;

    } else {
      return null;
    }
  }
  /* Stage.vdmpp 59:14 */
  public Object GetType() {

    /* Stage.vdmpp 61:5 */
    return type;
  }
  /* Stage.vdmpp 64:14 */
  public Number GetId() {

    /* Stage.vdmpp 66:5 */
    return id;
  }
  /* Stage.vdmpp 69:14 */
  public Number GetDate() {

    /* Stage.vdmpp 71:5 */
    return date;
  }
  /* Stage.vdmpp 74:14 */
  public Number GetDistance() {

    /* Stage.vdmpp 76:5 */
    return distance;
  }
  /* Stage.vdmpp 79:14 */
  public VDMSeq GetPerformances() {

    /* Stage.vdmpp 81:4 */
    return Utils.copy(performances);
  }
  /* Stage.vdmpp 1:7 */
  public Stage() {}

  /* Stage.vdmpp 85:17 */
  private static VDMSeq InsertSorted(
      final Performance i, final VDMSeq l, final Func_1<Performance, Performance, Number> compare) {

    /* Stage.vdmpp 87:4 */
    if (Utils.empty(l)) {
      return SeqUtil.seq(i);

    } else {
      if (compare.eval(i, ((Performance) l.get(0))).longValue() <= 0L) {
        return SeqUtil.conc(SeqUtil.seq(i), Utils.copy(l));

      } else {
        return SeqUtil.conc(
            SeqUtil.seq(((Performance) l.get(0))),
            InsertSorted(i, SeqUtil.tail(Utils.copy(l)), compare));
      }
    }
  }
  /* Stage.vdmpp 91:17 */
  private static Number Compare(final Performance p1, final Performance p2) {

    /* Stage.vdmpp 93:4 */
    if (p1.GetTime().doubleValue() > p2.GetTime().doubleValue()) {
      return 1L;

    } else {
      return -1L;
    }
  }

  public String toString() {

    return "Stage{"
        + "performances := "
        + Utils.toString(performances)
        + ", type := "
        + Utils.toString(type)
        + ", date := "
        + Utils.toString(date)
        + ", distance := "
        + Utils.toString(distance)
        + ", id := "
        + Utils.toString(id)
        + "}";
  }
}
