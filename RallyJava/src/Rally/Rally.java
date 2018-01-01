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

  public void cg_init_Rally_1(
      final String name0,
      final String description0,
      final Object country0,
      final Object surface0,
      final Number startDate0,
      final Number endDate0) {

    name = name0;
    description = description0;
    country = country0;
    surface = surface0;
    startDate = startDate0;
    endDate = endDate0;
    return;
  }

  public Rally(
      final String name0,
      final String description0,
      final Object country0,
      final Object surface0,
      final Number startDate0,
      final Number endDate0) {

    cg_init_Rally_1(name0, description0, country0, surface0, startDate0, endDate0);
  }

  public void StartRally(final VDMSet drivers) {

    for (Iterator iterator_33 = drivers.iterator(); iterator_33.hasNext(); ) {
      Driver elem = (Driver) iterator_33.next();
      rankings = SeqUtil.conc(Utils.copy(rankings), SeqUtil.seq(new Ranking(elem)));
    }
    currentStageIndex = 1L;
    ((Stage) Utils.get(stages, currentStageIndex)).Init();
    Init();
  }

  public void NextStage(final VDMSet performances) {

    ((Stage) Utils.get(stages, currentStageIndex)).Finalize();
    for (Iterator iterator_34 = performances.iterator(); iterator_34.hasNext(); ) {
      Performance elem = (Performance) iterator_34.next();
      ((Stage) Utils.get(stages, currentStageIndex)).AddPerformance(elem);
      {
        Number i = null;
        Boolean success_3 = false;
        VDMSet set_3 = SeqUtil.inds(rankings);
        for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext() && !(success_3); ) {
          i = ((Number) iterator_3.next());
          success_3 =
              Utils.equals(elem.GetDriver(), ((Ranking) Utils.get(rankings, i)).GetDriver());
        }
        if (!(success_3)) {
          throw new RuntimeException("Let Be St found no applicable bindings");
        }

        ((Ranking) Utils.get(rankings, i)).AddPoints(elem.GetTime());
      }
    }
    rankings =
        SeqUtils.sort(
                new Func_2<Ranking, Ranking, Boolean>() {
                  public Boolean eval(final Ranking x, final Ranking y) {

                    return x.GetPoints().longValue() > y.GetPoints().longValue();
                  }
                })
            .eval(Utils.copy(rankings));
    currentStageIndex = currentStageIndex.longValue() + 1L;
    if (currentStageIndex.longValue() > stages.size()) {
      EndRally();
    } else {
      ((Stage) Utils.get(stages, currentStageIndex)).Init();
    }
  }

  private void EndRally() {

    currentStageIndex = -1L;
    Finalize();
  }

  public Number GetTeamRanking(final String teamName) {

    Number points = 0L;
    for (Iterator iterator_35 = rankings.iterator(); iterator_35.hasNext(); ) {
      Ranking elem = (Ranking) iterator_35.next();
      if (Utils.equals(elem.GetDriver().GetTeam().GetName(), teamName)) {
        points = points.longValue() + elem.GetPoints().longValue();
      }
    }
    return points;
  }

  public void AddStage(final Stage s) {

    stages = SeqUtil.conc(Utils.copy(stages), SeqUtil.seq(s));
    distance = distance.doubleValue() + s.GetDistance().doubleValue();
  }

  public Number GetStartDate() {

    return startDate;
  }

  public Number GetEndDate() {

    return endDate;
  }

  public String GetName() {

    return name;
  }

  public String GetDescription() {

    return description;
  }

  public Object GetCountry() {

    return country;
  }

  public Object GetSurface() {

    return surface;
  }

  public Number GetDistance() {

    return distance;
  }

  public VDMSeq GetStages() {

    return Utils.copy(stages);
  }

  public VDMSeq GetRankings() {

    return Utils.copy(rankings);
  }

  public Stage GetCurrentStage() {

    return ((Stage) Utils.get(stages, currentStageIndex));
  }

  public Ranking GetDriverRanking(final Driver driver0) {

    Number i = null;
    Boolean success_4 = false;
    VDMSet set_4 = SeqUtil.inds(rankings);
    for (Iterator iterator_4 = set_4.iterator(); iterator_4.hasNext() && !(success_4); ) {
      i = ((Number) iterator_4.next());
      success_4 = Utils.equals(((Ranking) Utils.get(rankings, i)).GetDriver(), driver0);
    }
    if (!(success_4)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    return ((Ranking) Utils.get(rankings, i));
  }

  public Performance GetDriverPerformanceOnStage(final Number stageId0, final Driver driver0) {

    Number iS = null;
    Boolean success_5 = false;
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

      return ((Performance) Utils.get(((Stage) Utils.get(stages, iS)).GetPerformances(), iP));
    }
  }

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
