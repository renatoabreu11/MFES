package Rally;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DateUtils {
  public static final Number MinDate = MakeDate(1L, 1L, 1L);

  public DateUtils() {}

  public static Boolean IsValidDate(final Number year, final Number month, final Number day) {

    Boolean andResult_31 = false;

    if (year.longValue() >= 1L) {
      Boolean andResult_32 = false;

      if (month.longValue() >= 1L) {
        Boolean andResult_33 = false;

        if (month.longValue() <= 12L) {
          Boolean andResult_34 = false;

          if (day.longValue() >= 1L) {
            if (day.longValue() <= DaysOfMonth(year, month).longValue()) {
              andResult_34 = true;
            }
          }

          if (andResult_34) {
            andResult_33 = true;
          }
        }

        if (andResult_33) {
          andResult_32 = true;
        }
      }

      if (andResult_32) {
        andResult_31 = true;
      }
    }

    return andResult_31;
  }

  public static Boolean IsLeapYear(final Number year) {

    Boolean orResult_1 = false;

    Boolean andResult_35 = false;

    if (Utils.equals(Utils.mod(year.longValue(), 4L), 0L)) {
      if (!(Utils.equals(Utils.mod(year.longValue(), 100L), 0L))) {
        andResult_35 = true;
      }
    }

    if (andResult_35) {
      orResult_1 = true;
    } else {
      orResult_1 = Utils.equals(Utils.mod(year.longValue(), 400L), 0L);
    }

    return orResult_1;
  }

  public static Number DaysOfMonth(final Number year, final Number month) {

    Number casesExpResult_1 = null;

    Number intPattern_1 = month;
    Boolean success_10 = Utils.equals(intPattern_1, 1L);

    if (!(success_10)) {
      Number intPattern_2 = month;
      success_10 = Utils.equals(intPattern_2, 3L);

      if (!(success_10)) {
        Number intPattern_3 = month;
        success_10 = Utils.equals(intPattern_3, 5L);

        if (!(success_10)) {
          Number intPattern_4 = month;
          success_10 = Utils.equals(intPattern_4, 7L);

          if (!(success_10)) {
            Number intPattern_5 = month;
            success_10 = Utils.equals(intPattern_5, 8L);

            if (!(success_10)) {
              Number intPattern_6 = month;
              success_10 = Utils.equals(intPattern_6, 10L);

              if (!(success_10)) {
                Number intPattern_7 = month;
                success_10 = Utils.equals(intPattern_7, 12L);

                if (!(success_10)) {
                  Number intPattern_8 = month;
                  success_10 = Utils.equals(intPattern_8, 4L);

                  if (!(success_10)) {
                    Number intPattern_9 = month;
                    success_10 = Utils.equals(intPattern_9, 6L);

                    if (!(success_10)) {
                      Number intPattern_10 = month;
                      success_10 = Utils.equals(intPattern_10, 9L);

                      if (!(success_10)) {
                        Number intPattern_11 = month;
                        success_10 = Utils.equals(intPattern_11, 11L);

                        if (!(success_10)) {
                          Number intPattern_12 = month;
                          success_10 = Utils.equals(intPattern_12, 2L);

                          if (success_10) {
                            Number ternaryIfExp_1 = null;

                            if (IsLeapYear(year)) {
                              ternaryIfExp_1 = 29L;
                            } else {
                              ternaryIfExp_1 = 28L;
                            }

                            casesExpResult_1 = ternaryIfExp_1;
                          }

                        } else {
                          casesExpResult_1 = 30L;
                        }

                      } else {
                        casesExpResult_1 = 30L;
                      }

                    } else {
                      casesExpResult_1 = 30L;
                    }

                  } else {
                    casesExpResult_1 = 30L;
                  }

                } else {
                  casesExpResult_1 = 31L;
                }

              } else {
                casesExpResult_1 = 31L;
              }

            } else {
              casesExpResult_1 = 31L;
            }

          } else {
            casesExpResult_1 = 31L;
          }

        } else {
          casesExpResult_1 = 31L;
        }

      } else {
        casesExpResult_1 = 31L;
      }

    } else {
      casesExpResult_1 = 31L;
    }

    return casesExpResult_1;
  }

  public static Number MakeDate(final Number year, final Number month, final Number day) {

    return year.longValue() * 10000L + month.longValue() * 100L + day.longValue();
  }

  public static Number Year(final Number d) {

    return Utils.div(d.longValue(), 10000L);
  }

  public static Number Month(final Number d) {

    return Utils.mod(Utils.div(d.longValue(), 100L), 100L);
  }

  public static Number Day(final Number d) {

    return Utils.mod(d.longValue(), 100L);
  }

  public String toString() {

    return "DateUtils{" + "MinDate = " + Utils.toString(MinDate) + "}";
  }
}
