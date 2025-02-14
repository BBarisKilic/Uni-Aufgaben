package com.bbkdevelopment;

/**
 * DivKnoten ist ein BinaerOperatorKnoten, der zwei Knoten durch Division verknuepft.
 */
public class DivKnoten extends BinaerOperatorKnoten {

  /**
   * Erzeugt einen neuen Divisions-Knoten.
   *
   * @param erster  Der erste Operand.
   * @param zweiter Der zweite Operand.
   */
  public DivKnoten(Knoten erster, Knoten zweiter) {
    super(erster, zweiter);
  }

  @Override
  public int werteAus() {
    if (liefereZweitenOperand().werteAus() == 0) {
      throw new ArithmeticException("Division durch 0!");
    }
    return liefereErstenOperand().werteAus() / liefereZweitenOperand().werteAus();
  }

  @Override
  public String toString() {
    return "(" + liefereErstenOperand().toString() + " / " + liefereZweitenOperand().toString()
        + ")";
  }
}
