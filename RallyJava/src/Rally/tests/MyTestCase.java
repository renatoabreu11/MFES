package Rally.tests;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MyTestCase {
  /* MyTestCase.vdmpp 4:13 */
  protected void assertTrue(final Boolean arg) {

    /* MyTestCase.vdmpp 6:5 */
    return;
  }
  /* MyTestCase.vdmpp 9:12 */
  protected void assertFalse(final Boolean arg) {

    /* MyTestCase.vdmpp 10:24 */
    return;
  }
  /* MyTestCase.vdmpp 13:13 */
  protected void assertEqual(final Object expected, final Object actual) {

    /* MyTestCase.vdmpp 15:5 */
    if (!(Utils.equals(expected, actual))) {
      /* MyTestCase.vdmpp 16:7 */
      IO.print("Actual value (");
      /* MyTestCase.vdmpp 17:7 */
      IO.print(((Object) actual));
      /* MyTestCase.vdmpp 18:7 */
      IO.print(") different from expected (");
      /* MyTestCase.vdmpp 19:7 */
      IO.print(((Object) expected));
      /* MyTestCase.vdmpp 20:7 */
      IO.println(")\n");
    }
  }
  /* MyTestCase.vdmpp 1:7 */
  public MyTestCase() {}

  public String toString() {

    return "MyTestCase{}";
  }
}
