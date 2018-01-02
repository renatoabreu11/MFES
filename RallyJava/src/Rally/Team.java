package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Team {
  private VDMSet drivers = SetUtil.set();
  private VDMSet sponsors = SetUtil.set();
  private Manufacturer backer = null;
  private VDMSet cars = SetUtil.set();
  private String name;
  private Object based;
  private Team true_self;
  /* Team.vdmpp 29:10 */
  public void cg_init_Team_1(final String name0, final Object based0) {

    /* Team.vdmpp 31:4 */
    name = name0;
    /* Team.vdmpp 32:4 */
    based = based0;
    /* Team.vdmpp 33:4 */
    true_self = this;
    /* Team.vdmpp 34:5 */
    return;
  }
  /* Team.vdmpp 29:10 */
  public Team(final String name0, final Object based0) {

    cg_init_Team_1(name0, based0);
  }
  /* Team.vdmpp 41:9 */
  public void AddSponsor(final Sponsor s) {

    /* Team.vdmpp 43:4 */
    sponsors = SetUtil.union(Utils.copy(sponsors), SetUtil.set(s));
  }
  /* Team.vdmpp 47:9 */
  public void RemoveSponsor(final Sponsor s) {

    /* Team.vdmpp 49:4 */
    sponsors = SetUtil.diff(Utils.copy(sponsors), SetUtil.set(s));
  }
  /* Team.vdmpp 54:9 */
  public void SetBacker(final Manufacturer m) {

    /* Team.vdmpp 56:4 */
    backer = m;
  }
  /* Team.vdmpp 60:9 */
  public void RemoveBacker() {

    /* Team.vdmpp 62:4 */
    backer = null;
  }
  /* Team.vdmpp 66:9 */
  public void AddCar(final Car c) {

    /* Team.vdmpp 68:4 */
    cars = SetUtil.union(Utils.copy(cars), SetUtil.set(c));
  }
  /* Team.vdmpp 74:9 */
  public void RemoveCar(final Car c) {

    /* Team.vdmpp 76:4 */
    cars = SetUtil.diff(Utils.copy(cars), SetUtil.set(c));
  }
  /* Team.vdmpp 81:9 */
  public void AssignCarToDriver(final Car car, final Driver driver) {

    /* Team.vdmpp 83:7 */
    for (Iterator iterator_41 = drivers.iterator(); iterator_41.hasNext(); ) {
      Driver elem = (Driver) iterator_41.next();
      if (Utils.equals(elem.GetName(), driver.GetName())) {
        /* Team.vdmpp 86:19 */
        elem.SetCar(car);
      }
    }
  }
  /* Team.vdmpp 90:9 */
  public void UnassignCarFromDriver(final Driver driver) {

    /* Team.vdmpp 92:7 */
    for (Iterator iterator_42 = drivers.iterator(); iterator_42.hasNext(); ) {
      Driver elem = (Driver) iterator_42.next();
      if (Utils.equals(elem.GetName(), driver.GetName())) {
        /* Team.vdmpp 95:19 */
        elem.RemoveCar();
      }
    }
  }
  /* Team.vdmpp 99:9 */
  public void AddDriver(Driver d) {

    /* Team.vdmpp 101:4 */
    d.SetTeam(this);
    /* Team.vdmpp 102:4 */
    drivers = SetUtil.union(Utils.copy(drivers), SetUtil.set(d));
  }
  /* Team.vdmpp 106:9 */
  public void RemoveDriver(final Driver d) {

    /* Team.vdmpp 108:4 */
    drivers = SetUtil.diff(Utils.copy(drivers), SetUtil.set(d));
    /* Team.vdmpp 109:4 */
    d.RemoveTeam();
    /* Team.vdmpp 110:4 */
    d.RemoveCar();
  }
  /* Team.vdmpp 117:14 */
  public VDMSet GetCars() {

    /* Team.vdmpp 119:5 */
    return Utils.copy(cars);
  }
  /* Team.vdmpp 122:14 */
  public VDMSet GetSponsors() {

    /* Team.vdmpp 124:5 */
    return Utils.copy(sponsors);
  }
  /* Team.vdmpp 127:14 */
  public VDMSet GetDrivers() {

    /* Team.vdmpp 129:5 */
    return Utils.copy(drivers);
  }
  /* Team.vdmpp 132:14 */
  public Manufacturer GetBacker() {

    /* Team.vdmpp 134:5 */
    return backer;
  }
  /* Team.vdmpp 137:14 */
  public String GetName() {

    /* Team.vdmpp 139:5 */
    return name;
  }
  /* Team.vdmpp 142:14 */
  public Object GetBased() {

    /* Team.vdmpp 144:5 */
    return based;
  }
  /* Team.vdmpp 147:14 */
  public Driver GetDriverByName(final String dName) {

    Driver driver = null;
    Boolean success_7 = false;
    /* Team.vdmpp 149:22 */
    VDMSet set_7 = Utils.copy(drivers);
    for (Iterator iterator_7 = set_7.iterator(); iterator_7.hasNext() && !(success_7); ) {
      driver = ((Driver) iterator_7.next());
      success_7 = Utils.equals(driver.GetName(), dName);
    }
    if (!(success_7)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    /* Team.vdmpp 149:62 */
    return driver;
  }
  /* Team.vdmpp 1:7 */
  public Team() {}

  public String toString() {

    return "Team{"
        + "drivers := "
        + Utils.toString(drivers)
        + ", sponsors := "
        + Utils.toString(sponsors)
        + ", backer := "
        + Utils.toString(backer)
        + ", cars := "
        + Utils.toString(cars)
        + ", name := "
        + Utils.toString(name)
        + ", based := "
        + Utils.toString(based)
        + "}";
  }
}
