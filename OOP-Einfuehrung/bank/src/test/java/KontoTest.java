import com.bbkdevelopment.Bank;
import com.bbkdevelopment.Konto;
import com.bbkdevelopment.Kunde;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import junit.framework.TestCase;

/**
 * Testklasse für die Klasse Konto.
 */
public class KontoTest extends TestCase {

  public void testAttributExistenz() {
    assertEquals("Die Klasse Konto besitzt nicht genau 4 (Instanz-)Variablen.", 4,
        Konto.class.getDeclaredFields().length);
  }

  public void testAttributKontostand() {
    final String attrName = "kontostand";
    final Class<?> attrTyp = long.class;
    try {
      final Field f = Konto.class.getDeclaredField(attrName);
      assertFalse("Das Attribut " + attrName + " der Klasse Konto ist als static deklariert.",
          Modifier.isStatic(f.getModifiers()));
      assertEquals(
          "Das Attribut " + attrName + " der Klasse Konto ist nicht vom Typ " + attrTyp + ".",
          attrTyp, f.getType());
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Die Klasse Konto besitzt kein Attribut " + attrName
          + ". Beachten Sie Gross- und Kleinschreibung.");
      e.printStackTrace();
    }
  }

  public void testAttributNummer() {
    final String attrName = "nummer";
    final Class<?> attrTyp = long.class;
    try {
      final Field f = Konto.class.getDeclaredField(attrName);
      assertFalse("Das Attribut " + attrName + " der Klasse Konto ist als static deklariert.",
          Modifier.isStatic(f.getModifiers()));
      assertEquals(
          "Das Attribut " + attrName + " der Klasse Konto ist nicht vom Typ " + attrTyp + ".",
          attrTyp, f.getType());
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Die Klasse Konto besitzt kein Attribut " + attrName
          + ". Beachten Sie Gross- und Kleinschreibung.");
      e.printStackTrace();
    }
  }

  public void testAttributInhaber() {
    final String attrName = "inhaber";
    final Class<?> attrTyp = Kunde.class;
    try {
      final Field f = Konto.class.getDeclaredField(attrName);
      assertFalse("Das Attribut " + attrName + " der Klasse Konto ist als static deklariert.",
          Modifier.isStatic(f.getModifiers()));
      assertEquals(
          "Das Attribut " + attrName + " der Klasse Konto ist nicht vom Typ " + attrTyp + ".",
          attrTyp, f.getType());
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Die Klasse Konto besitzt kein Attribut " + attrName
          + ". Beachten Sie Gross- und Kleinschreibung.");
      e.printStackTrace();
    }
  }

  public void testAttributBank() {
    final String attrName = "bank";
    final Class<?> attrTyp = Bank.class;
    try {
      final Field f = Konto.class.getDeclaredField(attrName);
      assertFalse("Das Attribut " + attrName + " der Klasse Konto ist als static deklariert.",
          Modifier.isStatic(f.getModifiers()));
      assertEquals(
          "Das Attribut " + attrName + " der Klasse Konto ist nicht vom Typ " + attrTyp + ".",
          attrTyp, f.getType());
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Die Klasse Konto besitzt kein Attribut " + attrName
          + ". Beachten Sie Gross- und Kleinschreibung.");
      e.printStackTrace();
    }
  }

  public void testKonstruktor() {
    final Constructor<?>[] cons = Konto.class.getDeclaredConstructors();
    assertEquals("Die Klasse Konto besitzt mehr als einen Konstruktor.", 1, cons.length);
    Konto k = null;
    final Bank bank = new Bank("Test", 124);
    final Kunde kunde = new Kunde("Testkunde");
    final int nummer = 123;
    try {
      final Constructor<Konto> c = Konto.class.getDeclaredConstructor(long.class, Bank.class,
          Kunde.class);
      k = c.newInstance(nummer, bank, kunde);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail(
          "Die Klasse Konto besitzt keinen Konstruktor mit den folgenden Parametertypen: long, Bank, Kunde");
      e.printStackTrace();
    } catch (IllegalArgumentException | InstantiationException | IllegalAccessException |
             InvocationTargetException e) {
      fail("Das Ausfuehren des Konstruktors ist fehlgeschlagen: " + e);
      e.printStackTrace();
    } catch (Throwable t) {
      fail("Das Ausfuehren des Konstruktors ist fehlgeschlagen: " + t);
    }
    // ueberpruefe Werte der Attribute
    String attrName = "kontostand";
    Field f = null;
    try {
      f = Konto.class.getDeclaredField(attrName);
      f.setAccessible(true);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Wert von Attribut " + attrName
          + " kann nicht ueberprueft werden, da es nicht existiert.");
      e.printStackTrace();
    }
    try {
      assert f != null;
      assertEquals(
          attrName + " besitzt nach der Ausfuehrung des Konstruktors nicht den erwarteten Wert.", 0,
          f.getLong(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Wert von Attribut " + attrName + " konnte nicht ueberprueft werden.");
      e.printStackTrace();
    }
    attrName = "nummer";
    try {
      f = Konto.class.getDeclaredField(attrName);
      f.setAccessible(true);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Wert von Attribut " + attrName
          + " kann nicht ueberprueft werden, da es nicht existiert.");
      e.printStackTrace();
    }
    try {
      assertEquals(
          attrName + " besitzt nach der Ausfuehrung des Konstruktors nicht den erwarteten Wert.",
          nummer, f.getLong(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Wert von Attribut " + attrName + " konnte nicht ueberprueft werden.");
      e.printStackTrace();
    }
    attrName = "bank";
    try {
      f = Konto.class.getDeclaredField(attrName);
      f.setAccessible(true);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Wert von Attribut " + attrName
          + " kann nicht ueberprueft werden, da es nicht existiert.");
      e.printStackTrace();
    }
    try {
      assertEquals(
          attrName + " besitzt nach der Ausfuehrung des Konstruktors nicht den erwarteten Wert.",
          bank, f.get(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Wert von Attribut " + attrName + " konnte nicht ueberprueft werden.");
      e.printStackTrace();
    }
    attrName = "inhaber";
    try {
      f = Konto.class.getDeclaredField(attrName);
      f.setAccessible(true);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Wert von Attribut " + attrName
          + " kann nicht ueberprueft werden, da es nicht existiert.");
      e.printStackTrace();
    }
    try {
      assertEquals(
          attrName + " besitzt nach der Ausfuehrung des Konstruktors nicht den erwarteten Wert.",
          kunde, f.get(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Wert von Attribut " + attrName + " konnte nicht ueberprueft werden.");
      e.printStackTrace();
    }
  }

  public void testeMethodenExistenz() {
    final Method[] meths = Konto.class.getDeclaredMethods();
    assertEquals("Die Klasse Konto besitzt nicht genau 7 Methoden.", 7, meths.length);
  }

  public void testeAuszahlenEigenschaften() {
    final String methName = "auszahlen";
    final Class<?> retType = void.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName, long.class);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail(
          "Die Klasse Konto besitzt keine Methode " + methName + " mit folgenden Parametern: long");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeEinzahlenEigenschaften() {
    final String methName = "einzahlen";
    final Class<?> retType = void.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName, long.class);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail(
          "Die Klasse Konto besitzt keine Methode " + methName + " mit folgenden Parametern: long");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeLiefereBanknameEigenschaften() {
    final String methName = "liefereBankname";
    final Class<?> retType = String.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail("Die Klasse Konto besitzt keine Methode " + methName + " ohne Parameter.");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeLiefereBLZEigenschaften() {
    final String methName = "liefereBLZ";
    final Class<?> retType = long.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail("Die Klasse Konto besitzt keine Methode " + methName + " ohne Parameter.");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeLiefereInhabernameEigenschaften() {
    final String methName = "liefereInhabername";
    final Class<?> retType = String.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail("Die Klasse Konto besitzt keine Methode " + methName + " ohne Parameter.");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeLiefereKontonummerEigenschaften() {
    final String methName = "liefereKontonummer";
    final Class<?> retType = long.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail("Die Klasse Konto besitzt keine Methode " + methName + " ohne Parameter.");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeLiefereKontostandEigenschaften() {
    final String methName = "liefereKontostand";
    final Class<?> retType = long.class;
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(methName);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail("Die Klasse Konto besitzt keine Methode " + methName + " ohne Parameter.");
      e.printStackTrace();
    }
    assert m != null;
    assertFalse("Die Methode " + methName + " der Klasse Konto ist als static deklariert.",
        Modifier.isStatic(m.getModifiers()));
    assertEquals(
        "Die Methode " + methName + " der Klasse Konto hat nicht den Rueckgabetyp: " + retType,
        retType, m.getReturnType());
  }

  public void testeEinzahlenAuszahlen() {
    final Bank bank = new Bank("Test", 124);
    final Kunde kunde = new Kunde("Testkunde");
    final Konto k = createKonto(123, bank, kunde);
    Method m = getMethod("einzahlen", long.class);
    final long ein = 20000;
    callVoidMethod(k, m, ein);
    final Field kontostand = getField();
    try {
      assertEquals("Der Kontostand hat nach der Einzahlung nicht den gewuenschten Wert", ein,
          kontostand.getLong(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Der Wert des Attributs kontostand konnte nach dem Einzahlen nicht ueberprueft werden.");
      e.printStackTrace();
    }
    m = getMethod("auszahlen", long.class);
    final long aus = 10000;
    callVoidMethod(k, m, aus);
    try {
      assertEquals("Der Kontostand hat nach der Einzahlung nicht den gewuenschten Wert", ein - aus,
          kontostand.getLong(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Der Wert des Attributs kontostand konnte nach dem Auszahlen nicht ueberprueft werden.");
      e.printStackTrace();
    }
    callVoidMethod(k, m, aus);
    try {
      assertEquals("Der Kontostand hat nach der Einzahlung nicht den gewuenschten Wert",
          0, kontostand.getLong(k));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      fail("Der Wert des Attributs kontostand konnte nach dem Auszahlen nicht ueberprueft werden.");
      e.printStackTrace();
    }

  }

  public void testeLiefereBankname() {
    final String bankname = "Testbank";
    final Bank bank = new Bank(bankname, 124);
    final Kunde kunde = new Kunde("Testkunde");
    final Konto k = createKonto(123, bank, kunde);
    final Method m = getMethod("liefereBankname");
    final Object o = callMethod(k, m);
    assertEquals("Die Methode liefereBankname liefert den falschen Wert.", bankname, o);
  }

  public void testeLiefereBLZ() {
    final long blz = 124;
    final Bank bank = new Bank("Testbank", blz);
    final Kunde kunde = new Kunde("Testkunde");
    final Konto k = createKonto(123, bank, kunde);
    final Method m = getMethod("liefereBLZ");
    final Object o = callMethod(k, m);
    assertEquals("Die Methode liefereBLZ liefert den falschen Wert.", blz, o);
  }

  public void testeLiefereInhabername() {
    final Bank bank = new Bank("Testbank", 124);
    final String kundenname = "Testkunde";
    final Kunde kunde = new Kunde(kundenname);
    final Konto k = createKonto(123, bank, kunde);
    final Method m = getMethod("liefereInhabername");
    final Object o = callMethod(k, m);
    assertEquals("Die Methode liefereInhabername liefert den falschen Wert.", kundenname, o);
  }

  public void testeLiefereKontonummer() {
    final Bank bank = new Bank("Testbank", 124);
    final Kunde kunde = new Kunde("Testkunde");
    final long nummer = 123;
    final Konto k = createKonto(nummer, bank, kunde);
    final Method m = getMethod("liefereKontonummer");
    final Object o = callMethod(k, m);
    assertEquals("Die Methode liefereKontonummer liefert den falschen Wert.", nummer, o);
  }

  public void testeLiefereKontostand() {
    final Bank bank = new Bank("Testbank", 124);
    final Kunde kunde = new Kunde("Testkunde");
    final Konto k = createKonto(123, bank, kunde);
    final Method get = getMethod("liefereKontostand");
    final Field f = getField();
    Object o = callMethod(k, get);
    try {
      assertEquals("liefereKontostand liefert nicht den Wert der Variable kontostand.",
          f.getLong(k), o);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    final Method einz = getMethod("einzahlen", long.class);
    final Method ausz = getMethod("auszahlen", long.class);
    final long ein = 20000;
    final long aus = 5000;
    callVoidMethod(k, einz, ein);
    o = callMethod(k, get);
    try {
      assertEquals(
          "liefereKontostand liefert nach dem Einzahlen nicht den Wert der Variable kontostand.",
          f.getLong(k), o);
      assertEquals("liefereKontostand liefert nach dem Einzahlen nicht den erwarteten Wert .", ein,
          o);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    callVoidMethod(k, ausz, aus);
    o = callMethod(k, get);
    try {
      assertEquals(
          "liefereKontostand liefert nach dem Auszahlen nicht den Wert der Variable kontostand.",
          f.getLong(k), o);
      assertEquals("liefereKontostand liefert nach dem Auszahlen nicht den erwarteten Wert .",
          ein - aus,
          o);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    callVoidMethod(k, ausz, aus);
    o = callMethod(k, get);
    try {
      assertEquals(
          "liefereKontostand liefert nach dem Auszahlen nicht den Wert der Variable kontostand.",
          f.getLong(k), o);
      assertEquals("liefereKontostand liefert nach dem Auszahlen nicht den erwarteten Wert .",
          ein - aus - aus,
          o);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public void testGetter() {
    final long blz = 124;
    final TestBank bank = new TestBank("Testbank", blz);
    final String kundenname = "Testkunde";
    final TestKunde kunde = new TestKunde(kundenname);
    final Konto k = createKonto(123, bank, kunde);
    final long neueBlz = 125;
    final String neuerKundenname = "NeuerName";
    final String neuerBankname = "NeueBank";
    kunde.setName(neuerKundenname);
    bank.setBLZ(neueBlz);
    bank.setName(neuerBankname);
    Method m = getMethod("liefereInhabername");
    Object o = callMethod(k, m);
    assertEquals(
        "Die Methode liefereInhabername liefert den falschen Wert. Verwenden Sie evtl. nicht die Methode liefereName() der Klasse Kunde?",
        neuerKundenname, o);
    m = getMethod("liefereBLZ");
    o = callMethod(k, m);
    assertEquals(
        "Die Methode liefereBLZ liefert den falschen Wert. Verwenden Sie evtl. nicht die Methode liefereBLZ() der Klasse Bank?",
        neueBlz, o);
    m = getMethod("liefereBankname");
    o = callMethod(k, m);
    assertEquals(
        "Die Methode liefereBankname liefert den falschen Wert. Verwenden Sie evtl. nicht die Methode liefereName() der Klasse Bank?",
        neuerBankname, o);
  }


  private Field getField() {
    Field f = null;
    try {
      f = Konto.class.getDeclaredField("kontostand");
      f.setAccessible(true);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      fail("Die Klasse Konto besitzt keine Attribut " + "kontostand" + ".");
      e.printStackTrace();
    }
    return f;
  }

  private Method getMethod(String name, Class<?>... params) {
    Method m = null;
    try {
      m = Konto.class.getDeclaredMethod(name, params);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail("Die Klasse Konto besitzt keine passende Methode " + name + ".");
      e.printStackTrace();
    }
    return m;
  }

  private void callVoidMethod(Konto k, Method m, Object... args) {
    try {
      m.invoke(k, args);
    } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
      fail("Das Ausfuehren der Methode " + m.getName() + "(" + Arrays.toString(args)
          + ") ist fehlgeschlagen: " + e);
      e.printStackTrace();
    }
  }

  private Object callMethod(Konto k, Method m, Object... args) {
    try {
      return m.invoke(k, args);
    } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
      fail("Das Ausfuehren der Methode " + m.getName() + "(" + Arrays.toString(args)
          + ") ist fehlgeschlagen: " + e);
      e.printStackTrace();
    }
    return null;
  }

  private Konto createKonto(long nummer, Bank bank, Kunde kunde) {
    final Constructor<?>[] cons = Konto.class.getDeclaredConstructors();
    assertEquals("Die Klasse Konto besitzt mehr als einen Konstruktor.", 1, cons.length);
    Konto k = null;
    try {
      final Constructor<Konto> c = Konto.class.getDeclaredConstructor(long.class, Bank.class,
          Kunde.class);
      k = c.newInstance(nummer, bank, kunde);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      fail(
          "Die Klasse Konto besitzt keinen Konstruktor mit den folgenden Parametertypen: long, Bank, Kunde");
      e.printStackTrace();
    } catch (IllegalArgumentException | InstantiationException | IllegalAccessException |
             InvocationTargetException e) {
      fail("Das Ausfuehren des Konstruktors ist fehlgeschlagen: " + e);
      e.printStackTrace();
    } catch (Throwable t) {
      fail("Das Ausfuehren des Konstruktors ist fehlgeschlagen: " + t);
    }
    return k;
  }

  private static class TestBank extends Bank {

    private long blz;

    private String name;

    public TestBank(String bankname, long bankleitzahl) {
      super(bankname, bankleitzahl);
      name = bankname;
      blz = bankleitzahl;
    }

    @Override
    public long liefereBLZ() {
      return blz;
    }

    @Override
    public String liefereName() {
      return name;
    }

    void setName(String n) {
      name = n;
    }

    void setBLZ(long b) {
      blz = b;
    }
  }

  private static class TestKunde extends Kunde {

    private String name;

    public TestKunde(String n) {
      super(n);
      name = n;
    }

    @Override
    public String liefereName() {
      return name;
    }

    void setName(String n) {
      this.name = n;
    }
  }
}