package com.bbkdevelopment;

/**
 * Ein Knoten, der zwei Operanden subtrahiert.
 */
public class SubKnoten extends BinaerOperatorKnoten {

  /**
   * Erzeugt einen neuen Subtraktions-Knoten.
   *
   * @param erster  Der erste Operand.
   * @param zweiter Der zweite Operand.
   */
  public SubKnoten(Knoten erster, Knoten zweiter) {
    super(erster, zweiter);
  }

  @Override
  public int werteAus() {
    return liefereErstenOperand().werteAus() - liefereZweitenOperand().werteAus();
  }

  @Override
  public String toString() {
    return "(" + liefereErstenOperand().toString() + " - " + liefereZweitenOperand().toString()
        + ")";
  }
}
