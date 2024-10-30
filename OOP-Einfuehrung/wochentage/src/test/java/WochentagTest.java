import com.bbkdevelopment.WochentagBerechner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/**
 * Diese Klasse testet die Methode berechneWochentag der Klasse WochentagBerechner.
 */
public class WochentagTest extends TestCase {

  private final WochentagBerechner wochentagBerechner = new WochentagBerechner();

  /**
   * Testet die Methode berechneWochentag.
   */
  public void testeEinfachesDatum() {
    final PrintStream orig = System.out;
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    PrintStream p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(20, 7, 2009);
    String tag = "Montag";
    assertEquals("Der 20.7.2009 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(3, 4, 1678);
    tag = "Sonntag";
    assertEquals("Der 3.4.1678 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(11, 12, 2077);
    tag = "Samstag";
    assertEquals("Der 11.12.2077 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(12, 6, 2054);
    tag = "Freitag";
    assertEquals("Der 12.6.2054 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(23, 4, 2003);
    tag = "Mittwoch";
    assertEquals("Der 23.4.2003 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(24, 7, 1900);
    tag = "Dienstag";
    assertEquals("Der 24.7.1900 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(13, 3, 2008);
    tag = "Donnerstag";
    assertEquals("Der 13.3.2008 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    System.setOut(orig);
  }

  /**
   * Testet die Methode berechneWochentag. Es wird der Wochentag zu einem Datum im Januar bestimmt.
   */
  public void testeJanuar() {
    final PrintStream orig = System.out;
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    PrintStream p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(4, 1, 2009);
    String tag = "Sonntag";
    assertEquals("Der 4.1.2009 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(31, 1, 2099);
    tag = "Samstag";
    assertEquals("Der 31.1.2099 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(6, 1, 2000);
    tag = "Donnerstag";
    assertEquals("Der 6.1.2000 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    System.setOut(orig);
  }

  /**
   * Testet die Methode berechneWochentag. Es wird der Wochentag zu einem Datum im Februar
   * bestimmt.
   */
  public void testeFebruar() {
    final PrintStream orig = System.out;
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    PrintStream p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(20, 2, 1878);
    String tag = "Mittwoch";
    assertEquals("Der 20.2.1878 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(1, 2, 1966);
    tag = "Dienstag";
    assertEquals("Der 1.2.1966 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(5, 2, 2000);
    tag = "Samstag";
    assertEquals("Der 5.2.2000 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    System.setOut(orig);
  }

  /**
   * Testet die Methode berechneWochentag. Es wird der Wochentag zu einem Datum im März bestimmt.
   */
  public void testeSchaltjahr() {
    final PrintStream orig = System.out;
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    PrintStream p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(29, 2, 2008);
    String tag = "Freitag";
    assertEquals("Der 29.2.2008 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(29, 2, 2016);
    tag = "Montag";
    assertEquals("Der 29.2.2016 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    b = new ByteArrayOutputStream();
    p = new PrintStream(b);
    System.setOut(p);
    wochentagBerechner.berechneWochentag(29, 2, 2000);
    tag = "Dienstag";
    assertEquals("Der 29.2.2000 ist kein " + b.toString().trim() + " sondern ein " + tag, tag,
        b.toString().trim());
    System.setOut(orig);
  }
}