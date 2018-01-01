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

  public void cg_init_Driver_1(
      final String name0, final Object gender0, final Object nationality0, final Number birth0) {

    name = name0;
    gender = gender0;
    nationality = nationality0;
    birth = birth0;
    true_self = this;
    return;
  }

  public Driver(
      final String name0, final Object gender0, final Object nationality0, final Number birth0) {

    cg_init_Driver_1(name0, gender0, nationality0, birth0);
  }

  public void SetTeam(final Team t) {

    team = t;
  }

  public void RemoveTeam() {

    team = null;
  }

  public void RemoveCar() {

    car = null;
  }

  public void SetCar(final Car c) {

    car = c;
  }

  public Team GetTeam() {

    return team;
  }

  public Car GetCar() {

    return car;
  }

  public String GetName() {

    return name;
  }

  public Object GetGender() {

    return gender;
  }

  public Object GetNationality() {

    return nationality;
  }

  public Number GetBirth() {

    return birth;
  }

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
