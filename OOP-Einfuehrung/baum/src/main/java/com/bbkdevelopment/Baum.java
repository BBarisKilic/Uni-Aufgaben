package com.bbkdevelopment;

/**
 * Ein Baum besteht aus einem Wurzelknoten.
 */
public class Baum {

  /**
   * Die Wurzel des Baumes.
   */
  private Knoten wurzel;

  /**
   * Erzeugt einen neuen Baum mit der gegebenen Wurzel.
   *
   * @param wurzel Die Wurzel des Baumes.
   */
  public Baum(Knoten wurzel) {
    this.wurzel = wurzel;
  }

  /**
   * Erzeugt einen Beispielbaum.
   *
   * @param a Der Wert des ersten Blattes.
   * @param b Der Wert des zweiten Blattes.
   * @param c Der Wert des dritten Blattes.
   * @param d Der Wert des vierten Blattes.
   * @param e Der Wert des fuenften Blattes.
   * @return Der Beispielbaum.
   */
  public static Baum erzeugeBeispielBaum(int a, int b, int c, int d, int e) {
    final Knoten knotenA = new IntKnoten(a);
    final Knoten knotenB = new IntKnoten(b);
    final Knoten knotenC = new IntKnoten(c);
    final Knoten knotenD = new IntKnoten(d);
    final Knoten knotenE = new IntKnoten(e);
    final Knoten knotenDE = new SubKnoten(knotenD, knotenE);
    final Knoten knotenCDE = new DivKnoten(knotenC, knotenDE);
    final Knoten knotenAB = new MultKnoten(knotenA, knotenB);
    final Knoten wurzel = new AddKnoten(knotenAB, knotenCDE);
    return new Baum(wurzel);
  }

  /**
   * Gibt das Ergebnis der Berechnung des Baumes zurueck.
   *
   * @return Das Ergebnis der Berechnung.
   */
  public int werteAus() {
    return wurzel.werteAus();
  }

  /**
   * Gibt die Wurzel des Baumes zurueck.
   *
   * @return Die Wurzel des Baumes.
   */
  public Knoten liefereWurzel() {
    return wurzel;
  }

  @Override
  public String toString() {
    return wurzel.toString();
  }
}