package Rally;

import java.util.*;
import Rally.quotes.*;
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
  /* Championship.vdmpp 28:10 */
  public void cg_init_Championship_1(
      final String name0, final Number startDate0, final Number endDate0) {

    /* Championship.vdmpp 30:6 */
    name = name0;
    /* Championship.vdmpp 31:6 */
    startDate = startDate0;
    /* Championship.vdmpp 32:6 */
    endDate = endDate0;
    /* Championship.vdmpp 33:6 */
    return;
  }
  /* Championship.vdmpp 28:10 */
  public Championship(final String name0, final Number startDate0, final Number endDate0) {

    cg_init_Championship_1(name0, startDate0, endDate0);
  }
  /* Championship.vdmpp 40:9 */
  public void StartChampionship() {

    /* Championship.vdmpp 42:4 */
    currentRallyIndex = 1L;
    /* Championship.vdmpp 43:5 */
    ((Rally) Utils.get(series, currentRallyIndex)).StartRally(GetDrivers());
    /* Championship.vdmpp 44:4 */
    Init();
  }
  /* Championship.vdmpp 49:9 */
  public void UpdateCurrentRally(final VDMSet performances) {

    /* Championship.vdmpp 51:4 */
    ((Rally) Utils.get(series, currentRallyIndex)).NextStage(Utils.copy(performances));
  }
  /* Championship.vdmpp 55:9 */
  public Boolean IsCurrentRallyCompleted() {

    /* Championship.vdmpp 57:4 */
    if (Utils.equals(
        ((Rally) Utils.get(series, currentRallyIndex)).GetState(),
        CompletedQuote.getInstance())) {
      return true;

    } else {
      return false;
    }
  }
  /* Championship.vdmpp 63:9 */
  public void NextRally() {

    /* Championship.vdmpp 65:4 */
    currentRallyIndex = currentRallyIndex.longValue() + 1L;
    /* Championship.vdmpp 66:5 */
    if (currentRallyIndex.longValue() > series.size()) {
      EndChampionship();
    } else {
      ((Rally) Utils.get(series, currentRallyIndex)).StartRally(GetDrivers());
    }
  }
  /* Championship.vdmpp 70:10 */
  private void EndChampionship() {

    /* Championship.vdmpp 72:4 */
    currentRallyIndex = -1L;
    /* Championship.vdmpp 73:4 */
    Finalize();
  }
  /* Championship.vdmpp 78:9 */
  public void AddPartner(final Partner p) {

    /* Championship.vdmpp 80:4 */
    partners = SetUtil.union(Utils.copy(partners), SetUtil.set(p));
  }
  /* Championship.vdmpp 85:9 */
  public Number GetTeamRallyRanking(final String teamName, final String rallyName) {

    {
      Number i = null;
      Boolean success_1 = false;
      /* Championship.vdmpp 87:17 */
      VDMSet set_1 = SeqUtil.inds(series);
      for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext() && !(success_1); ) {
        i = ((Number) iterator_1.next());
        success_1 = Utils.equals(((Rally) Utils.get(series, i)).GetName(), rallyName);
      }
      if (!(success_1)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      /* Championship.vdmpp 87:70 */
      return ((Rally) Utils.get(series, i)).GetTeamRanking(teamName);
    }
  }
  /* Championship.vdmpp 91:9 */
  public Number GetTeamGlobalRanking(final String teamName) {

    /* Championship.vdmpp 93:8 */
    Number points = 0L;
    /* Championship.vdmpp 94:5 */
    for (Iterator iterator_36 = series.iterator(); iterator_36.hasNext(); ) {
      Rally elem = (Rally) iterator_36.next();
      if (!(Utils.equals(elem.GetState(), OffSeasonQuote.getInstance()))) {
        /* Championship.vdmpp 97:19 */
        points = points.longValue() + elem.GetTeamRanking(teamName).longValue();
      }
    }
    /* Championship.vdmpp 99:3 */
    return points;
  }
  /* Championship.vdmpp 103:9 */
  public VDMMap GetTeamsRanking() {

    /* Championship.vdmpp 105:9 */
    VDMMap rankings = MapUtil.map();
    /* Championship.vdmpp 106:5 */
    for (Iterator iterator_37 = MapUtil.dom(Utils.copy(teams)).iterator();
        iterator_37.hasNext();
        ) {
      String elem = (String) iterator_37.next();
      rankings =
          MapUtil.munion(
              Utils.copy(rankings), MapUtil.map(new Maplet(elem, GetTeamGlobalRanking(elem))));
    }
    /* Championship.vdmpp 109:5 */
    return Utils.copy(rankings);
  }
  /* Championship.vdmpp 112:9 */
  public void RemovePartner(final Partner p) {

    /* Championship.vdmpp 114:4 */
    partners = SetUtil.diff(Utils.copy(partners), SetUtil.set(p));
  }
  /* Championship.vdmpp 119:9 */
  public void AddRally(final Rally r) {

    /* Championship.vdmpp 121:4 */
    series = SeqUtil.conc(Utils.copy(series), SeqUtil.seq(r));
  }
  /* Championship.vdmpp 125:9 */
  public void AddTeam(final Team t) {

    /* Championship.vdmpp 127:4 */
    teams = MapUtil.munion(Utils.copy(teams), MapUtil.map(new Maplet(t.GetName(), t)));
  }
  /* Championship.vdmpp 132:9 */
  public void RemoveTeam(final Team t) {

    /* Championship.vdmpp 134:4 */
    teams = MapUtil.domResBy(SetUtil.set(t.GetName()), Utils.copy(teams));
  }
  /* Championship.vdmpp 141:14 */
  public Rally GetCurrentRally() {

    Boolean andResult_30 = false;

    if (Utils.equals(state, OccurringQuote.getInstance())) {
      if (currentRallyIndex.longValue() >= 1L) {
        andResult_30 = true;
      }
    }

    /* Championship.vdmpp 144:5 */
    if (andResult_30) {
      return ((Rally) Utils.get(series, currentRallyIndex));

    } else {
      return null;
    }
  }
  /* Championship.vdmpp 149:14 */
  public VDMSet GetDrivers() {

    VDMSet setCompResult_1 = SetUtil.set();
    /* Championship.vdmpp 151:46 */
    VDMSet set_13 = MapUtil.rng(Utils.copy(teams));
    for (Iterator iterator_13 = set_13.iterator(); iterator_13.hasNext(); ) {
      Team t = ((Team) iterator_13.next());
      setCompResult_1.add(t.GetDrivers());
    }
    /* Championship.vdmpp 151:4 */
    return SetUtil.dunion(Utils.copy(setCompResult_1));
  }
  /* Championship.vdmpp 153:14 */
  public String GetName() {

    /* Championship.vdmpp 155:5 */
    return name;
  }
  /* Championship.vdmpp 158:14 */
  public Number GetStartDate() {

    /* Championship.vdmpp 160:5 */
    return startDate;
  }
  /* Championship.vdmpp 163:14 */
  public Number GetEndDate() {

    /* Championship.vdmpp 165:5 */
    return endDate;
  }
  /* Championship.vdmpp 168:14 */
  public VDMMap GetTeams() {

    /* Championship.vdmpp 170:3 */
    return Utils.copy(teams);
  }
  /* Championship.vdmpp 173:14 */
  public VDMSet GetPartners() {

    /* Championship.vdmpp 175:4 */
    return Utils.copy(partners);
  }
  /* Championship.vdmpp 178:14 */
  public VDMSeq GetSeries() {

    /* Championship.vdmpp 180:4 */
    return Utils.copy(series);
  }
  /* Championship.vdmpp 183:14 */
  public Team GetTeamByName(final String tName) {

    /* Championship.vdmpp 185:4 */
    return ((Team) Utils.get(teams, tName));
  }
  /* Championship.vdmpp 188:14 */
  public Rally GetRallyByName(final String rName) {

    Number i = null;
    Boolean success_2 = false;
    /* Championship.vdmpp 190:17 */
    VDMSet set_2 = SeqUtil.inds(series);
    for (Iterator iterator_2 = set_2.iterator(); iterator_2.hasNext() && !(success_2); ) {
      i = ((Number) iterator_2.next());
      success_2 = Utils.equals(((Rally) Utils.get(series, i)).GetName(), rName);
    }
    if (!(success_2)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    /* Championship.vdmpp 190:64 */
    return ((Rally) Utils.get(series, i));
  }
  /* Championship.vdmpp 1:7 */
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
