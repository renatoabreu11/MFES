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

  public void cg_init_Team_1(final String name0, final Object based0) {

    name = name0;
    based = based0;
    true_self = this;
    return;
  }

  public Team(final String name0, final Object based0) {

    cg_init_Team_1(name0, based0);
  }

  public void AddSponsor(final Sponsor s) {

    sponsors = SetUtil.union(Utils.copy(sponsors), SetUtil.set(s));
  }

  public void RemoveSponsor(final Sponsor s) {

    sponsors = SetUtil.diff(Utils.copy(sponsors), SetUtil.set(s));
  }

  public void SetBacker(final Manufacturer m) {

    backer = m;
  }

  public void RemoveBacker() {

    backer = null;
  }

  public void AddCar(final Car c) {

    cars = SetUtil.union(Utils.copy(cars), SetUtil.set(c));
  }

  public void RemoveCar(final Car c) {

    cars = SetUtil.diff(Utils.copy(cars), SetUtil.set(c));
  }

  public void AssignCarToDriver(final Car car, final Driver driver) {

    for (Iterator iterator_36 = drivers.iterator(); iterator_36.hasNext(); ) {
      Driver elem = (Driver) iterator_36.next();
      if (Utils.equals(elem.GetName(), driver.GetName())) {
        elem.SetCar(car);
      }
    }
  }

  public void UnassignCarFromDriver(final Driver driver) {

    for (Iterator iterator_37 = drivers.iterator(); iterator_37.hasNext(); ) {
      Driver elem = (Driver) iterator_37.next();
      if (Utils.equals(elem.GetName(), driver.GetName())) {
        elem.RemoveCar();
      }
    }
  }

  public void AddDriver(final Driver d) {

    d.SetTeam(this);
    drivers = SetUtil.union(Utils.copy(drivers), SetUtil.set(d));
  }

  public void RemoveDriver(final Driver d) {

    drivers = SetUtil.diff(Utils.copy(drivers), SetUtil.set(d));
    d.RemoveTeam();
    d.RemoveCar();
  }

  public VDMSet GetCars() {

    return Utils.copy(cars);
  }

  public VDMSet GetSponsors() {

    return Utils.copy(sponsors);
  }

  public VDMSet GetDrivers() {

    return Utils.copy(drivers);
  }

  public Manufacturer GetBacker() {

    return backer;
  }

  public String GetName() {

    return name;
  }

  public Object GetBased() {

    return based;
  }

  public Driver GetDriverByName(final String dName) {

    Driver driver = null;
    Boolean success_7 = false;
    VDMSet set_7 = Utils.copy(drivers);
    for (Iterator iterator_7 = set_7.iterator(); iterator_7.hasNext() && !(success_7); ) {
      driver = ((Driver) iterator_7.next());
      success_7 = Utils.equals(driver.GetName(), dName);
    }
    if (!(success_7)) {
      throw new RuntimeException("Let Be St found no applicable bindings");
    }

    return driver;
  }

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
        + ", true_self := "
        + Utils.toString(true_self)
        + "}";
  }
}
