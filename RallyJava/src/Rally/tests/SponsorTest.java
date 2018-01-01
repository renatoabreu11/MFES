package Rally.tests;

import Rally.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SponsorTest extends MyTestCase {
  private Sponsor sponsor1 =
      new Sponsor(
          "Abu Dhabi",
          "Official visitor website for Abu Dhabi travel and tourism, offering information on hotels, restaurants, things to do, culture & heritage and events.");
  private Sponsor sponsor2 =
      new Sponsor(
          "Eparco",
          "Spécialiste assainissement compact, développe et fabrique en exclusivité des solutions pour l'assainissement non collectif depuis 45 ans.");
  private Sponsor sponsor3 =
      new Sponsor(
          "Stilo",
          "Stilo helmets competition. Top functionality, everything a driver needs must be standard feature: intercom, connections, earmuffs, drinking system.");
  private Sponsor sponsor4 =
      new Sponsor(
          "Michelin",
          "Michelin, the leading tire company, is dedicated to enhancing its clients’ mobility, sustainably; designing and distributing the most suitable tires, services and solutions for its clients’ needs.");
  private Partner partner1 =
      new Partner(
          "Michelin",
          "Michelin, the leading tire company, is dedicated to enhancing its clients’ mobility, sustainably; designing and distributing the most suitable tires, services and solutions for its clients’ needs.");
  private Partner partner2 =
      new Partner(
          "Certina",
          "Precision, reliability, innovation and dynamism. These are the values that have always linked Certina to sport.");
  private Partner partner3 =
      new Partner(
          "OneBet",
          "OneBet is the official sports betting partner of the FIA World Rally Championship, providing spectacular opportunities to boost the rush and experience of WRC.");
  /* SponsorTest.vdmpp 14:9 */
  public void Run() {

    /* SponsorTest.vdmpp 16:3 */
    IO.println("\nSponsor and Partner Tests");
    /* SponsorTest.vdmpp 18:3 */
    assertEqual("Abu Dhabi", sponsor1.GetName());
    /* SponsorTest.vdmpp 19:3 */
    assertEqual(
        "Spécialiste assainissement compact, développe et fabrique en exclusivité des solutions pour l'assainissement non collectif depuis 45 ans.",
        sponsor2.GetDescription());
    /* SponsorTest.vdmpp 21:3 */
    assertEqual("Michelin", partner1.GetName());
    /* SponsorTest.vdmpp 22:3 */
    assertEqual(
        "Precision, reliability, innovation and dynamism. These are the values that have always linked Certina to sport.",
        partner2.GetDescription());
    /* SponsorTest.vdmpp 24:3 */
    IO.println("\nFinalizing Sponsor and Partner Tests");
  }
  /* SponsorTest.vdmpp 1:7 */
  public SponsorTest() {}

  public String toString() {

    return "SponsorTest{"
        + "sponsor1 := "
        + Utils.toString(sponsor1)
        + ", sponsor2 := "
        + Utils.toString(sponsor2)
        + ", sponsor3 := "
        + Utils.toString(sponsor3)
        + ", sponsor4 := "
        + Utils.toString(sponsor4)
        + ", partner1 := "
        + Utils.toString(partner1)
        + ", partner2 := "
        + Utils.toString(partner2)
        + ", partner3 := "
        + Utils.toString(partner3)
        + "}";
  }
}
