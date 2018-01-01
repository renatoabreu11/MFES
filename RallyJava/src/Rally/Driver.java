package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Driver {
  private Team team = null;
  private Car car = null;
  private String name;
  private Object gender;
  private Object nationality;
  private Number birth;
  private Driver true_self;
  /* Driver.vdmpp 23:10 */
  public void cg_init_Driver_1(
      final String name0, final Object gender0, final Object nationality0, final Number birth0) {

    /* Driver.vdmpp 25:5 */
    name = name0;
    /* Driver.vdmpp 26:5 */
    gender = gender0;
    /* Driver.vdmpp 27:5 */
    nationality = nationality0;
    /* Driver.vdmpp 28:5 */
    birth = birth0;
    /* Driver.vdmpp 29:5 */
    true_self = this;
    /* Driver.vdmpp 30:5 */
    return;
  }
  /* Driver.vdmpp 23:10 */
  public Driver(
      final String name0, final Object gender0, final Object nationality0, final Number birth0) {

    cg_init_Driver_1(name0, gender0, nationality0, birth0);
  }
  /* Driver.vdmpp 37:9 */
  public void SetTeam(final Team t) {

    /* Driver.vdmpp 39:5 */
    team = t;
  }
  /* Driver.vdmpp 43:9 */
  public void RemoveTeam() {

    /* Driver.vdmpp 45:5 */
    team = null;
  }
  /* Driver.vdmpp 48:9 */
  public void RemoveCar() {

    /* Driver.vdmpp 50:5 */
    car = null;
  }
  /* Driver.vdmpp 53:9 */
  public void SetCar(final Car c) {

    /* Driver.vdmpp 55:5 */
    car = c;
  }
  /* Driver.vdmpp 61:14 */
  public Team GetTeam() {

    /* Driver.vdmpp 63:5 */
    return team;
  }
  /* Driver.vdmpp 66:14 */
  public Car GetCar() {

    /* Driver.vdmpp 68:5 */
    return car;
  }
  /* Driver.vdmpp 71:14 */
  public String GetName() {

    /* Driver.vdmpp 73:5 */
    return name;
  }
  /* Driver.vdmpp 76:14 */
  public Object GetGender() {

    /* Driver.vdmpp 78:5 */
    return gender;
  }
  /* Driver.vdmpp 81:14 */
  public Object GetNationality() {

    /* Driver.vdmpp 83:5 */
    return nationality;
  }
  /* Driver.vdmpp 86:14 */
  public Number GetBirth() {

    /* Driver.vdmpp 88:5 */
    return birth;
  }
  /* Driver.vdmpp 1:7 */
  public Driver() {}

  public String toString() {

    return "Driver{"
        + "team := "
        + Utils.toString(team)
        + ", car := "
        + Utils.toString(car)
        + ", name := "
        + Utils.toString(name)
        + ", gender := "
        + Utils.toString(gender)
        + ", nationality := "
        + Utils.toString(nationality)
        + ", birth := "
        + Utils.toString(birth)
        + ", true_self := "
        + Utils.toString(true_self)
        + "}";
  }
}
