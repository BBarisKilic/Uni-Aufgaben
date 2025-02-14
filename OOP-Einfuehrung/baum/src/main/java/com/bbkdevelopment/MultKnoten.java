package com.bbkdevelopment;

/**
 * Ein Knoten, der eine Multiplikation repräsentiert.
 */
public class MultKnoten extends BinaerOperatorKnoten {

  /**
   * Erzeugt einen neuen Multiplikations-Knoten.
   *
   * @param erster  Der erste Operand.
   * @param zweiter Der zweite Operand.
   */
  public MultKnoten(Knoten erster, Knoten zweiter) {
    super(erster, zweiter);
  }

  @Override
  public int werteAus() {
    return liefereErstenOperand().werteAus() * liefereZweitenOperand().werteAus();
  }

  @Override
  public String toString() {
    return "(" + liefereErstenOperand().toString() + " * " + liefereZweitenOperand().toString()
        + ")";
  }
}
