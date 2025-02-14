import com.bbkdevelopment.AddKnoten;
import com.bbkdevelopment.Baum;
import com.bbkdevelopment.BinaerOperatorKnoten;
import com.bbkdevelopment.DivKnoten;
import com.bbkdevelopment.IntKnoten;
import com.bbkdevelopment.Knoten;
import com.bbkdevelopment.MultKnoten;
import com.bbkdevelopment.SubKnoten;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;


public class BaumTest extends TestCase {

  public void testeKnotenInterface() {
    final Class<?> knoten;
    try {
      knoten = Class.forName("com.bbkdevelopment.Knoten");
    } catch (ClassNotFoundException e) {
      fail("Das Interface Knoten konnte nicht gefunden werden.");
      return;
    }
    final Method[] m = knoten.getDeclaredMethods();
    assertEquals("Es gibt nicht genau 2 Methoden.", 2, m.length);
    try {
      knoten.getDeclaredMethod("werteAus", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode werteAus konnte nicht gefunden werden.");
    }

    try {
      knoten.getDeclaredMethod("toString", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode toString konnte nicht gefunden werden.");
    }
  }

  public void testeIntKnoten() {
    final Class<?> intKnoten;
    try {
      intKnoten = Class.forName("com.bbkdevelopment.IntKnoten");
    } catch (ClassNotFoundException e) {
      fail("Die Klasse IntKnoten konnte nicht gefunden werden.");
      return;
    }
    final Class<?>[] interfaces = intKnoten.getInterfaces();
    assertEquals("Die Klasse implementiert nicht genau ein Interface", 1, interfaces.length);
    assertEquals("Das implementierte Interface heisst nicht Knoten", "com.bbkdevelopment.Knoten",
        interfaces[0].getName());

    try {
      intKnoten.getDeclaredMethod("werteAus", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode werteAus konnte nicht gefunden werden.");
    }

    try {
      intKnoten.getDeclaredMethod("toString", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode werteAus konnte nicht gefunden werden.");
    }

    try {
      intKnoten.getDeclaredConstructor(new Class[]{int.class});
    } catch (NoSuchMethodException e) {
      fail("Der Konstruktor mit einem int-Parameter konnte nicht gefunden werden.");
    }
  }

  public void testeBinaerOperatorKnoten() {
    final Class<?> binaerOp;
    try {
      binaerOp = Class.forName("com.bbkdevelopment.BinaerOperatorKnoten");
    } catch (ClassNotFoundException e) {
      fail("Die Klasse BinaerOperatorKnoten konnte nicht gefunden werden.");
      return;
    }
    assertTrue("Die Klasse ist nicht abstrakt.", Modifier.isAbstract(binaerOp.getModifiers()));
    final Class<?>[] interfaces = binaerOp.getInterfaces();
    assertEquals("Die Klasse implementiert nicht genau ein Interface", 1, interfaces.length);
    assertEquals("Das implementierte Interface heisst nicht Knoten", "com.bbkdevelopment.Knoten",
        interfaces[0].getName());

    try {
      binaerOp.getDeclaredMethod("liefereErstenOperand", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode liefereErstenOperand konnte nicht gefunden werden.");
    }

    try {
      binaerOp.getDeclaredMethod("liefereZweitenOperand", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode liefereZweitenOperand konnte nicht gefunden werden.");
    }

    try {
      binaerOp.getDeclaredConstructor(new Class[]{Knoten.class, Knoten.class});
    } catch (NoSuchMethodException e) {
      fail("Der Konstruktor mit zwei Knoten-Parameter konnte nicht gefunden werden.");
    }
  }

  public void testeOperatorKnoten() {
    final String[] namen = {"com.bbkdevelopment.AddKnoten", "com.bbkdevelopment.SubKnoten",
        "com.bbkdevelopment.MultKnoten", "com.bbkdevelopment.DivKnoten"};
    for (String n : namen) {
      final Class<?> opKnoten;
      try {
        opKnoten = Class.forName(n);
      } catch (ClassNotFoundException e) {
        fail("Die Klasse " + n + " konnte nicht gefunden werden.");
        return;
      }
      assertEquals("Die Klasse " + n + " ist keine direkte Unterklasse von BinaerOperatorKnoten.",
          BinaerOperatorKnoten.class, opKnoten.getSuperclass());

      try {
        opKnoten.getDeclaredConstructor(new Class[]{Knoten.class, Knoten.class});
      } catch (NoSuchMethodException e) {
        fail("Der Konstruktor mit zwei Knoten-Parameter konnte in Klasse " + n
            + " nicht gefunden werden.");
      }
    }
  }

  public void testeBaum() {
    final Class<?> baum;
    try {
      baum = Class.forName("com.bbkdevelopment.Baum");
    } catch (ClassNotFoundException e) {
      fail("Die Klasse Baum konnte nicht gefunden werden.");
      return;
    }

    try {
      baum.getDeclaredMethod("werteAus", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode werteAus konnte nicht gefunden werden.");
    }

    try {
      baum.getDeclaredMethod("toString", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode werteAus konnte nicht gefunden werden.");
    }

    try {
      baum.getDeclaredMethod("liefereWurzel", new Class[0]);
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode liefereWurzel konnte nicht gefunden werden.");
    }

    try {
      final Method m = baum.getDeclaredMethod("erzeugeBeispielBaum",
          new Class[]{int.class, int.class, int.class, int.class, int.class});
      assertTrue("Die Methode erzeugeBeispielBaum ist nicht als static deklariert.",
          Modifier.isStatic(m.getModifiers()));
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Die Methode erzeugeBeispielBaum mit 5 int-Parametern konnte nicht gefunden werden.");
    }

    try {
      baum.getDeclaredConstructor(new Class[]{Knoten.class});
    } catch (SecurityException e) {
      e.printStackTrace();
      fail();
    } catch (NoSuchMethodException e) {
      fail("Der Konstruktor mit einem Knoten-Parameter konnte nicht gefunden werden.");
    }
  }

  public void testeWerteAus() {
    for (int i = 0; i < 100; i++) {
      final IntKnoten j = new IntKnoten(i);
      assertEquals("werteAus() bei IntKnoten fehlerhaft", i, j.werteAus());
    }
    final IntKnoten t1 = new IntKnoten(15);
    final IntKnoten t2 = new IntKnoten(5);
    final AddKnoten add = new AddKnoten(t1, t2);
    assertEquals("werteAus() bei AddKnoten fehlerhaft", 20, add.werteAus());
    final SubKnoten sub = new SubKnoten(t1, t2);
    assertEquals("werteAus() bei SubKnoten fehlerhaft", 10, sub.werteAus());
    final MultKnoten mult = new MultKnoten(t1, t2);
    assertEquals("werteAus() bei MultKnoten fehlerhaft", 75, mult.werteAus());
    final DivKnoten div = new DivKnoten(t1, t2);
    assertEquals("werteAus() bei DivKnoten fehlerhaft", 3, div.werteAus());
    final Knoten k = new SubKnoten(new DivKnoten(new AddKnoten(add, sub), div), mult);
    assertEquals(
        "Ergebnis des folgendes Ausdrucks fehlerhaft: ((((15 + 5) + (15 - 5)) / (15 / 5)) - (15 * 5))",
        -65, k.werteAus());
  }

  public void testeWerteAusAusnahmen() {
    final IntKnoten t1 = new IntKnoten(15);
    final IntKnoten t2 = new IntKnoten(0);
    final DivKnoten div = new DivKnoten(t1, t2);
    try {
      div.werteAus();
      fail("Hier hÃ¤tte eine Ausnahme auftreten sollen, da durch 0 dividiert wird.");
    } catch (ArithmeticException e) {
      assertEquals("Die Ausnahme enhaelt nicht dei gewuenschte Fehlermeldung", "Division durch 0!",
          e.getMessage());
    }

  }

  public void testeToString() {
    for (int i = 0; i < 100; i++) {
      final IntKnoten j = new IntKnoten(i);
      assertEquals("toString() bei IntKnoten fehlerhaft", "" + i, j.toString());
    }
    final IntKnoten t1 = new IntKnoten(15);
    final IntKnoten t2 = new IntKnoten(5);
    final AddKnoten add = new AddKnoten(t1, t2);
    assertEquals("toString() bei AddKnoten fehlerhaft", "(15 + 5)", add.toString());
    final SubKnoten sub = new SubKnoten(t1, t2);
    assertEquals("toString() bei SubKnoten fehlerhaft", "(15 - 5)", sub.toString());
    final MultKnoten mult = new MultKnoten(t1, t2);
    assertEquals("toString() bei MultKnoten fehlerhaft", "(15 * 5)", mult.toString());
    final DivKnoten div = new DivKnoten(t1, t2);
    assertEquals("toString() bei DivKnoten fehlerhaft", "(15 / 5)", div.toString());
    final Knoten k = new SubKnoten(new DivKnoten(new AddKnoten(add, sub), div), mult);
    assertEquals(
        "toString() liefert bei folgendem Ausdruck nicht das gewÃ¼nschte Ergebnis: ((((15 + 5) + (15 - 5)) / (15 / 5)) - (15 * 5))",
        "((((15 + 5) + (15 - 5)) / (15 / 5)) - (15 * 5))", k.toString());
  }

  public void testeOperatorKonstruktorAusnahmen() {
    try {
      new AddKnoten(null, null);
      fail("Konstruktor von AddKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new SubKnoten(null, null);
      fail("Konstruktor von SubKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new MultKnoten(null, null);
      fail("Konstruktor von MultKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new DivKnoten(null, null);
      fail("Konstruktor von DivKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new AddKnoten(new IntKnoten(2), null);
      fail("Konstruktor von AddKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new SubKnoten(new IntKnoten(2), null);
      fail("Konstruktor von SubKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new MultKnoten(new IntKnoten(2), null);
      fail("Konstruktor von MultKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new DivKnoten(new IntKnoten(2), null);
      fail("Konstruktor von DivKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }

    try {
      new AddKnoten(null, new IntKnoten(-10));
      fail("Konstruktor von AddKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new SubKnoten(null, new IntKnoten(-10));
      fail("Konstruktor von SubKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new MultKnoten(null, new IntKnoten(-10));
      fail("Konstruktor von MultKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new DivKnoten(null, new IntKnoten(-10));
      fail("Konstruktor von DivKnoten haette IllegalArgumentException erzeugen sollen.");
    } catch (IllegalArgumentException e) {
    }
  }

  public void testeBaumKonstruktor() {
    final IntKnoten i = new IntKnoten(100);
    final Baum b = new Baum(i);
    assertEquals("Wurzel ist nach Konstruktoraufruf inkorrekt.", i, b.liefereWurzel());
  }

  public void testeBaumWerteAus() {
    for (int i = 0; i < 100; i++) {
      final IntKnoten j = new IntKnoten(i);
      final Baum b = new Baum(j);
      assertEquals("werteAus() bei Baum mit nur einem IntKnoten fehlerhaft", i, b.werteAus());
    }
    final IntKnoten t1 = new IntKnoten(15);
    final IntKnoten t2 = new IntKnoten(5);
    final AddKnoten add = new AddKnoten(t1, t2);
    Baum b = new Baum(add);
    assertEquals("werteAus() bei Baum fehlerhaft", 20, b.werteAus());
    final SubKnoten sub = new SubKnoten(t1, t2);
    b = new Baum(sub);
    assertEquals("werteAus() bei Baum fehlerhaft", 10, b.werteAus());
    final MultKnoten mult = new MultKnoten(t1, t2);
    b = new Baum(mult);
    assertEquals("werteAus() bei Baum fehlerhaft", 75, b.werteAus());
    final DivKnoten div = new DivKnoten(t1, t2);
    b = new Baum(div);
    assertEquals("werteAus() bei Baum fehlerhaft", 3, b.werteAus());
    final Knoten k = new SubKnoten(new DivKnoten(new AddKnoten(add, sub), div), mult);
    b = new Baum(k);
    assertEquals(
        "Ergebnis des Baumes mit folgendem Ausdrucks fehlerhaft: ((((15 + 5) + (15 - 5)) / (15 / 5)) - (15 * 5))",
        -65, b.werteAus());
  }

  public void testeBaumWerteAusAusnahmen() {
    final IntKnoten t1 = new IntKnoten(15);
    final IntKnoten t2 = new IntKnoten(0);
    final DivKnoten div = new DivKnoten(t1, t2);
    final Baum b = new Baum(div);
    try {
      b.werteAus();
      fail("Hier hÃ¤tte eine Ausnahme auftreten sollen, da durch 0 dividiert wird.");
    } catch (ArithmeticException e) {
      assertEquals("Die Ausnahme enhaelt nicht die gewuenschte Fehlermeldung", "Division durch 0!",
          e.getMessage());
    }

  }

  public void testeBaumToString() {
    for (int i = 0; i < 100; i++) {
      final IntKnoten j = new IntKnoten(i);
      final Baum b = new Baum(j);
      assertEquals("toString() bei Baum mit nur einem IntKnoten fehlerhaft", "" + i, b.toString());
    }
    final IntKnoten t1 = new IntKnoten(15);
    final IntKnoten t2 = new IntKnoten(5);
    final AddKnoten add = new AddKnoten(t1, t2);
    Baum b = new Baum(add);
    assertEquals("toString() bei AddKnoten fehlerhaft", "(15 + 5)", b.toString());
    final SubKnoten sub = new SubKnoten(t1, t2);
    b = new Baum(sub);
    assertEquals("toString() bei SubKnoten fehlerhaft", "(15 - 5)", b.toString());
    final MultKnoten mult = new MultKnoten(t1, t2);
    b = new Baum(mult);
    assertEquals("toString() bei MultKnoten fehlerhaft", "(15 * 5)", b.toString());
    final DivKnoten div = new DivKnoten(t1, t2);
    b = new Baum(div);
    assertEquals("toString() bei DivKnoten fehlerhaft", "(15 / 5)", b.toString());
    final Knoten k = new SubKnoten(new DivKnoten(new AddKnoten(add, sub), div), mult);
    b = new Baum(k);
    assertEquals(
        "toString() liefert bei Baum mit folgendem Ausdruck nicht das gewÃ¼nschte Ergebnis: ((((15 + 5) + (15 - 5)) / (15 / 5)) - (15 * 5))",
        "((((15 + 5) + (15 - 5)) / (15 / 5)) - (15 * 5))", b.toString());
  }

  public void testeBeispielBaum() {
    final Baum b = Baum.erzeugeBeispielBaum(2, 4, 20, 5, 10);
    assertEquals("Ergebnis bei Beispielbaum fehlerhaft.", 4, b.werteAus());
    assertEquals("toString bei Beispielbaum fehlerhaft.", "((2 * 4) + (20 / (5 - 10)))",
        b.toString());
    assertTrue("Die Wurzel des Beispielbaums ist kein AddKnoten",
        b.liefereWurzel() instanceof AddKnoten);
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) b.liefereWurzel()).liefereErstenOperand() instanceof MultKnoten);
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand() instanceof DivKnoten);
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereErstenOperand()).liefereErstenOperand() instanceof IntKnoten);
    assertEquals(2,
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereErstenOperand()).liefereErstenOperand()
            .werteAus());
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereErstenOperand()).liefereZweitenOperand() instanceof IntKnoten);
    assertEquals(4,
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereErstenOperand()).liefereZweitenOperand()
            .werteAus());
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereErstenOperand() instanceof IntKnoten);
    assertEquals(20,
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereErstenOperand()
            .werteAus());
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereZweitenOperand() instanceof SubKnoten);
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereZweitenOperand()).liefereErstenOperand() instanceof IntKnoten);
    assertEquals(5,
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereZweitenOperand()).liefereErstenOperand()
            .werteAus());
    assertTrue("Die Struktur des Beispielbaums ist fehlerhaft",
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereZweitenOperand()).liefereZweitenOperand() instanceof IntKnoten);
    assertEquals(10,
        ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) ((BinaerOperatorKnoten) b.liefereWurzel()).liefereZweitenOperand()).liefereZweitenOperand()).liefereZweitenOperand()
            .werteAus());
  }

}