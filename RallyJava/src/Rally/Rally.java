package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Rally extends State {
  private VDMSeq stages = SeqUtil.seq();
  private Number currentStageIndex = -1L;
  private VDMSeq rankings = SeqUtil.seq();
  private Number startDate;
  private Number endDate;
  private String name;
  private String description;
  private Object country;
  private Object surface;
  private Number distance = 0.0;
  /* Rally.vdmpp 33:10 */
  public void cg_init_Rally_1(
      final String name0,
      final String description0,
      final Object country0,
      final Object surface0,
      final Number startDate0,
      final Number endDate0) {

    /* Rally.vdmpp 35:4 */
    name = name0;
    /* Rally.vdmpp 36:4 */
    description = description0;
    /* Rally.vdmpp 37:4 */
    country = country0;
    /* Rally.vdmpp 38:4 */
    surface = surface0;
    /* Rally.vdmpp 39:4 */
    startDate = startDate0;
    /* Rally.vdmpp 40:4 */
    endDate = endDate0;
    /* Rally.vdmpp 41:5 */
    return;
  }
  /* Rally.vdmpp 33:10 */
  public Rally(
      final String name0,
      final String description0,
      final Object country0,
      final Object surface0,
      final Number startDate0,
      final Number endDate0) {

    cg_init_Rally_1(name0, description0, country0, surface0, startDate0, endDate0);
  }
  /* Rally.vdmpp 50:9 */
  public void StartRally(final VDMSet drivers) {

    /* Rally.vdmpp 52:4 */
    for (Iterator iterator_38 = drivers.iterator(); iterator_38.hasNext(); ) {
      Driver elem = (Driver) iterator_38.next();
      rankings = SeqUtil.conc(Utils.copy(rankings), SeqUtil.seq(new Ranking(elem)));
    }
    /* Rally.vdmpp 54:5 */
    currentStageIndex = 1L;
    /* Rally.vdmpp 55:5 */
    ((Stage) Utils.get(stages, currentStageIndex)).Init();
    /* Rally.vdmpp 56:4 */
    Init();
  }
  /* Rally.vdmpp 61:9 */
  public void NextStage(final VDMSet performances) {

    /* Rally.vdmpp 63:4 */
    ((Stage) Utils.get(stages, currentStageIndex)).Finalize();
    /* Rally.vdmpp 64:4 */
    for (Iterator iterator_39 = performances.iterator(); iterator_39.hasNext(); ) {
      Performance elem = (Performance) iterator_39.next();
      /* Rally.vdmpp 66:7 */
      ((Stage) Utils.get(stages, currentStageIndex)).AddPerformance(elem);
      {
        Number i = null;
        Boolean success_3 = false;
        /* Rally.vdmpp 67:20 */
        VDMSet set_3 = SeqUtil.inds(rankings);
        for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext() && !(success_3); ) {
          i = ((Number) iterator_3.next());
          success_3 =
              Utils.equals(elem.GetDriver(), ((Ranking) Utils.get(rankings, i)).GetDriver());
        }
        if (!(success_3)) {
          throw new RuntimeException("Let Be St found no applicable bindings");
        }

        /* Rally.vdmpp 68:10 */
        ((Ranking) Utils.get(rankings, i)).AddPoints(elem.GetTime());
      }
    }
    /* Rally.vdmpp 70:5 */
    rankings = BubbleSort(Utils.copy(rankings));
    /* Rally.vdmpp 72:5 */
    currentStageIndex = currentStageIndex.longValue() + 1L;
    /* Rally.vdmpp 73:5 */
    if (currentStageIndex.longValue() > stages.size()) {
      EndRally();
    } else {
      ((Stage) Utils.get(stages, currentStageIndex)).Init();
    }
  }
  /* Rally.vdmpp 79:10 */
  private void EndRally() {

    /* Rally.vdmpp 81:4 */
    currentStageIndex = -1L;
    /* Rally.vdmpp 82:4 */
    Finalize();
  }
  /* Rally.vdmpp 87:9 */
  public Number GetTeamRanking(final String teamName) {

    /* Rally.vdmpp 89:9 */
    Number points = 0L;
    /* Rally.vdmpp 90:6 */
    for (Iterator iterator_40 = rankings.iterator(); iterator_40.hasNext(); ) {
      Ranking elem = (Ranking) iterator_40.next();
      if (Utils.equals(elem.GetDriver().GetTeam().GetName(), teamName)) {
        /* Rally.vdmpp 93:20 */
        points = points.longValue() + elem.GetPoints().longValue();
      }
    }
    /* Rally.vdmpp 95:4 */
    return points;
  }
  /* Rally.vdmpp 99:9 */
  public void AddStage(final Stage s) {

    /* Rally.vdmpp 101:4 */
    stages = SeqUtil.conc(Utils.copy(stages), SeqUtil.seq(s));
    /* Rally.vdmpp 102:4 */
    distance = distance.doubleValue() + s.GetDistance().doubleValue();
  }
  /* Rally.vdmpp 109:14 */
  public Number GetStartDate() {

    /* Rally.vdmpp 111:5 */
    return startDate;
  }
  /* Rally.vdmpp 114:14 */
  public Number GetEndDate() {

    /* Rally.vdmpp 116:5 */
    return endDate;
  }
  /* Rally.vdmpp 119:14 */
  public String GetName() {

    /* Rally.vdmpp 121:5 */
    return name;
  }
  /* Rally.vdmpp 124:14 */
  public String GetDescription() {

    /* Rally.vdmpp 126:5 */
    return description;
  }
  /* Rally.vdmpp 129:14 */
  public Object GetCountry() {

    /* Rally.vdmpp 131:5 */
    return country;
  }
  /* Rally.vdmpp 134:14 */
  public Object GetSurface() {

    /* Rally.vdmpp 136:5 */
    return surface;
  }
  /* Rally.vdmpp 139:14 */
  public Number GetDistance() {

    /* Rally.vdmpp 141:5 */
    return distance;
  }
  /* Rally.vdmpp 144:14 */
  public VDMSeq GetStages() {

    /* Rally.vdmpp 146:4 */
    return Utils.copy(stages);
  }
  /* Rally.vdmpp 149:14 */
  public VDMSeq GetRankings() {

    /* Rally.vdmpp 151:4 */
    return Utils.copy(rankings);
  }
  /* Rally.vdmpp 154:14 */
  public Stage GetCurrentStage() {

    /* Rally.vdmpp 156:4 */
    return ((Stage) Utils.get(stages, currentStageIndex));
  }
  /* Rally.vdmpp 160:14 */
  public Ranking GetDriverRanking(final Driver driver0) {

    Number i = null;
    Boolean success_4 = false;
    /* Rally.vdmpp 162:17 */
    VDMSet set_4 = SeqUtil.inds(rankings);
    for (Iterator iterator_4 = set_4.iterator(); iterator_4.hasNext() && !(success_4); ) {
      i = ((Number) iterator_4.next());
      success_4 = Utils.equals(((Ranking) Utils.get(rankings, i)).GetDriver(), driver0);
    }
    if (!(success_4)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    /* Rally.vdmpp 162:74 */
    return ((Ranking) Utils.get(rankings, i));
  }
  /* Rally.vdmpp 165:14 */
  public Performance GetDriverPerformanceOnStage(final Number stageId0, final Driver driver0) {

    Number iS = null;
    Boolean success_5 = false;
    /* Rally.vdmpp 167:20 */
    VDMSet set_5 = SeqUtil.inds(stages);
    for (Iterator iterator_5 = set_5.iterator(); iterator_5.hasNext() && !(success_5); ) {
      iS = ((Number) iterator_5.next());
      success_5 = Utils.equals(((Stage) Utils.get(stages, iS)).GetId(), stageId0);
    }
    if (!(success_5)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    {
      Number iP = null;
      Boolean success_6 = false;
      /* Rally.vdmpp 168:24 */
      VDMSet set_6 = SeqUtil.inds(((Stage) Utils.get(stages, iS)).GetPerformances());
      for (Iterator iterator_6 = set_6.iterator(); iterator_6.hasNext() && !(success_6); ) {
        iP = ((Number) iterator_6.next());
        success_6 =
            Utils.equals(
                ((Performance) Utils.get(((Stage) Utils.get(stages, iS)).GetPerformances(), iP))
                    .GetDriver(),
                driver0);
      }
      if (!(success_6)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      /* Rally.vdmpp 169:12 */
      return ((Performance) Utils.get(((Stage) Utils.get(stages, iS)).GetPerformances(), iP));
    }
  }
  /* Rally.vdmpp 173:17 */
  private static VDMSeq BubbleSort(final VDMSeq k) {

    /* Rally.vdmpp 175:8 */
    VDMSeq sorted_list = Utils.copy(k);
    /* Rally.vdmpp 176:4 */
    long toVar_2 = 1L;
    long byVar_1 = -1L;
    for (Long i = Long.valueOf(k.size()); byVar_1 < 0 ? i >= toVar_2 : i <= toVar_2; i += byVar_1) {
      long toVar_1 = i.longValue() - 1L;

      for (Long j = 1L; j <= toVar_1; j++) {
        if (((Ranking) Utils.get(sorted_list, j)).GetPoints().longValue()
            < ((Ranking) Utils.get(sorted_list, j.longValue() + 1L)).GetPoints().longValue()) {
          /* Rally.vdmpp 179:17 */
          Ranking temp = ((Ranking) Utils.get(sorted_list, j));
          /* Rally.vdmpp 180:6 */
          Utils.mapSeqUpdate(
              sorted_list, j, ((Ranking) Utils.get(sorted_list, j.longValue() + 1L)));
          /* Rally.vdmpp 181:6 */
          Utils.mapSeqUpdate(sorted_list, j.longValue() + 1L, temp);
        }
      }
    }
    /* Rally.vdmpp 183:4 */
    return Utils.copy(sorted_list);
  }
  /* Rally.vdmpp 1:7 */
  public Rally() {}

  public String toString() {

    return "Rally{"
        + "stages := "
        + Utils.toString(stages)
        + ", currentStageIndex := "
        + Utils.toString(currentStageIndex)
        + ", rankings := "
        + Utils.toString(rankings)
        + ", startDate := "
        + Utils.toString(startDate)
        + ", endDate := "
        + Utils.toString(endDate)
        + ", name := "
        + Utils.toString(name)
        + ", description := "
        + Utils.toString(description)
        + ", country := "
        + Utils.toString(country)
        + ", surface := "
        + Utils.toString(surface)
        + ", distance := "
        + Utils.toString(distance)
        + "}";
  }
}
