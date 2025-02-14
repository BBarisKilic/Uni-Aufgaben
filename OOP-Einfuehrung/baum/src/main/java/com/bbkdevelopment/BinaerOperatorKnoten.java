package com.bbkdevelopment;

/**
 * Represents a binary operator node in the syntax tree.
 */
public abstract class BinaerOperatorKnoten implements Knoten {

  private final Knoten erster;
  private final Knoten zweiter;

  /**
   * Erzeugt einen neuen BinaerOperatorKnoten.
   *
   * @param erster  Der erste Operand.
   * @param zweiter Der zweite Operand.
   */
  protected BinaerOperatorKnoten(Knoten erster, Knoten zweiter) {
    if (erster == null || zweiter == null) {
      throw new IllegalArgumentException("Operands must not be null");
    }

    this.erster = erster;
    this.zweiter = zweiter;
  }

  /**
   * Liefert den ersten Operanden.
   *
   * @return Der erste Operand.
   */
  public Knoten liefereErstenOperand() {
    return erster;
  }

  /**
   * Liefert den zweiten Operanden.
   *
   * @return Der zweite Operand.
   */
  public Knoten liefereZweitenOperand() {
    return zweiter;
  }
}
