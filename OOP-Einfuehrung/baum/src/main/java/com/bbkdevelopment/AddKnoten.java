package com.bbkdevelopment;

/**
 * Ein Knoten, der zwei Operanden addiert.
 */
public class AddKnoten extends BinaerOperatorKnoten {

  /**
   * Erzeugt einen neuen Additions-Knoten.
   *
   * @param erster  Der erste Operand.
   * @param zweiter Der zweite Operand.
   */
  public AddKnoten(Knoten erster, Knoten zweiter) {
    super(erster, zweiter);
  }

  @Override
  public int werteAus() {
    return liefereErstenOperand().werteAus() + liefereZweitenOperand().werteAus();
  }

  @Override
  public String toString() {
    return "(" + liefereErstenOperand().toString() + " + " + liefereZweitenOperand().toString()
        + ")";
  }
}
