package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Championship extends State {
  private VDMSeq series = SeqUtil.seq();
  private Number currentRallyIndex = -1L;
  private VDMMap teams = MapUtil.map();
  private VDMSet partners = SetUtil.set();
  private String name;
  private Number startDate;
  private Number endDate;

  public void cg_init_Championship_1(
      final String name0, final Number startDate0, final Number endDate0) {

    name = name0;
    startDate = startDate0;
    endDate = endDate0;
    return;
  }

  public Championship(final String name0, final Number startDate0, final Number endDate0) {

    cg_init_Championship_1(name0, startDate0, endDate0);
  }

  public void StartChampionship() {

    currentRallyIndex = 1L;
    ((Rally) Utils.get(series, currentRallyIndex)).StartRally(GetDrivers());
    Init();
  }

  public void UpdateCurrentRally(final VDMSet performances) {

    ((Rally) Utils.get(series, currentRallyIndex)).NextStage(Utils.copy(performances));
  }

  public Boolean IsCurrentRallyCompleted() {

    if (Utils.equals(
        ((Rally) Utils.get(series, currentRallyIndex)).GetState(),
        Rally.quotes.CompletedQuote.getInstance())) {
      return true;

    } else {
      return false;
    }
  }

  public void NextRally() {

    currentRallyIndex = currentRallyIndex.longValue() + 1L;
    if (currentRallyIndex.longValue() > series.size()) {
      EndChampionship();
    } else {
      ((Rally) Utils.get(series, currentRallyIndex)).StartRally(GetDrivers());
    }
  }

  private void EndChampionship() {

    currentRallyIndex = -1L;
    Finalize();
  }

  public void AddPartner(final Partner p) {

    partners = SetUtil.union(Utils.copy(partners), SetUtil.set(p));
  }

  public Number GetTeamRallyRanking(final String teamName, final String rallyName) {

    {
      Number i = null;
      Boolean success_1 = false;
      VDMSet set_1 = SeqUtil.inds(series);
      for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext() && !(success_1); ) {
        i = ((Number) iterator_1.next());
        success_1 = Utils.equals(((Rally) Utils.get(series, i)).GetName(), rallyName);
      }
      if (!(success_1)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      return ((Rally) Utils.get(series, i)).GetTeamRanking(teamName);
    }
  }

  public Number GetTeamGlobalRanking(final String teamName) {

    Number points = 0L;
    for (Iterator iterator_31 = series.iterator(); iterator_31.hasNext(); ) {
      Rally elem = (Rally) iterator_31.next();
      if (!(Utils.equals(elem.GetState(), Rally.quotes.OffSeasonQuote.getInstance()))) {
        points = points.longValue() + elem.GetTeamRanking(teamName).longValue();
      }
    }
    return points;
  }

  public VDMMap GetTeamsRanking() {

    VDMMap rankings = MapUtil.map();
    for (Iterator iterator_32 = MapUtil.dom(Utils.copy(teams)).iterator();
        iterator_32.hasNext();
        ) {
      String elem = (String) iterator_32.next();
      rankings =
          MapUtil.munion(
              Utils.copy(rankings), MapUtil.map(new Maplet(elem, GetTeamGlobalRanking(elem))));
    }
    return Utils.copy(rankings);
  }

  public void RemovePartner(final Partner p) {

    partners = SetUtil.diff(Utils.copy(partners), SetUtil.set(p));
  }

  public void AddRally(final Rally r) {

    series = SeqUtil.conc(Utils.copy(series), SeqUtil.seq(r));
  }

  public void AddTeam(final Team t) {

    teams = MapUtil.munion(Utils.copy(teams), MapUtil.map(new Maplet(t.GetName(), t)));
  }

  public void RemoveTeam(final Team t) {

    teams = MapUtil.domResBy(SetUtil.set(t.GetName()), Utils.copy(teams));
  }

  public Rally GetCurrentRally() {

    Boolean andResult_30 = false;

    if (Utils.equals(state, Rally.quotes.OccurringQuote.getInstance())) {
      if (currentRallyIndex.longValue() >= 1L) {
        andResult_30 = true;
      }
    }

    if (andResult_30) {
      return ((Rally) Utils.get(series, currentRallyIndex));

    } else {
      return null;
    }
  }

  public VDMSet GetDrivers() {

    VDMSet setCompResult_1 = SetUtil.set();
    VDMSet set_13 = MapUtil.rng(Utils.copy(teams));
    for (Iterator iterator_13 = set_13.iterator(); iterator_13.hasNext(); ) {
      Team t = ((Team) iterator_13.next());
      setCompResult_1.add(t.GetDrivers());
    }
    return SetUtil.dunion(Utils.copy(setCompResult_1));
  }

  public String GetName() {

    return name;
  }

  public Number GetStartDate() {

    return startDate;
  }

  public Number GetEndDate() {

    return endDate;
  }

  public VDMMap GetTeams() {

    return Utils.copy(teams);
  }

  public VDMSet GetPartners() {

    return Utils.copy(partners);
  }

  public VDMSeq GetSeries() {

    return Utils.copy(series);
  }

  public Team GetTeamByName(final String tName) {

    return ((Team) Utils.get(teams, tName));
  }

  public Rally GetRallyByName(final String rName) {

    Number i = null;
    Boolean success_2 = false;
    VDMSet set_2 = SeqUtil.inds(series);
    for (Iterator iterator_2 = set_2.iterator(); iterator_2.hasNext() && !(success_2); ) {
      i = ((Number) iterator_2.next());
      success_2 = Utils.equals(((Rally) Utils.get(series, i)).GetName(), rName);
    }
    if (!(success_2)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    return ((Rally) Utils.get(series, i));
  }

  public Championship() {}

  public String toString() {

    return "Championship{"
        + "series := "
        + Utils.toString(series)
        + ", currentRallyIndex := "
        + Utils.toString(currentRallyIndex)
        + ", teams := "
        + Utils.toString(teams)
        + ", partners := "
        + Utils.toString(partners)
        + ", name := "
        + Utils.toString(name)
        + ", startDate := "
        + Utils.toString(startDate)
        + ", endDate := "
        + Utils.toString(endDate)
        + "}";
  }
}
